package cn.lixx.designpatterns.interpreter;

/**
 * TerminalExpression (终结符表达式)
 * Represents a variable in the expression (e.g., 'a', 'b').
 */
public class ValueNode implements Node {
    private String key;

    public ValueNode(String key) {
        this.key = key;
    }

    @Override
    public int interpret(Context context) {
        return context.getValue(this.key);
    }
}
