package adaptor;

public class Adaptor extends Rectangle implements IRound{

    public void draw(Float _x,Float _y,Float _redius)
    {
        Float x=_x-_redius;
        Float y=_y-_redius;
        Float width=2*_redius;
        Float height=2*_redius;

        draw(x,y,width,height);
    }
}
