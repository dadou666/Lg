package generer;

import grammaire.lgLexer;
import grammaire.lgListener;
import grammaire.lgParser;
import grammaire.lgParser.AccesContext;
import grammaire.lgParser.AllContext;
import grammaire.lgParser.AppelContext;
import grammaire.lgParser.AttributContext;
import grammaire.lgParser.AttributsContext;
import grammaire.lgParser.ChampContext;
import grammaire.lgParser.ChampsContext;
import grammaire.lgParser.CodeContext;
import grammaire.lgParser.ConstanteContext;
import grammaire.lgParser.CreerContext;
import grammaire.lgParser.CreerListeContext;
import grammaire.lgParser.DefPredicatContext;
import grammaire.lgParser.DefTypeContext;
import grammaire.lgParser.DefTypeFunctionContext;
import grammaire.lgParser.ElementContext;
import grammaire.lgParser.EstTypeContext;
import grammaire.lgParser.ExistContext;
import grammaire.lgParser.ExternContext;
import grammaire.lgParser.FonctionRefAppelContext;
import grammaire.lgParser.FunctionContext;
import grammaire.lgParser.FunctionDefContext;
import grammaire.lgParser.FunctionLocalContext;
import grammaire.lgParser.MultipleContext;
import grammaire.lgParser.OperateurContext;
import grammaire.lgParser.OperationContext;
import grammaire.lgParser.OperationOuAccesContext;
import grammaire.lgParser.SiContext;
import grammaire.lgParser.SimpleContext;
import grammaire.lgParser.SuperTypeContext;
import grammaire.lgParser.SystemContext;
import grammaire.lgParser.TmpCodeContext;
import grammaire.lgParser.TypeBaseContext;
import grammaire.lgParser.TypeContext;
import grammaire.lgParser.VarContext;

import java.io.IOException;
import java.lang.reflect.Field;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import model.erreur.ErreurModule;
import model.erreur.ErreurSemantique;
import model.semantique.Acces;
import model.semantique.AppelBase;

import model.semantique.AppelRec;
import model.semantique.Attribut;
import model.semantique.Champ;
import model.semantique.Code;
import model.semantique.Const;
import model.semantique.Element;
import model.semantique.Entier;
import model.semantique.FonctionDef;
import model.semantique.FonctionLocal;
import model.semantique.Objet;
import model.semantique.Si;
import model.semantique.TypeBasic;
import model.semantique.TypeDef;
import model.semantique.TypeFunction;
import model.semantique.TypeLiteral;
import model.semantique.TypeMultiple;
import model.semantique.TypeSimple;
import model.semantique.Univers;
import model.semantique.Var;

import org.antlr.v4.runtime.ANTLRErrorListener;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;
import org.antlr.v4.runtime.atn.ATNConfigSet;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.misc.Nullable;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.SimpleContent;

import components.Terminal;

public class Generateur implements ANTLRErrorListener {

	public Map<AppelBase, AppelContext> appels = new HashMap<>();
	public Map<AppelBase, OperationContext> operations = new HashMap<>();

	public Map<TypeMultiple, MultipleContext> typeMultiples = new HashMap<>();
	public Map<Objet, CreerListeContext> listeCreer = new HashMap<>();
	public Map<Var, VarContext> vars = new HashMap<>();
	public Map<TypeSimple, SimpleContext> typeSimples = new HashMap<>();
	public Map<Champ, ChampContext> champs = new HashMap<>();
	public Map<Attribut, AttributContext> attributs = new HashMap<>();
	public Map<FonctionLocal, FunctionContext> fonctions = new HashMap<>();
	public Map<FonctionLocal, ExternContext> externs = new HashMap<>();
	public Map<FonctionLocal, FunctionLocalContext> fonctionLocals = new HashMap<>();
	public Map<TypeDef, TypeContext> types = new HashMap<>();
	public Map<Const, ConstanteContext> constantes = new HashMap<>();
	public Map<String, FonctionDef> fonctionsAnonyme = new HashMap<>();
	public boolean error = false;

