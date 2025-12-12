package state.before;

public class TriBody {

    private String currentState="";
    public String getCurrentState()
    {
        return this.currentState;
    }
    public void setCurrentState(String _state)
    {
        this.currentState=_state;
    }

    public void talk()
    {
        switch (this.currentState)
        {
            case "Common":
                System.out.println("三体人现在可以说话啦");
                break;
            case "Dewater":
                break;
            case "Frozen":
                break;
        }
    }

    public void walk()
    {
        switch (this.currentState)
        {
            case "Common":
                System.out.println("三体人现在可以走路啦");
                break;
            case "Dewater":
                break;
            case "Frozen":
                break;
        }
    }

    public void revive()
    {
        switch (this.currentState)
        {
            case "Common":
                break;
            case "Dewater":
                System.out.println("我开始补水啦");
                this.currentState=AsistClass.StateType.Common.toString();
                break;
            case "Frozen":
                System.out.println("我开始解冻啦");
                this.currentState=AsistClass.StateType.Common.toString();
                break;
        }
    }
}
