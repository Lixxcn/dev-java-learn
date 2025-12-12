package abstractfactory;

public class NvWa {
    static void main(String[] args) {
        MaleFactory males = new MaleFactory();
        Loesser loesser = males.createLoesser();
        Corder corder = males.createCorder();

    }

}
