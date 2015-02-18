package com.talentica.dsl;

import com.talentica.dsl.antlr.CalculatorBaseListener;
import com.talentica.dsl.antlr.CalculatorParser;
import org.antlr.v4.runtime.misc.NotNull;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Created by debasishc on 18/2/15.
 */
public class RealCalculator extends CalculatorBaseListener{
    
    private HashMap<String, Double> variables = new HashMap<>();
    private Stack<Double> operandStack = new Stack<>();
    private Double result;
    private LinkedList<String> errors = new LinkedList<>();

    public Double getResult() {
        return result;
    }
    
    public List<String> getErrors(){
        
        return errors;
    }

    @Override
    public void exitMultOrDiv(@NotNull CalculatorParser.MultOrDivContext ctx) {
        String operand = ctx.getChild(1).getText();
        Double operand2 = operandStack.pop();
        Double operand1 = operandStack.pop();
        switch (operand){
            case "*":
                operandStack.push(operand1 * operand2);
                break;
            case "/":
                operandStack.push(operand1 / operand2);
                break;
        }
    }

    @Override
    public void exitIdExpression(@NotNull CalculatorParser.IdExpressionContext ctx) {
        String name = ctx.ID().getText();
        Double value = variables.get(name);
        if (value == null) {
            errors.add("Undefined Alias "+name + "at "+ctx.getStart().getLine());
            operandStack.push(0d);
        }else{
            operandStack.push(value);
        }
    }

    @Override
    public void exitDoubleExpression(@NotNull CalculatorParser.DoubleExpressionContext ctx) {
        operandStack.push(Double.valueOf(ctx.DOUBLE().getText()));
    }



    @Override
    public void exitAddOrSubtract(@NotNull CalculatorParser.AddOrSubtractContext ctx) {
        String operand = ctx.getChild(1).getText();
        Double operand2 = operandStack.pop();
        Double operand1 = operandStack.pop();
        switch (operand){
            case "+":
                operandStack.push(operand1 + operand2);
                break;
            case "-":
                operandStack.push(operand1 - operand2);
                break;
        }
    }

    @Override
    public void exitStatement(@NotNull CalculatorParser.StatementContext ctx) {
        String name = ctx.ID().getText();
        variables.put(name, operandStack.pop());
    }

    @Override
    public void exitProgram(@NotNull CalculatorParser.ProgramContext ctx) {
        result = operandStack.pop();
    }


}
