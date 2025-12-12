package command;

public class Mouse {
    Invoker invoker=new Invoker();
    public void move()
    {
        //
        invoker.setCommand(new MoveCommand());
        invoker.excute();
    }

}
