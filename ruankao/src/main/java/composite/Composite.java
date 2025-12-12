package composite;

import java.util.ArrayList;
import java.util.List;

public class Composite extends Component{
    private List<Component> compList=new ArrayList<Component>();

    public void add(Component _component)
    {
        this.compList.add(_component);
    }

    public void remove(Integer index)
    {
        this.compList.remove(index);
    }
}