	static public String genererTypes(List<Class> classes) {
		StringBuffer sb = new StringBuffer();
		Set<String> names = new HashSet<>();
		String longDef = null;
		for (Class cls : classes) {
			Class superclass = cls.getSuperclass();
			String superclassSrc = "";
			String name = cls.getSimpleName();
			if (names.contains(name)) {

				throw new Error(" doublon : " + name);
			}
			sb.append("type");
			sb.append(" ");
			sb.append(name);

			names.add(name);
			if (superclass != Object.class) {
				if (classes.contains(superclass)) {
					superclassSrc = " : " + superclass.getSimpleName();
					sb.append(superclassSrc);

				}
			}
			sb.append(" {");

			for (Field field : cls.getDeclaredFields()) {
				sb.append("\n");
				Class fieldClass = field.getType();
				if (fieldClass == long.class) {
					if (longDef == null) {
						longDef = "type @long { }";
					}
					sb.append("long:");

				} else {

					if (!classes.contains(fieldClass)) {
						throw new Error(" no type for " + field.getType());

					}
					sb.append(fieldClass.getSimpleName());
					sb.append(":");
				}
				sb.append(field.getName());

			}
			sb.append("}\n");
		}
		if (longDef != null) {
			sb.append(longDef);
		}

		return sb.toString();
	}

	public static Univers metaModele() throws IOException {
		lgLexer lgLexer = new lgLexer(org.antlr.v4.runtime.CharStreams
				.fromStream(Univers.class.getResourceAsStream("/generer/metaModele.mdl")));
		CommonTokenStream tokens = new CommonTokenStream(lgLexer);
		lgParser parser = new lgParser(tokens);
		Univers u = new Generateur().generer(parser.system());
		u.init();
		u.verifierSemantique();
		if (u.erreurs.isEmpty()) {
			return u;
		}
		throw new Error("metaModele incorrecte");

	}

	public Univers lireFichier(String file) throws IOException {
		lgLexer lgLexer = new lgLexer(org.antlr.v4.runtime.CharStreams.fromFileName(file));
		CommonTokenStream tokens = new CommonTokenStream(lgLexer);
		lgParser parser = new lgParser(tokens);

		return this.generer(parser.system());

	}

	public Univers lireSourceUnivers(String src) {

		lgLexer lgLexer = new lgLexer(org.antlr.v4.runtime.CharStreams.fromString(src));
		CommonTokenStream tokens = new CommonTokenStream(lgLexer);
		lgParser parser = new lgParser(tokens);
		parser.addErrorListener(this);
		if (error) {
			return null;
		}

		return this.generer(parser.system());

	}

	public Univers lireSourceUnivers(String src, Map<String, String> depandances) {

		lgLexer lgLexer = new lgLexer(org.antlr.v4.runtime.CharStreams.fromString(src));
		CommonTokenStream tokens = new CommonTokenStream(lgLexer);
		lgParser parser = new lgParser(tokens);
		parser.addErrorListener(this);
		if (error) {
			return null;
		}

		return this.generer(parser.system());

	}

	public Set<String> modulesEnCours = new HashSet<String>();
	public List<ErreurSemantique> erreurs = new ArrayList<>();

	public Univers donnerUnivers(String nom, Univers courant, Map<String, String> sources) {

		if (modulesEnCours.contains(nom)) {
			ErreurModule erreur = new ErreurModule(nom, courant.nom, ErreurModule.TypeErreur.Cycle);
			erreurs.add(erreur);
			return null;

		}
		modulesEnCours.add(nom);

		String src;

		src = sources.get(nom+".mdl");

		Univers u = this.donnerUniversPourSource(nom, src, courant, sources);
		if (!u.erreurs.isEmpty()) {
			ErreurModule erreur = new ErreurModule(nom, courant.nom, ErreurModule.TypeErreur.Semantique);
			erreurs.add(erreur);
			return null;
		}
		return u;

	}

