package mediator.before;

public class Client {
    static void main(String[] args) {
        YuNi yuNi = new YuNi();
        FuZha fuZha = new FuZha();
        WuRanWu wuRanWu = new WuRanWu();

        yuNi.setIsOverrun(true);
        Boolean flag = yuNi.getIsOverrun();
        if (flag) {
            Boolean flag2 = yuNi.isHunZhuo(fuZha);
            if (flag2) {

            } else {
                flag2 = yuNi.isHunZhuo(wuRanWu);

            }

        }

    }

}
