package cn.lixx.designpatterns.interpreter.db;

/**
 * 表达式解析器
 * 解析指令字符串并构建抽象语法树 (AST)。
 * 
 * 文法：
 * Expression ::= ACTION + TYPE + [NAME] + 'FROM' + SRC + 'TO' + DES
 * ACTION ::= 'COPY' | 'MOVE'
 * TYPE ::= 'VIEW' | 'TABLE'
 */
public class ExpressionParser {
    
    public AbstractNode parse(String statement) {
        String[] tokens = statement.trim().split("\\s+");
        
        // 基本校验
        if (tokens.length < 6) {
            System.err.println("指令格式不正确。");
            return null;
        }

        AbstractNode action = new ValueNode(tokens[0]);
        AbstractNode type = new ValueNode(tokens[1]);
        
        AbstractNode name = null;
        AbstractNode src = null;
        AbstractNode des = null;
        
        int currentIndex = 2;

        // 检查是否提供了具体的名称（如 'Student'）或者是隐含的（如 'VIEW'）
        // 指令示例: 
        // 1. "COPY VIEW FROM srcDB TO desDB" (长度 6)
        //    tokens: COPY, VIEW, FROM, srcDB, TO, desDB
        // 2. "MOVE TABLE Student FROM srcDB TO desDB" (长度 7)
        //    tokens: MOVE, TABLE, Student, FROM, srcDB, TO, desDB
        
        if (tokens[currentIndex].equalsIgnoreCase("FROM")) {
            // 场景1：未提供具体名称（例如：COPY VIEW FROM ...）。名称为空。
        } else {
            // 场景2：提供了具体名称（例如：MOVE TABLE Student ...）
            name = new ValueNode(tokens[currentIndex]);
            currentIndex++;
        }

        // 跳过关键字 'FROM'
        if (currentIndex < tokens.length && tokens[currentIndex].equalsIgnoreCase("FROM")) {
            currentIndex++;
        }
        
        if (currentIndex < tokens.length) {
            src = new ValueNode(tokens[currentIndex]);
            currentIndex++;
        }

        // 跳过关键字 'TO'
        if (currentIndex < tokens.length && tokens[currentIndex].equalsIgnoreCase("TO")) {
            currentIndex++;
        }

        if (currentIndex < tokens.length) {
            des = new ValueNode(tokens[currentIndex]);
        }

        return new SentenceNode(action, type, name, src, des);
    }
}