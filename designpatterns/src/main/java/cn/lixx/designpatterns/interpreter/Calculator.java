package cn.lixx.designpatterns.interpreter;

import java.util.Stack;

/**
 * Calculator
 * Helper class to parse the expression string and build the Abstract Syntax Tree (AST).
 * Not strictly part of the pattern, but essential for usage.
 */
public class Calculator {
    private Node expression;

    public void build(String expressionStr) {
        Node left = null;
        Node right = null;
        Stack<Node> stack = new Stack<>();

        String[] charArray = expressionStr.split(" ");

        for (int i = 0; i < charArray.length; i++) {
            switch (charArray[i]) {
                case "+":
                    // Pop left operand, next token is right operand
                    left = stack.pop();
                    right = new ValueNode(charArray[++i]);
                    stack.push(new AddNode(left, right));
                    break;
                case "-":
                    left = stack.pop();
                    right = new ValueNode(charArray[++i]);
                    stack.push(new SubNode(left, right));
                    break;
                default:
                    // It's a variable
                    stack.push(new ValueNode(charArray[i]));
                    break;
            }
        }
        this.expression = stack.pop();
    }

    public int compute(Context context) {
        return this.expression.interpret(context);
    }
}
