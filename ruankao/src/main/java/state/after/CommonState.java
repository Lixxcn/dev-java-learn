package state.after;

public class CommonState extends State{

    @Override
    public void talk() {
        System.out.println("三体人可以说话");
    }

    @Override
    public void walk() {
        System.out.println("三体人可以走路");
    }

    @Override
    public void revive() {
        return;
    }
}
