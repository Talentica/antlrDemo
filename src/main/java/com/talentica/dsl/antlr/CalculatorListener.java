// Generated from /home/debasishc/AntlrDemo/src/main/java/com/talentica/dsl/antlr/Calculator.g4 by ANTLR 4.3

package com.talentica.dsl.antlr;

import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link CalculatorParser}.
 */
public interface CalculatorListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link CalculatorParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(@NotNull CalculatorParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link CalculatorParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(@NotNull CalculatorParser.StatementContext ctx);

	/**
	 * Enter a parse tree produced by the {@code addOrSubtract}
	 * labeled alternative in {@link CalculatorParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterAddOrSubtract(@NotNull CalculatorParser.AddOrSubtractContext ctx);
	/**
	 * Exit a parse tree produced by the {@code addOrSubtract}
	 * labeled alternative in {@link CalculatorParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitAddOrSubtract(@NotNull CalculatorParser.AddOrSubtractContext ctx);

	/**
	 * Enter a parse tree produced by the {@code multOrDiv}
	 * labeled alternative in {@link CalculatorParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterMultOrDiv(@NotNull CalculatorParser.MultOrDivContext ctx);
	/**
	 * Exit a parse tree produced by the {@code multOrDiv}
	 * labeled alternative in {@link CalculatorParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitMultOrDiv(@NotNull CalculatorParser.MultOrDivContext ctx);

	/**
	 * Enter a parse tree produced by {@link CalculatorParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(@NotNull CalculatorParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link CalculatorParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(@NotNull CalculatorParser.ProgramContext ctx);

	/**
	 * Enter a parse tree produced by the {@code idExpression}
	 * labeled alternative in {@link CalculatorParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterIdExpression(@NotNull CalculatorParser.IdExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code idExpression}
	 * labeled alternative in {@link CalculatorParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitIdExpression(@NotNull CalculatorParser.IdExpressionContext ctx);

	/**
	 * Enter a parse tree produced by the {@code doubleExpression}
	 * labeled alternative in {@link CalculatorParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterDoubleExpression(@NotNull CalculatorParser.DoubleExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code doubleExpression}
	 * labeled alternative in {@link CalculatorParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitDoubleExpression(@NotNull CalculatorParser.DoubleExpressionContext ctx);

	/**
	 * Enter a parse tree produced by the {@code parenExpression}
	 * labeled alternative in {@link CalculatorParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterParenExpression(@NotNull CalculatorParser.ParenExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code parenExpression}
	 * labeled alternative in {@link CalculatorParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitParenExpression(@NotNull CalculatorParser.ParenExpressionContext ctx);
}