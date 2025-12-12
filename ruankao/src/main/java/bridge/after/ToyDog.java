package bridge.after;

public class ToyDog extends Toy{

    public ToyDog(ToyColor _toyColor) {
        super(_toyColor);
    }

    @Override
    public void setShape() {
        System.out.println("使用狗形模具");
    }
}
