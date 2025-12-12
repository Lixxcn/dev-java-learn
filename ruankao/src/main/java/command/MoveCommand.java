package command;

public class MoveCommand extends Command{
    @Override
    public void excute() {
        this.receiver.move();
    }
}
