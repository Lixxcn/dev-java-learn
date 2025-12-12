package memento;

import java.util.Dictionary;
import java.util.Hashtable;

public class Caretaker {
    private Dictionary<Integer,Memento> mementos=new Hashtable<>();

    public void addMemento(Integer index,Memento _memento)
    {
        this.mementos.put(index,_memento);
    }

    public Memento getMemento(Integer index)
    {
        return this.mementos.get(index);
    }

}
