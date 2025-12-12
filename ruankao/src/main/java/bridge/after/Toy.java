package bridge.after;

public abstract class Toy {
    private ToyColor toyColor=null;

    public Toy(ToyColor _toyColor)
    {
        this.toyColor=_toyColor;
    }

    public void setToyColor()
    {
        this.toyColor.setColor();
    }

    public abstract void setShape();
}
