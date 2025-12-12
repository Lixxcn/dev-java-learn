package factory.after;

public class ConcreteCreator extends Creator{
    public <T extends PasserBy> T createPasserBy(Class<T> c){
        PasserBy passerBy=null;
        try {
            passerBy=(T)Class.forName(c.getName()).newInstance();
        }catch (Exception e)
        {
            System.out.println(e.getMessage());
        }

        return (T)passerBy;
    }

}
