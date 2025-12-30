package cn.lixx.designpatterns.interpreter;

/**
 * Concrete NonTerminalExpression: Addition
 */
public class AddNode extends SymbolNode {
    public AddNode(Node left, Node right) {
        super(left, right);
    }

    @Override
    public int interpret(Context context) {
        return super.left.interpret(context) + super.right.interpret(context);
    }
}
