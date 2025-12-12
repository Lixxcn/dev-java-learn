package state.before;

public class Client {
    static void main(String[] args) {
        TriBody triBody = new TriBody();
        triBody.setCurrentState(AsistClass.StateType.Dewater.toString());

        triBody.talk();
        triBody.walk();
        triBody.revive();

    }

}
