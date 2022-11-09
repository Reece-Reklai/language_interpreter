package edu.wallawalla.cs.cptr354.visitor;

import java.util.HashMap;
import java.util.LinkedList;
import java.lang.Math;
import java.util.*;

public class ExpressionVisitor implements ExpressionParserVisitor {

	private LinkedList<Object> stack = new LinkedList<Object>();
	private HashMap<Object, Object> symbolTable = new HashMap<Object, Object>();

	public Object visit(SimpleNode node, Object data) {
		node.childrenAccept(this, data);
		return null;
	}

	public Object visit(ASTmanyStateExpr node, Object data) {
		node.childrenAccept(this, data);
		return null;
	}

	public Object visit(ASTstart node, Object data) {
		node.childrenAccept(this, data);
		return symbolTable;
	}


	public Object visit(ASTDebugExpr node, Object data) {
		node.childrenAccept(this, data);
		System.out.println(symbolTable);
		return null;
	}

	public Object visit(ASTPrintExpr node, Object data) {
            node.childrenAccept(this, data);
            Object arg1 = stack.removeFirst();
            System.out.println(arg1);
		    return null;
	}

	public Object visit(ASTAddExpr node, Object data) {
		node.childrenAccept(this, data);
		Double arg1 = pop();
		Double arg2 = pop();
		stack.addFirst(Double.valueOf(arg2.doubleValue() + arg1.doubleValue()));
		return null;
	}
    
    public Object visit(ASTSubtractionExpr node, Object data) {
		node.childrenAccept(this, data);
		Double arg1 = pop();
		Double arg2 = pop();
		stack.addFirst(Double.valueOf(arg2.doubleValue() - arg1.doubleValue()));
		return null;
	}



    public Object visit(ASTMultiplyExpr node, Object data) {
		node.childrenAccept(this, data);
		Double arg1 = pop();
		Double arg2 = pop();
		stack.addFirst(Double.valueOf(arg2.doubleValue() * arg1.doubleValue()));
		return null;
	}

	public Object visit(ASTDivideExpr node, Object data) {
		node.childrenAccept(this, data);
		Double arg1 = pop();
		Double arg2 = pop();
		stack.addFirst(Double.valueOf(arg2.doubleValue() / arg1.doubleValue()));
		return null;
	}

    	public Object visit(ASTSQRTExpr node, Object data) {
		node.childrenAccept(this, data);
        Double arg1 = new Double(pop());
		stack.addFirst(Double.valueOf(Math.sqrt(arg1.doubleValue())));
		return null;
	}

	public Object visit(ASTNegateExpr node, Object data) {
		node.childrenAccept(this, data);
		Double arg1 = pop();
		stack.addFirst(Double.valueOf(arg1.doubleValue() * -1));
		return null;
	}

	public Object visit(ASTNumber node, Object data) {
		node.childrenAccept(this, data);
		stack.addFirst(node.data.get("value"));
		return null;
	}

    public Object visit(ASTlistexpr node, Object data) {
		LinkedList<Double> list = new LinkedList<Double>();
        for(int i = 0; i< node.jjtGetNumChildren(); i++){
            node.jjtGetChild(i).jjtAccept(this, data);
            list.add(pop());
        }
        stack.addFirst(list);
		return null;
	}

	public Object visit(ASTStatement node, Object data) {
		node.childrenAccept(this, data);
		Object value = stack.removeFirst();
		String var = (String) stack.removeFirst();
		symbolTable.put(var, value);
		return null;
	}
    
	public Object visit(ASTListAssignmentStatement node, Object data) {
		node.childrenAccept(this, data);
		Double value = pop();
        Integer index = pop().intValue();
		String var = (String) stack.removeFirst();
		LinkedList<Double> listValue = (LinkedList<Double>) symbolTable.get(var);
		listValue.set(index, value);
		return null;
	}

