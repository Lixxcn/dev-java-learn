package visitor;

public abstract class Test {
    public abstract void talk();

    public void doTest(TangSeng tangSeng)
    {
        this.talk();
    }

    public void doTest(SunWuKong sunWuKong)
    {
        this.talk();
    }

    public void doTest(ZhuBaJie zhuBaJie)
    {
        this.talk();
    }

    public void doTest(ShaSeng shaSeng)
    {
        this.talk();
    }
}
