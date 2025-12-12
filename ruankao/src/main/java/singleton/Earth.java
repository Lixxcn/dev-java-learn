package singleton;

public class Earth implements Planet{
    public void rotate()
    {
        Sun sun=Sun.getInstance();
        sun.active();
    }
}
