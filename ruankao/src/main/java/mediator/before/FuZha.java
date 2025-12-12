package mediator.before;

public class FuZha extends Indicator{
    @Override
    public Boolean isHunZhuo(Indicator indicator) {
        String name=indicator.getClass().getName();
        if(name.equals("淤泥"))
        {
            System.out.println("调用浮渣-淤泥的判断规则");
            return true;
        }else if(name.equals("污染物"))
        {
            System.out.println("调用浮渣-污染物的判断规则");
            return true;
        }
        return false;
    }
}
