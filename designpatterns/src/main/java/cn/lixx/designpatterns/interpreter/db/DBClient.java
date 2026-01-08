package cn.lixx.designpatterns.interpreter.db;

public class DBClient {
    public static void main(String[] args) {
        String cmd1 = "COPY VIEW FROM srcDB TO desDB";
        String cmd2 = "MOVE TABLE Student FROM srcDB TO desDB";

        DBContext context = new DBContext();
        ExpressionParser parser = new ExpressionParser();

        System.out.println("--- Command 1 ---");
        AbstractNode node1 = parser.parse(cmd1);
        node1.interpret(context);

        System.out.println("\n--- Command 2 ---");
        AbstractNode node2 = parser.parse(cmd2);
        node2.interpret(context);
    }
}