	public Univers donnerUniversPourSource(String nom, String src, Univers courant, Map<String, String> sources) {
		Generateur gen = new Generateur();
		Univers u;

		u = gen.lireSourceUnivers(src);
		u.estAPI = (nom.equals("api.mdl"));
		if (gen.error) {
			ErreurModule erreur = new ErreurModule(nom, courant.nom, ErreurModule.TypeErreur.Syntaxe);
			erreurs.add(erreur);

			return null;
		}
		u.nom = nom;
		Set<String> modules = u.modules();

		for (String module : modules) {
			Univers um = this.donnerUnivers(module, u, sources);
			if (um != null) {
				u.ajouterImportModule(module, um);

			}

		}
		if (!erreurs.isEmpty()) {
			return null;
		}

		if (u != null) {
			u.init();
			u.verifierSemantique();

		}
		return u;

	}

	public Code lireSourceCode(String src) {

		lgLexer lgLexer = new lgLexer(org.antlr.v4.runtime.CharStreams.fromString(src));
		CommonTokenStream tokens = new CommonTokenStream(lgLexer);
		lgParser parser = new lgParser(tokens);
		parser.addErrorListener(this);
		if (error) {
			return null;
		}

		return transformer(parser.tmpCode());

	}

	public void ajouterFonctionAnonyme(Univers u) {
		for (Map.Entry<String, FonctionDef> e : this.fonctionsAnonyme.entrySet()) {
			FonctionLocal fl = new FonctionLocal(e.getKey());
			fl.def = e.getValue();
			fl.anonyme = true;

			// u.ajouterFonction(e.getKey(), fl);
			u.elements.add(fl);

		}
	}

	public Univers generer(SystemContext sc) {
		List<Element> r = new ArrayList<Element>();
		for (ElementContext ec : sc.element()) {
			r.add(transformer(ec));
		}

		Univers u = new Univers();

		u.elements = r;
		this.ajouterFonctionAnonyme(u);
		return u;
	}

	public Element transformer(ElementContext ec) {
		if (ec.function() != null) {
			return transformer(ec.function());
		}
		if (ec.type() != null) {
			return transformer(ec.type());
		}
		if (ec.constante() != null) {
			Const c = new Const(ec.constante().ID().toString(), this.transformer(ec.constante().tmpCode()));
			this.constantes.put(c, ec.constante());
			return c;

		}
		if (ec.extern() != null) {
			return this.transformer(ec.extern());
		}

		return null;

	}

	public TypeDef transformer(TypeContext tc) {

		TypeDef td = new TypeDef(tc.ID().getText());

		td.multiple = tc.multipleFlag() != null;
		if (tc.superType() != null) {
			if (tc.superType().ID() != null) {
				td.superType = tc.superType().ID().getText();
			} else {
				td.superModule = tc.superType().id_externe().ID(0).getText();
				td.superType = tc.superType().id_externe().ID(1).getText();

			}
		}
		td.champs = new ArrayList<Champ>();
		this.types.put(td, tc);
		for (ChampContext cc : tc.champs().champ()) {
			Champ champ = new Champ(cc.ID().getText(), this.transformer(cc.defType()));

			td.champs.add(champ);
			this.champs.put(champ, cc);

		}
		return td;
	}

	public FonctionLocal transformer(FunctionContext fc) {
		FonctionLocal f = null;
		if (fc.ID() != null) {
			f = new FonctionLocal(fc.ID().getText());

		}
		if (fc.operateur() != null) {
			f = new FonctionLocal(fc.operateur().getText());

		}
		this.fonctions.put(f, fc);
		f.def = new FonctionDef();
		f.def.params = new ArrayList<Champ>();
		if (fc.champs() != null) {
			for (ChampContext cc : fc.champs().champ()) {
				Champ champ = new Champ(cc.ID().getText(), this.transformer(cc.defType()));

				f.def.params.add(champ);
				this.champs.put(champ, cc);
			}
			f.def.code = this.transformer(fc.tmpCode());

		}
		return f;

	}

