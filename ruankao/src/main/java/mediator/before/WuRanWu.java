package mediator.before;

public class WuRanWu extends Indicator{

    @Override
    public Boolean isHunZhuo(Indicator indicator) {
        String name=indicator.getClass().getName();
        if(name.equals("淤泥"))
        {
            System.out.println("调用污染物-淤泥的判断规则");
            return true;
        }else if(name.equals("浮渣"))
        {
            System.out.println("调用污染物-浮渣的判断规则");
            return true;
        }
        return false;
    }
}
