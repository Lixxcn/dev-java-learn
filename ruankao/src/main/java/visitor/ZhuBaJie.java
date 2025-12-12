package visitor;

public class ZhuBaJie extends Buddist{
    public ZhuBaJie()
    {
        this.name="猪八戒";
    }

    @Override
    public void accept(Test test) {
        test.doTest(this);
    }
}
