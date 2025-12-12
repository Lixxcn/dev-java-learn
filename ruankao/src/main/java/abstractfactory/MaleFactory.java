package abstractfactory;

public class MaleFactory extends AbstractFactory{

    public Loesser createLoesser()
    {
        return new MaleLoesser();
    }

    public Corder createCorder()
    {
        return new MaleCorder();
    }
}
