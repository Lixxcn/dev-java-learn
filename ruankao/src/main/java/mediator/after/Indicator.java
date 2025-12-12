package mediator.after;

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

    protected Mediator mediator=null;

    public Indicator(Mediator _mediator)
    {
        this.mediator=_mediator;
    }

    public abstract Boolean isHunZhuo(Indicator _indicator);
}
