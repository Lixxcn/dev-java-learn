package factory.before;

public class Teenager implements PasserBy{
    public void response(LuoFu luoFu)
    {
        if(luoFu.getIsCaiSang())
        {
            System.out.println("脱帽著帩头");
        }
    }
}
