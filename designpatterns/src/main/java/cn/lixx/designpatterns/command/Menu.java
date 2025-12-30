package cn.lixx.designpatterns.command;

import java.util.ArrayList;
import java.util.List;

/**
 * Invoker Container: Menu
 * Holds multiple MenuItems.
 */
public class Menu {
    private List<MenuItem> menuItems = new ArrayList<>();

    public void addMenuItem(MenuItem item) {
        this.menuItems.add(item);
    }

    public List<MenuItem> getMenuItems() {
        return menuItems;
    }
}
