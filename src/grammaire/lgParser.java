// Generated from src\grammaire\lg.g4 by ANTLR 4.0
package grammaire;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class lgParser extends Parser {
	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__34=1, T__33=2, T__32=3, T__31=4, T__30=5, T__29=6, T__28=7, T__27=8, 
		T__26=9, T__25=10, T__24=11, T__23=12, T__22=13, T__21=14, T__20=15, T__19=16, 
		T__18=17, T__17=18, T__16=19, T__15=20, T__14=21, T__13=22, T__12=23, 
		T__11=24, T__10=25, T__9=26, T__8=27, T__7=28, T__6=29, T__5=30, T__4=31, 
		T__3=32, T__2=33, T__1=34, T__0=35, ENTIER=36, ENTIER_EXTERNE=37, ID=38, 
		WS=39;
	public static final String[] tokenNames = {
		"<INVALID>", "'/'", "'{'", "'='", "'}'", "'if'", "'$'", "'All'", "'&'", 
		"'('", "'is'", "'predicat'", "'*'", "'.'", "'->'", "'abstract'", "'const'", 
		"':'", "'['", "'|'", "'<'", "']'", "'>'", "'@'", "'type'", "'!'", "'=>'", 
		"'#'", "'Exist'", "'%'", "'else'", "'function'", "')'", "'then'", "'+'", 
		"'-'", "ENTIER", "ENTIER_EXTERNE", "ID", "WS"
	};
	public static final int
		RULE_system = 0, RULE_element = 1, RULE_constante = 2, RULE_type = 3, 
		RULE_multipleFlag = 4, RULE_abstractFlag = 5, RULE_superType = 6, RULE_champs = 7, 
		RULE_champ = 8, RULE_multiple = 9, RULE_simple = 10, RULE_typeBase = 11, 
		RULE_attribut = 12, RULE_defTypeFunction = 13, RULE_defTypes = 14, RULE_defType = 15, 
		RULE_attributs = 16, RULE_code = 17, RULE_var = 18, RULE_metaModele = 19, 
		RULE_entier = 20, RULE_appel = 21, RULE_flagMultiple = 22, RULE_creer = 23, 
		RULE_creerListe = 24, RULE_id_externe = 25, RULE_acces = 26, RULE_fonctionRefAppel = 27, 
		RULE_operation = 28, RULE_operationOuAcces = 29, RULE_operateur = 30, 
		RULE_si = 31, RULE_negation = 32, RULE_function = 33, RULE_functionDef = 34, 
		RULE_functionLocal = 35, RULE_tmpCode = 36, RULE_exist = 37, RULE_all = 38, 
		RULE_estType = 39, RULE_defPredicat = 40;
	public static final String[] ruleNames = {
		"system", "element", "constante", "type", "multipleFlag", "abstractFlag", 
		"superType", "champs", "champ", "multiple", "simple", "typeBase", "attribut", 
		"defTypeFunction", "defTypes", "defType", "attributs", "code", "var", 
		"metaModele", "entier", "appel", "flagMultiple", "creer", "creerListe", 
		"id_externe", "acces", "fonctionRefAppel", "operation", "operationOuAcces", 
		"operateur", "si", "negation", "function", "functionDef", "functionLocal", 
		"tmpCode", "exist", "all", "estType", "defPredicat"
	};

	@Override
	public String getGrammarFileName() { return "lg.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public lgParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class SystemContext extends ParserRuleContext {
		public List<ElementContext> element() {
			return getRuleContexts(ElementContext.class);
		}
		public ElementContext element(int i) {
			return getRuleContext(ElementContext.class,i);
		}
		public SystemContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_system; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof lgListener ) ((lgListener)listener).enterSystem(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof lgListener ) ((lgListener)listener).exitSystem(this);
		}
	}

	public final SystemContext system() throws RecognitionException {
		SystemContext _localctx = new SystemContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_system);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(85);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 11) | (1L << 15) | (1L << 16) | (1L << 24) | (1L << 31))) != 0)) {
				{
				{
				setState(82); element();
				}
				}
				setState(87);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ElementContext extends ParserRuleContext {
		public DefPredicatContext defPredicat() {
			return getRuleContext(DefPredicatContext.class,0);
		}
		public ConstanteContext constante() {
			return getRuleContext(ConstanteContext.class,0);
		}
		public FunctionContext function() {
			return getRuleContext(FunctionContext.class,0);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public ElementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_element; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof lgListener ) ((lgListener)listener).enterElement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof lgListener ) ((lgListener)listener).exitElement(this);
		}
	}

	public final ElementContext element() throws RecognitionException {
		ElementContext _localctx = new ElementContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_element);
		try {
			setState(92);
			switch (_input.LA(1)) {
			case 15:
			case 24:
				enterOuterAlt(_localctx, 1);
				{
				setState(88); type();
				}
				break;
			case 31:
				enterOuterAlt(_localctx, 2);
				{
				setState(89); function();
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 3);
				{
				setState(90); defPredicat();
				}
				break;
			case 16:
				enterOuterAlt(_localctx, 4);
				{
				setState(91); constante();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ConstanteContext extends ParserRuleContext {
		public TmpCodeContext tmpCode() {
			return getRuleContext(TmpCodeContext.class,0);
		}
		public TerminalNode ID() { return getToken(lgParser.ID, 0); }
		public ConstanteContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constante; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof lgListener ) ((lgListener)listener).enterConstante(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof lgListener ) ((lgListener)listener).exitConstante(this);
		}
	}

	public final ConstanteContext constante() throws RecognitionException {
		ConstanteContext _localctx = new ConstanteContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_constante);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(94); match(16);
			setState(95); match(ID);
			setState(96); tmpCode();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypeContext extends ParserRuleContext {
		public ChampsContext champs() {
			return getRuleContext(ChampsContext.class,0);
		}
		public MultipleFlagContext multipleFlag() {
			return getRuleContext(MultipleFlagContext.class,0);
		}
		public TerminalNode ID() { return getToken(lgParser.ID, 0); }
		public AbstractFlagContext abstractFlag() {
			return getRuleContext(AbstractFlagContext.class,0);
		}
		public SuperTypeContext superType() {
			return getRuleContext(SuperTypeContext.class,0);
		}
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof lgListener ) ((lgListener)listener).enterType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof lgListener ) ((lgListener)listener).exitType(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_type);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(98); abstractFlag();
			setState(99); match(24);
			setState(102);
			switch (_input.LA(1)) {
			case 23:
				{
				setState(100); multipleFlag();
				}
				break;
			case ID:
				{
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(104); match(ID);
			setState(107);
			switch (_input.LA(1)) {
			case 17:
				{
				setState(105); superType();
				}
				break;
			case 2:
				{
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(109); match(2);
			setState(110); champs();
			setState(111); match(4);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MultipleFlagContext extends ParserRuleContext {
		public MultipleFlagContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_multipleFlag; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof lgListener ) ((lgListener)listener).enterMultipleFlag(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof lgListener ) ((lgListener)listener).exitMultipleFlag(this);
		}
	}

	public final MultipleFlagContext multipleFlag() throws RecognitionException {
		MultipleFlagContext _localctx = new MultipleFlagContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_multipleFlag);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(113); match(23);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AbstractFlagContext extends ParserRuleContext {
		public AbstractFlagContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_abstractFlag; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof lgListener ) ((lgListener)listener).enterAbstractFlag(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof lgListener ) ((lgListener)listener).exitAbstractFlag(this);
		}
	}

	public final AbstractFlagContext abstractFlag() throws RecognitionException {
		AbstractFlagContext _localctx = new AbstractFlagContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_abstractFlag);
		try {
			setState(117);
			switch (_input.LA(1)) {
			case 15:
				enterOuterAlt(_localctx, 1);
				{
				setState(115); match(15);
				}
				break;
			case 24:
				enterOuterAlt(_localctx, 2);
				{
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SuperTypeContext extends ParserRuleContext {
		public Id_externeContext id_externe() {
			return getRuleContext(Id_externeContext.class,0);
		}
		public TerminalNode ID() { return getToken(lgParser.ID, 0); }
		public SuperTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_superType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof lgListener ) ((lgListener)listener).enterSuperType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof lgListener ) ((lgListener)listener).exitSuperType(this);
		}
	}

	public final SuperTypeContext superType() throws RecognitionException {
		SuperTypeContext _localctx = new SuperTypeContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_superType);
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(119); match(17);
			setState(122);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				{
				setState(120); match(ID);
				}
				break;

			case 2:
				{
				setState(121); id_externe();
				}
				break;
			}
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ChampsContext extends ParserRuleContext {
		public ChampContext champ(int i) {
			return getRuleContext(ChampContext.class,i);
		}
		public List<ChampContext> champ() {
			return getRuleContexts(ChampContext.class);
		}
		public ChampsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_champs; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof lgListener ) ((lgListener)listener).enterChamps(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof lgListener ) ((lgListener)listener).exitChamps(this);
		}
	}

	public final ChampsContext champs() throws RecognitionException {
		ChampsContext _localctx = new ChampsContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_champs);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(127);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 18) | (1L << 23) | (1L << ID))) != 0)) {
				{
				{
				setState(124); champ();
				}
				}
				setState(129);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ChampContext extends ParserRuleContext {
		public DefTypeContext defType() {
			return getRuleContext(DefTypeContext.class,0);
		}
		public TerminalNode ID() { return getToken(lgParser.ID, 0); }
		public ChampContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_champ; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof lgListener ) ((lgListener)listener).enterChamp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof lgListener ) ((lgListener)listener).exitChamp(this);
		}
	}

	public final ChampContext champ() throws RecognitionException {
		ChampContext _localctx = new ChampContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_champ);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(130); defType();
			setState(131); match(17);
			setState(132); match(ID);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MultipleContext extends ParserRuleContext {
		public Id_externeContext id_externe() {
			return getRuleContext(Id_externeContext.class,0);
		}
		public TerminalNode ID() { return getToken(lgParser.ID, 0); }
		public MultipleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_multiple; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof lgListener ) ((lgListener)listener).enterMultiple(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof lgListener ) ((lgListener)listener).exitMultiple(this);
		}
	}

	public final MultipleContext multiple() throws RecognitionException {
		MultipleContext _localctx = new MultipleContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_multiple);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(134); match(23);
			setState(137);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				{
				setState(135); match(ID);
				}
				break;

			case 2:
				{
				setState(136); id_externe();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SimpleContext extends ParserRuleContext {
		public Id_externeContext id_externe() {
			return getRuleContext(Id_externeContext.class,0);
		}
		public TerminalNode ID() { return getToken(lgParser.ID, 0); }
		public SimpleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_simple; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof lgListener ) ((lgListener)listener).enterSimple(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof lgListener ) ((lgListener)listener).exitSimple(this);
		}
	}

	public final SimpleContext simple() throws RecognitionException {
		SimpleContext _localctx = new SimpleContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_simple);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(141);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				{
				setState(139); match(ID);
				}
				break;

			case 2:
				{
				setState(140); id_externe();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypeBaseContext extends ParserRuleContext {
		public MultipleContext multiple() {
			return getRuleContext(MultipleContext.class,0);
		}
		public SimpleContext simple() {
			return getRuleContext(SimpleContext.class,0);
		}
		public TypeBaseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeBase; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof lgListener ) ((lgListener)listener).enterTypeBase(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof lgListener ) ((lgListener)listener).exitTypeBase(this);
		}
	}

	public final TypeBaseContext typeBase() throws RecognitionException {
		TypeBaseContext _localctx = new TypeBaseContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_typeBase);
		try {
			setState(145);
			switch (_input.LA(1)) {
			case 23:
				enterOuterAlt(_localctx, 1);
				{
				setState(143); multiple();
				}
				break;
			case ID:
				enterOuterAlt(_localctx, 2);
				{
				setState(144); simple();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AttributContext extends ParserRuleContext {
		public TmpCodeContext tmpCode() {
			return getRuleContext(TmpCodeContext.class,0);
		}
		public TerminalNode ID() { return getToken(lgParser.ID, 0); }
		public AttributContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_attribut; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof lgListener ) ((lgListener)listener).enterAttribut(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof lgListener ) ((lgListener)listener).exitAttribut(this);
		}
	}

	public final AttributContext attribut() throws RecognitionException {
		AttributContext _localctx = new AttributContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_attribut);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(147); match(ID);
			setState(148); match(3);
			setState(149); tmpCode();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DefTypeFunctionContext extends ParserRuleContext {
		public DefTypeContext defType() {
			return getRuleContext(DefTypeContext.class,0);
		}
		public DefTypesContext defTypes() {
			return getRuleContext(DefTypesContext.class,0);
		}
		public DefTypeFunctionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_defTypeFunction; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof lgListener ) ((lgListener)listener).enterDefTypeFunction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof lgListener ) ((lgListener)listener).exitDefTypeFunction(this);
		}
	}

	public final DefTypeFunctionContext defTypeFunction() throws RecognitionException {
		DefTypeFunctionContext _localctx = new DefTypeFunctionContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_defTypeFunction);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(151); match(18);
			setState(152); defTypes();
			setState(153); match(21);
			setState(154); match(14);
			setState(155); defType();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DefTypesContext extends ParserRuleContext {
		public DefTypeContext defType(int i) {
			return getRuleContext(DefTypeContext.class,i);
		}
		public List<DefTypeContext> defType() {
			return getRuleContexts(DefTypeContext.class);
		}
		public DefTypesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_defTypes; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof lgListener ) ((lgListener)listener).enterDefTypes(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof lgListener ) ((lgListener)listener).exitDefTypes(this);
		}
	}

	public final DefTypesContext defTypes() throws RecognitionException {
		DefTypesContext _localctx = new DefTypesContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_defTypes);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(160);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 18) | (1L << 23) | (1L << ID))) != 0)) {
				{
				{
				setState(157); defType();
				}
				}
				setState(162);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DefTypeContext extends ParserRuleContext {
		public TypeBaseContext typeBase() {
			return getRuleContext(TypeBaseContext.class,0);
		}
		public DefTypeFunctionContext defTypeFunction() {
			return getRuleContext(DefTypeFunctionContext.class,0);
		}
		public DefTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_defType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof lgListener ) ((lgListener)listener).enterDefType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof lgListener ) ((lgListener)listener).exitDefType(this);
		}
	}

	public final DefTypeContext defType() throws RecognitionException {
		DefTypeContext _localctx = new DefTypeContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_defType);
		try {
			setState(165);
			switch (_input.LA(1)) {
			case 23:
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(163); typeBase();
				}
				break;
			case 18:
				enterOuterAlt(_localctx, 2);
				{
				setState(164); defTypeFunction();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AttributsContext extends ParserRuleContext {
		public List<AttributContext> attribut() {
			return getRuleContexts(AttributContext.class);
		}
		public AttributContext attribut(int i) {
			return getRuleContext(AttributContext.class,i);
		}
		public AttributsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_attributs; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof lgListener ) ((lgListener)listener).enterAttributs(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof lgListener ) ((lgListener)listener).exitAttributs(this);
		}
	}

	public final AttributsContext attributs() throws RecognitionException {
		AttributsContext _localctx = new AttributsContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_attributs);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(170);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==ID) {
				{
				{
				setState(167); attribut();
				}
				}
				setState(172);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CodeContext extends ParserRuleContext {
		public CreerListeContext creerListe() {
			return getRuleContext(CreerListeContext.class,0);
		}
		public CodeContext code() {
			return getRuleContext(CodeContext.class,0);
		}
		public AppelContext appel() {
			return getRuleContext(AppelContext.class,0);
		}
		public VarContext var() {
			return getRuleContext(VarContext.class,0);
		}
		public EntierContext entier() {
			return getRuleContext(EntierContext.class,0);
		}
		public SiContext si() {
			return getRuleContext(SiContext.class,0);
		}
		public List<OperationOuAccesContext> operationOuAcces() {
			return getRuleContexts(OperationOuAccesContext.class);
		}
		public OperationOuAccesContext operationOuAcces(int i) {
			return getRuleContext(OperationOuAccesContext.class,i);
		}
		public CreerContext creer() {
			return getRuleContext(CreerContext.class,0);
		}
		public CodeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_code; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof lgListener ) ((lgListener)listener).enterCode(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof lgListener ) ((lgListener)listener).exitCode(this);
		}
	}

	public final CodeContext code() throws RecognitionException {
		CodeContext _localctx = new CodeContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_code);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(188);
			switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
			case 1:
				{
				{
				setState(173); match(9);
				setState(174); code();
				setState(175); match(32);
				}
				}
				break;

			case 2:
				{
				setState(186);
				switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
				case 1:
					{
					setState(177); appel();
					}
					break;

				case 2:
					{
					setState(178); creerListe();
					}
					break;

				case 3:
					{
					setState(179); creer();
					}
					break;

				case 4:
					{
					setState(180); var();
					}
					break;

				case 5:
					{
					setState(181); entier();
					}
					break;

				case 6:
					{
					{
					setState(182); match(9);
					{
					setState(183); si();
					}
					setState(184); match(32);
					}
					}
					break;
				}
				}
				break;
			}
			setState(193);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					{
					{
					setState(190); operationOuAcces();
					}
					} 
				}
				setState(195);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VarContext extends ParserRuleContext {
		public Id_externeContext id_externe() {
			return getRuleContext(Id_externeContext.class,0);
		}
		public MetaModeleContext metaModele() {
			return getRuleContext(MetaModeleContext.class,0);
		}
		public TerminalNode ID() { return getToken(lgParser.ID, 0); }
		public VarContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_var; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof lgListener ) ((lgListener)listener).enterVar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof lgListener ) ((lgListener)listener).exitVar(this);
		}
	}

	public final VarContext var() throws RecognitionException {
		VarContext _localctx = new VarContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_var);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(196); metaModele();
			setState(199);
			switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
			case 1:
				{
				setState(197); match(ID);
				}
				break;

			case 2:
				{
				setState(198); id_externe();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MetaModeleContext extends ParserRuleContext {
		public MetaModeleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_metaModele; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof lgListener ) ((lgListener)listener).enterMetaModele(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof lgListener ) ((lgListener)listener).exitMetaModele(this);
		}
	}

	public final MetaModeleContext metaModele() throws RecognitionException {
		MetaModeleContext _localctx = new MetaModeleContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_metaModele);
		try {
			setState(203);
			switch (_input.LA(1)) {
			case 29:
				enterOuterAlt(_localctx, 1);
				{
				setState(201); match(29);
				}
				break;
			case ID:
				enterOuterAlt(_localctx, 2);
				{
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class EntierContext extends ParserRuleContext {
		public TerminalNode ENTIER_EXTERNE() { return getToken(lgParser.ENTIER_EXTERNE, 0); }
		public TerminalNode ENTIER() { return getToken(lgParser.ENTIER, 0); }
		public EntierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_entier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof lgListener ) ((lgListener)listener).enterEntier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof lgListener ) ((lgListener)listener).exitEntier(this);
		}
	}

	public final EntierContext entier() throws RecognitionException {
		EntierContext _localctx = new EntierContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_entier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(205);
			_la = _input.LA(1);
			if ( !(_la==ENTIER || _la==ENTIER_EXTERNE) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AppelContext extends ParserRuleContext {
		public FonctionRefAppelContext fonctionRefAppel() {
			return getRuleContext(FonctionRefAppelContext.class,0);
		}
		public FunctionDefContext functionDef() {
			return getRuleContext(FunctionDefContext.class,0);
		}
		public List<TmpCodeContext> tmpCode() {
			return getRuleContexts(TmpCodeContext.class);
		}
		public TmpCodeContext tmpCode(int i) {
			return getRuleContext(TmpCodeContext.class,i);
		}
		public AppelContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_appel; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof lgListener ) ((lgListener)listener).enterAppel(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof lgListener ) ((lgListener)listener).exitAppel(this);
		}
	}

	public final AppelContext appel() throws RecognitionException {
		AppelContext _localctx = new AppelContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_appel);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(209);
			switch (_input.LA(1)) {
			case ID:
				{
				setState(207); fonctionRefAppel();
				}
				break;
			case 27:
				{
				setState(208); functionDef();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(211); match(9);
			setState(215);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 5) | (1L << 9) | (1L << 23) | (1L << 27) | (1L << 29) | (1L << ENTIER) | (1L << ENTIER_EXTERNE) | (1L << ID))) != 0)) {
				{
				{
				setState(212); tmpCode();
				}
				}
				setState(217);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(218); match(32);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FlagMultipleContext extends ParserRuleContext {
		public FlagMultipleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_flagMultiple; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof lgListener ) ((lgListener)listener).enterFlagMultiple(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof lgListener ) ((lgListener)listener).exitFlagMultiple(this);
		}
	}

	public final FlagMultipleContext flagMultiple() throws RecognitionException {
		FlagMultipleContext _localctx = new FlagMultipleContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_flagMultiple);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(220); match(23);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CreerContext extends ParserRuleContext {
		public Id_externeContext id_externe() {
			return getRuleContext(Id_externeContext.class,0);
		}
		public TerminalNode ID() { return getToken(lgParser.ID, 0); }
		public AttributsContext attributs() {
			return getRuleContext(AttributsContext.class,0);
		}
		public FlagMultipleContext flagMultiple() {
			return getRuleContext(FlagMultipleContext.class,0);
		}
		public CreerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_creer; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof lgListener ) ((lgListener)listener).enterCreer(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof lgListener ) ((lgListener)listener).exitCreer(this);
		}
	}

	public final CreerContext creer() throws RecognitionException {
		CreerContext _localctx = new CreerContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_creer);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(224);
			switch (_input.LA(1)) {
			case 23:
				{
				setState(222); flagMultiple();
				}
				break;
			case ID:
				{
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(228);
			switch ( getInterpreter().adaptivePredict(_input,21,_ctx) ) {
			case 1:
				{
				setState(226); match(ID);
				}
				break;

			case 2:
				{
				setState(227); id_externe();
				}
				break;
			}
			setState(230); match(2);
			setState(231); attributs();
			setState(232); match(4);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CreerListeContext extends ParserRuleContext {
		public AttributsContext attributs(int i) {
			return getRuleContext(AttributsContext.class,i);
		}
		public TerminalNode ID() { return getToken(lgParser.ID, 0); }
		public List<AttributsContext> attributs() {
			return getRuleContexts(AttributsContext.class);
		}
		public CreerListeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_creerListe; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof lgListener ) ((lgListener)listener).enterCreerListe(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof lgListener ) ((lgListener)listener).exitCreerListe(this);
		}
	}

	public final CreerListeContext creerListe() throws RecognitionException {
		CreerListeContext _localctx = new CreerListeContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_creerListe);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(234); match(ID);
			setState(235); match(18);
			{
			{
			setState(240); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(236); match(2);
				setState(237); attributs();
				setState(238); match(4);
				}
				}
				setState(242); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==2 );
			}
			}
			setState(244); match(21);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Id_externeContext extends ParserRuleContext {
		public List<TerminalNode> ID() { return getTokens(lgParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(lgParser.ID, i);
		}
		public Id_externeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_id_externe; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof lgListener ) ((lgListener)listener).enterId_externe(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof lgListener ) ((lgListener)listener).exitId_externe(this);
		}
	}

	public final Id_externeContext id_externe() throws RecognitionException {
		Id_externeContext _localctx = new Id_externeContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_id_externe);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(246); match(ID);
			setState(247); match(6);
			setState(248); match(ID);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AccesContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(lgParser.ID, 0); }
		public AccesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_acces; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof lgListener ) ((lgListener)listener).enterAcces(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof lgListener ) ((lgListener)listener).exitAcces(this);
		}
	}

	public final AccesContext acces() throws RecognitionException {
		AccesContext _localctx = new AccesContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_acces);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(250); match(13);
			setState(251); match(ID);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FonctionRefAppelContext extends ParserRuleContext {
		public Id_externeContext id_externe() {
			return getRuleContext(Id_externeContext.class,0);
		}
		public AccesContext acces(int i) {
			return getRuleContext(AccesContext.class,i);
		}
		public List<AccesContext> acces() {
			return getRuleContexts(AccesContext.class);
		}
		public TerminalNode ID() { return getToken(lgParser.ID, 0); }
		public FonctionRefAppelContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fonctionRefAppel; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof lgListener ) ((lgListener)listener).enterFonctionRefAppel(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof lgListener ) ((lgListener)listener).exitFonctionRefAppel(this);
		}
	}

	public final FonctionRefAppelContext fonctionRefAppel() throws RecognitionException {
		FonctionRefAppelContext _localctx = new FonctionRefAppelContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_fonctionRefAppel);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(255);
			switch ( getInterpreter().adaptivePredict(_input,23,_ctx) ) {
			case 1:
				{
				setState(253); match(ID);
				}
				break;

			case 2:
				{
				setState(254); id_externe();
				}
				break;
			}
			setState(260);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==13) {
				{
				{
				setState(257); acces();
				}
				}
				setState(262);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OperationContext extends ParserRuleContext {
		public TmpCodeContext tmpCode() {
			return getRuleContext(TmpCodeContext.class,0);
		}
		public OperateurContext operateur() {
			return getRuleContext(OperateurContext.class,0);
		}
		public OperationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_operation; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof lgListener ) ((lgListener)listener).enterOperation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof lgListener ) ((lgListener)listener).exitOperation(this);
		}
	}

	public final OperationContext operation() throws RecognitionException {
		OperationContext _localctx = new OperationContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_operation);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(263); operateur();
			setState(264); tmpCode();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OperationOuAccesContext extends ParserRuleContext {
		public AccesContext acces() {
			return getRuleContext(AccesContext.class,0);
		}
		public OperationContext operation() {
			return getRuleContext(OperationContext.class,0);
		}
		public OperationOuAccesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_operationOuAcces; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof lgListener ) ((lgListener)listener).enterOperationOuAcces(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof lgListener ) ((lgListener)listener).exitOperationOuAcces(this);
		}
	}

	public final OperationOuAccesContext operationOuAcces() throws RecognitionException {
		OperationOuAccesContext _localctx = new OperationOuAccesContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_operationOuAcces);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(268);
			switch (_input.LA(1)) {
			case 13:
				{
				setState(266); acces();
				}
				break;
			case 1:
			case 3:
			case 8:
			case 12:
			case 14:
			case 19:
			case 20:
			case 22:
			case 26:
			case 34:
			case 35:
				{
				setState(267); operation();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OperateurContext extends ParserRuleContext {
		public OperateurContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_operateur; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof lgListener ) ((lgListener)listener).enterOperateur(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof lgListener ) ((lgListener)listener).exitOperateur(this);
		}
	}

	public final OperateurContext operateur() throws RecognitionException {
		OperateurContext _localctx = new OperateurContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_operateur);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(270);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 1) | (1L << 3) | (1L << 8) | (1L << 12) | (1L << 14) | (1L << 19) | (1L << 20) | (1L << 22) | (1L << 26) | (1L << 34) | (1L << 35))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SiContext extends ParserRuleContext {
		public NegationContext negation() {
			return getRuleContext(NegationContext.class,0);
		}
		public List<CodeContext> code() {
			return getRuleContexts(CodeContext.class);
		}
		public SiContext si() {
			return getRuleContext(SiContext.class,0);
		}
		public MultipleContext multiple() {
			return getRuleContext(MultipleContext.class,0);
		}
		public SimpleContext simple() {
			return getRuleContext(SimpleContext.class,0);
		}
		public CodeContext code(int i) {
			return getRuleContext(CodeContext.class,i);
		}
		public SiContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_si; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof lgListener ) ((lgListener)listener).enterSi(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof lgListener ) ((lgListener)listener).exitSi(this);
		}
	}

	public final SiContext si() throws RecognitionException {
		SiContext _localctx = new SiContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_si);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(272); match(5);
			setState(273); code();
			setState(274); match(10);
			setState(275); negation();
			setState(278);
			switch (_input.LA(1)) {
			case ID:
				{
				setState(276); simple();
				}
				break;
			case 23:
				{
				setState(277); multiple();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(280); match(33);
			setState(281); code();
			setState(282); match(30);
			setState(285);
			switch (_input.LA(1)) {
			case 5:
				{
				setState(283); si();
				}
				break;
			case 9:
			case 23:
			case 27:
			case 29:
			case ENTIER:
			case ENTIER_EXTERNE:
			case ID:
				{
				setState(284); code();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NegationContext extends ParserRuleContext {
		public NegationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_negation; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof lgListener ) ((lgListener)listener).enterNegation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof lgListener ) ((lgListener)listener).exitNegation(this);
		}
	}

	public final NegationContext negation() throws RecognitionException {
		NegationContext _localctx = new NegationContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_negation);
		try {
			setState(289);
			switch (_input.LA(1)) {
			case 25:
				enterOuterAlt(_localctx, 1);
				{
				setState(287); match(25);
				}
				break;
			case 23:
			case ID:
				enterOuterAlt(_localctx, 2);
				{
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FunctionContext extends ParserRuleContext {
		public ChampsContext champs() {
			return getRuleContext(ChampsContext.class,0);
		}
		public TmpCodeContext tmpCode() {
			return getRuleContext(TmpCodeContext.class,0);
		}
		public TerminalNode ID() { return getToken(lgParser.ID, 0); }
		public OperateurContext operateur() {
			return getRuleContext(OperateurContext.class,0);
		}
		public FunctionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof lgListener ) ((lgListener)listener).enterFunction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof lgListener ) ((lgListener)listener).exitFunction(this);
		}
	}

	public final FunctionContext function() throws RecognitionException {
		FunctionContext _localctx = new FunctionContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_function);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(291); match(31);
			setState(294);
			switch (_input.LA(1)) {
			case ID:
				{
				setState(292); match(ID);
				}
				break;
			case 1:
			case 3:
			case 8:
			case 12:
			case 14:
			case 19:
			case 20:
			case 22:
			case 26:
			case 34:
			case 35:
				{
				setState(293); operateur();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(296); champs();
			setState(297); match(19);
			setState(298); tmpCode();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FunctionDefContext extends ParserRuleContext {
		public ChampsContext champs() {
			return getRuleContext(ChampsContext.class,0);
		}
		public TmpCodeContext tmpCode() {
			return getRuleContext(TmpCodeContext.class,0);
		}
		public FunctionDefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionDef; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof lgListener ) ((lgListener)listener).enterFunctionDef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof lgListener ) ((lgListener)listener).exitFunctionDef(this);
		}
	}

	public final FunctionDefContext functionDef() throws RecognitionException {
		FunctionDefContext _localctx = new FunctionDefContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_functionDef);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(300); match(27);
			setState(301); match(2);
			setState(302); champs();
			setState(303); match(19);
			setState(304); tmpCode();
			setState(305); match(4);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FunctionLocalContext extends ParserRuleContext {
		public ChampsContext champs() {
			return getRuleContext(ChampsContext.class,0);
		}
		public TmpCodeContext tmpCode() {
			return getRuleContext(TmpCodeContext.class,0);
		}
		public TerminalNode ID() { return getToken(lgParser.ID, 0); }
		public FunctionLocalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionLocal; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof lgListener ) ((lgListener)listener).enterFunctionLocal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof lgListener ) ((lgListener)listener).exitFunctionLocal(this);
		}
	}

	public final FunctionLocalContext functionLocal() throws RecognitionException {
		FunctionLocalContext _localctx = new FunctionLocalContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_functionLocal);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(307); match(ID);
			setState(308); match(3);
			setState(309); champs();
			setState(310); match(19);
			setState(311); tmpCode();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TmpCodeContext extends ParserRuleContext {
		public AppelContext appel() {
			return getRuleContext(AppelContext.class,0);
		}
		public CodeContext code() {
			return getRuleContext(CodeContext.class,0);
		}
		public SiContext si() {
			return getRuleContext(SiContext.class,0);
		}
		public FunctionDefContext functionDef() {
			return getRuleContext(FunctionDefContext.class,0);
		}
		public TmpCodeContext tmpCode() {
			return getRuleContext(TmpCodeContext.class,0);
		}
		public TmpCodeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tmpCode; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof lgListener ) ((lgListener)listener).enterTmpCode(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof lgListener ) ((lgListener)listener).exitTmpCode(this);
		}
	}

	public final TmpCodeContext tmpCode() throws RecognitionException {
		TmpCodeContext _localctx = new TmpCodeContext(_ctx, getState());
		enterRule(_localctx, 72, RULE_tmpCode);
		try {
			setState(321);
			switch ( getInterpreter().adaptivePredict(_input,30,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(313); functionDef();
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(314); appel();
				}
				break;

			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(315); si();
				}
				break;

			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(316); code();
				}
				break;

			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(317); match(9);
				setState(318); tmpCode();
				setState(319); match(32);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExistContext extends ParserRuleContext {
		public ExistContext exist() {
			return getRuleContext(ExistContext.class,0);
		}
		public AllContext all() {
			return getRuleContext(AllContext.class,0);
		}
		public ChampsContext champs() {
			return getRuleContext(ChampsContext.class,0);
		}
		public EstTypeContext estType() {
			return getRuleContext(EstTypeContext.class,0);
		}
		public ExistContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exist; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof lgListener ) ((lgListener)listener).enterExist(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof lgListener ) ((lgListener)listener).exitExist(this);
		}
	}

	public final ExistContext exist() throws RecognitionException {
		ExistContext _localctx = new ExistContext(_ctx, getState());
		enterRule(_localctx, 74, RULE_exist);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(323); match(28);
			setState(324); champs();
			setState(325); match(19);
			setState(329);
			switch (_input.LA(1)) {
			case 28:
				{
				setState(326); exist();
				}
				break;
			case 7:
				{
				setState(327); all();
				}
				break;
			case 5:
			case 9:
			case 23:
			case 27:
			case 29:
			case ENTIER:
			case ENTIER_EXTERNE:
			case ID:
				{
				setState(328); estType();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AllContext extends ParserRuleContext {
		public ExistContext exist() {
			return getRuleContext(ExistContext.class,0);
		}
		public AllContext all() {
			return getRuleContext(AllContext.class,0);
		}
		public ChampsContext champs() {
			return getRuleContext(ChampsContext.class,0);
		}
		public EstTypeContext estType() {
			return getRuleContext(EstTypeContext.class,0);
		}
		public AllContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_all; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof lgListener ) ((lgListener)listener).enterAll(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof lgListener ) ((lgListener)listener).exitAll(this);
		}
	}

	public final AllContext all() throws RecognitionException {
		AllContext _localctx = new AllContext(_ctx, getState());
		enterRule(_localctx, 76, RULE_all);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(331); match(7);
			setState(332); champs();
			setState(333); match(19);
			setState(337);
			switch (_input.LA(1)) {
			case 28:
				{
				setState(334); exist();
				}
				break;
			case 7:
				{
				setState(335); all();
				}
				break;
			case 5:
			case 9:
			case 23:
			case 27:
			case 29:
			case ENTIER:
			case ENTIER_EXTERNE:
			case ID:
				{
				setState(336); estType();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class EstTypeContext extends ParserRuleContext {
		public DefTypeContext defType() {
			return getRuleContext(DefTypeContext.class,0);
		}
		public TmpCodeContext tmpCode() {
			return getRuleContext(TmpCodeContext.class,0);
		}
		public EstTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_estType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof lgListener ) ((lgListener)listener).enterEstType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof lgListener ) ((lgListener)listener).exitEstType(this);
		}
	}

	public final EstTypeContext estType() throws RecognitionException {
		EstTypeContext _localctx = new EstTypeContext(_ctx, getState());
		enterRule(_localctx, 78, RULE_estType);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(339); tmpCode();
			setState(340); match(10);
			setState(341); defType();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DefPredicatContext extends ParserRuleContext {
		public ExistContext exist() {
			return getRuleContext(ExistContext.class,0);
		}
		public AllContext all() {
			return getRuleContext(AllContext.class,0);
		}
		public ChampsContext champs() {
			return getRuleContext(ChampsContext.class,0);
		}
		public TerminalNode ID() { return getToken(lgParser.ID, 0); }
		public DefPredicatContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_defPredicat; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof lgListener ) ((lgListener)listener).enterDefPredicat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof lgListener ) ((lgListener)listener).exitDefPredicat(this);
		}
	}

	public final DefPredicatContext defPredicat() throws RecognitionException {
		DefPredicatContext _localctx = new DefPredicatContext(_ctx, getState());
		enterRule(_localctx, 80, RULE_defPredicat);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(343); match(11);
			setState(344); match(ID);
			setState(345); champs();
			setState(346); match(19);
			setState(349);
			switch (_input.LA(1)) {
			case 28:
				{
				setState(347); exist();
				}
				break;
			case 7:
				{
				setState(348); all();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\2\3)\u0162\4\2\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4"+
		"\t\t\t\4\n\t\n\4\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20"+
		"\4\21\t\21\4\22\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27"+
		"\4\30\t\30\4\31\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36"+
		"\4\37\t\37\4 \t \4!\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4"+
		")\t)\4*\t*\3\2\7\2V\n\2\f\2\16\2Y\13\2\3\3\3\3\3\3\3\3\5\3_\n\3\3\4\3"+
		"\4\3\4\3\4\3\5\3\5\3\5\3\5\5\5i\n\5\3\5\3\5\3\5\5\5n\n\5\3\5\3\5\3\5\3"+
		"\5\3\6\3\6\3\7\3\7\5\7x\n\7\3\b\3\b\3\b\5\b}\n\b\3\t\7\t\u0080\n\t\f\t"+
		"\16\t\u0083\13\t\3\n\3\n\3\n\3\n\3\13\3\13\3\13\5\13\u008c\n\13\3\f\3"+
		"\f\5\f\u0090\n\f\3\r\3\r\5\r\u0094\n\r\3\16\3\16\3\16\3\16\3\17\3\17\3"+
		"\17\3\17\3\17\3\17\3\20\7\20\u00a1\n\20\f\20\16\20\u00a4\13\20\3\21\3"+
		"\21\5\21\u00a8\n\21\3\22\7\22\u00ab\n\22\f\22\16\22\u00ae\13\22\3\23\3"+
		"\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\5\23\u00bd"+
		"\n\23\5\23\u00bf\n\23\3\23\7\23\u00c2\n\23\f\23\16\23\u00c5\13\23\3\24"+
		"\3\24\3\24\5\24\u00ca\n\24\3\25\3\25\5\25\u00ce\n\25\3\26\3\26\3\27\3"+
		"\27\5\27\u00d4\n\27\3\27\3\27\7\27\u00d8\n\27\f\27\16\27\u00db\13\27\3"+
		"\27\3\27\3\30\3\30\3\31\3\31\5\31\u00e3\n\31\3\31\3\31\5\31\u00e7\n\31"+
		"\3\31\3\31\3\31\3\31\3\32\3\32\3\32\3\32\3\32\3\32\6\32\u00f3\n\32\r\32"+
		"\16\32\u00f4\3\32\3\32\3\33\3\33\3\33\3\33\3\34\3\34\3\34\3\35\3\35\5"+
		"\35\u0102\n\35\3\35\7\35\u0105\n\35\f\35\16\35\u0108\13\35\3\36\3\36\3"+
		"\36\3\37\3\37\5\37\u010f\n\37\3 \3 \3!\3!\3!\3!\3!\3!\5!\u0119\n!\3!\3"+
		"!\3!\3!\3!\5!\u0120\n!\3\"\3\"\5\"\u0124\n\"\3#\3#\3#\5#\u0129\n#\3#\3"+
		"#\3#\3#\3$\3$\3$\3$\3$\3$\3$\3%\3%\3%\3%\3%\3%\3&\3&\3&\3&\3&\3&\3&\3"+
		"&\5&\u0144\n&\3\'\3\'\3\'\3\'\3\'\3\'\5\'\u014c\n\'\3(\3(\3(\3(\3(\3("+
		"\5(\u0154\n(\3)\3)\3)\3)\3*\3*\3*\3*\3*\3*\5*\u0160\n*\3*\2+\2\4\6\b\n"+
		"\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\64\668:<>@BDFHJLNPR\2\4\3"+
		"&\'\13\3\3\5\5\n\n\16\16\20\20\25\26\30\30\34\34$%\u0165\2W\3\2\2\2\4"+
		"^\3\2\2\2\6`\3\2\2\2\bd\3\2\2\2\ns\3\2\2\2\fw\3\2\2\2\16y\3\2\2\2\20\u0081"+
		"\3\2\2\2\22\u0084\3\2\2\2\24\u0088\3\2\2\2\26\u008f\3\2\2\2\30\u0093\3"+
		"\2\2\2\32\u0095\3\2\2\2\34\u0099\3\2\2\2\36\u00a2\3\2\2\2 \u00a7\3\2\2"+
		"\2\"\u00ac\3\2\2\2$\u00be\3\2\2\2&\u00c6\3\2\2\2(\u00cd\3\2\2\2*\u00cf"+
		"\3\2\2\2,\u00d3\3\2\2\2.\u00de\3\2\2\2\60\u00e2\3\2\2\2\62\u00ec\3\2\2"+
		"\2\64\u00f8\3\2\2\2\66\u00fc\3\2\2\28\u0101\3\2\2\2:\u0109\3\2\2\2<\u010e"+
		"\3\2\2\2>\u0110\3\2\2\2@\u0112\3\2\2\2B\u0123\3\2\2\2D\u0125\3\2\2\2F"+
		"\u012e\3\2\2\2H\u0135\3\2\2\2J\u0143\3\2\2\2L\u0145\3\2\2\2N\u014d\3\2"+
		"\2\2P\u0155\3\2\2\2R\u0159\3\2\2\2TV\5\4\3\2UT\3\2\2\2VY\3\2\2\2WU\3\2"+
		"\2\2WX\3\2\2\2X\3\3\2\2\2YW\3\2\2\2Z_\5\b\5\2[_\5D#\2\\_\5R*\2]_\5\6\4"+
		"\2^Z\3\2\2\2^[\3\2\2\2^\\\3\2\2\2^]\3\2\2\2_\5\3\2\2\2`a\7\22\2\2ab\7"+
		"(\2\2bc\5J&\2c\7\3\2\2\2de\5\f\7\2eh\7\32\2\2fi\5\n\6\2gi\3\2\2\2hf\3"+
		"\2\2\2hg\3\2\2\2ij\3\2\2\2jm\7(\2\2kn\5\16\b\2ln\3\2\2\2mk\3\2\2\2ml\3"+
		"\2\2\2no\3\2\2\2op\7\4\2\2pq\5\20\t\2qr\7\6\2\2r\t\3\2\2\2st\7\31\2\2"+
		"t\13\3\2\2\2ux\7\21\2\2vx\3\2\2\2wu\3\2\2\2wv\3\2\2\2x\r\3\2\2\2y|\7\23"+
		"\2\2z}\7(\2\2{}\5\64\33\2|z\3\2\2\2|{\3\2\2\2}\17\3\2\2\2~\u0080\5\22"+
		"\n\2\177~\3\2\2\2\u0080\u0083\3\2\2\2\u0081\177\3\2\2\2\u0081\u0082\3"+
		"\2\2\2\u0082\21\3\2\2\2\u0083\u0081\3\2\2\2\u0084\u0085\5 \21\2\u0085"+
		"\u0086\7\23\2\2\u0086\u0087\7(\2\2\u0087\23\3\2\2\2\u0088\u008b\7\31\2"+
		"\2\u0089\u008c\7(\2\2\u008a\u008c\5\64\33\2\u008b\u0089\3\2\2\2\u008b"+
		"\u008a\3\2\2\2\u008c\25\3\2\2\2\u008d\u0090\7(\2\2\u008e\u0090\5\64\33"+
		"\2\u008f\u008d\3\2\2\2\u008f\u008e\3\2\2\2\u0090\27\3\2\2\2\u0091\u0094"+
		"\5\24\13\2\u0092\u0094\5\26\f\2\u0093\u0091\3\2\2\2\u0093\u0092\3\2\2"+
		"\2\u0094\31\3\2\2\2\u0095\u0096\7(\2\2\u0096\u0097\7\5\2\2\u0097\u0098"+
		"\5J&\2\u0098\33\3\2\2\2\u0099\u009a\7\24\2\2\u009a\u009b\5\36\20\2\u009b"+
		"\u009c\7\27\2\2\u009c\u009d\7\20\2\2\u009d\u009e\5 \21\2\u009e\35\3\2"+
		"\2\2\u009f\u00a1\5 \21\2\u00a0\u009f\3\2\2\2\u00a1\u00a4\3\2\2\2\u00a2"+
		"\u00a0\3\2\2\2\u00a2\u00a3\3\2\2\2\u00a3\37\3\2\2\2\u00a4\u00a2\3\2\2"+
		"\2\u00a5\u00a8\5\30\r\2\u00a6\u00a8\5\34\17\2\u00a7\u00a5\3\2\2\2\u00a7"+
		"\u00a6\3\2\2\2\u00a8!\3\2\2\2\u00a9\u00ab\5\32\16\2\u00aa\u00a9\3\2\2"+
		"\2\u00ab\u00ae\3\2\2\2\u00ac\u00aa\3\2\2\2\u00ac\u00ad\3\2\2\2\u00ad#"+
		"\3\2\2\2\u00ae\u00ac\3\2\2\2\u00af\u00b0\7\13\2\2\u00b0\u00b1\5$\23\2"+
		"\u00b1\u00b2\7\"\2\2\u00b2\u00bf\3\2\2\2\u00b3\u00bd\5,\27\2\u00b4\u00bd"+
		"\5\62\32\2\u00b5\u00bd\5\60\31\2\u00b6\u00bd\5&\24\2\u00b7\u00bd\5*\26"+
		"\2\u00b8\u00b9\7\13\2\2\u00b9\u00ba\5@!\2\u00ba\u00bb\7\"\2\2\u00bb\u00bd"+
		"\3\2\2\2\u00bc\u00b3\3\2\2\2\u00bc\u00b4\3\2\2\2\u00bc\u00b5\3\2\2\2\u00bc"+
		"\u00b6\3\2\2\2\u00bc\u00b7\3\2\2\2\u00bc\u00b8\3\2\2\2\u00bd\u00bf\3\2"+
		"\2\2\u00be\u00af\3\2\2\2\u00be\u00bc\3\2\2\2\u00bf\u00c3\3\2\2\2\u00c0"+
		"\u00c2\5<\37\2\u00c1\u00c0\3\2\2\2\u00c2\u00c5\3\2\2\2\u00c3\u00c1\3\2"+
		"\2\2\u00c3\u00c4\3\2\2\2\u00c4%\3\2\2\2\u00c5\u00c3\3\2\2\2\u00c6\u00c9"+
		"\5(\25\2\u00c7\u00ca\7(\2\2\u00c8\u00ca\5\64\33\2\u00c9\u00c7\3\2\2\2"+
		"\u00c9\u00c8\3\2\2\2\u00ca\'\3\2\2\2\u00cb\u00ce\7\37\2\2\u00cc\u00ce"+
		"\3\2\2\2\u00cd\u00cb\3\2\2\2\u00cd\u00cc\3\2\2\2\u00ce)\3\2\2\2\u00cf"+
		"\u00d0\t\2\2\2\u00d0+\3\2\2\2\u00d1\u00d4\58\35\2\u00d2\u00d4\5F$\2\u00d3"+
		"\u00d1\3\2\2\2\u00d3\u00d2\3\2\2\2\u00d4\u00d5\3\2\2\2\u00d5\u00d9\7\13"+
		"\2\2\u00d6\u00d8\5J&\2\u00d7\u00d6\3\2\2\2\u00d8\u00db\3\2\2\2\u00d9\u00d7"+
		"\3\2\2\2\u00d9\u00da\3\2\2\2\u00da\u00dc\3\2\2\2\u00db\u00d9\3\2\2\2\u00dc"+
		"\u00dd\7\"\2\2\u00dd-\3\2\2\2\u00de\u00df\7\31\2\2\u00df/\3\2\2\2\u00e0"+
		"\u00e3\5.\30\2\u00e1\u00e3\3\2\2\2\u00e2\u00e0\3\2\2\2\u00e2\u00e1\3\2"+
		"\2\2\u00e3\u00e6\3\2\2\2\u00e4\u00e7\7(\2\2\u00e5\u00e7\5\64\33\2\u00e6"+
		"\u00e4\3\2\2\2\u00e6\u00e5\3\2\2\2\u00e7\u00e8\3\2\2\2\u00e8\u00e9\7\4"+
		"\2\2\u00e9\u00ea\5\"\22\2\u00ea\u00eb\7\6\2\2\u00eb\61\3\2\2\2\u00ec\u00ed"+
		"\7(\2\2\u00ed\u00f2\7\24\2\2\u00ee\u00ef\7\4\2\2\u00ef\u00f0\5\"\22\2"+
		"\u00f0\u00f1\7\6\2\2\u00f1\u00f3\3\2\2\2\u00f2\u00ee\3\2\2\2\u00f3\u00f4"+
		"\3\2\2\2\u00f4\u00f2\3\2\2\2\u00f4\u00f5\3\2\2\2\u00f5\u00f6\3\2\2\2\u00f6"+
		"\u00f7\7\27\2\2\u00f7\63\3\2\2\2\u00f8\u00f9\7(\2\2\u00f9\u00fa\7\b\2"+
		"\2\u00fa\u00fb\7(\2\2\u00fb\65\3\2\2\2\u00fc\u00fd\7\17\2\2\u00fd\u00fe"+
		"\7(\2\2\u00fe\67\3\2\2\2\u00ff\u0102\7(\2\2\u0100\u0102\5\64\33\2\u0101"+
		"\u00ff\3\2\2\2\u0101\u0100\3\2\2\2\u0102\u0106\3\2\2\2\u0103\u0105\5\66"+
		"\34\2\u0104\u0103\3\2\2\2\u0105\u0108\3\2\2\2\u0106\u0104\3\2\2\2\u0106"+
		"\u0107\3\2\2\2\u01079\3\2\2\2\u0108\u0106\3\2\2\2\u0109\u010a\5> \2\u010a"+
		"\u010b\5J&\2\u010b;\3\2\2\2\u010c\u010f\5\66\34\2\u010d\u010f\5:\36\2"+
		"\u010e\u010c\3\2\2\2\u010e\u010d\3\2\2\2\u010f=\3\2\2\2\u0110\u0111\t"+
		"\3\2\2\u0111?\3\2\2\2\u0112\u0113\7\7\2\2\u0113\u0114\5$\23\2\u0114\u0115"+
		"\7\f\2\2\u0115\u0118\5B\"\2\u0116\u0119\5\26\f\2\u0117\u0119\5\24\13\2"+
		"\u0118\u0116\3\2\2\2\u0118\u0117\3\2\2\2\u0119\u011a\3\2\2\2\u011a\u011b"+
		"\7#\2\2\u011b\u011c\5$\23\2\u011c\u011f\7 \2\2\u011d\u0120\5@!\2\u011e"+
		"\u0120\5$\23\2\u011f\u011d\3\2\2\2\u011f\u011e\3\2\2\2\u0120A\3\2\2\2"+
		"\u0121\u0124\7\33\2\2\u0122\u0124\3\2\2\2\u0123\u0121\3\2\2\2\u0123\u0122"+
		"\3\2\2\2\u0124C\3\2\2\2\u0125\u0128\7!\2\2\u0126\u0129\7(\2\2\u0127\u0129"+
		"\5> \2\u0128\u0126\3\2\2\2\u0128\u0127\3\2\2\2\u0129\u012a\3\2\2\2\u012a"+
		"\u012b\5\20\t\2\u012b\u012c\7\25\2\2\u012c\u012d\5J&\2\u012dE\3\2\2\2"+
		"\u012e\u012f\7\35\2\2\u012f\u0130\7\4\2\2\u0130\u0131\5\20\t\2\u0131\u0132"+
		"\7\25\2\2\u0132\u0133\5J&\2\u0133\u0134\7\6\2\2\u0134G\3\2\2\2\u0135\u0136"+
		"\7(\2\2\u0136\u0137\7\5\2\2\u0137\u0138\5\20\t\2\u0138\u0139\7\25\2\2"+
		"\u0139\u013a\5J&\2\u013aI\3\2\2\2\u013b\u0144\5F$\2\u013c\u0144\5,\27"+
		"\2\u013d\u0144\5@!\2\u013e\u0144\5$\23\2\u013f\u0140\7\13\2\2\u0140\u0141"+
		"\5J&\2\u0141\u0142\7\"\2\2\u0142\u0144\3\2\2\2\u0143\u013b\3\2\2\2\u0143"+
		"\u013c\3\2\2\2\u0143\u013d\3\2\2\2\u0143\u013e\3\2\2\2\u0143\u013f\3\2"+
		"\2\2\u0144K\3\2\2\2\u0145\u0146\7\36\2\2\u0146\u0147\5\20\t\2\u0147\u014b"+
		"\7\25\2\2\u0148\u014c\5L\'\2\u0149\u014c\5N(\2\u014a\u014c\5P)\2\u014b"+
		"\u0148\3\2\2\2\u014b\u0149\3\2\2\2\u014b\u014a\3\2\2\2\u014cM\3\2\2\2"+
		"\u014d\u014e\7\t\2\2\u014e\u014f\5\20\t\2\u014f\u0153\7\25\2\2\u0150\u0154"+
		"\5L\'\2\u0151\u0154\5N(\2\u0152\u0154\5P)\2\u0153\u0150\3\2\2\2\u0153"+
		"\u0151\3\2\2\2\u0153\u0152\3\2\2\2\u0154O\3\2\2\2\u0155\u0156\5J&\2\u0156"+
		"\u0157\7\f\2\2\u0157\u0158\5 \21\2\u0158Q\3\2\2\2\u0159\u015a\7\r\2\2"+
		"\u015a\u015b\7(\2\2\u015b\u015c\5\20\t\2\u015c\u015f\7\25\2\2\u015d\u0160"+
		"\5L\'\2\u015e\u0160\5N(\2\u015f\u015d\3\2\2\2\u015f\u015e\3\2\2\2\u0160"+
		"S\3\2\2\2$W^hmw|\u0081\u008b\u008f\u0093\u00a2\u00a7\u00ac\u00bc\u00be"+
		"\u00c3\u00c9\u00cd\u00d3\u00d9\u00e2\u00e6\u00f4\u0101\u0106\u010e\u0118"+
		"\u011f\u0123\u0128\u0143\u014b\u0153\u015f";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
	}
}