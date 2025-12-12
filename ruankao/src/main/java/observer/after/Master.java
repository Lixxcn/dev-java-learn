package observer.after;

public class Master implements IListener {
    @Override
    public void response() {
        System.out.println("叫唤个啥？？");
    }
}
