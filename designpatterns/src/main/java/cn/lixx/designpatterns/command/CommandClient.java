package cn.lixx.designpatterns.command;

public class CommandClient {
    public static void main(String[] args) {
        // 1. Receiver
        BoardScreen screen = new BoardScreen();

        // 2. Commands
        Command openCmd = new OpenCommand(screen);
        Command createCmd = new CreateCommand(screen);
        Command editCmd = new EditCommand(screen);

        // 3. Invokers (Menu Items)
        MenuItem item1 = new MenuItem("Open Board");
        item1.setCommand(openCmd);

        MenuItem item2 = new MenuItem("New Post");
        item2.setCommand(createCmd);

        MenuItem item3 = new MenuItem("Edit Post");
        item3.setCommand(editCmd);

        // 4. Menu
        Menu mainMenu = new Menu();
        mainMenu.addMenuItem(item1);
        mainMenu.addMenuItem(item2);
        mainMenu.addMenuItem(item3);

        // 5. Simulate User Actions
        System.out.println("--- Testing Menu Clicks ---");
        for (MenuItem item : mainMenu.getMenuItems()) {
            item.click();
            System.out.println();
        }
    }
}
