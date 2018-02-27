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
import grammaire.lgParser.CreerContext;
import grammaire.lgParser.CreerListeContext;
import grammaire.lgParser.DefPredicatContext;
import grammaire.lgParser.DefTypeContext;
import grammaire.lgParser.DefTypeFunctionContext;
import grammaire.lgParser.ElementContext;
import grammaire.lgParser.EstTypeContext;
import grammaire.lgParser.ExistContext;
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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.Acces;
import model.Appel;
import model.Attribut;
import model.Champ;
import model.Code;
import model.Const;
import model.Creer;
import model.CreerEntier;
import model.Element;
import model.FonctionDef;
import model.FonctionLocal;
import model.Si;
import model.TypeBasic;
import model.TypeDef;
import model.TypeFunction;
import model.TypeLiteral;
import model.TypeMultiple;
import model.TypeMultipleExterne;
import model.TypeSimple;
import model.TypeSimpleExterne;
import model.Univers;
import model.Var;

import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.SimpleContent;

import components.Terminal;

public class Generateur {

	public Map<Appel, AppelContext> appels = new HashMap<>();
	public Map<Appel, OperationContext> operations = new HashMap<>();
	public Map<TypeMultiple,MultipleContext> typeMultiples = new HashMap<>();
	public Map<Creer,CreerListeContext> listeCreer = new HashMap<>();
	public Map<Var,VarContext> vars = new HashMap<>();
	public Map<TypeSimple,SimpleContext> typeSimples = new HashMap<>();
	public Map<Champ,ChampContext> champs = new HashMap<>();
	public Map<Attribut,AttributContext> attributs = new HashMap<>();
	public Map<FonctionLocal,FunctionContext> fonctions = new HashMap<>();
	public Map<FonctionLocal,FunctionLocalContext> fonctionLocals = new HashMap<>();
	public Map<TypeDef,TypeContext> types = new HashMap<>();
	public Univers lireFichier(String file) throws IOException {
		lgLexer lgLexer = new lgLexer(
				org.antlr.v4.runtime.CharStreams.fromFileName(file));
		CommonTokenStream tokens = new CommonTokenStream(lgLexer);
		lgParser parser = new lgParser(tokens);

		return this.generer(parser.system());

	}

	public Univers lireSource(String src) {

		lgLexer lgLexer = new lgLexer(
				org.antlr.v4.runtime.CharStreams.fromString(src));
		CommonTokenStream tokens = new CommonTokenStream(lgLexer);
		lgParser parser = new lgParser(tokens);

		return this.generer(parser.system());

	}

