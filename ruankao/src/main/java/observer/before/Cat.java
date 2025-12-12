package observer.before;

public class Cat {
    public void cry()
    {
        Rat rat1=new Rat();
        rat1.response();
        Rat rat2=new Rat();
        rat2.response();

        Master master=new Master();
        master.response();
    }


}
