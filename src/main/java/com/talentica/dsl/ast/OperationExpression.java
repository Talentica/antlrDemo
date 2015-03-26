package com.talentica.dsl.ast;

import org.objectweb.asm.Opcodes;
import org.objectweb.asm.tree.InsnList;
import org.objectweb.asm.tree.InsnNode;

/**
 * Created by debasishc on 26/3/15.
 */
public class OperationExpression extends Expression{
    private Expression left;
    private Expression right;
    private String operation;

    public OperationExpression(Expression left, Expression right, String operation) {
        this.left = left;
        this.right = right;
        this.operation = operation;
    }

    @Override
    public void generateCode(InsnList insnList) {
        left.generateCode(insnList);
        right.generateCode(insnList);
        switch (operation){
            case "+": insnList.add(new InsnNode(Opcodes.DADD)); break;
            case "-": insnList.add(new InsnNode(Opcodes.DSUB)); break;
            case "*": insnList.add(new InsnNode(Opcodes.DMUL)); break;
            case "/": insnList.add(new InsnNode(Opcodes.DDIV)); break;
        }
    }
}
