package factory.before;

public class XingZhe implements PasserBy{
    public void response(LuoFu luoFu)
    {
        if(luoFu.getIsCaiSang())
        {
            System.out.println("下担捋髭须");
        }
    }
}
