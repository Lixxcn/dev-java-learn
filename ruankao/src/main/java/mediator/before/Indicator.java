package mediator.before;

public abstract class Indicator {
    protected Boolean isOverrun=false;
    public Boolean getIsOverrun()
    {
        return this.isOverrun;
    }
    public void setIsOverrun(Boolean _isOverrun)
    {
        this.isOverrun=_isOverrun;
    }

    public abstract Boolean isHunZhuo(Indicator indicator);
}
