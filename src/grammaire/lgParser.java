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
		T__35=1, T__34=2, T__33=3, T__32=4, T__31=5, T__30=6, T__29=7, T__28=8, 
		T__27=9, T__26=10, T__25=11, T__24=12, T__23=13, T__22=14, T__21=15, T__20=16, 
		T__19=17, T__18=18, T__17=19, T__16=20, T__15=21, T__14=22, T__13=23, 
		T__12=24, T__11=25, T__10=26, T__9=27, T__8=28, T__7=29, T__6=30, T__5=31, 
		T__4=32, T__3=33, T__2=34, T__1=35, T__0=36, ENTIER=37, ENTIER_EXTERNE=38, 
		ID=39, WS=40;
	public static final String[] tokenNames = {
		"<INVALID>", "'/'", "'extern'", "'{'", "'='", "'}'", "'if'", "'$'", "'All'", 
		"'&'", "'('", "'is'", "'predicat'", "'*'", "'.'", "'->'", "'abstract'", 
		"'const'", "':'", "'['", "'|'", "'<'", "']'", "'>'", "'@'", "'type'", 
		"'!'", "'=>'", "'#'", "'Exist'", "'%'", "'else'", "'function'", "')'", 
		"'then'", "'+'", "'-'", "ENTIER", "ENTIER_EXTERNE", "ID", "WS"
	};
	public static final int
		RULE_system = 0, RULE_element = 1, RULE_extern = 2, RULE_constante = 3, 
		RULE_type = 4, RULE_multipleFlag = 5, RULE_abstractFlag = 6, RULE_superType = 7, 
		RULE_champs = 8, RULE_champ = 9, RULE_multiple = 10, RULE_simple = 11, 
		RULE_typeBase = 12, RULE_attribut = 13, RULE_defTypeFunction = 14, RULE_defTypes = 15, 
		RULE_defType = 16, RULE_attributs = 17, RULE_code = 18, RULE_var = 19, 
		RULE_metaModele = 20, RULE_entier = 21, RULE_appel = 22, RULE_flagMultiple = 23, 
		RULE_creer = 24, RULE_creerListe = 25, RULE_id_externe = 26, RULE_acces = 27, 
		RULE_fonctionRefAppel = 28, RULE_operation = 29, RULE_operationOuAcces = 30, 
		RULE_operateur = 31, RULE_si = 32, RULE_negation = 33, RULE_function = 34, 
		RULE_functionDef = 35, RULE_functionLocal = 36, RULE_tmpCode = 37, RULE_exist = 38, 
		RULE_all = 39, RULE_estType = 40, RULE_defPredicat = 41;
	public static final String[] ruleNames = {
		"system", "element", "extern", "constante", "type", "multipleFlag", "abstractFlag", 
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
			setState(87);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 2) | (1L << 12) | (1L << 16) | (1L << 17) | (1L << 25) | (1L << 32))) != 0)) {
				{
				{
				setState(84); element();
				}
				}
				setState(89);
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
		public ExternContext extern() {
			return getRuleContext(ExternContext.class,0);
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
			setState(95);
			switch (_input.LA(1)) {
			case 16:
			case 25:
				enterOuterAlt(_localctx, 1);
				{
				setState(90); type();
				}
				break;
			case 32:
				enterOuterAlt(_localctx, 2);
				{
				setState(91); function();
				}
				break;
			case 12:
				enterOuterAlt(_localctx, 3);
				{
				setState(92); defPredicat();
				}
				break;
			case 17:
				enterOuterAlt(_localctx, 4);
				{
				setState(93); constante();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 5);
				{
				setState(94); extern();
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

	public static class ExternContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(lgParser.ID, 0); }
		public OperateurContext operateur() {
			return getRuleContext(OperateurContext.class,0);
		}
		public DefTypeFunctionContext defTypeFunction() {
			return getRuleContext(DefTypeFunctionContext.class,0);
		}
		public ExternContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_extern; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof lgListener ) ((lgListener)listener).enterExtern(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof lgListener ) ((lgListener)listener).exitExtern(this);
		}
	}

	public final ExternContext extern() throws RecognitionException {
		ExternContext _localctx = new ExternContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_extern);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(97); match(2);
			setState(100);
			switch (_input.LA(1)) {
			case ID:
				{
				setState(98); match(ID);
				}
				break;
			case 1:
			case 4:
			case 9:
			case 13:
			case 15:
			case 20:
			case 21:
			case 23:
			case 27:
			case 35:
			case 36:
				{
				setState(99); operateur();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(102); defTypeFunction();
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
		enterRule(_localctx, 6, RULE_constante);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(104); match(17);
			setState(105); match(ID);
			setState(106); tmpCode();
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
		enterRule(_localctx, 8, RULE_type);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(108); abstractFlag();
			setState(109); match(25);
			setState(112);
			switch (_input.LA(1)) {
			case 24:
				{
				setState(110); multipleFlag();
				}
				break;
			case ID:
				{
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(114); match(ID);
			setState(117);
			switch (_input.LA(1)) {
			case 18:
				{
				setState(115); superType();
				}
				break;
			case 3:
				{
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(119); match(3);
			setState(120); champs();
			setState(121); match(5);
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
		enterRule(_localctx, 10, RULE_multipleFlag);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(123); match(24);
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
		enterRule(_localctx, 12, RULE_abstractFlag);
		try {
			setState(127);
			switch (_input.LA(1)) {
			case 16:
				enterOuterAlt(_localctx, 1);
				{
				setState(125); match(16);
				}
				break;
			case 25:
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
		enterRule(_localctx, 14, RULE_superType);
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(129); match(18);
			setState(132);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				{
				setState(130); match(ID);
				}
				break;

			case 2:
				{
				setState(131); id_externe();
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
		enterRule(_localctx, 16, RULE_champs);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(137);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 19) | (1L << 24) | (1L << ID))) != 0)) {
				{
				{
				setState(134); champ();
				}
				}
				setState(139);
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
		enterRule(_localctx, 18, RULE_champ);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(140); defType();
			setState(141); match(18);
			setState(142); match(ID);
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
		enterRule(_localctx, 20, RULE_multiple);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(144); match(24);
			setState(147);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				{
				setState(145); match(ID);
				}
				break;

			case 2:
				{
				setState(146); id_externe();
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
		enterRule(_localctx, 22, RULE_simple);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(151);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				{
				setState(149); match(ID);
				}
				break;

			case 2:
				{
				setState(150); id_externe();
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
		enterRule(_localctx, 24, RULE_typeBase);
		try {
			setState(155);
			switch (_input.LA(1)) {
			case 24:
				enterOuterAlt(_localctx, 1);
				{
				setState(153); multiple();
				}
				break;
			case ID:
				enterOuterAlt(_localctx, 2);
				{
				setState(154); simple();
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
		enterRule(_localctx, 26, RULE_attribut);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(157); match(ID);
			setState(158); match(4);
			setState(159); tmpCode();
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
		enterRule(_localctx, 28, RULE_defTypeFunction);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(161); match(19);
			setState(162); defTypes();
			setState(163); match(22);
			setState(164); match(15);
			setState(165); defType();
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
		enterRule(_localctx, 30, RULE_defTypes);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(170);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 19) | (1L << 24) | (1L << ID))) != 0)) {
				{
				{
				setState(167); defType();
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
		enterRule(_localctx, 32, RULE_defType);
		try {
			setState(175);
			switch (_input.LA(1)) {
			case 24:
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(173); typeBase();
				}
				break;
			case 19:
				enterOuterAlt(_localctx, 2);
				{
				setState(174); defTypeFunction();
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
		enterRule(_localctx, 34, RULE_attributs);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(180);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==ID) {
				{
				{
				setState(177); attribut();
				}
				}
				setState(182);
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
		enterRule(_localctx, 36, RULE_code);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(198);
			switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
			case 1:
				{
				{
				setState(183); match(10);
				setState(184); code();
				setState(185); match(33);
				}
				}
				break;

			case 2:
				{
				setState(196);
				switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
				case 1:
					{
					setState(187); appel();
					}
					break;

				case 2:
					{
					setState(188); creerListe();
					}
					break;

				case 3:
					{
					setState(189); creer();
					}
					break;

				case 4:
					{
					setState(190); var();
					}
					break;

				case 5:
					{
					setState(191); entier();
					}
					break;

				case 6:
					{
					{
					setState(192); match(10);
					{
					setState(193); si();
					}
					setState(194); match(33);
					}
					}
					break;
				}
				}
				break;
			}
			setState(203);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					{
					{
					setState(200); operationOuAcces();
					}
					} 
				}
				setState(205);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
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
		enterRule(_localctx, 38, RULE_var);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(206); metaModele();
			setState(209);
			switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
			case 1:
				{
				setState(207); match(ID);
				}
				break;

			case 2:
				{
				setState(208); id_externe();
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
		enterRule(_localctx, 40, RULE_metaModele);
		try {
			setState(213);
			switch (_input.LA(1)) {
			case 30:
				enterOuterAlt(_localctx, 1);
				{
				setState(211); match(30);
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
		enterRule(_localctx, 42, RULE_entier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(215);
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
		enterRule(_localctx, 44, RULE_appel);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(219);
			switch (_input.LA(1)) {
			case ID:
				{
				setState(217); fonctionRefAppel();
				}
				break;
			case 28:
				{
				setState(218); functionDef();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(221); match(10);
			setState(225);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 6) | (1L << 10) | (1L << 24) | (1L << 28) | (1L << 30) | (1L << ENTIER) | (1L << ENTIER_EXTERNE) | (1L << ID))) != 0)) {
				{
				{
				setState(222); tmpCode();
				}
				}
				setState(227);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(228); match(33);
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
		enterRule(_localctx, 46, RULE_flagMultiple);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(230); match(24);
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
		enterRule(_localctx, 48, RULE_creer);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(234);
			switch (_input.LA(1)) {
			case 24:
				{
				setState(232); flagMultiple();
				}
				break;
			case ID:
				{
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(238);
			switch ( getInterpreter().adaptivePredict(_input,22,_ctx) ) {
			case 1:
				{
				setState(236); match(ID);
				}
				break;

			case 2:
				{
				setState(237); id_externe();
				}
				break;
			}
			setState(240); match(3);
			setState(241); attributs();
			setState(242); match(5);
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
		enterRule(_localctx, 50, RULE_creerListe);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(244); match(ID);
			setState(245); match(19);
			{
			{
			setState(250); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(246); match(3);
				setState(247); attributs();
				setState(248); match(5);
				}
				}
				setState(252); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==3 );
			}
			}
			setState(254); match(22);
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
		enterRule(_localctx, 52, RULE_id_externe);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(256); match(ID);
			setState(257); match(7);
			setState(258); match(ID);
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
		enterRule(_localctx, 54, RULE_acces);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(260); match(14);
			setState(261); match(ID);
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
		enterRule(_localctx, 56, RULE_fonctionRefAppel);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(265);
			switch ( getInterpreter().adaptivePredict(_input,24,_ctx) ) {
			case 1:
				{
				setState(263); match(ID);
				}
				break;

			case 2:
				{
				setState(264); id_externe();
				}
				break;
			}
			setState(270);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==14) {
				{
				{
				setState(267); acces();
				}
				}
				setState(272);
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
		enterRule(_localctx, 58, RULE_operation);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(273); operateur();
			setState(274); tmpCode();
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
		enterRule(_localctx, 60, RULE_operationOuAcces);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(278);
			switch (_input.LA(1)) {
			case 14:
				{
				setState(276); acces();
				}
				break;
			case 1:
			case 4:
			case 9:
			case 13:
			case 15:
			case 20:
			case 21:
			case 23:
			case 27:
			case 35:
			case 36:
				{
				setState(277); operation();
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
		enterRule(_localctx, 62, RULE_operateur);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(280);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 1) | (1L << 4) | (1L << 9) | (1L << 13) | (1L << 15) | (1L << 20) | (1L << 21) | (1L << 23) | (1L << 27) | (1L << 35) | (1L << 36))) != 0)) ) {
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
		enterRule(_localctx, 64, RULE_si);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(282); match(6);
			setState(283); code();
			setState(284); match(11);
			setState(285); negation();
			setState(288);
			switch (_input.LA(1)) {
			case ID:
				{
				setState(286); simple();
				}
				break;
			case 24:
				{
				setState(287); multiple();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(290); match(34);
			setState(291); code();
			setState(292); match(31);
			setState(295);
			switch (_input.LA(1)) {
			case 6:
				{
				setState(293); si();
				}
				break;
			case 10:
			case 24:
			case 28:
			case 30:
			case ENTIER:
			case ENTIER_EXTERNE:
			case ID:
				{
				setState(294); code();
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
		enterRule(_localctx, 66, RULE_negation);
		try {
			setState(299);
			switch (_input.LA(1)) {
			case 26:
				enterOuterAlt(_localctx, 1);
				{
				setState(297); match(26);
				}
				break;
			case 24:
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
		enterRule(_localctx, 68, RULE_function);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(301); match(32);
			setState(304);
			switch (_input.LA(1)) {
			case ID:
				{
				setState(302); match(ID);
				}
				break;
			case 1:
			case 4:
			case 9:
			case 13:
			case 15:
			case 20:
			case 21:
			case 23:
			case 27:
			case 35:
			case 36:
				{
				setState(303); operateur();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(306); champs();
			setState(307); match(20);
			setState(308); tmpCode();
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
		enterRule(_localctx, 70, RULE_functionDef);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(310); match(28);
			setState(311); match(3);
			setState(312); champs();
			setState(313); match(20);
			setState(314); tmpCode();
			setState(315); match(5);
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
		enterRule(_localctx, 72, RULE_functionLocal);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(317); match(ID);
			setState(318); match(4);
			setState(319); champs();
			setState(320); match(20);
			setState(321); tmpCode();
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
		enterRule(_localctx, 74, RULE_tmpCode);
		try {
			setState(331);
			switch ( getInterpreter().adaptivePredict(_input,31,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(323); functionDef();
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(324); appel();
				}
				break;

			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(325); si();
				}
				break;

			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(326); code();
				}
				break;

			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(327); match(10);
				setState(328); tmpCode();
				setState(329); match(33);
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
		enterRule(_localctx, 76, RULE_exist);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(333); match(29);
			setState(334); champs();
			setState(335); match(20);
			setState(339);
			switch (_input.LA(1)) {
			case 29:
				{
				setState(336); exist();
				}
				break;
			case 8:
				{
				setState(337); all();
				}
				break;
			case 6:
			case 10:
			case 24:
			case 28:
			case 30:
			case ENTIER:
			case ENTIER_EXTERNE:
			case ID:
				{
				setState(338); estType();
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
		enterRule(_localctx, 78, RULE_all);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(341); match(8);
			setState(342); champs();
			setState(343); match(20);
			setState(347);
			switch (_input.LA(1)) {
			case 29:
				{
				setState(344); exist();
				}
				break;
			case 8:
				{
				setState(345); all();
				}
				break;
			case 6:
			case 10:
			case 24:
			case 28:
			case 30:
			case ENTIER:
			case ENTIER_EXTERNE:
			case ID:
				{
				setState(346); estType();
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
		enterRule(_localctx, 80, RULE_estType);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(349); tmpCode();
			setState(350); match(11);
			setState(351); defType();
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
		enterRule(_localctx, 82, RULE_defPredicat);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(353); match(12);
			setState(354); match(ID);
			setState(355); champs();
			setState(356); match(20);
			setState(359);
			switch (_input.LA(1)) {
			case 29:
				{
				setState(357); exist();
				}
				break;
			case 8:
				{
				setState(358); all();
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
		"\2\3*\u016c\4\2\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4"+
		"\t\t\t\4\n\t\n\4\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20"+
		"\4\21\t\21\4\22\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27"+
		"\4\30\t\30\4\31\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36"+
		"\4\37\t\37\4 \t \4!\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4"+
		")\t)\4*\t*\4+\t+\3\2\7\2X\n\2\f\2\16\2[\13\2\3\3\3\3\3\3\3\3\3\3\5\3b"+
		"\n\3\3\4\3\4\3\4\5\4g\n\4\3\4\3\4\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\5\6"+
		"s\n\6\3\6\3\6\3\6\5\6x\n\6\3\6\3\6\3\6\3\6\3\7\3\7\3\b\3\b\5\b\u0082\n"+
		"\b\3\t\3\t\3\t\5\t\u0087\n\t\3\n\7\n\u008a\n\n\f\n\16\n\u008d\13\n\3\13"+
		"\3\13\3\13\3\13\3\f\3\f\3\f\5\f\u0096\n\f\3\r\3\r\5\r\u009a\n\r\3\16\3"+
		"\16\5\16\u009e\n\16\3\17\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3\20\3\20"+
		"\3\21\7\21\u00ab\n\21\f\21\16\21\u00ae\13\21\3\22\3\22\5\22\u00b2\n\22"+
		"\3\23\7\23\u00b5\n\23\f\23\16\23\u00b8\13\23\3\24\3\24\3\24\3\24\3\24"+
		"\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\5\24\u00c7\n\24\5\24\u00c9\n"+
		"\24\3\24\7\24\u00cc\n\24\f\24\16\24\u00cf\13\24\3\25\3\25\3\25\5\25\u00d4"+
		"\n\25\3\26\3\26\5\26\u00d8\n\26\3\27\3\27\3\30\3\30\5\30\u00de\n\30\3"+
		"\30\3\30\7\30\u00e2\n\30\f\30\16\30\u00e5\13\30\3\30\3\30\3\31\3\31\3"+
		"\32\3\32\5\32\u00ed\n\32\3\32\3\32\5\32\u00f1\n\32\3\32\3\32\3\32\3\32"+
		"\3\33\3\33\3\33\3\33\3\33\3\33\6\33\u00fd\n\33\r\33\16\33\u00fe\3\33\3"+
		"\33\3\34\3\34\3\34\3\34\3\35\3\35\3\35\3\36\3\36\5\36\u010c\n\36\3\36"+
		"\7\36\u010f\n\36\f\36\16\36\u0112\13\36\3\37\3\37\3\37\3 \3 \5 \u0119"+
		"\n \3!\3!\3\"\3\"\3\"\3\"\3\"\3\"\5\"\u0123\n\"\3\"\3\"\3\"\3\"\3\"\5"+
		"\"\u012a\n\"\3#\3#\5#\u012e\n#\3$\3$\3$\5$\u0133\n$\3$\3$\3$\3$\3%\3%"+
		"\3%\3%\3%\3%\3%\3&\3&\3&\3&\3&\3&\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\5\'"+
		"\u014e\n\'\3(\3(\3(\3(\3(\3(\5(\u0156\n(\3)\3)\3)\3)\3)\3)\5)\u015e\n"+
		")\3*\3*\3*\3*\3+\3+\3+\3+\3+\3+\5+\u016a\n+\3+\2,\2\4\6\b\n\f\16\20\22"+
		"\24\26\30\32\34\36 \"$&(*,.\60\62\64\668:<>@BDFHJLNPRT\2\4\3\'(\13\3\3"+
		"\6\6\13\13\17\17\21\21\26\27\31\31\35\35%&\u0170\2Y\3\2\2\2\4a\3\2\2\2"+
		"\6c\3\2\2\2\bj\3\2\2\2\nn\3\2\2\2\f}\3\2\2\2\16\u0081\3\2\2\2\20\u0083"+
		"\3\2\2\2\22\u008b\3\2\2\2\24\u008e\3\2\2\2\26\u0092\3\2\2\2\30\u0099\3"+
		"\2\2\2\32\u009d\3\2\2\2\34\u009f\3\2\2\2\36\u00a3\3\2\2\2 \u00ac\3\2\2"+
		"\2\"\u00b1\3\2\2\2$\u00b6\3\2\2\2&\u00c8\3\2\2\2(\u00d0\3\2\2\2*\u00d7"+
		"\3\2\2\2,\u00d9\3\2\2\2.\u00dd\3\2\2\2\60\u00e8\3\2\2\2\62\u00ec\3\2\2"+
		"\2\64\u00f6\3\2\2\2\66\u0102\3\2\2\28\u0106\3\2\2\2:\u010b\3\2\2\2<\u0113"+
		"\3\2\2\2>\u0118\3\2\2\2@\u011a\3\2\2\2B\u011c\3\2\2\2D\u012d\3\2\2\2F"+
		"\u012f\3\2\2\2H\u0138\3\2\2\2J\u013f\3\2\2\2L\u014d\3\2\2\2N\u014f\3\2"+
		"\2\2P\u0157\3\2\2\2R\u015f\3\2\2\2T\u0163\3\2\2\2VX\5\4\3\2WV\3\2\2\2"+
		"X[\3\2\2\2YW\3\2\2\2YZ\3\2\2\2Z\3\3\2\2\2[Y\3\2\2\2\\b\5\n\6\2]b\5F$\2"+
		"^b\5T+\2_b\5\b\5\2`b\5\6\4\2a\\\3\2\2\2a]\3\2\2\2a^\3\2\2\2a_\3\2\2\2"+
		"a`\3\2\2\2b\5\3\2\2\2cf\7\4\2\2dg\7)\2\2eg\5@!\2fd\3\2\2\2fe\3\2\2\2g"+
		"h\3\2\2\2hi\5\36\20\2i\7\3\2\2\2jk\7\23\2\2kl\7)\2\2lm\5L\'\2m\t\3\2\2"+
		"\2no\5\16\b\2or\7\33\2\2ps\5\f\7\2qs\3\2\2\2rp\3\2\2\2rq\3\2\2\2st\3\2"+
		"\2\2tw\7)\2\2ux\5\20\t\2vx\3\2\2\2wu\3\2\2\2wv\3\2\2\2xy\3\2\2\2yz\7\5"+
		"\2\2z{\5\22\n\2{|\7\7\2\2|\13\3\2\2\2}~\7\32\2\2~\r\3\2\2\2\177\u0082"+
		"\7\22\2\2\u0080\u0082\3\2\2\2\u0081\177\3\2\2\2\u0081\u0080\3\2\2\2\u0082"+
		"\17\3\2\2\2\u0083\u0086\7\24\2\2\u0084\u0087\7)\2\2\u0085\u0087\5\66\34"+
		"\2\u0086\u0084\3\2\2\2\u0086\u0085\3\2\2\2\u0087\21\3\2\2\2\u0088\u008a"+
		"\5\24\13\2\u0089\u0088\3\2\2\2\u008a\u008d\3\2\2\2\u008b\u0089\3\2\2\2"+
		"\u008b\u008c\3\2\2\2\u008c\23\3\2\2\2\u008d\u008b\3\2\2\2\u008e\u008f"+
		"\5\"\22\2\u008f\u0090\7\24\2\2\u0090\u0091\7)\2\2\u0091\25\3\2\2\2\u0092"+
		"\u0095\7\32\2\2\u0093\u0096\7)\2\2\u0094\u0096\5\66\34\2\u0095\u0093\3"+
		"\2\2\2\u0095\u0094\3\2\2\2\u0096\27\3\2\2\2\u0097\u009a\7)\2\2\u0098\u009a"+
		"\5\66\34\2\u0099\u0097\3\2\2\2\u0099\u0098\3\2\2\2\u009a\31\3\2\2\2\u009b"+
		"\u009e\5\26\f\2\u009c\u009e\5\30\r\2\u009d\u009b\3\2\2\2\u009d\u009c\3"+
		"\2\2\2\u009e\33\3\2\2\2\u009f\u00a0\7)\2\2\u00a0\u00a1\7\6\2\2\u00a1\u00a2"+
		"\5L\'\2\u00a2\35\3\2\2\2\u00a3\u00a4\7\25\2\2\u00a4\u00a5\5 \21\2\u00a5"+
		"\u00a6\7\30\2\2\u00a6\u00a7\7\21\2\2\u00a7\u00a8\5\"\22\2\u00a8\37\3\2"+
		"\2\2\u00a9\u00ab\5\"\22\2\u00aa\u00a9\3\2\2\2\u00ab\u00ae\3\2\2\2\u00ac"+
		"\u00aa\3\2\2\2\u00ac\u00ad\3\2\2\2\u00ad!\3\2\2\2\u00ae\u00ac\3\2\2\2"+
		"\u00af\u00b2\5\32\16\2\u00b0\u00b2\5\36\20\2\u00b1\u00af\3\2\2\2\u00b1"+
		"\u00b0\3\2\2\2\u00b2#\3\2\2\2\u00b3\u00b5\5\34\17\2\u00b4\u00b3\3\2\2"+
		"\2\u00b5\u00b8\3\2\2\2\u00b6\u00b4\3\2\2\2\u00b6\u00b7\3\2\2\2\u00b7%"+
		"\3\2\2\2\u00b8\u00b6\3\2\2\2\u00b9\u00ba\7\f\2\2\u00ba\u00bb\5&\24\2\u00bb"+
		"\u00bc\7#\2\2\u00bc\u00c9\3\2\2\2\u00bd\u00c7\5.\30\2\u00be\u00c7\5\64"+
		"\33\2\u00bf\u00c7\5\62\32\2\u00c0\u00c7\5(\25\2\u00c1\u00c7\5,\27\2\u00c2"+
		"\u00c3\7\f\2\2\u00c3\u00c4\5B\"\2\u00c4\u00c5\7#\2\2\u00c5\u00c7\3\2\2"+
		"\2\u00c6\u00bd\3\2\2\2\u00c6\u00be\3\2\2\2\u00c6\u00bf\3\2\2\2\u00c6\u00c0"+
		"\3\2\2\2\u00c6\u00c1\3\2\2\2\u00c6\u00c2\3\2\2\2\u00c7\u00c9\3\2\2\2\u00c8"+
		"\u00b9\3\2\2\2\u00c8\u00c6\3\2\2\2\u00c9\u00cd\3\2\2\2\u00ca\u00cc\5>"+
		" \2\u00cb\u00ca\3\2\2\2\u00cc\u00cf\3\2\2\2\u00cd\u00cb\3\2\2\2\u00cd"+
		"\u00ce\3\2\2\2\u00ce\'\3\2\2\2\u00cf\u00cd\3\2\2\2\u00d0\u00d3\5*\26\2"+
		"\u00d1\u00d4\7)\2\2\u00d2\u00d4\5\66\34\2\u00d3\u00d1\3\2\2\2\u00d3\u00d2"+
		"\3\2\2\2\u00d4)\3\2\2\2\u00d5\u00d8\7 \2\2\u00d6\u00d8\3\2\2\2\u00d7\u00d5"+
		"\3\2\2\2\u00d7\u00d6\3\2\2\2\u00d8+\3\2\2\2\u00d9\u00da\t\2\2\2\u00da"+
		"-\3\2\2\2\u00db\u00de\5:\36\2\u00dc\u00de\5H%\2\u00dd\u00db\3\2\2\2\u00dd"+
		"\u00dc\3\2\2\2\u00de\u00df\3\2\2\2\u00df\u00e3\7\f\2\2\u00e0\u00e2\5L"+
		"\'\2\u00e1\u00e0\3\2\2\2\u00e2\u00e5\3\2\2\2\u00e3\u00e1\3\2\2\2\u00e3"+
		"\u00e4\3\2\2\2\u00e4\u00e6\3\2\2\2\u00e5\u00e3\3\2\2\2\u00e6\u00e7\7#"+
		"\2\2\u00e7/\3\2\2\2\u00e8\u00e9\7\32\2\2\u00e9\61\3\2\2\2\u00ea\u00ed"+
		"\5\60\31\2\u00eb\u00ed\3\2\2\2\u00ec\u00ea\3\2\2\2\u00ec\u00eb\3\2\2\2"+
		"\u00ed\u00f0\3\2\2\2\u00ee\u00f1\7)\2\2\u00ef\u00f1\5\66\34\2\u00f0\u00ee"+
		"\3\2\2\2\u00f0\u00ef\3\2\2\2\u00f1\u00f2\3\2\2\2\u00f2\u00f3\7\5\2\2\u00f3"+
		"\u00f4\5$\23\2\u00f4\u00f5\7\7\2\2\u00f5\63\3\2\2\2\u00f6\u00f7\7)\2\2"+
		"\u00f7\u00fc\7\25\2\2\u00f8\u00f9\7\5\2\2\u00f9\u00fa\5$\23\2\u00fa\u00fb"+
		"\7\7\2\2\u00fb\u00fd\3\2\2\2\u00fc\u00f8\3\2\2\2\u00fd\u00fe\3\2\2\2\u00fe"+
		"\u00fc\3\2\2\2\u00fe\u00ff\3\2\2\2\u00ff\u0100\3\2\2\2\u0100\u0101\7\30"+
		"\2\2\u0101\65\3\2\2\2\u0102\u0103\7)\2\2\u0103\u0104\7\t\2\2\u0104\u0105"+
		"\7)\2\2\u0105\67\3\2\2\2\u0106\u0107\7\20\2\2\u0107\u0108\7)\2\2\u0108"+
		"9\3\2\2\2\u0109\u010c\7)\2\2\u010a\u010c\5\66\34\2\u010b\u0109\3\2\2\2"+
		"\u010b\u010a\3\2\2\2\u010c\u0110\3\2\2\2\u010d\u010f\58\35\2\u010e\u010d"+
		"\3\2\2\2\u010f\u0112\3\2\2\2\u0110\u010e\3\2\2\2\u0110\u0111\3\2\2\2\u0111"+
		";\3\2\2\2\u0112\u0110\3\2\2\2\u0113\u0114\5@!\2\u0114\u0115\5L\'\2\u0115"+
		"=\3\2\2\2\u0116\u0119\58\35\2\u0117\u0119\5<\37\2\u0118\u0116\3\2\2\2"+
		"\u0118\u0117\3\2\2\2\u0119?\3\2\2\2\u011a\u011b\t\3\2\2\u011bA\3\2\2\2"+
		"\u011c\u011d\7\b\2\2\u011d\u011e\5&\24\2\u011e\u011f\7\r\2\2\u011f\u0122"+
		"\5D#\2\u0120\u0123\5\30\r\2\u0121\u0123\5\26\f\2\u0122\u0120\3\2\2\2\u0122"+
		"\u0121\3\2\2\2\u0123\u0124\3\2\2\2\u0124\u0125\7$\2\2\u0125\u0126\5&\24"+
		"\2\u0126\u0129\7!\2\2\u0127\u012a\5B\"\2\u0128\u012a\5&\24\2\u0129\u0127"+
		"\3\2\2\2\u0129\u0128\3\2\2\2\u012aC\3\2\2\2\u012b\u012e\7\34\2\2\u012c"+
		"\u012e\3\2\2\2\u012d\u012b\3\2\2\2\u012d\u012c\3\2\2\2\u012eE\3\2\2\2"+
		"\u012f\u0132\7\"\2\2\u0130\u0133\7)\2\2\u0131\u0133\5@!\2\u0132\u0130"+
		"\3\2\2\2\u0132\u0131\3\2\2\2\u0133\u0134\3\2\2\2\u0134\u0135\5\22\n\2"+
		"\u0135\u0136\7\26\2\2\u0136\u0137\5L\'\2\u0137G\3\2\2\2\u0138\u0139\7"+
		"\36\2\2\u0139\u013a\7\5\2\2\u013a\u013b\5\22\n\2\u013b\u013c\7\26\2\2"+
		"\u013c\u013d\5L\'\2\u013d\u013e\7\7\2\2\u013eI\3\2\2\2\u013f\u0140\7)"+
		"\2\2\u0140\u0141\7\6\2\2\u0141\u0142\5\22\n\2\u0142\u0143\7\26\2\2\u0143"+
		"\u0144\5L\'\2\u0144K\3\2\2\2\u0145\u014e\5H%\2\u0146\u014e\5.\30\2\u0147"+
		"\u014e\5B\"\2\u0148\u014e\5&\24\2\u0149\u014a\7\f\2\2\u014a\u014b\5L\'"+
		"\2\u014b\u014c\7#\2\2\u014c\u014e\3\2\2\2\u014d\u0145\3\2\2\2\u014d\u0146"+
		"\3\2\2\2\u014d\u0147\3\2\2\2\u014d\u0148\3\2\2\2\u014d\u0149\3\2\2\2\u014e"+
		"M\3\2\2\2\u014f\u0150\7\37\2\2\u0150\u0151\5\22\n\2\u0151\u0155\7\26\2"+
		"\2\u0152\u0156\5N(\2\u0153\u0156\5P)\2\u0154\u0156\5R*\2\u0155\u0152\3"+
		"\2\2\2\u0155\u0153\3\2\2\2\u0155\u0154\3\2\2\2\u0156O\3\2\2\2\u0157\u0158"+
		"\7\n\2\2\u0158\u0159\5\22\n\2\u0159\u015d\7\26\2\2\u015a\u015e\5N(\2\u015b"+
		"\u015e\5P)\2\u015c\u015e\5R*\2\u015d\u015a\3\2\2\2\u015d\u015b\3\2\2\2"+
		"\u015d\u015c\3\2\2\2\u015eQ\3\2\2\2\u015f\u0160\5L\'\2\u0160\u0161\7\r"+
		"\2\2\u0161\u0162\5\"\22\2\u0162S\3\2\2\2\u0163\u0164\7\16\2\2\u0164\u0165"+
		"\7)\2\2\u0165\u0166\5\22\n\2\u0166\u0169\7\26\2\2\u0167\u016a\5N(\2\u0168"+
		"\u016a\5P)\2\u0169\u0167\3\2\2\2\u0169\u0168\3\2\2\2\u016aU\3\2\2\2%Y"+
		"afrw\u0081\u0086\u008b\u0095\u0099\u009d\u00ac\u00b1\u00b6\u00c6\u00c8"+
		"\u00cd\u00d3\u00d7\u00dd\u00e3\u00ec\u00f0\u00fe\u010b\u0110\u0118\u0122"+
		"\u0129\u012d\u0132\u014d\u0155\u015d\u0169";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
	}
}