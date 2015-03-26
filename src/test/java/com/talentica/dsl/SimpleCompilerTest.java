package com.talentica.dsl;

/**
 * Created by debasishc on 26/3/15.
 */
public class SimpleCompilerTest extends SimpleTest{
    @Override
    public CalculatorRunner getRunner() {
        return new CalculatorCompilerRunner();
    }
}
