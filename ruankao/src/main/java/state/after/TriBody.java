package state.after;

public class TriBody {
    private State currentState=this.commonState;
    public State getCurrentState()
    {
        return this.currentState;
    }
    public void setCurrentState(State _state)
    {
        this.currentState=_state;
    }

    private CommonState commonState=new CommonState();
    public CommonState getCommonState()
    {
        return this.commonState;
    }

    private DewaterState dewaterState=new DewaterState();
    public DewaterState getDewaterState()
    {
        return this.dewaterState;
    }

    private FrozenState frozenState=new FrozenState();
    public FrozenState getFrozenState()
    {
        return this.frozenState;
    }

    public void stateChange(State _state)
    {
        this.currentState=_state;

        this.currentState.setTriBody(this);
    }

    public void talk()
    {
        this.currentState.talk();
    }

    public void walk()
    {
        this.currentState.walk();
    }

    public void revive()
    {
        this.currentState.revive();
    }


}
