package cn.lixx.designpatterns.builder.component;

/**
 * 收藏列表组件
 */
public class FavoriteList {
    private String name;   // 收藏列表名称
    private int count;     // 收藏数量

    public FavoriteList(String name, int count) {
        this.name = name;
        this.count = count;
    }

    public void display() {
        System.out.println("  ⭐ " + name + " (" + count + "个收藏)");
        System.out.println("     ├─ ❤️  最喜欢的电影");
        System.out.println("     ├─ ❤️  经典MV");
        System.out.println("     └─ ❤️  学习资料");
    }

    @Override
    public String toString() {
        return name + "(" + count + "个收藏)";
    }
}