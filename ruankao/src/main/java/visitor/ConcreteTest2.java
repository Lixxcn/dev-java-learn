package visitor;

public class ConcreteTest2 extends Test{
    @Override
    public void talk() {
        System.out.println("若肯放开怀抱，长发留头，与舍下做个家长，穿绫着锦，胜强如那瓦钵缁衣，雪鞋云笠。");
    }

    @Override
    public void doTest(TangSeng tangSeng) {
        super.doTest(tangSeng);
        tangSeng.response("坐在上面，好便似雷惊的孩子");
    }

    @Override
    public void doTest(ZhuBaJie zhuBaJie) {
        super.doTest(zhuBaJie);
        zhuBaJie.response("闻得这般富贵，却心痒难挠\n");
    }
}
