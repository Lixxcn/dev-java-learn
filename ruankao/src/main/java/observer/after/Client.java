package observer.after;

public class Client {
    static void main(String[] args) {
        Rat rat1 = new Rat();
        Rat rat2 = new Rat();
        Master master = new Master();

        Cat cat = new Cat();
        cat.add(rat1);
        cat.add(rat2);
        cat.add(master);

        cat.cry();
    }

}
