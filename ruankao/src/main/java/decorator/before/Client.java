package decorator.before;

public class Client {
    static void main(String[] args) {
        String state = "";
        if (state.equals("忧伤的")) {
            DepressedOldAge depressedOldAge = new DepressedOldAge();
            depressedOldAge.action();

        } else {
            OldAge oldAge = new OldAge();
            oldAge.action();

        }

    }

}
