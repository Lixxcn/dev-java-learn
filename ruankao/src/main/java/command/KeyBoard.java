package command;

import java.util.ArrayList;

public class KeyBoard {
    Invoker invoker=new Invoker();

    public void move()
    {
        //
        invoker.setCommand(new MoveCommand());
        invoker.excute();
    }


}
