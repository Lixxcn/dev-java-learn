package mediator.before;

public class YuNi extends Indicator{
    @Override
    public Boolean isHunZhuo(Indicator indicator) {
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
}
