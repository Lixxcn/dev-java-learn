package cn.lixx.designpatterns.interpreter;

/**
 * Concrete NonTerminalExpression: Subtraction
 */
public class SubNode extends SymbolNode {
    public SubNode(Node left, Node right) {
        super(left, right);
    }

    @Override
    public int interpret(Context context) {
        return super.left.interpret(context) - super.right.interpret(context);
    }
}
