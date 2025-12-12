package visitor;

public class SunWuKong extends Buddist{
    public SunWuKong()
    {
        this.name="孙悟空";
    }

    @Override
    public void accept(Test test) {
        test.doTest(this);
    }
}
