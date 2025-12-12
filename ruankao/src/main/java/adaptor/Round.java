package adaptor;

public class Round implements IRound{
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

    private Float redius=0f;
    public void setRedius(Float _redius)
    {
        this.redius=_redius;
    }
    public Float getRedius()
    {
        return this.redius;
    }

    public void draw(Float _x,Float _y,Float _redius)
    {
        this.x=_x;
        this.y=_y;
        this.redius=_redius;
        //……
    }




}
