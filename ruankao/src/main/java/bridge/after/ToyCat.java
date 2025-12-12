package bridge.after;

public class ToyCat extends Toy{

    public ToyCat(ToyColor _toyColor) {
        super(_toyColor);
    }

    @Override
    public void setShape() {
        System.out.println("使用猫形模具");
    }
}
