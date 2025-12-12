package command;

public abstract class Command {
    protected Receiver receiver=new Receiver();

    public abstract void excute();
}
