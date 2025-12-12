package visitor;

public class ConcreteTest3 extends Test{
    @Override
    public void talk() {
        System.out.println("这泼和尚无礼！我若不看你东土远来，就该叱出。");
    }

    @Override
    public void doTest(TangSeng tangSeng) {
        super.doTest(tangSeng);
        tangSeng.response("者者谦谦");
    }

    @Override
    public void doTest(SunWuKong sunWuKong) {
        super.doTest(sunWuKong);
        sunWuKong.response("我从小儿不晓得干那般事");
    }

    @Override
    public void doTest(ShaSeng shaSeng) {
        super.doTest(shaSeng);
        shaSeng.response("宁死也要往西天去，决不干此欺心之事");
    }

    @Override
    public void doTest(ZhuBaJie zhuBaJie) {
        super.doTest(zhuBaJie);
        zhuBaJie.response("大家从长计较");
    }
}
