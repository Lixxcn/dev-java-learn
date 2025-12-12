package template;

public abstract class PasserBy {
    public boolean meet(LuoFu luoFU)
    {
        if(luoFU.getIsCaiSang())
        {
            return true;
        }

        return false;
    }

    public abstract void act();

    public void response(LuoFu luoFu)
    {
        if(this.meet(luoFu))
        {
            this.act();
        }
    }

}
