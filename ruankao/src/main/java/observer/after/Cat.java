package observer.after;

import observer.before.Master;
import observer.before.Rat;

import java.util.ArrayList;

public class Cat {
    private ArrayList<IListener> linteners=new ArrayList<IListener>();

    public void add(IListener listener)
    {
        this.linteners.add(listener);
    }

    public void remove(Integer index)
    {
        this.linteners.remove(index);
    }

    public void cry()
    {
        for(int i=0;i<this.linteners.size();i++)
        {
            this.linteners.get(i).response();
        }
    }
}
