package composite;

public abstract class Component {
    private String name="";
    public String getName()
    {
        return this.name;
    }
    public void setName(String _name)
    {
        this.name=_name;
    }

    public void operation()
    {
        System.out.println("本建筑是："+this.name);
    }

}
