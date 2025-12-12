package visitor;

public class ConcreteTest1 extends Test{

    @Override
    public void talk() {
        System.out.println("有家资万贯，良田千顷。娘女四人，意欲坐山招夫，四位恰好，不知尊意肯否如何?");
    }

    @Override
    public void doTest(TangSeng tangSeng) {
        super.doTest(tangSeng);
        tangSeng.response("推聋妆哑，瞑目宁心，寂然不答");
    }

}
