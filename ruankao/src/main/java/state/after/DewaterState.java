package state.after;

public class DewaterState extends State{

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
        System.out.println("给我加水");

        TriBody triBody=new TriBody();
        this.triBody.stateChange(triBody.getCommonState());
    }
}
