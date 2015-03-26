// Generated from /home/debasishc/AntlrDemo/src/main/java/com/talentica/dsl/antlr/Calculator.g4 by ANTLR 4.3

package com.talentica.dsl.antlr;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class CalculatorLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.3", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__6=1, T__5=2, T__4=3, T__3=4, T__2=5, T__1=6, T__0=7, ID=8, DOUBLE=9, 
		COMMENT=10, WS=11;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"'\\u0000'", "'\\u0001'", "'\\u0002'", "'\\u0003'", "'\\u0004'", "'\\u0005'", 
		"'\\u0006'", "'\\u0007'", "'\b'", "'\t'", "'\n'", "'\\u000B'"
	};
	public static final String[] ruleNames = {
		"T__6", "T__5", "T__4", "T__3", "T__2", "T__1", "T__0", "ID", "DOUBLE", 
		"COMMENT", "WS"
	};


	public CalculatorLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Calculator.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\r\\\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3"+
		"\t\3\t\7\t*\n\t\f\t\16\t-\13\t\3\n\7\n\60\n\n\f\n\16\n\63\13\n\3\n\3\n"+
		"\6\n\67\n\n\r\n\16\n8\3\n\6\n<\n\n\r\n\16\n=\3\n\3\n\7\nB\n\n\f\n\16\n"+
		"E\13\n\5\nG\n\n\5\nI\n\n\3\13\3\13\7\13M\n\13\f\13\16\13P\13\13\3\13\3"+
		"\13\3\13\3\13\3\f\6\fW\n\f\r\f\16\fX\3\f\3\f\3N\2\r\3\3\5\4\7\5\t\6\13"+
		"\7\r\b\17\t\21\n\23\13\25\f\27\r\3\2\7\5\2C\\aac|\6\2\62;C\\aac|\4\2\60"+
		"\60^^\3\2\f\f\5\2\13\f\17\17\"\"d\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2"+
		"\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3"+
		"\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\3\31\3\2\2\2\5\33\3\2\2\2\7\35\3\2\2"+
		"\2\t\37\3\2\2\2\13!\3\2\2\2\r#\3\2\2\2\17%\3\2\2\2\21\'\3\2\2\2\23H\3"+
		"\2\2\2\25J\3\2\2\2\27V\3\2\2\2\31\32\7+\2\2\32\4\3\2\2\2\33\34\7-\2\2"+
		"\34\6\3\2\2\2\35\36\7,\2\2\36\b\3\2\2\2\37 \7/\2\2 \n\3\2\2\2!\"\7*\2"+
		"\2\"\f\3\2\2\2#$\7\61\2\2$\16\3\2\2\2%&\7?\2\2&\20\3\2\2\2\'+\t\2\2\2"+
		"(*\t\3\2\2)(\3\2\2\2*-\3\2\2\2+)\3\2\2\2+,\3\2\2\2,\22\3\2\2\2-+\3\2\2"+
		"\2.\60\4\62;\2/.\3\2\2\2\60\63\3\2\2\2\61/\3\2\2\2\61\62\3\2\2\2\62\64"+
		"\3\2\2\2\63\61\3\2\2\2\64\66\t\4\2\2\65\67\4\62;\2\66\65\3\2\2\2\678\3"+
		"\2\2\28\66\3\2\2\289\3\2\2\29I\3\2\2\2:<\4\62;\2;:\3\2\2\2<=\3\2\2\2="+
		";\3\2\2\2=>\3\2\2\2>F\3\2\2\2?C\t\4\2\2@B\4\62;\2A@\3\2\2\2BE\3\2\2\2"+
		"CA\3\2\2\2CD\3\2\2\2DG\3\2\2\2EC\3\2\2\2F?\3\2\2\2FG\3\2\2\2GI\3\2\2\2"+
		"H\61\3\2\2\2H;\3\2\2\2I\24\3\2\2\2JN\7%\2\2KM\13\2\2\2LK\3\2\2\2MP\3\2"+
		"\2\2NO\3\2\2\2NL\3\2\2\2OQ\3\2\2\2PN\3\2\2\2QR\t\5\2\2RS\3\2\2\2ST\b\13"+
		"\2\2T\26\3\2\2\2UW\t\6\2\2VU\3\2\2\2WX\3\2\2\2XV\3\2\2\2XY\3\2\2\2YZ\3"+
		"\2\2\2Z[\b\f\2\2[\30\3\2\2\2\f\2+\618=CFHNX\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}