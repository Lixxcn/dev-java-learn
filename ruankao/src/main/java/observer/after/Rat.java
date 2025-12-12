package observer.after;

public class Rat implements IListener {
    @Override
    public void response() {
        System.out.println("快跑啊");
    }
}
