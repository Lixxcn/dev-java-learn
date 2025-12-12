package mediator.after;

public class Client {
    static void main(String[] args) {
        Mediator mediator = new Mediator();
        YuNi yuNi = new YuNi(mediator);
        mediator.setYuNi(yuNi);

        FuZha fuZha = new FuZha(mediator);
        mediator.setFuZha(fuZha);

        WuRanWu wuRanWu = new WuRanWu(mediator);
        mediator.setWuRanWu(wuRanWu);

        yuNi.setIsOverrun(true);

        yuNi.isHunZhuo(fuZha);

    }

}
