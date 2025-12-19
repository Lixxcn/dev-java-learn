package cn.lixx.designpatterns.builder.component;

/**
 * 菜单组件
 */
public class Menu {
    private String type;  // 菜单类型

    public Menu(String type) {
        this.type = type;
    }

    public void display() {
        System.out.println("  📋 显示" + type + "菜单");
        System.out.println("     ├─ 文件");
        System.out.println("     ├─ 编辑");
        System.out.println("     ├─ 播放");
        System.out.println("     ├─ 视图");
        System.out.println("     └─ 帮助");
    }

    @Override
    public String toString() {
        return type + "菜单";
    }
}