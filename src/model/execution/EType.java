package model.execution;

abstract public class EType {
	abstract String afficher(EUniversDef univers) ;
	abstract void afficher(StringBuilder sb,EUniversDef univers);
	abstract ESymbol symbol(String nom);
}
