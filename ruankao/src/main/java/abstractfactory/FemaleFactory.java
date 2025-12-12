package abstractfactory;

public class FemaleFactory extends AbstractFactory{
    public Loesser createLoesser()
    {
        return new FemaleLoesser();
    }

    public Corder createCorder()
    {
        return new FemaleCorder();
    }

}
