package visitor;

public abstract class Buddist {
    protected String name="";
    public String getName()
    {
        return this.name;
    }

    public void response(String _response)
    {
        System.out.println(_response);
    }

    public abstract void accept(Test test);
}
