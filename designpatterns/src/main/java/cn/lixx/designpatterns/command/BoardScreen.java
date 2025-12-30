package cn.lixx.designpatterns.command;

/**
 * Receiver: BoardScreen
 * The actual receiver of the requests. It contains the business logic.
 */
public class BoardScreen {
    
    public void open() {
        System.out.println("[BoardScreen] Opening the bulletin board interface...");
    }

    public void create() {
        System.out.println("[BoardScreen] Creating a new bulletin board item...");
    }

    public void edit() {
        System.out.println("[BoardScreen] Editing an existing bulletin board item...");
    }
}
