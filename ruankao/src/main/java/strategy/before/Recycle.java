package strategy.before;

public class Recycle {
    static void main(String[] args) {
        Strategy strategy = new ConcreteStrategy2();
        strategy.action();
    }

}