	public FonctionLocal transformer(ExternContext ec) {
		FonctionLocal f = null;
		if (ec.ID() != null) {
			f = new FonctionLocal(ec.ID().getText());
		}
		if (ec.operateur() != null) {
			f = new FonctionLocal(ec.operateur().getText());

		}
		this.externs.put(f, ec);
		f.def = new FonctionDef();
		f.def.params = new ArrayList<Champ>();
		TypeFunction tf = this.transformer(ec.defTypeFunction());
		f.def.params = new ArrayList<Champ>();
		List<TypeLiteral> params = new ArrayList<>();
		tf.AddParamType(params);
		TypeLiteral tr = tf.typeRetour();
		int idx = 0;
		for (TypeLiteral tl : params) {
			Champ champ = new Champ("p" + idx, tl);
			f.def.params.add(champ);
			idx++;

		}
		// f.def.tlReturn = tr;
		f.def.typeRetour = tr;

		// for(T)
		return f;

	}

	public FonctionLocal transformer(FunctionLocalContext flc) {
		FonctionLocal r = new FonctionLocal(flc.ID().getText());
		r.def = new FonctionDef();
		r.def.params = new ArrayList<Champ>();
		this.fonctionLocals.put(r, flc);
		if (flc.champs() != null) {
			for (ChampContext cc : flc.champs().champ()) {
				Champ champ = new Champ(cc.ID().getText(), this.transformer(cc.defType()));

				r.def.params.add(champ);
				this.champs.put(champ, cc);

			}

		}

		r.def.code = this.transformer(flc.tmpCode());
		return r;

	}

	public FonctionDef transformer(FunctionDefContext fdc) {
		FonctionDef r = new FonctionDef();
		r.params = new ArrayList<Champ>();
		if (fdc.champs() != null) {
			for (ChampContext cc : fdc.champs().champ()) {
				Champ champ = new Champ(cc.ID().getText(), this.transformer(cc.defType()));

				r.params.add(champ);
				this.champs.put(champ, cc);

			}

		}
		r.code = this.transformer(fdc.tmpCode());

		return r;

	}

	public TypeBasic transformer(MultipleContext mc) {
		if (mc.id_externe() != null) {
			TerminalNode mn = mc.id_externe().ID(0);
			TerminalNode tn = mc.id_externe().ID(1);
			TypeMultiple ts = new TypeMultiple(tn.getText(), mn.getText());
			this.typeMultiples.put(ts, mc);

			return ts;
		}

		TypeMultiple tm = new TypeMultiple(mc.ID().getText(), null);
		this.typeMultiples.put(tm, mc);
		return tm;

	}

	public TypeBasic transformer(SimpleContext sc) {

		if (sc.id_externe() != null) {
			TerminalNode mn = sc.id_externe().ID(0);
			TerminalNode tn = sc.id_externe().ID(1);
			TypeSimple ts = new TypeSimple(tn.getText(), mn.getText());
			this.typeSimples.put(ts, sc);
			return ts;
		}
		TypeSimple ts = new TypeSimple(sc.getText(), null);
		this.typeSimples.put(ts, sc);
		return ts;

	}

	public Objet transformer(CreerContext cc) {
		Objet r = new Objet();
		boolean multiple = cc.flagMultiple() != null;
		if (cc.id_externe() != null) {
			TerminalNode mn = cc.id_externe().ID(0);
			TerminalNode tn = cc.id_externe().ID(1);
			if (multiple) {
				r.typeRetour = new TypeMultiple(tn.getText(), mn.getText());
			} else {
				r.typeRetour = new TypeSimple(tn.getText(), mn.getText());
			}
		}
		if (cc.ID() != null) {
			if (multiple) {
				r.typeRetour = new TypeMultiple(cc.ID().getText(), null);
			} else {
				r.typeRetour = new TypeSimple(cc.ID().getText(), null);
			}
		}

		for (AttributContext ac : cc.attributs().attribut()) {
			Attribut a = r.ajouterAttribut(ac.ID().getText(), this.transformer(ac.tmpCode()));
			this.attributs.put(a, ac);

		}
		return r;

	}

