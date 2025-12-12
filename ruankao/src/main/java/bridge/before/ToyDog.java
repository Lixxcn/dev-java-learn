package bridge.before;

public abstract class ToyDog extends Toy{
    @Override
    public void setShape() {
        System.out.println("使用狗形模具");
    }
}
