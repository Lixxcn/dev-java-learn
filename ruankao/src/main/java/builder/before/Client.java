package builder.before;

public class Client {
    static void main(String[] args) {
        Rule rule = new Rule(2, "张三", "甲A0001", null, null, null, null, 35);
        Float cost = rule.CalculateCost();

        rule = new Rule(0, null, "京C2231", true, false, "YY-MM-DD HH:MM:SS", "YY-MM-DD HH:MM:SS", null);
        cost = rule.CalculateCost();
    }
}
