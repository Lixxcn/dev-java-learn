package cn.lixx.designpatterns.interpreter.db;

/**
 * 非终结符表达式：SentenceNode
 * 代表完整的指令结构：
 * 动作 + 类型 + 名称 + 'FROM' + 源数据库 + 'TO' + 目标数据库
 */
public class SentenceNode implements AbstractNode {
    private AbstractNode action;
    private AbstractNode type;
    private AbstractNode name; // 表名，如果是视图则可能为空（暗示“所有”）
    private AbstractNode srcDB;
    private AbstractNode desDB;

    public SentenceNode(AbstractNode action, AbstractNode type, AbstractNode name, AbstractNode srcDB, AbstractNode desDB) {
        this.action = action;
        this.type = type;
        this.name = name;
        this.srcDB = srcDB;
        this.desDB = desDB;
    }

    @Override
    public String interpret(DBContext context) {
        String actVal = action.interpret(context);
        String typeVal = type.interpret(context);
        String nameVal = (name == null) ? "" : name.interpret(context);
        String srcVal = srcDB.interpret(context);
        String desVal = desDB.interpret(context);

        context.execute(actVal, typeVal, nameVal, srcVal, desVal);
        return "执行完毕: " + actVal + " " + typeVal + " ...";
    }
}