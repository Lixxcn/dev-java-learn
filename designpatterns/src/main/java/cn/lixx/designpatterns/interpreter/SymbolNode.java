package cn.lixx.designpatterns.interpreter;

/**
 * NonTerminalExpression (非终结符表达式) - Abstract Base
 * Represents an operation that involves other nodes (children).
 */
public abstract class SymbolNode implements Node {
    protected Node left;
    protected Node right;

    public SymbolNode(Node left, Node right) {
        this.left = left;
        this.right = right;
    }
}
