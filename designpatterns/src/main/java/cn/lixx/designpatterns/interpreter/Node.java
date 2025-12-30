package cn.lixx.designpatterns.interpreter;

/**
 * AbstractExpression (抽象表达式)
 * Declares the abstract interpret method common to all nodes in the AST.
 */
public interface Node {
    int interpret(Context context);
}