    public Object visit(ASTifStatement node, Object data) {
        int totalChildren = node.jjtGetNumChildren();
        int counter = 0;
        do{
        node.jjtGetChild(counter).jjtAccept(this,data);
        Double condition = pop();
        counter++;
            if(condition != 0){
                node.jjtGetChild(counter).jjtAccept(this, data);
                break;
            } else {
                counter++;
                if(counter == totalChildren - 1){
                    node.jjtGetChild(counter).jjtAccept(this,data);
                    break;
                }
            }
        }while(counter < totalChildren);
        return symbolTable;
	}

    public Object visit(ASTwhileExpr node, Object data) {
        node.jjtGetChild(0).jjtAccept(this,data);
        Double condition = pop();
        while(condition != 0){
            if(condition != 0){
                node.jjtGetChild(1).jjtAccept(this, data);
            }
        node.jjtGetChild(0).jjtAccept(this,data);
        condition = pop();
        }
        return symbolTable;
	}

	public Object visit(ASTVariable node, Object data) {
		node.childrenAccept(this, data);
		String var = (String) node.data.get("name");
		stack.addFirst(var);
		return null;
	}

	public Object visit(ASTVariableValue node, Object data) {
		node.childrenAccept(this, data);
		String var = (String) stack.removeFirst();
		stack.addFirst(symbolTable.get(var));
		return null;
	}

    	public Object visit(ASTlistVariableValue node, Object data) {
		node.childrenAccept(this, data);
        Integer index = pop().intValue();
		String var = (String) stack.removeFirst();
        LinkedList<Double> value = (LinkedList<Double> ) symbolTable.get(var);
		stack.addFirst(value.get(index));
		return null;
	}

        public Object visit(ASTlengthexpr node, Object data) {
		node.childrenAccept(this, data);
		String var = (String) stack.removeFirst();
        LinkedList<Double> value = (LinkedList<Double> ) symbolTable.get(var);
		stack.addFirst(Double.valueOf(value.size()));
		return null;
	}

    public Object visit(ASTEqualExpr node, Object data) {
        node.childrenAccept(this, data);
        Double arg2 = pop();
		Double arg1 = pop();
        if(arg1.equals(arg2)){
            stack.addFirst(new Double(1));
        } else {
            stack.addFirst(new Double(0));
        }
		return null;
	}

        public Object visit(ASTNotExpr node, Object data) {
		node.childrenAccept(this, data);
		Double arg2 = pop();
		Double arg1 = pop();
        if(arg1.doubleValue() != arg2.doubleValue()){
            stack.addFirst(new Double(1));
        } else {
            stack.addFirst(new Double(0));
        }
		return null;
	}
        public Object visit(ASTGreatExpr node, Object data) {
		node.childrenAccept(this, data);
		Double arg2 = pop();
		Double arg1 = pop();
        if(arg1.doubleValue() > arg2.doubleValue()){
            stack.addFirst(new Double(1));
        } else {
            stack.addFirst(new Double(0));
        }
		return null;
	}
        public Object visit(ASTLessExpr node, Object data) {
		node.childrenAccept(this, data);
		Double arg2 = pop();
		Double arg1 = pop();
        if(arg1.doubleValue() < arg2.doubleValue()){
            stack.addFirst(new Double(1));
        } else {
            stack.addFirst(new Double(0));
        }
		return null;
	}
        public Object visit(ASTGreaterExpr node, Object data) {
		node.childrenAccept(this, data);
		Double arg2 = pop();
		Double arg1 = pop();
        if(arg1.doubleValue() >= arg2.doubleValue()){
            stack.addFirst(new Double(1));
        } else {
            stack.addFirst(new Double(0));
        }
		return null;
	}
        public Object visit(ASTLesserExpr node, Object data) {
		node.childrenAccept(this, data);
		Double arg2 = pop();
		Double arg1 = pop();
        if(arg1 <= arg2){
            stack.addFirst(new Double(1));
        } else {
            stack.addFirst(new Double(0));
        }
		return null;
	}

	private Double pop() {
        return (Double) stack.removeFirst();
	}

}