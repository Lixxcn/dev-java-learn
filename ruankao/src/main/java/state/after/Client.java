package state.after;

public class Client {
    static void main(String[] args) {
        TriBody triBody = new TriBody();
        triBody.talk();
        triBody.walk();
        triBody.revive();

        triBody.stateChange(new DewaterState());
        triBody.talk();

    }

}
