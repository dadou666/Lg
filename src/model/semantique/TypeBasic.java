package model.semantique;

import model.execution.EType;
import model.execution.ETypeObjet;
import model.execution.ETypeRef;
import model.execution.EUniversDef;

import org.antlr.v4.runtime.tree.TerminalNode;

abstract public class TypeBasic extends TypeLiteral implements Reference {
	public abstract String nom();

	public abstract void nom(String nom);

	public boolean estMultiple() {
		return false;
	}
	public EType compiler(EUniversDef machine,Univers u) {
		ETypeObjet eto= machine.donnerType(nom(), u);
		return new ETypeRef(eto.idx);
	}
	public TypeLiteral typeUnion(TypeLiteral tl, Univers u) {
		if (!(tl instanceof TypeBasic)) {
			return null;
		}
		TypeBasic tb = (TypeBasic) tl;

		return typeUnion(tb, u);
	}

	public TypeBasic typeUnion(TypeBasic tl, Univers u) {
		if (tl.nom().equals(nom())) {
			return tl;
		}
		String typeUnion = u.typeUnion(this.nom(), tl.nom());
		if (typeUnion == null) {
			return null;
		}
		if (typeUnion.charAt(0) =='*') {
			TypeMultiple tp = new TypeMultiple(null,null);
			tp.nom(typeUnion);
			return tp;
		}
		TypeSimple ts = new TypeSimple(null,null);
		ts.nom(typeUnion);
		return ts;
	}

	

}
