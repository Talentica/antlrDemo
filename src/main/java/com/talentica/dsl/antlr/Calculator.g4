grammar Calculator;
@header{
package com.talentica.dsl.antlr;
}

// PARSER

program
    : statement* expression;

expression
    : '(' expression ')'                								# parenExpression
    | expression ('*'|'/') expression   								# multOrDiv
    | expression ('+'|'-') expression   								# addOrSubtract
    | ID                                                                # idExpression
    | DOUBLE                                                            # doubleExpression;
    
statement
    : ID '=' expression;
    


// LEXER

ID           : ('_'|'a'..'z'|'A'..'Z')('_'|'a'..'z'|'A'..'Z'|'0'..'9')*;
DOUBLE       : '0'..'9'*[\.]'0'..'9'+|'0'..'9'+([\.]'0'..'9'*)?;
COMMENT      : ('#'.*?[\n]) -> skip;
WS           : [ \t\r\n]+ -> skip;
