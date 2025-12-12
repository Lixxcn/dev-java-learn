package factory.after;

public class Client {
    static void main(String[] args) {
        ConcreteCreator creator = new ConcreteCreator();

        LuoFu luoFu = new LuoFu();
        luoFu.setIsCaiSang(true);

        PasserBy passerBy = creator.createPasserBy(Teenager.class);
        passerBy.response(luoFu);

        // PasserBy passerBy=new XingZhe();
        // PasserBy passerBy=new Teenager();
        // passerBy.response(luoFu);

    }

}
