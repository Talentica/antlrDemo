package com.talentica.dsl;

import org.antlr.v4.Tool;
import org.antlr.v4.tool.ErrorType;

import java.io.IOException;

/**
 * Run this file as a java program to generate DSL parser source template.
 * You should run it from inside your IDE.
 * or you should run the gradle task generateSources
 *
 * @author debasishc
 */
public class SourceGenerator {

    public static void main(String[] args) {
        runAntlr(new String[]{System.getProperty("user.dir") + "/src/main/java/com/talentica/dsl/antlr/Calculator.g4"});
    }

    public static void runAntlr(String[] args) {
        Tool antlr = new Tool(args);
        if (args.length == 0) {
            antlr.help();
            antlr.exit(0);
        }

        try {
            antlr.processGrammarsOnCommandLine();
        } finally {
            if (antlr.log) {
                try {
                    String logname = antlr.logMgr.save();
                    System.out.println("wrote " + logname);
                } catch (IOException ioe) {
                    antlr.errMgr.toolError(ErrorType.INTERNAL_ERROR, ioe);
                }
            }
        }

        if (antlr.errMgr.getNumErrors() > 0) {
            antlr.exit(1);
        }
    }

}
