package model.semantique;

import java.util.Map;
import java.util.Set;

import model.execution.ECode;
import model.execution.EEntier;
import model.execution.EFonction;
import model.execution.EFonctionRef;
import model.execution.ELocal;
import model.execution.ETypeObjet;
import model.execution.EUnivers;
import model.execution.EUniversDef;

import org.antlr.v4.runtime.tree.TerminalNode;

public class Var extends Code implements Reference {
	private String nom;
	private String module;

	public enum TypeVar {
		Local, Fonction, Constante, MetaModele ,MetaModeleFunction,MetaModeleType,MetaModeleUnivers
	};

	public TypeVar typeVar;

	public ECode compiler(Univers u, EUniversDef machine) {
		if (typeVar == TypeVar.Local) {
			return new ELocal(machine.fonctionCourante.map.get(nom),nom);
		}
		if (typeVar == TypeVar.Fonction) {
			EFonction ef = machine.donnerFonction(nom(), u);
			return new EFonctionRef(ef.idx);
		}
		if (typeVar == TypeVar.Constante) {
			return machine.donnerConstante(nom(), u);
		}
		if (typeVar == TypeVar.MetaModeleFunction ){
			EFonction ef = machine.donnerFonction(nom(), u);
			ETypeObjet to = machine.donnerType("metaModele$ref", u);
			EEntier e = new EEntier();
			e.idx =to.idx;
			e.valeur =ef.idx;
			return e;
		}
		if (typeVar == TypeVar.MetaModeleType ){
			ETypeObjet to = machine.donnerType(nom(), u);
			ETypeObjet toRef = machine.donnerType("metaModele$ref", u);
			EEntier e = new EEntier();
			e.idx =toRef.idx;
			e.valeur =to.idx;
			return e;
		}
		if (typeVar == TypeVar.MetaModeleUnivers ) {
			return new EUnivers();
		}
		return null;
	}

	public Var(String nom, String module) {
		this.nom = nom;
		this.module = module;
	}

	public String toString() {
		return nom();
	}

	public String nom() {
		if (module != null) {
			return module + "$" + nom;
		}
		return nom;
	}

	public void donnerModules(Set<String> modules) {
		if (module != null) {
			modules.add(module);
		}
	}

	public void assignerModule(String nom) {
		if (typeVar == TypeVar.Local) {
			return;
		}
		if (module == null) {
			module = nom;
		}

	}
	public boolean estAccesMetaModele() {
		if (typeVar == TypeVar.MetaModele) {
			return true;
		}
		if (typeVar == TypeVar.MetaModeleFunction) {
			return true;
		}
		if (typeVar == TypeVar.MetaModeleType) {
			return true;
		}
		if (typeVar == TypeVar.MetaModeleUnivers) {
			return true;
		}
		return false;
	}
	public TypeLiteral typeRetour(Univers u, Map<String, TypeLiteral> variables) {
		if (typeRetour != null) {
			return typeRetour;
		}
		if (estAccesMetaModele() ) {
			String nomObjet = this.nom;
			if (module != null) {
				nomObjet = module + "$" + this.nom;
			}
			if (nomObjet.equals("univers")) {
				typeVar =TypeVar.MetaModeleUnivers;
				return new TypeSimple("universDef", "metaModele");
			}
			FonctionLocal fd = u.donnerFonction(nomObjet);
			if (fd != null) {
				typeVar = TypeVar.MetaModeleFunction;
				return new TypeSimple("ref", "metaModele");
			}
			TypeDef td = u.donnerType(nomObjet);
			if (td != null) {
				typeVar =TypeVar.MetaModeleType;
				return new TypeSimple("ref", "metaModele");
			}
			u.erreurs.add(new ObjetInconnu(this));
			return null;

		}
		TypeLiteral tl = variables.get(nom());
		if (tl != null) {
			typeVar = TypeVar.Local;
			typeRetour = tl;
			return tl;
		}

		Const c = u.constantes.get(nom());
		if (c == null) {
			FonctionLocal fl = u.donnerFonction(nom());
			if (fl != null) {
				typeVar = TypeVar.Fonction;

				fl.tl(u);

				typeRetour = fl.def.typeFunction(u, variables);
				return typeRetour;
			}
			u.erreurs.add(new ObjetInconnu(this));
			return null;
		}
		typeVar = TypeVar.Constante;
		typeRetour= c.tl(u);
		return typeRetour;

	}

	public TypeLiteral ajouterPourSi(Si si, Map<String, TypeLiteral> variables) {
		TypeLiteral oldTL = variables.get(nom());
		variables.put(nom(), si.type);
		return oldTL;
	}

	public void supprimerPourSi(Map<String, TypeLiteral> variables,
			TypeLiteral tl) {
		if (tl != null) {
			variables.put(nom, tl);
		}

	}

	@Override
	public String nomRef() {
		// TODO Auto-generated method stub
		return nom();
	}

}
