package flyweight;

import java.util.HashMap;

public class FlyweightFactory {
    private static final HashMap<Integer,ConcreteFlyweight> flyweightFactory=new HashMap<>();

    public static void createFlyweightFactory()
    {
        ConcreteFlyweight flyweight1=new ConcreteFlyweight();
        flyweight1.setAlarmName(AsistClass.AlarmName.水泵报警.toString());
        flyweight1.setAlarmType(AsistClass.AlarmType.水泵故障.toString());
        flyweight1.setAlarmDesc(AsistClass.ALarmDesc.desc1.toString());
        flyweightFactory.put(0,flyweight1);

        ConcreteFlyweight flyweight2=new ConcreteFlyweight();
        flyweight2.setAlarmName(AsistClass.AlarmName.气泵报警.toString());
        flyweight2.setAlarmType(AsistClass.AlarmType.气泵漏气.toString());
        flyweight2.setAlarmDesc(AsistClass.ALarmDesc.desc2.toString());
        flyweightFactory.put(1,flyweight2);

        //……

    }

    public static ConcreteFlyweight getFlyweight(Integer index)
    {
        if(flyweightFactory.containsKey(index))
        {
            return flyweightFactory.get(index);
        }
        else
        {
            return null;
        }
    }
}
