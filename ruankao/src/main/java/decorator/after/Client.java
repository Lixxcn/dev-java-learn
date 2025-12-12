package decorator.after;

public class Client {
    static void main(String[] args) {
        String state = "";
        Human old = new OldAge();
        if (state.equals("抑郁的")) {
            old = new DepressedFeeling(old);
        } else if (state.equals("乐观的")) {
            old = new AmbitiousFeeling(old);
        }
        old.action();

    }

}