	public Objet transformer(CreerListeContext clc) {
		Objet creer = null;
		Objet creerRacine = null;
		TypeMultiple tp = new TypeMultiple(clc.ID().getText(), null);

		for (AttributsContext asc : clc.attributs()) {
			Objet creerTmp = new Objet();

			creerTmp.typeRetour = tp;

			for (AttributContext ac : asc.attribut()) {
				Attribut a = creerTmp.ajouterAttribut(ac.ID().getText(), this.transformer(ac.tmpCode()));
				this.attributs.put(a, ac);
				;

			}
			if (creer != null) {

				creer.ajouterAttribut("next", creerTmp);

			} else {
				creerRacine = creerTmp;
			}
			creer = creerTmp;

		}
		this.listeCreer.put(creerRacine, clc);
		return creerRacine;
	}

	public Code transformer(CodeContext ct) {

		boolean ret = ct.operationOuAcces() == null;
		Code r = null;
		if (ct.code() != null) {
			r = transformer(ct.code());
		}
		if (ct.entier() != null) {

			Entier creer = null;
			if (ct.entier().ENTIER() != null) {
				creer = new Entier(ct.entier().ENTIER());
			}

			/*
			 * if (ct.entier().ENTIER_EXTERNE() != null) {
			 * 
			 * }
			 */
			r = creer;
			if (ret) {
				return creer;
			}

		}
		if (ct.var() != null) {

			Var v = null;
			if (ct.var().id_externe() == null) {
				v = new Var(ct.var().ID().getText(), null);
			} else {
				v = new Var(ct.var().id_externe().ID(1).getText(), ct.var().id_externe().ID(0).getText());

			}
			if (!ct.var().metaModele().getText().isEmpty()) {
				v.typeVar = Var.TypeVar.MetaModele;

			}
			this.vars.put(v, ct.var());
			r = v;
			if (ret) {
				return r;
			}
		}
		if (ct.si() != null) {
			r = this.transformer(ct.si());

		}
		if (ct.creer() != null) {
			r = this.transformer(ct.creer());

		}
		if (ct.creerListe() != null) {
			r = this.transformer(ct.creerListe());

		}

		if (ct.appel() != null) {
			AppelBase appel = null;
			ArrayList<Code> params = new ArrayList<Code>();
			for (TmpCodeContext cc : ct.appel().tmpCode()) {
				params.add(this.transformer(cc));
			}
			appel = this.transformer(ct.appel().fonctionRefAppel());
			AppelBase ab = this.appelBase(appel, params, params.size() - 1);

			this.appels.put(ab, ct.appel());

			r = ab;
			if (ret) {
				return ab;
			}

		}
		Code tmp = r;
		for (OperationOuAccesContext oc : ct.operationOuAcces()) {
			if (oc.operation() != null) {
				AppelRec appel = new AppelRec(new Var(oc.operation().operateur().getText(), null), tmp);

				appel.isOp = true;
				AppelRec appelRec = new AppelRec(appel, transformer(oc.operation().tmpCode()));
				appelRec.isOp = true;

				tmp = appelRec;
				this.operations.put(appelRec, oc.operation());

			}
			if (oc.acces() != null) {

				Acces acces = new Acces(tmp, oc.acces().ID().getText());

				tmp = acces;

			}

		}

		return tmp;

	}

	public Code transformer(SiContext sic) {

		Si si = new Si();
		si.test = transformer(sic.code(0));
		if (!sic.negation().getText().isEmpty()) {
			si.negation = true;
		}
		si.alors = transformer(sic.code(1));
		if (sic.si() != null) {
			si.sinon = transformer(sic.si());

		} else {
			si.sinon = transformer(sic.code(2));
		}
		if (sic.multiple() != null) {

			si.type = this.transformer(sic.multiple());

		}

		if (sic.simple() != null) {

			si.type = this.transformer(sic.simple());

		}
		return si;
	}

	public AppelBase appelBase(AppelBase ad, List<Code> codes, int idx) {
		if (idx < 0) {
			return ad;
		}
		return new AppelRec(appelBase(ad, codes, idx - 1), codes.get(idx));

	}

