package decorator.after;

public abstract class Human {
    protected abstract void listeningRain();
    protected abstract void feeling();

    public final void action()
    {
        listeningRain();
        feeling();
    }
}
