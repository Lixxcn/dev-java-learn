package mediator.after;

public class FuZha extends Indicator {

    public FuZha(Mediator _mediator) {
        super(_mediator);
    }

    @Override
    public Boolean isHunZhuo(Indicator _indicator) {
        return this.mediator.isHunZhuoByFuZha(_indicator);
    }
}
