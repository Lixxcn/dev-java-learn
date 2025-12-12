package iterator.before;

import java.util.ArrayList;

public class RealTimeA {
    private ArrayList<Float> valueList=new ArrayList<Float>();
    private Integer position=0;

    public RealTimeA()
    {
        valueList.add(0.33f);
        valueList.add(0.99f);
    }

    public Float first()
    {
        return this.valueList.get(0);
    }

    public Boolean next()
    {
        Integer index=this.valueList.size()-1;
        position+=1;
        if(position>index)
        {
            return false;
        }
        else
        {
            return true;
        }
    }

    //……

}
