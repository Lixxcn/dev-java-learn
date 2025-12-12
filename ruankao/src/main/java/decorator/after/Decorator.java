package decorator.after;

public abstract class Decorator extends Human{
    private Human human=null;

    public Decorator(Human _human)
    {
        this.human=_human;
    }

    protected void listeningRain()
    {
        this.human.listeningRain();
    }

    protected void feeling()
    {
        this.human.feeling();
    }
}
