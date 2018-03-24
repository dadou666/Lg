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

import java.awt.Color;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.SwingUtilities;

import model.semantique.Acces;
import model.semantique.Attribut;
import model.semantique.Champ;
import model.semantique.Code;
import model.semantique.Element;
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
import model.semantique.Var;

import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.misc.Interval;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;

import components.Terminal;

public class ColorerSource {
	public Color colorType = Color.RED;
	public Color colorAttribut = Color.GREEN;
	public Color colorParam = Color.BLUE;
	public Color colorFonction = Color.ORANGE;
	public Color colorModule = Color.magenta;
	public Color colorEntier =Color.PINK;

	public List<MotAvecCouleur> ls = new ArrayList<>();

	public ColorerSource() {

	}

	public SystemContext lireSource(String src) {

		lgLexer lgLexer = new lgLexer(
				org.antlr.v4.runtime.CharStreams.fromString(src));
		CommonTokenStream tokens = new CommonTokenStream(lgLexer);
		lgParser parser = new lgParser(tokens);
		SystemContext sys = parser.system();
		for (ElementContext ec : sys.element()) {
			transformer(ec);
		}
		
		return sys;

	}

	public void transformer(ElementContext ec) {
		if (ec.function() != null) {
			transformer(ec.function());
		}
		if (ec.type() != null) {
			transformer(ec.type());
		}
		if (ec.constante() != null) {
			this.colorerParam(ec.constante().ID());
			transformer(ec.constante().tmpCode());
		}
		if (ec.defPredicat() != null) {
			this.transformer(ec.defPredicat());
		}

	}

	public void transformer(DefPredicatContext defpredicat) {
		this.colorerFonction(defpredicat.ID());
		if (defpredicat.champs() != null) {
			for (ChampContext cc : defpredicat.champs().champ()) {

				this.colorerParam(cc.ID());

				this.transformer(cc.defType());

			}

		}
		if (defpredicat.exist() != null) {
			this.transformer(defpredicat.exist());
		}
		if (defpredicat.all() != null) {
			this.transformer(defpredicat.all());
		}

	}

	public void transformer(ExistContext ec) {
		for (ChampContext cc : ec.champs().champ()) {

			this.colorerParam(cc.ID());

			this.transformer(cc.defType());

		}
		if (ec.all() != null) {
			this.transformer(ec.all());

		}
		if (ec.estType() != null) {
			this.transformer(ec.estType());

		}

	}

	public void transformer(EstTypeContext estType) {
		this.transformer(estType.tmpCode());
	}

	public void transformer(AllContext ac) {
		for (ChampContext cc : ac.champs().champ()) {

			this.colorerParam(cc.ID());

			this.transformer(cc.defType());

		}
		if (ac.exist() != null) {
			this.transformer(ac.exist());
		}
		if (ac.estType() != null) {
			this.transformer(ac.estType());

		}
	}

	public void colorer(final TerminalNode tn, final Color c) {
		if (tn == null) {
			return;
		}

		int start = tn.getSymbol().getStartIndex();
		int l = tn.getSymbol().getStopIndex() - start;
		MotAvecCouleur mot = new MotAvecCouleur();
		mot.debut = start;
		mot.taille = l + 1;
		mot.color = c;
		this.ls.add(mot);

	}

	public void colorer(final ParserRuleContext tn, final Color c) {

		int start = tn.start.getStartIndex();
		int l = tn.stop.getStopIndex() - start;
		MotAvecCouleur mot = new MotAvecCouleur();
		mot.debut = start;
		mot.taille = l + 1;
		mot.color = c;
		this.ls.add(mot);
	}

	public void colorerType(TerminalNode tn) {
		// System.out.println(" colorer type " +
		// tn.getSourceInterval().length());
		this.colorer(tn, this.colorType);

	}

	public void colorerModule(TerminalNode tn) {
		// System.out.println(" colorer type " +
		// tn.getSourceInterval().length());
		this.colorer(tn, this.colorModule);

	}

	public void colorerParam(TerminalNode tn) {
		this.colorer(tn, this.colorParam);

	}

	public void colorerAttribut(TerminalNode tn) {
		this.colorer(tn, this.colorAttribut);

	}

	public void colorerFonction(TerminalNode tn) {
		this.colorer(tn, this.colorFonction);
	}

	public void transformer(TypeContext tc) {

		colorerType(tc.ID());

		if (tc.superType() != null) {

			this.colorerType(tc.superType().ID());

		}

		if (tc.champs() != null)
			for (ChampContext cc : tc.champs().champ()) {

				this.transformer(cc.defType());
				this.colorerAttribut(cc.ID());

			}

	}

	public void transformer(FunctionContext fc) {
		if (fc.ID() != null) {
			this.colorerFonction(fc.ID());
		}
		if (fc.operateur() != null) {
			this.colorer(fc.operateur(), this.colorFonction);
		}

		if (fc.champs() != null) {
			for (ChampContext cc : fc.champs().champ()) {

				this.colorerParam(cc.ID());

				this.transformer(cc.defType());

			}

		}
		this.transformer(fc.tmpCode());

	}

