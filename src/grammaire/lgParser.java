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
		T__33=1, T__32=2, T__31=3, T__30=4, T__29=5, T__28=6, T__27=7, T__26=8, 
		T__25=9, T__24=10, T__23=11, T__22=12, T__21=13, T__20=14, T__19=15, T__18=16, 
		T__17=17, T__16=18, T__15=19, T__14=20, T__13=21, T__12=22, T__11=23, 
		T__10=24, T__9=25, T__8=26, T__7=27, T__6=28, T__5=29, T__4=30, T__3=31, 
		T__2=32, T__1=33, T__0=34, ENTIER=35, ID=36, WS=37;
	public static final String[] tokenNames = {
		"<INVALID>", "'/'", "'{'", "'='", "'}'", "'if'", "'$'", "'All'", "'&'", 
		"'('", "'is'", "'predicat'", "'*'", "'.'", "'->'", "'abstract'", "'const'", 
		"':'", "'['", "'|'", "'<'", "']'", "'>'", "'type'", "'!'", "'=>'", "'#'", 
		"'Exist'", "'%'", "'else'", "'function'", "')'", "'then'", "'+'", "'-'", 
		"ENTIER", "ID", "WS"
	};
	public static final int
		RULE_system = 0, RULE_element = 1, RULE_constante = 2, RULE_type = 3, 
		RULE_multipleFlag = 4, RULE_abstractFlag = 5, RULE_superType = 6, RULE_champs = 7, 
		RULE_champ = 8, RULE_multiple = 9, RULE_simple = 10, RULE_typeBase = 11, 
		RULE_attribut = 12, RULE_defTypeFunction = 13, RULE_defTypes = 14, RULE_defType = 15, 
		RULE_attributs = 16, RULE_code = 17, RULE_var = 18, RULE_entier = 19, 
		RULE_appel = 20, RULE_creer = 21, RULE_creerListe = 22, RULE_id_externe = 23, 
		RULE_acces = 24, RULE_operation = 25, RULE_operationOuAcces = 26, RULE_operateur = 27, 
		RULE_si = 28, RULE_negation = 29, RULE_function = 30, RULE_functionDef = 31, 
		RULE_functionLocal = 32, RULE_tmpCode = 33, RULE_exist = 34, RULE_all = 35, 
		RULE_estType = 36, RULE_defPredicat = 37;
	public static final String[] ruleNames = {
		"system", "element", "constante", "type", "multipleFlag", "abstractFlag", 
		"superType", "champs", "champ", "multiple", "simple", "typeBase", "attribut", 
		"defTypeFunction", "defTypes", "defType", "attributs", "code", "var", 
		"entier", "appel", "creer", "creerListe", "id_externe", "acces", "operation", 
		"operationOuAcces", "operateur", "si", "negation", "function", "functionDef", 
		"functionLocal", "tmpCode", "exist", "all", "estType", "defPredicat"
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
			setState(79);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 11) | (1L << 15) | (1L << 16) | (1L << 23) | (1L << 30))) != 0)) {
				{
				{
				setState(76); element();
				}
				}
				setState(81);
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
			setState(86);
			switch (_input.LA(1)) {
			case 15:
			case 23:
				enterOuterAlt(_localctx, 1);
				{
				setState(82); type();
				}
				break;
			case 30:
				enterOuterAlt(_localctx, 2);
				{
				setState(83); function();
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 3);
				{
				setState(84); defPredicat();
				}
				break;
			case 16:
				enterOuterAlt(_localctx, 4);
				{
				setState(85); constante();
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
			setState(88); match(16);
			setState(89); match(ID);
			setState(90); tmpCode();
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
			setState(92); abstractFlag();
			setState(93); match(23);
			setState(96);
			switch (_input.LA(1)) {
			case 12:
				{
				setState(94); multipleFlag();
				}
				break;
			case ID:
				{
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(98); match(ID);
			setState(101);
			switch (_input.LA(1)) {
			case 17:
				{
				setState(99); superType();
				}
				break;
			case 2:
				{
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(103); match(2);
			setState(104); champs();
			setState(105); match(4);
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
			setState(107); match(12);
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
			setState(111);
			switch (_input.LA(1)) {
			case 15:
				enterOuterAlt(_localctx, 1);
				{
				setState(109); match(15);
				}
				break;
			case 23:
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
			setState(113); match(17);
			setState(116);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				{
				setState(114); match(ID);
				}
				break;

			case 2:
				{
				setState(115); id_externe();
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
			setState(121);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 12) | (1L << 18) | (1L << ID))) != 0)) {
				{
				{
				setState(118); champ();
				}
				}
				setState(123);
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
			setState(124); defType();
			setState(125); match(17);
			setState(126); match(ID);
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
			setState(128); match(12);
			setState(131);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				{
				setState(129); match(ID);
				}
				break;

			case 2:
				{
				setState(130); id_externe();
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
			setState(135);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				{
				setState(133); match(ID);
				}
				break;

			case 2:
				{
				setState(134); id_externe();
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
			setState(139);
			switch (_input.LA(1)) {
			case 12:
				enterOuterAlt(_localctx, 1);
				{
				setState(137); multiple();
				}
				break;
			case ID:
				enterOuterAlt(_localctx, 2);
				{
				setState(138); simple();
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
			setState(141); match(ID);
			setState(142); match(3);
			setState(143); tmpCode();
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
			setState(145); match(18);
			setState(146); defTypes();
			setState(147); match(21);
			setState(148); match(14);
			setState(149); defType();
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
			setState(154);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 12) | (1L << 18) | (1L << ID))) != 0)) {
				{
				{
				setState(151); defType();
				}
				}
				setState(156);
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
			setState(159);
			switch (_input.LA(1)) {
			case 12:
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(157); typeBase();
				}
				break;
			case 18:
				enterOuterAlt(_localctx, 2);
				{
				setState(158); defTypeFunction();
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
			setState(164);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==ID) {
				{
				{
				setState(161); attribut();
				}
				}
				setState(166);
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
			setState(182);
			switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
			case 1:
				{
				{
				setState(167); match(9);
				setState(168); code();
				setState(169); match(31);
				}
				}
				break;

			case 2:
				{
				setState(180);
				switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
				case 1:
					{
					setState(171); appel();
					}
					break;

				case 2:
					{
					setState(172); creerListe();
					}
					break;

				case 3:
					{
					setState(173); creer();
					}
					break;

				case 4:
					{
					setState(174); var();
					}
					break;

				case 5:
					{
					setState(175); entier();
					}
					break;

				case 6:
					{
					{
					setState(176); match(9);
					{
					setState(177); si();
					}
					setState(178); match(31);
					}
					}
					break;
				}
				}
				break;
			}
			setState(187);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					{
					{
					setState(184); operationOuAcces();
					}
					} 
				}
				setState(189);
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
			setState(190); match(ID);
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
		enterRule(_localctx, 38, RULE_entier);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(192); match(ENTIER);
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
		public Id_externeContext id_externe() {
			return getRuleContext(Id_externeContext.class,0);
		}
		public List<TmpCodeContext> tmpCode() {
			return getRuleContexts(TmpCodeContext.class);
		}
		public TerminalNode ID() { return getToken(lgParser.ID, 0); }
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
		enterRule(_localctx, 40, RULE_appel);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(196);
			switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
			case 1:
				{
				setState(194); match(ID);
				}
				break;

			case 2:
				{
				setState(195); id_externe();
				}
				break;
			}
			setState(198); match(9);
			setState(202);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 5) | (1L << 9) | (1L << 12) | (1L << 26) | (1L << ENTIER) | (1L << ID))) != 0)) {
				{
				{
				setState(199); tmpCode();
				}
				}
				setState(204);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(205); match(31);
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
		public MultipleContext multiple() {
			return getRuleContext(MultipleContext.class,0);
		}
		public SimpleContext simple() {
			return getRuleContext(SimpleContext.class,0);
		}
		public AttributsContext attributs() {
			return getRuleContext(AttributsContext.class,0);
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
		enterRule(_localctx, 42, RULE_creer);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(209);
			switch (_input.LA(1)) {
			case ID:
				{
				setState(207); simple();
				}
				break;
			case 12:
				{
				setState(208); multiple();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(211); match(2);
			setState(212); attributs();
			setState(213); match(4);
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
		enterRule(_localctx, 44, RULE_creerListe);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(215); match(ID);
			setState(216); match(18);
			{
			{
			setState(221); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(217); match(2);
				setState(218); attributs();
				setState(219); match(4);
				}
				}
				setState(223); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==2 );
			}
			}
			setState(225); match(21);
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
		enterRule(_localctx, 46, RULE_id_externe);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(227); match(ID);
			setState(228); match(6);
			setState(229); match(ID);
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
		enterRule(_localctx, 48, RULE_acces);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(231); match(13);
			setState(232); match(ID);
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
		enterRule(_localctx, 50, RULE_operation);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(234); operateur();
			setState(235); tmpCode();
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
		enterRule(_localctx, 52, RULE_operationOuAcces);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(239);
			switch (_input.LA(1)) {
			case 13:
				{
				setState(237); acces();
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
			case 25:
			case 28:
			case 33:
			case 34:
				{
				setState(238); operation();
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
		enterRule(_localctx, 54, RULE_operateur);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(241);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 1) | (1L << 3) | (1L << 8) | (1L << 12) | (1L << 14) | (1L << 19) | (1L << 20) | (1L << 22) | (1L << 25) | (1L << 28) | (1L << 33) | (1L << 34))) != 0)) ) {
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
		enterRule(_localctx, 56, RULE_si);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(243); match(5);
			setState(244); code();
			setState(245); match(10);
			setState(246); negation();
			setState(249);
			switch (_input.LA(1)) {
			case ID:
				{
				setState(247); simple();
				}
				break;
			case 12:
				{
				setState(248); multiple();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(251); match(32);
			setState(252); code();
			setState(253); match(29);
			setState(256);
			switch (_input.LA(1)) {
			case 5:
				{
				setState(254); si();
				}
				break;
			case 9:
			case 12:
			case ENTIER:
			case ID:
				{
				setState(255); code();
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
		enterRule(_localctx, 58, RULE_negation);
		try {
			setState(260);
			switch (_input.LA(1)) {
			case 24:
				enterOuterAlt(_localctx, 1);
				{
				setState(258); match(24);
				}
				break;
			case 12:
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
		enterRule(_localctx, 60, RULE_function);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(262); match(30);
			setState(265);
			switch (_input.LA(1)) {
			case ID:
				{
				setState(263); match(ID);
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
			case 25:
			case 28:
			case 33:
			case 34:
				{
				setState(264); operateur();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(267); champs();
			setState(268); match(19);
			setState(269); tmpCode();
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
		public List<FunctionLocalContext> functionLocal() {
			return getRuleContexts(FunctionLocalContext.class);
		}
		public FunctionLocalContext functionLocal(int i) {
			return getRuleContext(FunctionLocalContext.class,i);
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
		enterRule(_localctx, 62, RULE_functionDef);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(271); match(26);
			setState(272); match(2);
			setState(273); champs();
			setState(274); match(19);
			setState(275); tmpCode();
			setState(279);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==ID) {
				{
				{
				setState(276); functionLocal();
				}
				}
				setState(281);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(282); match(4);
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
		enterRule(_localctx, 64, RULE_functionLocal);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(284); match(ID);
			setState(285); match(3);
			setState(286); champs();
			setState(287); match(19);
			setState(288); tmpCode();
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
		enterRule(_localctx, 66, RULE_tmpCode);
		try {
			setState(298);
			switch ( getInterpreter().adaptivePredict(_input,26,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(290); functionDef();
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(291); appel();
				}
				break;

			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(292); si();
				}
				break;

			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(293); code();
				}
				break;

			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(294); match(9);
				setState(295); tmpCode();
				setState(296); match(31);
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
		enterRule(_localctx, 68, RULE_exist);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(300); match(27);
			setState(301); champs();
			setState(302); match(19);
			setState(306);
			switch (_input.LA(1)) {
			case 27:
				{
				setState(303); exist();
				}
				break;
			case 7:
				{
				setState(304); all();
				}
				break;
			case 5:
			case 9:
			case 12:
			case 26:
			case ENTIER:
			case ID:
				{
				setState(305); estType();
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
		enterRule(_localctx, 70, RULE_all);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(308); match(7);
			setState(309); champs();
			setState(310); match(19);
			setState(314);
			switch (_input.LA(1)) {
			case 27:
				{
				setState(311); exist();
				}
				break;
			case 7:
				{
				setState(312); all();
				}
				break;
			case 5:
			case 9:
			case 12:
			case 26:
			case ENTIER:
			case ID:
				{
				setState(313); estType();
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
		enterRule(_localctx, 72, RULE_estType);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(316); tmpCode();
			setState(317); match(10);
			setState(318); defType();
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
		enterRule(_localctx, 74, RULE_defPredicat);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(320); match(11);
			setState(321); match(ID);
			setState(322); champs();
			setState(323); match(19);
			setState(326);
			switch (_input.LA(1)) {
			case 27:
				{
				setState(324); exist();
				}
				break;
			case 7:
				{
				setState(325); all();
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
		"\2\3\'\u014b\4\2\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4"+
		"\t\t\t\4\n\t\n\4\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20"+
		"\4\21\t\21\4\22\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27"+
		"\4\30\t\30\4\31\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36"+
		"\4\37\t\37\4 \t \4!\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\3\2\7\2"+
		"P\n\2\f\2\16\2S\13\2\3\3\3\3\3\3\3\3\5\3Y\n\3\3\4\3\4\3\4\3\4\3\5\3\5"+
		"\3\5\3\5\5\5c\n\5\3\5\3\5\3\5\5\5h\n\5\3\5\3\5\3\5\3\5\3\6\3\6\3\7\3\7"+
		"\5\7r\n\7\3\b\3\b\3\b\5\bw\n\b\3\t\7\tz\n\t\f\t\16\t}\13\t\3\n\3\n\3\n"+
		"\3\n\3\13\3\13\3\13\5\13\u0086\n\13\3\f\3\f\5\f\u008a\n\f\3\r\3\r\5\r"+
		"\u008e\n\r\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\17\3\20\7\20"+
		"\u009b\n\20\f\20\16\20\u009e\13\20\3\21\3\21\5\21\u00a2\n\21\3\22\7\22"+
		"\u00a5\n\22\f\22\16\22\u00a8\13\22\3\23\3\23\3\23\3\23\3\23\3\23\3\23"+
		"\3\23\3\23\3\23\3\23\3\23\3\23\5\23\u00b7\n\23\5\23\u00b9\n\23\3\23\7"+
		"\23\u00bc\n\23\f\23\16\23\u00bf\13\23\3\24\3\24\3\25\3\25\3\26\3\26\5"+
		"\26\u00c7\n\26\3\26\3\26\7\26\u00cb\n\26\f\26\16\26\u00ce\13\26\3\26\3"+
		"\26\3\27\3\27\5\27\u00d4\n\27\3\27\3\27\3\27\3\27\3\30\3\30\3\30\3\30"+
		"\3\30\3\30\6\30\u00e0\n\30\r\30\16\30\u00e1\3\30\3\30\3\31\3\31\3\31\3"+
		"\31\3\32\3\32\3\32\3\33\3\33\3\33\3\34\3\34\5\34\u00f2\n\34\3\35\3\35"+
		"\3\36\3\36\3\36\3\36\3\36\3\36\5\36\u00fc\n\36\3\36\3\36\3\36\3\36\3\36"+
		"\5\36\u0103\n\36\3\37\3\37\5\37\u0107\n\37\3 \3 \3 \5 \u010c\n \3 \3 "+
		"\3 \3 \3!\3!\3!\3!\3!\3!\7!\u0118\n!\f!\16!\u011b\13!\3!\3!\3\"\3\"\3"+
		"\"\3\"\3\"\3\"\3#\3#\3#\3#\3#\3#\3#\3#\5#\u012d\n#\3$\3$\3$\3$\3$\3$\5"+
		"$\u0135\n$\3%\3%\3%\3%\3%\3%\5%\u013d\n%\3&\3&\3&\3&\3\'\3\'\3\'\3\'\3"+
		"\'\3\'\5\'\u0149\n\'\3\'\2(\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \""+
		"$&(*,.\60\62\64\668:<>@BDFHJL\2\3\f\3\3\5\5\n\n\16\16\20\20\25\26\30\30"+
		"\33\33\36\36#$\u014d\2Q\3\2\2\2\4X\3\2\2\2\6Z\3\2\2\2\b^\3\2\2\2\nm\3"+
		"\2\2\2\fq\3\2\2\2\16s\3\2\2\2\20{\3\2\2\2\22~\3\2\2\2\24\u0082\3\2\2\2"+
		"\26\u0089\3\2\2\2\30\u008d\3\2\2\2\32\u008f\3\2\2\2\34\u0093\3\2\2\2\36"+
		"\u009c\3\2\2\2 \u00a1\3\2\2\2\"\u00a6\3\2\2\2$\u00b8\3\2\2\2&\u00c0\3"+
		"\2\2\2(\u00c2\3\2\2\2*\u00c6\3\2\2\2,\u00d3\3\2\2\2.\u00d9\3\2\2\2\60"+
		"\u00e5\3\2\2\2\62\u00e9\3\2\2\2\64\u00ec\3\2\2\2\66\u00f1\3\2\2\28\u00f3"+
		"\3\2\2\2:\u00f5\3\2\2\2<\u0106\3\2\2\2>\u0108\3\2\2\2@\u0111\3\2\2\2B"+
		"\u011e\3\2\2\2D\u012c\3\2\2\2F\u012e\3\2\2\2H\u0136\3\2\2\2J\u013e\3\2"+
		"\2\2L\u0142\3\2\2\2NP\5\4\3\2ON\3\2\2\2PS\3\2\2\2QO\3\2\2\2QR\3\2\2\2"+
		"R\3\3\2\2\2SQ\3\2\2\2TY\5\b\5\2UY\5> \2VY\5L\'\2WY\5\6\4\2XT\3\2\2\2X"+
		"U\3\2\2\2XV\3\2\2\2XW\3\2\2\2Y\5\3\2\2\2Z[\7\22\2\2[\\\7&\2\2\\]\5D#\2"+
		"]\7\3\2\2\2^_\5\f\7\2_b\7\31\2\2`c\5\n\6\2ac\3\2\2\2b`\3\2\2\2ba\3\2\2"+
		"\2cd\3\2\2\2dg\7&\2\2eh\5\16\b\2fh\3\2\2\2ge\3\2\2\2gf\3\2\2\2hi\3\2\2"+
		"\2ij\7\4\2\2jk\5\20\t\2kl\7\6\2\2l\t\3\2\2\2mn\7\16\2\2n\13\3\2\2\2or"+
		"\7\21\2\2pr\3\2\2\2qo\3\2\2\2qp\3\2\2\2r\r\3\2\2\2sv\7\23\2\2tw\7&\2\2"+
		"uw\5\60\31\2vt\3\2\2\2vu\3\2\2\2w\17\3\2\2\2xz\5\22\n\2yx\3\2\2\2z}\3"+
		"\2\2\2{y\3\2\2\2{|\3\2\2\2|\21\3\2\2\2}{\3\2\2\2~\177\5 \21\2\177\u0080"+
		"\7\23\2\2\u0080\u0081\7&\2\2\u0081\23\3\2\2\2\u0082\u0085\7\16\2\2\u0083"+
		"\u0086\7&\2\2\u0084\u0086\5\60\31\2\u0085\u0083\3\2\2\2\u0085\u0084\3"+
		"\2\2\2\u0086\25\3\2\2\2\u0087\u008a\7&\2\2\u0088\u008a\5\60\31\2\u0089"+
		"\u0087\3\2\2\2\u0089\u0088\3\2\2\2\u008a\27\3\2\2\2\u008b\u008e\5\24\13"+
		"\2\u008c\u008e\5\26\f\2\u008d\u008b\3\2\2\2\u008d\u008c\3\2\2\2\u008e"+
		"\31\3\2\2\2\u008f\u0090\7&\2\2\u0090\u0091\7\5\2\2\u0091\u0092\5D#\2\u0092"+
		"\33\3\2\2\2\u0093\u0094\7\24\2\2\u0094\u0095\5\36\20\2\u0095\u0096\7\27"+
		"\2\2\u0096\u0097\7\20\2\2\u0097\u0098\5 \21\2\u0098\35\3\2\2\2\u0099\u009b"+
		"\5 \21\2\u009a\u0099\3\2\2\2\u009b\u009e\3\2\2\2\u009c\u009a\3\2\2\2\u009c"+
		"\u009d\3\2\2\2\u009d\37\3\2\2\2\u009e\u009c\3\2\2\2\u009f\u00a2\5\30\r"+
		"\2\u00a0\u00a2\5\34\17\2\u00a1\u009f\3\2\2\2\u00a1\u00a0\3\2\2\2\u00a2"+
		"!\3\2\2\2\u00a3\u00a5\5\32\16\2\u00a4\u00a3\3\2\2\2\u00a5\u00a8\3\2\2"+
		"\2\u00a6\u00a4\3\2\2\2\u00a6\u00a7\3\2\2\2\u00a7#\3\2\2\2\u00a8\u00a6"+
		"\3\2\2\2\u00a9\u00aa\7\13\2\2\u00aa\u00ab\5$\23\2\u00ab\u00ac\7!\2\2\u00ac"+
		"\u00b9\3\2\2\2\u00ad\u00b7\5*\26\2\u00ae\u00b7\5.\30\2\u00af\u00b7\5,"+
		"\27\2\u00b0\u00b7\5&\24\2\u00b1\u00b7\5(\25\2\u00b2\u00b3\7\13\2\2\u00b3"+
		"\u00b4\5:\36\2\u00b4\u00b5\7!\2\2\u00b5\u00b7\3\2\2\2\u00b6\u00ad\3\2"+
		"\2\2\u00b6\u00ae\3\2\2\2\u00b6\u00af\3\2\2\2\u00b6\u00b0\3\2\2\2\u00b6"+
		"\u00b1\3\2\2\2\u00b6\u00b2\3\2\2\2\u00b7\u00b9\3\2\2\2\u00b8\u00a9\3\2"+
		"\2\2\u00b8\u00b6\3\2\2\2\u00b9\u00bd\3\2\2\2\u00ba\u00bc\5\66\34\2\u00bb"+
		"\u00ba\3\2\2\2\u00bc\u00bf\3\2\2\2\u00bd\u00bb\3\2\2\2\u00bd\u00be\3\2"+
		"\2\2\u00be%\3\2\2\2\u00bf\u00bd\3\2\2\2\u00c0\u00c1\7&\2\2\u00c1\'\3\2"+
		"\2\2\u00c2\u00c3\7%\2\2\u00c3)\3\2\2\2\u00c4\u00c7\7&\2\2\u00c5\u00c7"+
		"\5\60\31\2\u00c6\u00c4\3\2\2\2\u00c6\u00c5\3\2\2\2\u00c7\u00c8\3\2\2\2"+
		"\u00c8\u00cc\7\13\2\2\u00c9\u00cb\5D#\2\u00ca\u00c9\3\2\2\2\u00cb\u00ce"+
		"\3\2\2\2\u00cc\u00ca\3\2\2\2\u00cc\u00cd\3\2\2\2\u00cd\u00cf\3\2\2\2\u00ce"+
		"\u00cc\3\2\2\2\u00cf\u00d0\7!\2\2\u00d0+\3\2\2\2\u00d1\u00d4\5\26\f\2"+
		"\u00d2\u00d4\5\24\13\2\u00d3\u00d1\3\2\2\2\u00d3\u00d2\3\2\2\2\u00d4\u00d5"+
		"\3\2\2\2\u00d5\u00d6\7\4\2\2\u00d6\u00d7\5\"\22\2\u00d7\u00d8\7\6\2\2"+
		"\u00d8-\3\2\2\2\u00d9\u00da\7&\2\2\u00da\u00df\7\24\2\2\u00db\u00dc\7"+
		"\4\2\2\u00dc\u00dd\5\"\22\2\u00dd\u00de\7\6\2\2\u00de\u00e0\3\2\2\2\u00df"+
		"\u00db\3\2\2\2\u00e0\u00e1\3\2\2\2\u00e1\u00df\3\2\2\2\u00e1\u00e2\3\2"+
		"\2\2\u00e2\u00e3\3\2\2\2\u00e3\u00e4\7\27\2\2\u00e4/\3\2\2\2\u00e5\u00e6"+
		"\7&\2\2\u00e6\u00e7\7\b\2\2\u00e7\u00e8\7&\2\2\u00e8\61\3\2\2\2\u00e9"+
		"\u00ea\7\17\2\2\u00ea\u00eb\7&\2\2\u00eb\63\3\2\2\2\u00ec\u00ed\58\35"+
		"\2\u00ed\u00ee\5D#\2\u00ee\65\3\2\2\2\u00ef\u00f2\5\62\32\2\u00f0\u00f2"+
		"\5\64\33\2\u00f1\u00ef\3\2\2\2\u00f1\u00f0\3\2\2\2\u00f2\67\3\2\2\2\u00f3"+
		"\u00f4\t\2\2\2\u00f49\3\2\2\2\u00f5\u00f6\7\7\2\2\u00f6\u00f7\5$\23\2"+
		"\u00f7\u00f8\7\f\2\2\u00f8\u00fb\5<\37\2\u00f9\u00fc\5\26\f\2\u00fa\u00fc"+
		"\5\24\13\2\u00fb\u00f9\3\2\2\2\u00fb\u00fa\3\2\2\2\u00fc\u00fd\3\2\2\2"+
		"\u00fd\u00fe\7\"\2\2\u00fe\u00ff\5$\23\2\u00ff\u0102\7\37\2\2\u0100\u0103"+
		"\5:\36\2\u0101\u0103\5$\23\2\u0102\u0100\3\2\2\2\u0102\u0101\3\2\2\2\u0103"+
		";\3\2\2\2\u0104\u0107\7\32\2\2\u0105\u0107\3\2\2\2\u0106\u0104\3\2\2\2"+
		"\u0106\u0105\3\2\2\2\u0107=\3\2\2\2\u0108\u010b\7 \2\2\u0109\u010c\7&"+
		"\2\2\u010a\u010c\58\35\2\u010b\u0109\3\2\2\2\u010b\u010a\3\2\2\2\u010c"+
		"\u010d\3\2\2\2\u010d\u010e\5\20\t\2\u010e\u010f\7\25\2\2\u010f\u0110\5"+
		"D#\2\u0110?\3\2\2\2\u0111\u0112\7\34\2\2\u0112\u0113\7\4\2\2\u0113\u0114"+
		"\5\20\t\2\u0114\u0115\7\25\2\2\u0115\u0119\5D#\2\u0116\u0118\5B\"\2\u0117"+
		"\u0116\3\2\2\2\u0118\u011b\3\2\2\2\u0119\u0117\3\2\2\2\u0119\u011a\3\2"+
		"\2\2\u011a\u011c\3\2\2\2\u011b\u0119\3\2\2\2\u011c\u011d\7\6\2\2\u011d"+
		"A\3\2\2\2\u011e\u011f\7&\2\2\u011f\u0120\7\5\2\2\u0120\u0121\5\20\t\2"+
		"\u0121\u0122\7\25\2\2\u0122\u0123\5D#\2\u0123C\3\2\2\2\u0124\u012d\5@"+
		"!\2\u0125\u012d\5*\26\2\u0126\u012d\5:\36\2\u0127\u012d\5$\23\2\u0128"+
		"\u0129\7\13\2\2\u0129\u012a\5D#\2\u012a\u012b\7!\2\2\u012b\u012d\3\2\2"+
		"\2\u012c\u0124\3\2\2\2\u012c\u0125\3\2\2\2\u012c\u0126\3\2\2\2\u012c\u0127"+
		"\3\2\2\2\u012c\u0128\3\2\2\2\u012dE\3\2\2\2\u012e\u012f\7\35\2\2\u012f"+
		"\u0130\5\20\t\2\u0130\u0134\7\25\2\2\u0131\u0135\5F$\2\u0132\u0135\5H"+
		"%\2\u0133\u0135\5J&\2\u0134\u0131\3\2\2\2\u0134\u0132\3\2\2\2\u0134\u0133"+
		"\3\2\2\2\u0135G\3\2\2\2\u0136\u0137\7\t\2\2\u0137\u0138\5\20\t\2\u0138"+
		"\u013c\7\25\2\2\u0139\u013d\5F$\2\u013a\u013d\5H%\2\u013b\u013d\5J&\2"+
		"\u013c\u0139\3\2\2\2\u013c\u013a\3\2\2\2\u013c\u013b\3\2\2\2\u013dI\3"+
		"\2\2\2\u013e\u013f\5D#\2\u013f\u0140\7\f\2\2\u0140\u0141\5 \21\2\u0141"+
		"K\3\2\2\2\u0142\u0143\7\r\2\2\u0143\u0144\7&\2\2\u0144\u0145\5\20\t\2"+
		"\u0145\u0148\7\25\2\2\u0146\u0149\5F$\2\u0147\u0149\5H%\2\u0148\u0146"+
		"\3\2\2\2\u0148\u0147\3\2\2\2\u0149M\3\2\2\2 QXbgqv{\u0085\u0089\u008d"+
		"\u009c\u00a1\u00a6\u00b6\u00b8\u00bd\u00c6\u00cc\u00d3\u00e1\u00f1\u00fb"+
		"\u0102\u0106\u010b\u0119\u012c\u0134\u013c\u0148";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
	}
}