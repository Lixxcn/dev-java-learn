package mediator.after;

public class Mediator {
    private YuNi yuNi=null;
    public YuNi getYuNi()
    {
        return this.yuNi;
    }
    public void setYuNi(YuNi _yuNi)
    {
        this.yuNi=_yuNi;
    }

    private FuZha fuZha=null;
    public FuZha getFuZha()
    {
        return this.fuZha;
    }
    public void setFuZha(FuZha _fuZha)
    {
        this.fuZha=_fuZha;
    }

    private WuRanWu wuRanWu=null;
    public WuRanWu getWuRanWu()
    {
        return this.wuRanWu;
    }
    public void setWuRanWu(WuRanWu _wuRanWu)
    {
        this.wuRanWu=_wuRanWu;
    }

    public Boolean isHunZhuoByYuNI(Indicator indicator) {
        String name=indicator.getClass().getName();
        if(name.equals("浮渣"))
        {
            System.out.println("调用淤泥-浮渣的判断规则");
            return true;
        }else if(name.equals("污染物"))
        {
            System.out.println("调用淤泥-污染物的判断规则");
            return true;
        }
        return false;
    }

    public Boolean isHunZhuoByFuZha(Indicator indicator) {
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

    public Boolean isHunZhuoByWuRanWu(Indicator indicator) {
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
