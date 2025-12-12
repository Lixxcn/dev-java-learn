package singleton;

public class Client {

    static void main(String[] args) {
        Earth earth = new Earth();
        earth.rotate();

        Mark mark = new Mark();
        mark.rotate();

    }

}
