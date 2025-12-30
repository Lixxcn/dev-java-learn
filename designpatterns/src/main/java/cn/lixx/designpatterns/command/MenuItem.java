package cn.lixx.designpatterns.command;

/**
 * Invoker: MenuItem
 * Asks the command to carry out the request.
 */
public class MenuItem {
    private String name;
    private Command command;

    public MenuItem(String name) {
        this.name = name;
    }

    public void setCommand(Command command) {
        this.command = command;
    }

    public void click() {
        System.out.println("User clicked on menu item: " + this.name);
        if (this.command != null) {
            this.command.execute();
        } else {
            System.out.println("No command assigned to this item.");
        }
    }
}
