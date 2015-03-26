package com.talentica.dsl.ast;

import org.objectweb.asm.Opcodes;
import org.objectweb.asm.tree.InsnList;
import org.objectweb.asm.tree.VarInsnNode;

/**
 * Created by debasishc on 26/3/15.
 */
public class VarExpression extends Expression{
    int position;
    public VarExpression(int position){
        this.position = position;
    }

    @Override
    public void generateCode(InsnList insnList) {
        insnList.add(new VarInsnNode(Opcodes.DLOAD, position));
    }
}
