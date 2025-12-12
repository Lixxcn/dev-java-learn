package iterator.after;

import java.util.ArrayList;

public class ConcreteAggregrate implements Aggregrate{
    private ArrayList<Object> valueList=new ArrayList<Object>();

    public void add(Object value)
    {
        this.valueList.add(value);
    }

    public Iterator getIterator()
    {
        return new ConcreteIterator(this.valueList);
    }
}
