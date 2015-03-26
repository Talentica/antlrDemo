package com.talentica.dsl.ast;

import org.objectweb.asm.tree.InsnList;
import org.objectweb.asm.tree.LdcInsnNode;

/**
 * Created by debasishc on 26/3/15.
 */
public class LiteralExpression extends Expression{
    private double value;

    public LiteralExpression(double value) {
        this.value = value;
    }


    @Override
    public void generateCode(InsnList insnList) {
        insnList.add(new LdcInsnNode(value));
    }
}
