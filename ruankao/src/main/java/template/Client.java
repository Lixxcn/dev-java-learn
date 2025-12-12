package template;

public class Client {
    static void main(String[] args) {
        LuoFu luoFu = new LuoFu();
        luoFu.setIsCaiSang(true);

        PasserBy passerBy = new XingZhe();
        passerBy.response(luoFu);
    }

}
