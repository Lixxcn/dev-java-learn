package bridge.before;

public abstract class ToyCat extends Toy{
    @Override
    public void setShape() {
        System.out.println("使用猫形模具");
    }
}
