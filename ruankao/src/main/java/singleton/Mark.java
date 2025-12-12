package singleton;

public class Mark implements Planet{
    public void rotate()
    {
        Sun sun=Sun.getInstance();
        sun.active();
    }
}
