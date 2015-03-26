package com.talentica.dsl;

import com.talentica.dsl.antlr.CalculatorBaseListener;
import com.talentica.dsl.antlr.CalculatorParser;
import com.talentica.dsl.ast.*;
import org.antlr.v4.runtime.misc.NotNull;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.tree.ClassNode;
import org.objectweb.asm.tree.InsnList;
import org.objectweb.asm.tree.InsnNode;
import org.objectweb.asm.tree.MethodNode;
import org.objectweb.asm.util.CheckClassAdapter;
import org.objectweb.asm.util.TraceClassVisitor;

import java.io.*;
import java.net.URL;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Created by debasishc on 26/3/15.
 */
public class RealCompiler extends CalculatorBaseListener {

    private HashMap<String, Integer> variables = new HashMap<>();
    private LinkedList<AssignmentExpression> assignmentExpressions = new LinkedList<>();
    private int nextVarNumber = 0;
    private Stack<Expression> operandStack = new Stack<>();
    private InsnList insnList;
    private LinkedList<String> errors = new LinkedList<>();
    private String className;
    private ClassNode classNode=null;
    private MethodNode methodNode=null;

    public String getClassName() {
        return className;
    }

    public RealCompiler(String className) {

        ClassNode classNode = new ClassNode();
        className = className.replaceAll("\\.", "/");
        this.className = className;
        // These properties of the classNode must be set
        classNode.version = Opcodes.V1_7;// The generated class will only run on
        // JRE 1.6 or above
        classNode.access = Opcodes.ACC_PUBLIC;
        classNode.signature = "L" + className + ";";
        classNode.name = className;
        classNode.superName = "java/lang/Object";

        this.classNode = classNode;

        MethodNode method = new MethodNode(
                Opcodes.ACC_PUBLIC | Opcodes.ACC_STATIC | Opcodes.ACC_FINAL,
                "calc",
                "()D",
                null, null);
        this.insnList = method.instructions;
        this.methodNode = method;

    }

    public List<String> getErrors(){
        return errors;
    }

    @Override
    public void exitMultOrDiv(@NotNull CalculatorParser.MultOrDivContext ctx) {
        String operand = ctx.getChild(1).getText();
        Expression operand2 = operandStack.pop();
        Expression operand1 = operandStack.pop();
        operandStack.push(new OperationExpression(operand1, operand2,operand));

    }

    @Override
    public void exitIdExpression(@NotNull CalculatorParser.IdExpressionContext ctx) {
        String name = ctx.ID().getText();
        Integer pos = variables.get(name);
        if (pos == null) {
            errors.add("Undefined Alias "+name + "at "+ctx.getStart().getLine());
            operandStack.push(new VoidExpression());
        }else{
            operandStack.push(new VarExpression(pos));
        }
    }

    @Override
    public void exitDoubleExpression(@NotNull CalculatorParser.DoubleExpressionContext ctx) {
        double value = Double.parseDouble(ctx.getText());
        operandStack.push(new LiteralExpression(value));
    }



    @Override
    public void exitAddOrSubtract(@NotNull CalculatorParser.AddOrSubtractContext ctx) {
        String operand = ctx.getChild(1).getText();
        Expression operand2 = operandStack.pop();
        Expression operand1 = operandStack.pop();
        operandStack.push(new OperationExpression(operand1, operand2,operand));
    }

    @Override
    public void exitStatement(@NotNull CalculatorParser.StatementContext ctx) {
        String name = ctx.ID().getText();
        if(variables.containsKey(name)){
            assignmentExpressions.add(
                    new AssignmentExpression(variables.get(name), operandStack.pop()));
        }else {
            variables.put(name, nextVarNumber);
            nextVarNumber+=2;
            assignmentExpressions.add(
                    new AssignmentExpression(variables.get(name), operandStack.pop()));
        }

    }

    @Override
    public void exitProgram(@NotNull CalculatorParser.ProgramContext ctx) {
        compile();
    }

    public void compile(){
        for(AssignmentExpression assignmentExpression:assignmentExpressions){
            assignmentExpression.generateCode(insnList);
        }
        operandStack.pop().generateCode(insnList);
        insnList.add(new InsnNode(Opcodes.DRETURN));
        dumpClass();
    }

    public void dumpClass(){
        URL basePath = RealCompiler.class.getClassLoader().getResource("");
        File baseFile = new File(basePath.getFile());
        File classFile = new File(baseFile,className+".class");
        File classLocation = classFile.getParentFile();
        classLocation.mkdirs();
        classNode.methods.add(methodNode);
        ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_MAXS
                | ClassWriter.COMPUTE_FRAMES);
        classNode.accept(cw);



        try {
            DataOutputStream dout = new DataOutputStream(new FileOutputStream(classFile));
            dout.write(cw.toByteArray());
            dout.flush();
            printCode(cw);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            CheckClassAdapter.main(new String[]{classFile.getCanonicalPath()});
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    @SuppressWarnings("unused")
    private void printCode(ClassWriter cw) {
        ClassReader cr = new ClassReader(cw.toByteArray());
        TraceClassVisitor traceClassVisitor = new TraceClassVisitor(
                new PrintWriter(System.out));
        cr.accept(traceClassVisitor, 0);
    }

}
