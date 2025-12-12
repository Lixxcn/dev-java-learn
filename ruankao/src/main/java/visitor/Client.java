package visitor;

public class Client {
    static void main(String[] args) {
        TangSeng tangSeng = new TangSeng();
        SunWuKong sunWuKong = new SunWuKong();
        ZhuBaJie zhuBaJie = new ZhuBaJie();
        ShaSeng shaSeng = new ShaSeng();

        tangSeng.accept(new ConcreteTest2());
        sunWuKong.accept(new ConcreteTest2());
        zhuBaJie.accept(new ConcreteTest2());
        shaSeng.accept(new ConcreteTest2());
    }

}