	public Univers generer(SystemContext sc) {
		List<Element> r = new ArrayList<Element>();
		for (ElementContext ec : sc.element()) {
			r.add(transformer(ec));
		}
		Univers u = new Univers();
		u.elements = r;
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
			Const c = new Const();
			c.tn = ec.constante().ID();
			c.value = this.transformer(ec.constante().tmpCode());
			return c;

		}
		return null;

	}

	public TypeDef transformer(TypeContext tc) {
	

		TypeDef td = new TypeDef(tc.ID().getText());
		
		td.multiple = tc.multipleFlag() != null;
		if (tc.superType() != null) {
			td.superType = tc.superType().ID().getText();
		}
		td.champs = new ArrayList<Champ>();
		this.types.put(td, tc);
		for (ChampContext cc : tc.champs().champ()) {
			Champ champ = new Champ(cc.ID().getText(),this.transformer(cc.defType()));
		
			td.champs.add(champ);
			this.champs.put(champ, cc);

		}
		return td;
	}

	public FonctionLocal transformer(FunctionContext fc) {
		FonctionLocal f =null;
		if (fc.ID() != null) {
			f = new FonctionLocal(fc.ID().getText());
		
		}
		if (fc.operateur() != null) {
			f = new FonctionLocal(fc.operateur().getText());
		
		}
		this.fonctions.put(f, fc);
		f.params = new ArrayList<Champ>();
		if (fc.champs() != null) {
			for (ChampContext cc : fc.champs().champ()) {
				Champ champ = new Champ(cc.ID().getText(),this.transformer(cc.defType()));
			
				f.params.add(champ);
				this.champs.put(champ, cc);
			}
			f.code = this.transformer(fc.tmpCode());

		}
		return f;

	}

	public FonctionLocal transformer(FunctionLocalContext flc) {
		FonctionLocal r = new FonctionLocal(flc.ID().getText());
	
		r.params = new ArrayList<Champ>();
		this.fonctionLocals.put(r, flc);
		if (flc.champs() != null) {
			for (ChampContext cc : flc.champs().champ()) {
				Champ champ = new Champ(cc.ID().getText(),this.transformer(cc.defType()));
	
				r.params.add(champ);
				this.champs.put(champ, cc);

			}

		}
		
		r.code = this.transformer(flc.tmpCode());
		return r;

	}

	public FonctionDef transformer(FunctionDefContext fdc) {
		FonctionDef r = new FonctionDef();
		r.params = new ArrayList<Champ>();
		if (fdc.champs() != null) {
			for (ChampContext cc : fdc.champs().champ()) {
				Champ champ = new Champ(cc.ID().getText(),this.transformer(cc.defType()));
			
				r.params.add(champ);
				this.champs.put(champ, cc);

			}

		}
		r.code = this.transformer(fdc.tmpCode());
		r.locals = new ArrayList<>();
		for (FunctionLocalContext flc : fdc.functionLocal()) {
			r.locals.add(this.transformer(flc));

		}

		return r;

	}

	public TypeBasic transformer(MultipleContext mc) {
		if (mc.id_externe() != null) {
			TerminalNode mn = mc.id_externe().ID(0);
			TerminalNode tn = mc.id_externe().ID(1);
			TypeMultipleExterne ts = new TypeMultipleExterne(tn.getText(), mn.getText());
			this.typeMultiples.put(ts, mc);

			return ts;
		}

		TypeMultiple tm= new TypeMultiple(mc.ID().getText());
		this.typeMultiples.put(tm, mc);
		return tm;

	}

	public TypeBasic transformer(SimpleContext sc) {

		if (sc.id_externe() != null) {
			TerminalNode mn = sc.id_externe().ID(0);
			TerminalNode tn = sc.id_externe().ID(1);
			TypeSimpleExterne ts = new TypeSimpleExterne(tn.getText(),mn.getText());
			this.typeSimples.put(ts, sc);
			return ts;
		}
		TypeSimple ts= new TypeSimple(sc.getText());
		this.typeSimples.put(ts, sc);
		return ts;
		

	}

	public Creer transformer(CreerContext cc) {
		Creer r = new Creer();
		if (cc.multiple() != null) {
			r.type = this.transformer(cc.multiple());
		}
		if (cc.simple() != null) {
			r.type = this.transformer(cc.simple());
		}
		r.attributs = new ArrayList<>();
		for (AttributContext ac : cc.attributs().attribut()) {
			Attribut a = new Attribut(ac.ID().getText(),this.transformer(ac.tmpCode()));
			this.attributs.put(a, ac);
			r.attributs.add(a);

		}
		return r;

	}

	public Creer transformer(CreerListeContext clc) {
		Creer creer = null;
		Creer creerRacine = null;
		TypeMultiple tp = new TypeMultiple(clc.ID().getText());
		

		for (AttributsContext asc : clc.attributs()) {
			Creer creerTmp = new Creer();
			creerTmp.type = tp;
			creerTmp.attributs = new ArrayList<>();

			for (AttributContext ac : asc.attribut()) {
				Attribut a = new Attribut(ac.ID().getText(),this.transformer(ac.tmpCode()));
				this.attributs.put(a,ac);
				creerTmp.attributs.add(a);

			}
			if (creer != null) {
				Attribut a = new Attribut("next",creerTmp);
				creer.attributs.add(a);

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

			CreerEntier creer = new CreerEntier(ct.entier().ENTIER());
			r = creer;
			if (ret) {
				return creer;
			}

		}
		if (ct.var() != null) {
			Var v = new Var(ct.var().ID().getText());

			this.vars.put(v,ct.var());
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
			Appel appel = null;
			if (ct.appel().id_externe() != null) {
				appel = new Appel(ct.appel().id_externe().ID(1).getText(), ct
						.appel().id_externe().ID(0).getText());

			} else {
				appel = new Appel(ct.appel().ID().getText(), null);
			}

			this.appels.put(appel, ct.appel());
			appel.params = new ArrayList<Code>();
			for (TmpCodeContext cc : ct.appel().tmpCode()) {
				appel.params.add(this.transformer(cc));
			}
			r = appel;
			if (ret) {
				return appel;
			}

		}
		Code tmp = r;
		for (OperationOuAccesContext oc : ct.operationOuAcces()) {
			if (oc.operation() != null) {
				Appel appel = new Appel(oc.operation().operateur().getText(),null);
				appel.isOp = true;
			
				appel.params = new ArrayList<>();
				appel.params.add(tmp);
				appel.params.add(transformer(oc.operation().tmpCode()));
				tmp = appel;
				this.operations.put(appel, oc.operation());
				
			}
			if (oc.acces() != null) {
				Acces acces = new Acces();
				acces.tn = oc.acces().ID();
				acces.objet = tmp;
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

	public Code transformer(TmpCodeContext tmpCode) {

		if (tmpCode.functionDef() != null) {
			return this.transformer(tmpCode.functionDef());

		}
		if (tmpCode.si() != null) {
			return this.transformer(tmpCode.si());
		}
		if (tmpCode.appel() != null) {
			Appel appel ;
			if (tmpCode.appel().id_externe() != null) {

				appel = new Appel(tmpCode.appel().id_externe().ID(0).getText(),tmpCode.appel().id_externe().ID(1).getText());
			} else {
				appel=  new Appel(tmpCode.appel().ID().getText(),null);
			}
			appel.params = new ArrayList<Code>();
			for (TmpCodeContext cc : tmpCode.appel().tmpCode()) {
				appel.params.add(this.transformer(cc));
			}

			return appel;

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
		TypeFunction r = new TypeFunction();
		r.retour = this.transformer(dtf.defType());
		r.params = new ArrayList<TypeLiteral>();
		for (DefTypeContext dtc : dtf.defTypes().defType()) {
			r.params.add(this.transformer(dtc));

		}

		return r;

	}

}
