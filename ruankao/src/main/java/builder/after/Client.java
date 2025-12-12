package builder.after;

public class Client {
    static void main(String[] args) {
        Rule rule = new Rule.Builder(2).SetOwnerName("张三").SetPlate("甲A0001").SetDeadLine(35).Build();
        float cost = rule.CalculateCost();
    }
}
