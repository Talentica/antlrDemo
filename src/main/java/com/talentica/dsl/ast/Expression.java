package com.talentica.dsl.ast;

import org.objectweb.asm.tree.InsnList;

/**
 * Created by debasishc on 26/3/15.
 */
public abstract class Expression {
    public abstract void generateCode(InsnList insnList);
}
