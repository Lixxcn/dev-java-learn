package adaptor;

public class Rectangle {
    private Float x=0f;
    public void setX(Float _x)
    {
        this.x=_x;
    }
    public Float getX()
    {
        return this.x;
    }

    private Float y=0f;
    public void setY(Float _y)
    {
        this.y=_y;
    }
    public Float getY()
    {
        return this.y;
    }

    private Float width=0f;
    public void setWidth(Float _width)
    {
        this.width=_width;
    }
    public Float getWidth()
    {
        return this.width;
    }

    private Float height=0f;
    public void setHeight(Float _height)
    {
        this.height=_height;
    }
    public Float getHeight()
    {
        return this.height;
    }

    public void draw(Float _x,Float _y,Float _width,Float _height)
    {
        this.x=_x;
        this.y=_y;
        this.width=_width;
        this.height=_height;
        //……
    }
}
