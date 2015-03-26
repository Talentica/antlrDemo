package com.talentica.dsl.ast;

import org.objectweb.asm.Opcodes;
import org.objectweb.asm.tree.InsnList;
import org.objectweb.asm.tree.VarInsnNode;

/**
 * Created by debasishc on 26/3/15.
 */
public class AssignmentExpression extends Expression{
    private int position;
    private Expression expression;
    public AssignmentExpression(int position, Expression expression){
        this.position = position;
        this.expression = expression;
    }
    @Override
    public void generateCode(InsnList insnList) {
        expression.generateCode(insnList);
        insnList.add(new VarInsnNode(Opcodes.DSTORE,position));
    }
}
