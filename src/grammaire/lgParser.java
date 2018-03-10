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
		RULE_attributs = 16, RULE_code = 17, RULE_var = 18, RULE_entier = 19, 
		RULE_appel = 20, RULE_flagMultiple = 21, RULE_creer = 22, RULE_creerListe = 23, 
		RULE_id_externe = 24, RULE_acces = 25, RULE_operation = 26, RULE_operationOuAcces = 27, 
		RULE_operateur = 28, RULE_si = 29, RULE_negation = 30, RULE_function = 31, 
		RULE_functionDef = 32, RULE_functionLocal = 33, RULE_tmpCode = 34, RULE_exist = 35, 
		RULE_all = 36, RULE_estType = 37, RULE_defPredicat = 38;
	public static final String[] ruleNames = {
		"system", "element", "constante", "type", "multipleFlag", "abstractFlag", 
		"superType", "champs", "champ", "multiple", "simple", "typeBase", "attribut", 
		"defTypeFunction", "defTypes", "defType", "attributs", "code", "var", 
		"entier", "appel", "flagMultiple", "creer", "creerListe", "id_externe", 
		"acces", "operation", "operationOuAcces", "operateur", "si", "negation", 
		"function", "functionDef", "functionLocal", "tmpCode", "exist", "all", 
		"estType", "defPredicat"
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
			setState(81);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 11) | (1L << 15) | (1L << 16) | (1L << 24) | (1L << 31))) != 0)) {
				{
				{
				setState(78); element();
				}
				}
				setState(83);
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
			setState(88);
			switch (_input.LA(1)) {
			case 15:
			case 24:
				enterOuterAlt(_localctx, 1);
				{
				setState(84); type();
				}
				break;
			case 31:
				enterOuterAlt(_localctx, 2);
				{
				setState(85); function();
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 3);
				{
				setState(86); defPredicat();
				}
				break;
			case 16:
				enterOuterAlt(_localctx, 4);
				{
				setState(87); constante();
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
			setState(90); match(16);
			setState(91); match(ID);
			setState(92); tmpCode();
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
			setState(94); abstractFlag();
			setState(95); match(24);
			setState(98);
			switch (_input.LA(1)) {
			case 23:
				{
				setState(96); multipleFlag();
				}
				break;
			case ID:
				{
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(100); match(ID);
			setState(103);
			switch (_input.LA(1)) {
			case 17:
				{
				setState(101); superType();
				}
				break;
			case 2:
				{
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(105); match(2);
			setState(106); champs();
			setState(107); match(4);
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
			setState(109); match(23);
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
			setState(113);
			switch (_input.LA(1)) {
			case 15:
				enterOuterAlt(_localctx, 1);
				{
				setState(111); match(15);
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
			setState(115); match(17);
			setState(118);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				{
				setState(116); match(ID);
				}
				break;

			case 2:
				{
				setState(117); id_externe();
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
			setState(123);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 18) | (1L << 23) | (1L << ID))) != 0)) {
				{
				{
				setState(120); champ();
				}
				}
				setState(125);
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
			setState(126); defType();
			setState(127); match(17);
			setState(128); match(ID);
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
			setState(130); match(23);
			setState(133);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				{
				setState(131); match(ID);
				}
				break;

			case 2:
				{
				setState(132); id_externe();
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
			setState(137);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
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
			setState(141);
			switch (_input.LA(1)) {
			case 23:
				enterOuterAlt(_localctx, 1);
				{
				setState(139); multiple();
				}
				break;
			case ID:
				enterOuterAlt(_localctx, 2);
				{
				setState(140); simple();
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
			setState(143); match(ID);
			setState(144); match(3);
			setState(145); tmpCode();
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
			setState(147); match(18);
			setState(148); defTypes();
			setState(149); match(21);
			setState(150); match(14);
			setState(151); defType();
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
			setState(156);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 18) | (1L << 23) | (1L << ID))) != 0)) {
				{
				{
				setState(153); defType();
				}
				}
				setState(158);
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
			setState(161);
			switch (_input.LA(1)) {
			case 23:
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(159); typeBase();
				}
				break;
			case 18:
				enterOuterAlt(_localctx, 2);
				{
				setState(160); defTypeFunction();
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
			setState(166);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==ID) {
				{
				{
				setState(163); attribut();
				}
				}
				setState(168);
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
			setState(184);
			switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
			case 1:
				{
				{
				setState(169); match(9);
				setState(170); code();
				setState(171); match(32);
				}
				}
				break;

			case 2:
				{
				setState(182);
				switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
				case 1:
					{
					setState(173); appel();
					}
					break;

				case 2:
					{
					setState(174); creerListe();
					}
					break;

				case 3:
					{
					setState(175); creer();
					}
					break;

				case 4:
					{
					setState(176); var();
					}
					break;

				case 5:
					{
					setState(177); entier();
					}
					break;

				case 6:
					{
					{
					setState(178); match(9);
					{
					setState(179); si();
					}
					setState(180); match(32);
					}
					}
					break;
				}
				}
				break;
			}
			setState(189);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					{
					{
					setState(186); operationOuAcces();
					}
					} 
				}
				setState(191);
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
			setState(194);
			switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(192); match(ID);
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(193); id_externe();
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
		enterRule(_localctx, 38, RULE_entier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(196);
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
			setState(200);
			switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
			case 1:
				{
				setState(198); match(ID);
				}
				break;

			case 2:
				{
				setState(199); id_externe();
				}
				break;
			}
			setState(202); match(9);
			setState(206);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 5) | (1L << 9) | (1L << 23) | (1L << 27) | (1L << ENTIER) | (1L << ENTIER_EXTERNE) | (1L << ID))) != 0)) {
				{
				{
				setState(203); tmpCode();
				}
				}
				setState(208);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(209); match(32);
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
		enterRule(_localctx, 42, RULE_flagMultiple);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(211); match(23);
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
		enterRule(_localctx, 44, RULE_creer);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(215);
			switch (_input.LA(1)) {
			case 23:
				{
				setState(213); flagMultiple();
				}
				break;
			case ID:
				{
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(219);
			switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
			case 1:
				{
				setState(217); match(ID);
				}
				break;

			case 2:
				{
				setState(218); id_externe();
				}
				break;
			}
			setState(221); match(2);
			setState(222); attributs();
			setState(223); match(4);
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
		enterRule(_localctx, 46, RULE_creerListe);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(225); match(ID);
			setState(226); match(18);
			{
			{
			setState(231); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(227); match(2);
				setState(228); attributs();
				setState(229); match(4);
				}
				}
				setState(233); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==2 );
			}
			}
			setState(235); match(21);
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
		enterRule(_localctx, 48, RULE_id_externe);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(237); match(ID);
			setState(238); match(6);
			setState(239); match(ID);
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
		enterRule(_localctx, 50, RULE_acces);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(241); match(13);
			setState(242); match(ID);
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
		enterRule(_localctx, 52, RULE_operation);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(244); operateur();
			setState(245); tmpCode();
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
		enterRule(_localctx, 54, RULE_operationOuAcces);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(249);
			switch (_input.LA(1)) {
			case 13:
				{
				setState(247); acces();
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
			case 29:
			case 34:
			case 35:
				{
				setState(248); operation();
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
		enterRule(_localctx, 56, RULE_operateur);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(251);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 1) | (1L << 3) | (1L << 8) | (1L << 12) | (1L << 14) | (1L << 19) | (1L << 20) | (1L << 22) | (1L << 26) | (1L << 29) | (1L << 34) | (1L << 35))) != 0)) ) {
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
		enterRule(_localctx, 58, RULE_si);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(253); match(5);
			setState(254); code();
			setState(255); match(10);
			setState(256); negation();
			setState(259);
			switch (_input.LA(1)) {
			case ID:
				{
				setState(257); simple();
				}
				break;
			case 23:
				{
				setState(258); multiple();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(261); match(33);
			setState(262); code();
			setState(263); match(30);
			setState(266);
			switch (_input.LA(1)) {
			case 5:
				{
				setState(264); si();
				}
				break;
			case 9:
			case 23:
			case ENTIER:
			case ENTIER_EXTERNE:
			case ID:
				{
				setState(265); code();
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
		enterRule(_localctx, 60, RULE_negation);
		try {
			setState(270);
			switch (_input.LA(1)) {
			case 25:
				enterOuterAlt(_localctx, 1);
				{
				setState(268); match(25);
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
		enterRule(_localctx, 62, RULE_function);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(272); match(31);
			setState(275);
			switch (_input.LA(1)) {
			case ID:
				{
				setState(273); match(ID);
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
			case 29:
			case 34:
			case 35:
				{
				setState(274); operateur();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(277); champs();
			setState(278); match(19);
			setState(279); tmpCode();
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
		enterRule(_localctx, 64, RULE_functionDef);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(281); match(27);
			setState(282); match(2);
			setState(283); champs();
			setState(284); match(19);
			setState(285); tmpCode();
			setState(289);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==ID) {
				{
				{
				setState(286); functionLocal();
				}
				}
				setState(291);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(292); match(4);
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
		enterRule(_localctx, 66, RULE_functionLocal);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(294); match(ID);
			setState(295); match(3);
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
		enterRule(_localctx, 68, RULE_tmpCode);
		try {
			setState(308);
			switch ( getInterpreter().adaptivePredict(_input,28,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(300); functionDef();
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(301); appel();
				}
				break;

			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(302); si();
				}
				break;

			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(303); code();
				}
				break;

			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(304); match(9);
				setState(305); tmpCode();
				setState(306); match(32);
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
		enterRule(_localctx, 70, RULE_exist);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(310); match(28);
			setState(311); champs();
			setState(312); match(19);
			setState(316);
			switch (_input.LA(1)) {
			case 28:
				{
				setState(313); exist();
				}
				break;
			case 7:
				{
				setState(314); all();
				}
				break;
			case 5:
			case 9:
			case 23:
			case 27:
			case ENTIER:
			case ENTIER_EXTERNE:
			case ID:
				{
				setState(315); estType();
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
		enterRule(_localctx, 72, RULE_all);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(318); match(7);
			setState(319); champs();
			setState(320); match(19);
			setState(324);
			switch (_input.LA(1)) {
			case 28:
				{
				setState(321); exist();
				}
				break;
			case 7:
				{
				setState(322); all();
				}
				break;
			case 5:
			case 9:
			case 23:
			case 27:
			case ENTIER:
			case ENTIER_EXTERNE:
			case ID:
				{
				setState(323); estType();
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
		enterRule(_localctx, 74, RULE_estType);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(326); tmpCode();
			setState(327); match(10);
			setState(328); defType();
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
		enterRule(_localctx, 76, RULE_defPredicat);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(330); match(11);
			setState(331); match(ID);
			setState(332); champs();
			setState(333); match(19);
			setState(336);
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
		"\2\3)\u0155\4\2\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4"+
		"\t\t\t\4\n\t\n\4\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20"+
		"\4\21\t\21\4\22\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27"+
		"\4\30\t\30\4\31\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36"+
		"\4\37\t\37\4 \t \4!\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\3"+
		"\2\7\2R\n\2\f\2\16\2U\13\2\3\3\3\3\3\3\3\3\5\3[\n\3\3\4\3\4\3\4\3\4\3"+
		"\5\3\5\3\5\3\5\5\5e\n\5\3\5\3\5\3\5\5\5j\n\5\3\5\3\5\3\5\3\5\3\6\3\6\3"+
		"\7\3\7\5\7t\n\7\3\b\3\b\3\b\5\by\n\b\3\t\7\t|\n\t\f\t\16\t\177\13\t\3"+
		"\n\3\n\3\n\3\n\3\13\3\13\3\13\5\13\u0088\n\13\3\f\3\f\5\f\u008c\n\f\3"+
		"\r\3\r\5\r\u0090\n\r\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\17"+
		"\3\20\7\20\u009d\n\20\f\20\16\20\u00a0\13\20\3\21\3\21\5\21\u00a4\n\21"+
		"\3\22\7\22\u00a7\n\22\f\22\16\22\u00aa\13\22\3\23\3\23\3\23\3\23\3\23"+
		"\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\5\23\u00b9\n\23\5\23\u00bb\n"+
		"\23\3\23\7\23\u00be\n\23\f\23\16\23\u00c1\13\23\3\24\3\24\5\24\u00c5\n"+
		"\24\3\25\3\25\3\26\3\26\5\26\u00cb\n\26\3\26\3\26\7\26\u00cf\n\26\f\26"+
		"\16\26\u00d2\13\26\3\26\3\26\3\27\3\27\3\30\3\30\5\30\u00da\n\30\3\30"+
		"\3\30\5\30\u00de\n\30\3\30\3\30\3\30\3\30\3\31\3\31\3\31\3\31\3\31\3\31"+
		"\6\31\u00ea\n\31\r\31\16\31\u00eb\3\31\3\31\3\32\3\32\3\32\3\32\3\33\3"+
		"\33\3\33\3\34\3\34\3\34\3\35\3\35\5\35\u00fc\n\35\3\36\3\36\3\37\3\37"+
		"\3\37\3\37\3\37\3\37\5\37\u0106\n\37\3\37\3\37\3\37\3\37\3\37\5\37\u010d"+
		"\n\37\3 \3 \5 \u0111\n \3!\3!\3!\5!\u0116\n!\3!\3!\3!\3!\3\"\3\"\3\"\3"+
		"\"\3\"\3\"\7\"\u0122\n\"\f\"\16\"\u0125\13\"\3\"\3\"\3#\3#\3#\3#\3#\3"+
		"#\3$\3$\3$\3$\3$\3$\3$\3$\5$\u0137\n$\3%\3%\3%\3%\3%\3%\5%\u013f\n%\3"+
		"&\3&\3&\3&\3&\3&\5&\u0147\n&\3\'\3\'\3\'\3\'\3(\3(\3(\3(\3(\3(\5(\u0153"+
		"\n(\3(\2)\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\64\66"+
		"8:<>@BDFHJLN\2\4\3&\'\f\3\3\5\5\n\n\16\16\20\20\25\26\30\30\34\34\37\37"+
		"$%\u0158\2S\3\2\2\2\4Z\3\2\2\2\6\\\3\2\2\2\b`\3\2\2\2\no\3\2\2\2\fs\3"+
		"\2\2\2\16u\3\2\2\2\20}\3\2\2\2\22\u0080\3\2\2\2\24\u0084\3\2\2\2\26\u008b"+
		"\3\2\2\2\30\u008f\3\2\2\2\32\u0091\3\2\2\2\34\u0095\3\2\2\2\36\u009e\3"+
		"\2\2\2 \u00a3\3\2\2\2\"\u00a8\3\2\2\2$\u00ba\3\2\2\2&\u00c4\3\2\2\2(\u00c6"+
		"\3\2\2\2*\u00ca\3\2\2\2,\u00d5\3\2\2\2.\u00d9\3\2\2\2\60\u00e3\3\2\2\2"+
		"\62\u00ef\3\2\2\2\64\u00f3\3\2\2\2\66\u00f6\3\2\2\28\u00fb\3\2\2\2:\u00fd"+
		"\3\2\2\2<\u00ff\3\2\2\2>\u0110\3\2\2\2@\u0112\3\2\2\2B\u011b\3\2\2\2D"+
		"\u0128\3\2\2\2F\u0136\3\2\2\2H\u0138\3\2\2\2J\u0140\3\2\2\2L\u0148\3\2"+
		"\2\2N\u014c\3\2\2\2PR\5\4\3\2QP\3\2\2\2RU\3\2\2\2SQ\3\2\2\2ST\3\2\2\2"+
		"T\3\3\2\2\2US\3\2\2\2V[\5\b\5\2W[\5@!\2X[\5N(\2Y[\5\6\4\2ZV\3\2\2\2ZW"+
		"\3\2\2\2ZX\3\2\2\2ZY\3\2\2\2[\5\3\2\2\2\\]\7\22\2\2]^\7(\2\2^_\5F$\2_"+
		"\7\3\2\2\2`a\5\f\7\2ad\7\32\2\2be\5\n\6\2ce\3\2\2\2db\3\2\2\2dc\3\2\2"+
		"\2ef\3\2\2\2fi\7(\2\2gj\5\16\b\2hj\3\2\2\2ig\3\2\2\2ih\3\2\2\2jk\3\2\2"+
		"\2kl\7\4\2\2lm\5\20\t\2mn\7\6\2\2n\t\3\2\2\2op\7\31\2\2p\13\3\2\2\2qt"+
		"\7\21\2\2rt\3\2\2\2sq\3\2\2\2sr\3\2\2\2t\r\3\2\2\2ux\7\23\2\2vy\7(\2\2"+
		"wy\5\62\32\2xv\3\2\2\2xw\3\2\2\2y\17\3\2\2\2z|\5\22\n\2{z\3\2\2\2|\177"+
		"\3\2\2\2}{\3\2\2\2}~\3\2\2\2~\21\3\2\2\2\177}\3\2\2\2\u0080\u0081\5 \21"+
		"\2\u0081\u0082\7\23\2\2\u0082\u0083\7(\2\2\u0083\23\3\2\2\2\u0084\u0087"+
		"\7\31\2\2\u0085\u0088\7(\2\2\u0086\u0088\5\62\32\2\u0087\u0085\3\2\2\2"+
		"\u0087\u0086\3\2\2\2\u0088\25\3\2\2\2\u0089\u008c\7(\2\2\u008a\u008c\5"+
		"\62\32\2\u008b\u0089\3\2\2\2\u008b\u008a\3\2\2\2\u008c\27\3\2\2\2\u008d"+
		"\u0090\5\24\13\2\u008e\u0090\5\26\f\2\u008f\u008d\3\2\2\2\u008f\u008e"+
		"\3\2\2\2\u0090\31\3\2\2\2\u0091\u0092\7(\2\2\u0092\u0093\7\5\2\2\u0093"+
		"\u0094\5F$\2\u0094\33\3\2\2\2\u0095\u0096\7\24\2\2\u0096\u0097\5\36\20"+
		"\2\u0097\u0098\7\27\2\2\u0098\u0099\7\20\2\2\u0099\u009a\5 \21\2\u009a"+
		"\35\3\2\2\2\u009b\u009d\5 \21\2\u009c\u009b\3\2\2\2\u009d\u00a0\3\2\2"+
		"\2\u009e\u009c\3\2\2\2\u009e\u009f\3\2\2\2\u009f\37\3\2\2\2\u00a0\u009e"+
		"\3\2\2\2\u00a1\u00a4\5\30\r\2\u00a2\u00a4\5\34\17\2\u00a3\u00a1\3\2\2"+
		"\2\u00a3\u00a2\3\2\2\2\u00a4!\3\2\2\2\u00a5\u00a7\5\32\16\2\u00a6\u00a5"+
		"\3\2\2\2\u00a7\u00aa\3\2\2\2\u00a8\u00a6\3\2\2\2\u00a8\u00a9\3\2\2\2\u00a9"+
		"#\3\2\2\2\u00aa\u00a8\3\2\2\2\u00ab\u00ac\7\13\2\2\u00ac\u00ad\5$\23\2"+
		"\u00ad\u00ae\7\"\2\2\u00ae\u00bb\3\2\2\2\u00af\u00b9\5*\26\2\u00b0\u00b9"+
		"\5\60\31\2\u00b1\u00b9\5.\30\2\u00b2\u00b9\5&\24\2\u00b3\u00b9\5(\25\2"+
		"\u00b4\u00b5\7\13\2\2\u00b5\u00b6\5<\37\2\u00b6\u00b7\7\"\2\2\u00b7\u00b9"+
		"\3\2\2\2\u00b8\u00af\3\2\2\2\u00b8\u00b0\3\2\2\2\u00b8\u00b1\3\2\2\2\u00b8"+
		"\u00b2\3\2\2\2\u00b8\u00b3\3\2\2\2\u00b8\u00b4\3\2\2\2\u00b9\u00bb\3\2"+
		"\2\2\u00ba\u00ab\3\2\2\2\u00ba\u00b8\3\2\2\2\u00bb\u00bf\3\2\2\2\u00bc"+
		"\u00be\58\35\2\u00bd\u00bc\3\2\2\2\u00be\u00c1\3\2\2\2\u00bf\u00bd\3\2"+
		"\2\2\u00bf\u00c0\3\2\2\2\u00c0%\3\2\2\2\u00c1\u00bf\3\2\2\2\u00c2\u00c5"+
		"\7(\2\2\u00c3\u00c5\5\62\32\2\u00c4\u00c2\3\2\2\2\u00c4\u00c3\3\2\2\2"+
		"\u00c5\'\3\2\2\2\u00c6\u00c7\t\2\2\2\u00c7)\3\2\2\2\u00c8\u00cb\7(\2\2"+
		"\u00c9\u00cb\5\62\32\2\u00ca\u00c8\3\2\2\2\u00ca\u00c9\3\2\2\2\u00cb\u00cc"+
		"\3\2\2\2\u00cc\u00d0\7\13\2\2\u00cd\u00cf\5F$\2\u00ce\u00cd\3\2\2\2\u00cf"+
		"\u00d2\3\2\2\2\u00d0\u00ce\3\2\2\2\u00d0\u00d1\3\2\2\2\u00d1\u00d3\3\2"+
		"\2\2\u00d2\u00d0\3\2\2\2\u00d3\u00d4\7\"\2\2\u00d4+\3\2\2\2\u00d5\u00d6"+
		"\7\31\2\2\u00d6-\3\2\2\2\u00d7\u00da\5,\27\2\u00d8\u00da\3\2\2\2\u00d9"+
		"\u00d7\3\2\2\2\u00d9\u00d8\3\2\2\2\u00da\u00dd\3\2\2\2\u00db\u00de\7("+
		"\2\2\u00dc\u00de\5\62\32\2\u00dd\u00db\3\2\2\2\u00dd\u00dc\3\2\2\2\u00de"+
		"\u00df\3\2\2\2\u00df\u00e0\7\4\2\2\u00e0\u00e1\5\"\22\2\u00e1\u00e2\7"+
		"\6\2\2\u00e2/\3\2\2\2\u00e3\u00e4\7(\2\2\u00e4\u00e9\7\24\2\2\u00e5\u00e6"+
		"\7\4\2\2\u00e6\u00e7\5\"\22\2\u00e7\u00e8\7\6\2\2\u00e8\u00ea\3\2\2\2"+
		"\u00e9\u00e5\3\2\2\2\u00ea\u00eb\3\2\2\2\u00eb\u00e9\3\2\2\2\u00eb\u00ec"+
		"\3\2\2\2\u00ec\u00ed\3\2\2\2\u00ed\u00ee\7\27\2\2\u00ee\61\3\2\2\2\u00ef"+
		"\u00f0\7(\2\2\u00f0\u00f1\7\b\2\2\u00f1\u00f2\7(\2\2\u00f2\63\3\2\2\2"+
		"\u00f3\u00f4\7\17\2\2\u00f4\u00f5\7(\2\2\u00f5\65\3\2\2\2\u00f6\u00f7"+
		"\5:\36\2\u00f7\u00f8\5F$\2\u00f8\67\3\2\2\2\u00f9\u00fc\5\64\33\2\u00fa"+
		"\u00fc\5\66\34\2\u00fb\u00f9\3\2\2\2\u00fb\u00fa\3\2\2\2\u00fc9\3\2\2"+
		"\2\u00fd\u00fe\t\3\2\2\u00fe;\3\2\2\2\u00ff\u0100\7\7\2\2\u0100\u0101"+
		"\5$\23\2\u0101\u0102\7\f\2\2\u0102\u0105\5> \2\u0103\u0106\5\26\f\2\u0104"+
		"\u0106\5\24\13\2\u0105\u0103\3\2\2\2\u0105\u0104\3\2\2\2\u0106\u0107\3"+
		"\2\2\2\u0107\u0108\7#\2\2\u0108\u0109\5$\23\2\u0109\u010c\7 \2\2\u010a"+
		"\u010d\5<\37\2\u010b\u010d\5$\23\2\u010c\u010a\3\2\2\2\u010c\u010b\3\2"+
		"\2\2\u010d=\3\2\2\2\u010e\u0111\7\33\2\2\u010f\u0111\3\2\2\2\u0110\u010e"+
		"\3\2\2\2\u0110\u010f\3\2\2\2\u0111?\3\2\2\2\u0112\u0115\7!\2\2\u0113\u0116"+
		"\7(\2\2\u0114\u0116\5:\36\2\u0115\u0113\3\2\2\2\u0115\u0114\3\2\2\2\u0116"+
		"\u0117\3\2\2\2\u0117\u0118\5\20\t\2\u0118\u0119\7\25\2\2\u0119\u011a\5"+
		"F$\2\u011aA\3\2\2\2\u011b\u011c\7\35\2\2\u011c\u011d\7\4\2\2\u011d\u011e"+
		"\5\20\t\2\u011e\u011f\7\25\2\2\u011f\u0123\5F$\2\u0120\u0122\5D#\2\u0121"+
		"\u0120\3\2\2\2\u0122\u0125\3\2\2\2\u0123\u0121\3\2\2\2\u0123\u0124\3\2"+
		"\2\2\u0124\u0126\3\2\2\2\u0125\u0123\3\2\2\2\u0126\u0127\7\6\2\2\u0127"+
		"C\3\2\2\2\u0128\u0129\7(\2\2\u0129\u012a\7\5\2\2\u012a\u012b\5\20\t\2"+
		"\u012b\u012c\7\25\2\2\u012c\u012d\5F$\2\u012dE\3\2\2\2\u012e\u0137\5B"+
		"\"\2\u012f\u0137\5*\26\2\u0130\u0137\5<\37\2\u0131\u0137\5$\23\2\u0132"+
		"\u0133\7\13\2\2\u0133\u0134\5F$\2\u0134\u0135\7\"\2\2\u0135\u0137\3\2"+
		"\2\2\u0136\u012e\3\2\2\2\u0136\u012f\3\2\2\2\u0136\u0130\3\2\2\2\u0136"+
		"\u0131\3\2\2\2\u0136\u0132\3\2\2\2\u0137G\3\2\2\2\u0138\u0139\7\36\2\2"+
		"\u0139\u013a\5\20\t\2\u013a\u013e\7\25\2\2\u013b\u013f\5H%\2\u013c\u013f"+
		"\5J&\2\u013d\u013f\5L\'\2\u013e\u013b\3\2\2\2\u013e\u013c\3\2\2\2\u013e"+
		"\u013d\3\2\2\2\u013fI\3\2\2\2\u0140\u0141\7\t\2\2\u0141\u0142\5\20\t\2"+
		"\u0142\u0146\7\25\2\2\u0143\u0147\5H%\2\u0144\u0147\5J&\2\u0145\u0147"+
		"\5L\'\2\u0146\u0143\3\2\2\2\u0146\u0144\3\2\2\2\u0146\u0145\3\2\2\2\u0147"+
		"K\3\2\2\2\u0148\u0149\5F$\2\u0149\u014a\7\f\2\2\u014a\u014b\5 \21\2\u014b"+
		"M\3\2\2\2\u014c\u014d\7\r\2\2\u014d\u014e\7(\2\2\u014e\u014f\5\20\t\2"+
		"\u014f\u0152\7\25\2\2\u0150\u0153\5H%\2\u0151\u0153\5J&\2\u0152\u0150"+
		"\3\2\2\2\u0152\u0151\3\2\2\2\u0153O\3\2\2\2\"SZdisx}\u0087\u008b\u008f"+
		"\u009e\u00a3\u00a8\u00b8\u00ba\u00bf\u00c4\u00ca\u00d0\u00d9\u00dd\u00eb"+
		"\u00fb\u0105\u010c\u0110\u0115\u0123\u0136\u013e\u0146\u0152";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
	}
}