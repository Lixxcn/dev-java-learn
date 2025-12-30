package cn.lixx.designpatterns.command;

/**
 * Concrete Command: Edit
 */
public class EditCommand extends Command {
    private BoardScreen boardScreen;

    public EditCommand(BoardScreen boardScreen) {
        this.boardScreen = boardScreen;
    }

    @Override
    public void execute() {
        this.boardScreen.edit();
    }
}
