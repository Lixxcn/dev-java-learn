package factory.after;

public abstract class Creator {
    public abstract <T extends PasserBy> T createPasserBy(Class<T> c);
}
