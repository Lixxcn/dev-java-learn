package memento;

public class MaskMan {
    private String state="";
    public String getState()
    {
        return this.state;
    }
    public void setState(String _state)
    {
        this.state=_state;
    }

    public Memento createMemento()
    {
        return new Memento(this.state);
    }

    public void restoreMemento(Memento _memento)
    {
        this.state=_memento.getState();
    }
}
