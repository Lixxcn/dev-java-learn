package factory.before;

public class Client {
    static void main(String[] args) {
        LuoFu luoFu = new LuoFu();
        luoFu.setIsCaiSang(true);

        // PasserBy passerBy=new XingZhe();
        PasserBy passerBy = new Teenager();
        passerBy.response(luoFu);

    }

}
