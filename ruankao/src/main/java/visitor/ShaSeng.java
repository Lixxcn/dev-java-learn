package visitor;

public class ShaSeng extends Buddist{
    public ShaSeng()
    {
        this.name="沙悟净";
    }

    @Override
    public void accept(Test test) {
        test.doTest(this);
    }
}
