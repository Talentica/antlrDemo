package com.talentica.dsl;

import com.talentica.dsl.antlr.CalculatorParser;

import java.lang.reflect.Method;
import java.util.List;

/**
 * Created by debasishc on 26/3/15.
 */
public class CalculatorCompilerRunner extends CalculatorRunner{
    @Override
    public Double run(String sourcePath) throws Exception{
        CalculatorParser parser = setupParser(sourcePath);
        RealCompiler calculator = new RealCompiler(sourcePath.substring(0,sourcePath.length()-4));
        parser.addParseListener(calculator);
        parser.program();

        List<String> errors = calculator.getErrors();
        if(errors.size()>0){
            throw new Exception(errors.toString());
        }else{
            String className = calculator.getClassName().replaceAll("/",".");
            Class<?> c = Class.forName(className);
            Method m = c.getMethod("calc", new Class[0]);
            return (Double)m.invoke(null);
        }

    }
}
