package com.talentica.dsl;

import com.talentica.dsl.antlr.CalculatorLexer;
import com.talentica.dsl.antlr.CalculatorParser;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * Created by debasishc on 18/2/15.
 */
public class CalculatorRunner {
    public Double run(String sourcePath) throws Exception{
        CalculatorParser parser = setupParser(sourcePath);
        RealCalculator calculator = new RealCalculator();
        parser.addParseListener(calculator);
        parser.program();
        
        List<String> errors = calculator.getErrors();
        if(errors.size()>0){
            throw new Exception(errors.toString());
        }else{
            return calculator.getResult();
        }
        
    }

    public CalculatorParser setupParser(String programPath) throws IOException {
        // Reading the DSL script
        InputStream is = ClassLoader.getSystemResourceAsStream(programPath);

        return setupParser(is);
    }

    public CalculatorParser setupParser(InputStream is) throws IOException {

        // Loading the DSL script into the ANTLR stream.
        CharStream cs = new ANTLRInputStream(is);

        // Passing the input to the lexer to create tokens
        CalculatorLexer lexer = new CalculatorLexer(cs);

        CommonTokenStream tokens = new CommonTokenStream(lexer);

        // Passing the tokens to the parser to create the parse trea.
        CalculatorParser parser = new CalculatorParser(tokens);
        return parser;
    }
}
