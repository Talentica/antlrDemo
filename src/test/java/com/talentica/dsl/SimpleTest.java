package com.talentica.dsl;

import org.junit.Test;
import static org.junit.Assert.*;
/**
 * Created by debasishc on 18/2/15.
 */
public class SimpleTest {
    CalculatorRunner runner = new CalculatorRunner();
    private static final double PRECISION = 1e-10;
    
    @Test
    public void testAdd() throws Exception{
        Double result = runner.run("add.exp");
        assertEquals(5d, result, PRECISION);
        
    }
    
    @Test
    public void testSubstract() throws Exception{
        Double result = runner.run("substract.exp");
        assertEquals(1d, result, PRECISION);

    }

    @Test
    public void testMultiply() throws Exception{
        Double result = runner.run("multiply.exp");
        assertEquals(32d, result, PRECISION);

    }

    @Test
    public void testDivide() throws Exception{
        Double result = runner.run("divide.exp");
        assertEquals(6.5d, result, PRECISION);

    }

    @Test
    public void testBodmas() throws Exception{
        Double result = runner.run("bodmas.exp");
        assertEquals(5d, result, PRECISION);

    }

    @Test
    public void testParentheses() throws Exception{
        Double result = runner.run("parentheses.exp");
        assertEquals(2d, result, PRECISION);

    }

    @Test
    public void testSimpleVariable() throws Exception{
        Double result = runner.run("simpleVariable.exp");
        assertEquals(10d, result, PRECISION);

    }

    @Test
    public void testTwoVariables() throws Exception{
        Double result = runner.run("twoVariables.exp");
        assertEquals(8d, result, PRECISION);
    }
}
