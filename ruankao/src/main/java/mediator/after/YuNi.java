package mediator.after;

public class YuNi extends Indicator {

    public YuNi(Mediator _mediator) {
        super(_mediator);
    }

    @Override
    public Boolean isHunZhuo(Indicator _indicator) {
        return mediator.isHunZhuoByWuRanWu(_indicator);
    }
}
