package cn.lixx.designpatterns.command;

/**
 * Concrete Command: Open
 */
public class OpenCommand extends Command {
    private BoardScreen boardScreen;

    public OpenCommand(BoardScreen boardScreen) {
        this.boardScreen = boardScreen;
    }

    @Override
    public void execute() {
        this.boardScreen.open();
    }
}
