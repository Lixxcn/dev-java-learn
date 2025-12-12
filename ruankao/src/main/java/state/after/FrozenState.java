package state.after;

public class FrozenState extends State{

    @Override
    public void talk() {
        return;
    }

    @Override
    public void walk() {
        return;
    }

    @Override
    public void revive() {
        System.out.println("开始解冻");

        TriBody triBody=new TriBody();
        this.triBody.stateChange(triBody.getCommonState());
    }
}
