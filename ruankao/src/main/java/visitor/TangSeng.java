package visitor;

public class TangSeng extends Buddist{

    public TangSeng()
    {
        this.name="唐僧";
    }

    @Override
    public void accept(Test test) {
        test.doTest(this);
    }
}
