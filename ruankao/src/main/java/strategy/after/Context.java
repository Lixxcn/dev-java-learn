package strategy.after;

public class Context {
    private Strategy strategy=null;

    public Context(Strategy _strategy)
    {
        this.strategy=_strategy;
    }

    public void action()
    {
        this.strategy.action();
    }
}
