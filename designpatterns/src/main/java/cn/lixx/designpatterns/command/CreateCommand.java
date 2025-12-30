package cn.lixx.designpatterns.command;

/**
 * Concrete Command: Create
 */
public class CreateCommand extends Command {
    private BoardScreen boardScreen;

    public CreateCommand(BoardScreen boardScreen) {
        this.boardScreen = boardScreen;
    }

    @Override
    public void execute() {
        this.boardScreen.create();
    }
}