	public AppelBase transformer(FonctionRefAppelContext fr) {
		Var var = null;
		if (fr.ID() != null) {
			var = new Var(fr.ID().getText(), null);

		}
		if (fr.id_externe() != null) {
			var = new Var(fr.id_externe().ID(1).getText(), fr.id_externe().ID(0).getText());

		}
		List<AccesContext> ls = fr.acces();

		return acces(var, ls, ls.size() - 1);

	}

	public AppelBase acces(Var var, List<AccesContext> ls, int idx) {
		if (idx < 0) {
			return var;
		}
		return new Acces(acces(var, ls, idx - 1), ls.get(idx).ID().getText());

	}

	public Code transformer(TmpCodeContext tmpCode) {

		if (tmpCode.functionDef() != null) {
			FonctionDef fd = this.transformer(tmpCode.functionDef());
			String nom = "#" + this.fonctionsAnonyme.size() + "#";
			this.fonctionsAnonyme.put(nom, fd);
			Var var = new Var(nom, null);
			var.typeVar = Var.TypeVar.Fonction;
			return var;

		}
		if (tmpCode.si() != null) {
			return this.transformer(tmpCode.si());
		}
		if (tmpCode.appel() != null) {
			AppelBase appel;
			ArrayList<Code> params = new ArrayList<Code>();
			for (TmpCodeContext cc : tmpCode.appel().tmpCode()) {
				params.add(this.transformer(cc));
			}

			if (tmpCode.appel().fonctionRefAppel() != null) {

				appel = this.transformer(tmpCode.appel().fonctionRefAppel());
			} else {
				FunctionDefContext fdc = tmpCode.appel().functionDef();

				FonctionDef fd = this.transformer(fdc);

				String nom = "#" + this.fonctionsAnonyme.size() + "#";
				this.fonctionsAnonyme.put(nom, fd);
				appel = new Var(nom, null);

			}

			return appelBase(appel, params, params.size() - 1);

		}
		CodeContext ct = tmpCode.code();
		if (ct != null) {
			return transformer(ct);
		}
		return null;
	}

	public TypeLiteral transformer(TypeBaseContext tbc) {
		if (tbc.multiple() != null) {
			return this.transformer(tbc.multiple());

		}
		// TypeSimple ts = new TypeSimple(tbc);
		if (tbc.simple() != null) {
			return this.transformer(tbc.simple());
		}
		return null;
	}

	public TypeLiteral transformer(DefTypeContext dtc) {
		if (dtc.typeBase() != null) {
			return transformer(dtc.typeBase());
		}
		if (dtc.defTypeFunction() != null) {
			return transformer(dtc.defTypeFunction());

		}

		throw new Error(" " + dtc.getText());

	}

	public TypeFunction transformer(DefTypeFunctionContext dtf) {

		return this.typeFunction(this.transformer(dtf.defType()), dtf.defTypes().defType(), 0);

	}

	public TypeFunction typeFunction(TypeLiteral retour, List<DefTypeContext> ls, int idx) {
		TypeFunction tf = new TypeFunction();
		tf.param = this.transformer(ls.get(idx));
		if (ls.size() - 1 == idx) {

			tf.retour = retour;

		} else {
			tf.retour = typeFunction(retour, ls, idx + 1);
		}
		return tf;

	}

	@Override
	public void reportAmbiguity(@NotNull Parser arg0, DFA arg1, int arg2, int arg3, @NotNull BitSet arg4,
			@NotNull ATNConfigSet arg5) {
		// error=true;

	}

	@Override
	public void reportAttemptingFullContext(@NotNull Parser arg0, @NotNull DFA arg1, int arg2, int arg3,
			@NotNull ATNConfigSet arg4) {
		// error=true;

	}

	@Override
	public void reportContextSensitivity(@NotNull Parser arg0, @NotNull DFA arg1, int arg2, int arg3,
			@NotNull ATNConfigSet arg4) {
		// error=true;

	}

	@Override
	public void syntaxError(Recognizer<?, ?> arg0, @Nullable Object arg1, int arg2, int arg3, String arg4,
			@Nullable RecognitionException arg5) {
		error = true;

	}

}
