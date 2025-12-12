package strategy.after;

public class Recycle {
    static void main(String[] args) {
        Context context = new Context(new ConcreteStrategy3());
        context.action();
    }

}
