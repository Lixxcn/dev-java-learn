package memento;

public class Memento {
    private String state="";
    public String getState()
    {
        return this.state;
    }
    public void setState(String _state)
    {
        this.state=_state;
    }

    public Memento(String _state)
    {
        this.state=_state;
    }
}
