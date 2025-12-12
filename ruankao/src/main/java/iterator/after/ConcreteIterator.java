package iterator.after;

import java.util.ArrayList;
import java.util.PrimitiveIterator;

public class ConcreteIterator implements Iterator{
    private Integer position=0;
    private ArrayList<Object> valueList=null;
    public ConcreteIterator(ArrayList<Object> _valueList)
    {
        this.valueList=_valueList;
    }

    public Object first()
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
