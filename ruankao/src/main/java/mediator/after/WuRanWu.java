package mediator.after;

public class WuRanWu extends Indicator {

    public WuRanWu(Mediator _mediator) {
        super(_mediator);
    }

    @Override
    public Boolean isHunZhuo(Indicator _indicator) {
        return this.mediator.isHunZhuoByWuRanWu(_indicator);
    }
}
