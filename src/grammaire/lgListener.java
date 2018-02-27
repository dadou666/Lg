// Generated from src\grammaire\lg.g4 by ANTLR 4.0
package grammaire;
import org.antlr.v4.runtime.tree.*;
import org.antlr.v4.runtime.Token;

public interface lgListener extends ParseTreeListener {
	void enterNegation(lgParser.NegationContext ctx);
	void exitNegation(lgParser.NegationContext ctx);

	void enterChamps(lgParser.ChampsContext ctx);
	void exitChamps(lgParser.ChampsContext ctx);

	void enterCode(lgParser.CodeContext ctx);
	void exitCode(lgParser.CodeContext ctx);

	void enterAppel(lgParser.AppelContext ctx);
	void exitAppel(lgParser.AppelContext ctx);

	void enterDefTypes(lgParser.DefTypesContext ctx);
	void exitDefTypes(lgParser.DefTypesContext ctx);

	void enterOperationOuAcces(lgParser.OperationOuAccesContext ctx);
	void exitOperationOuAcces(lgParser.OperationOuAccesContext ctx);

	void enterSimple(lgParser.SimpleContext ctx);
	void exitSimple(lgParser.SimpleContext ctx);

	void enterType(lgParser.TypeContext ctx);
	void exitType(lgParser.TypeContext ctx);

	void enterTypeBase(lgParser.TypeBaseContext ctx);
	void exitTypeBase(lgParser.TypeBaseContext ctx);

	void enterDefTypeFunction(lgParser.DefTypeFunctionContext ctx);
	void exitDefTypeFunction(lgParser.DefTypeFunctionContext ctx);

	void enterDefPredicat(lgParser.DefPredicatContext ctx);
	void exitDefPredicat(lgParser.DefPredicatContext ctx);

	void enterDefType(lgParser.DefTypeContext ctx);
	void exitDefType(lgParser.DefTypeContext ctx);

	void enterConstante(lgParser.ConstanteContext ctx);
	void exitConstante(lgParser.ConstanteContext ctx);

	void enterEntier(lgParser.EntierContext ctx);
	void exitEntier(lgParser.EntierContext ctx);

	void enterSi(lgParser.SiContext ctx);
	void exitSi(lgParser.SiContext ctx);

	void enterFunction(lgParser.FunctionContext ctx);
	void exitFunction(lgParser.FunctionContext ctx);

	void enterChamp(lgParser.ChampContext ctx);
	void exitChamp(lgParser.ChampContext ctx);

	void enterElement(lgParser.ElementContext ctx);
	void exitElement(lgParser.ElementContext ctx);

	void enterAll(lgParser.AllContext ctx);
	void exitAll(lgParser.AllContext ctx);

	void enterMultipleFlag(lgParser.MultipleFlagContext ctx);
	void exitMultipleFlag(lgParser.MultipleFlagContext ctx);

	void enterVar(lgParser.VarContext ctx);
	void exitVar(lgParser.VarContext ctx);

	void enterAttribut(lgParser.AttributContext ctx);
	void exitAttribut(lgParser.AttributContext ctx);

	void enterMultiple(lgParser.MultipleContext ctx);
	void exitMultiple(lgParser.MultipleContext ctx);

	void enterFunctionLocal(lgParser.FunctionLocalContext ctx);
	void exitFunctionLocal(lgParser.FunctionLocalContext ctx);

	void enterAcces(lgParser.AccesContext ctx);
	void exitAcces(lgParser.AccesContext ctx);

	void enterCreer(lgParser.CreerContext ctx);
	void exitCreer(lgParser.CreerContext ctx);

	void enterAttributs(lgParser.AttributsContext ctx);
	void exitAttributs(lgParser.AttributsContext ctx);

	void enterExist(lgParser.ExistContext ctx);
	void exitExist(lgParser.ExistContext ctx);

	void enterCreerListe(lgParser.CreerListeContext ctx);
	void exitCreerListe(lgParser.CreerListeContext ctx);

	void enterSystem(lgParser.SystemContext ctx);
	void exitSystem(lgParser.SystemContext ctx);

	void enterId_externe(lgParser.Id_externeContext ctx);
	void exitId_externe(lgParser.Id_externeContext ctx);

	void enterFunctionDef(lgParser.FunctionDefContext ctx);
	void exitFunctionDef(lgParser.FunctionDefContext ctx);

	void enterTmpCode(lgParser.TmpCodeContext ctx);
	void exitTmpCode(lgParser.TmpCodeContext ctx);

	void enterOperateur(lgParser.OperateurContext ctx);
	void exitOperateur(lgParser.OperateurContext ctx);

	void enterAbstractFlag(lgParser.AbstractFlagContext ctx);
	void exitAbstractFlag(lgParser.AbstractFlagContext ctx);

	void enterSuperType(lgParser.SuperTypeContext ctx);
	void exitSuperType(lgParser.SuperTypeContext ctx);

	void enterOperation(lgParser.OperationContext ctx);
	void exitOperation(lgParser.OperationContext ctx);

	void enterEstType(lgParser.EstTypeContext ctx);
	void exitEstType(lgParser.EstTypeContext ctx);
}