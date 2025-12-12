package iterator.before;

public class Client {
    static void main(String[] args) {
        RealTimeA realTimeA = new RealTimeA();
        Boolean state = realTimeA.next();
        Float value = realTimeA.first();
    }

}
