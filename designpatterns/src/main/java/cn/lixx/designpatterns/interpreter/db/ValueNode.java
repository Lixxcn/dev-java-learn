package cn.lixx.designpatterns.interpreter.db;

/**
 * 终结符表达式：ValueNode
 * 持有简单的字符串值（如动作、类型、数据库名、表名等）。
 */
public class ValueNode implements AbstractNode {
    private String value;

    public ValueNode(String value) {
        this.value = value;
    }

    @Override
    public String interpret(DBContext context) {
        return this.value;
    }
}