	public void transformer(FunctionLocalContext flc) {

		this.colorerFonction(flc.ID());

		if (flc.champs() != null) {
			for (ChampContext cc : flc.champs().champ()) {

				this.colorerParam(cc.ID());

				this.transformer(cc.defType());

			}

		}
		this.transformer(flc.tmpCode());

	}

	public void transformer(FunctionDefContext fdc) {
		if (fdc == null) {
			return;
		}
		if (fdc.champs() != null) {
			for (ChampContext cc : fdc.champs().champ()) {

				this.colorerParam(cc.ID());

				this.transformer(cc.defType());

			}

		}
		if (fdc.tmpCode() != null) {
			this.transformer(fdc.tmpCode());
		}

	

	}

	public void transformer(CreerContext cc) {
		
		if (cc.id_externe() != null) {
			this.colorerModule(cc.id_externe() .ID(0));
			this.colorerType(cc.id_externe() .ID(1));
		}
		if (cc.ID() != null) {
			this.colorerType(cc.ID());
		}
		for (AttributContext ac : cc.attributs().attribut()) {

			this.colorerAttribut(ac.ID());
			this.transformer(ac.tmpCode());

		}

	}

	public void transformer(MultipleContext mc) {
		if (mc.id_externe() != null) {

			this.colorerModule(mc.id_externe().ID(0));
			this.colorerType(mc.id_externe().ID(1));
			return;

		}

		this.colorerType(mc.ID());

	}

	public void transformer(SimpleContext sc) {

		if (sc.id_externe() != null) {

			this.colorerModule(sc.id_externe().ID(0));
			this.colorerType(sc.id_externe().ID(1));
			return;
		}
		this.colorer(sc, this.colorType);

	}

	public void transformer(CreerListeContext clc) {

		this.colorerType(clc.ID());

		for (AttributsContext asc : clc.attributs()) {

			for (AttributContext ac : asc.attribut()) {
			
				this.colorerAttribut(ac.ID());
				this.transformer(ac.tmpCode());

			}
		}

	}

	public void transformer(CodeContext ct) {
		if (ct == null) {
			return;
		}
		boolean ret = ct.operationOuAcces() == null;

		if (ct.code() != null) {
			transformer(ct.code());
		}
		if (ct.entier() != null) {
			this.colorer(ct.entier().ENTIER(), colorEntier);
			if (ret) {
				return;
			}
			
		}
		if (ct.var() != null) {
			this.colorerParam(ct.var().ID());

			if (ret) {
				return;
			}
		}
		if (ct.si() != null) {
			this.transformer(ct.si());
		}
		if (ct.creer() != null) {
			this.transformer(ct.creer());

		}
		if (ct.creerListe() != null) {
			this.transformer(ct.creerListe());

		}
		if (ct.appel() != null) {

			this.colorerFonction(ct.appel().ID());

			for (TmpCodeContext cc : ct.appel().tmpCode()) {
				this.transformer(cc);
			}

			if (ret) {
				return;
			}

		}

		for (OperationOuAccesContext oc : ct.operationOuAcces()) {
			if (oc.operation() != null) {

				this.colorer(oc.operation().operateur(), this.colorFonction);
				transformer(oc.operation().tmpCode());

			}
			if (oc.acces() != null) {

				this.colorerAttribut(oc.acces().ID());

			}

		}

	}

	public void transformer(SiContext sic) {
		transformer(sic.code(0));
		transformer(sic.code(1));
		if (sic.si() != null) {
			transformer(sic.si());
		} else {
			transformer(sic.code(2));
		}
		if (sic.multiple() != null) {

			this.transformer(sic.multiple());

		}

		if (sic.simple() != null) {
			this.transformer(sic.simple());

		}

	}

	public void transformer(TmpCodeContext tmpCode) {
		if (tmpCode == null) {
			return;
		}
		if (tmpCode.functionDef() != null) {
			this.transformer(tmpCode.functionDef());
			return;
		}
		if (tmpCode.si() != null) {
			this.transformer(tmpCode.si());

		}
		if (tmpCode.appel() != null) {

			this.colorerFonction(tmpCode.appel().ID());

			for (TmpCodeContext cc : tmpCode.appel().tmpCode()) {
				this.transformer(cc);
			}

			return;

		}
		CodeContext ct = tmpCode.code();
		if (ct != null) {
			transformer(ct);
		}

	}

	public void transformer(TypeBaseContext tbc) {
		if (tbc.multiple() != null) {
			this.transformer(tbc.multiple());
			return;
		}
	
		this.transformer(tbc.simple());
	}

	public void transformer(DefTypeContext dtc) {
		if (dtc == null) {
			return;
		}
		if (dtc.typeBase() != null) {
			transformer(dtc.typeBase());

		}
		if (dtc.defTypeFunction() != null) {
			transformer(dtc.defTypeFunction());

		}

	}

	public void transformer(DefTypeFunctionContext dtf) {
		this.transformer(dtf.defType());

		for (DefTypeContext dtc : dtf.defTypes().defType()) {
			this.transformer(dtc);

		}

	}

}
