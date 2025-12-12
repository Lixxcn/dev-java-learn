package state.after;

public abstract class State {
    protected TriBody triBody=null;
    public TriBody getTriBody()
    {
        return this.triBody;
    }
    public void setTriBody(TriBody _triBody)
    {
        this.triBody=_triBody;
    }

    public abstract void talk();
    public abstract void walk();
    public abstract void revive();
}
