package cn.lixx.designpatterns.builder.component;

/**
 * 主窗口组件
 */
public class MainWindow {
    private String title;     // 窗口标题
    private int width;        // 窗口宽度
    private int height;       // 窗口高度

    public MainWindow(String title, int width, int height) {
        this.title = title;
        this.width = width;
        this.height = height;
    }

    public void display() {
        System.out.println("  🖥️  " + title);
        System.out.println("     尺寸: " + width + "x" + height);
        System.out.println("     ┌─────────────────────────┐");
        System.out.println("     │    视频播放区域         │");
        System.out.println("     │                         │");
        System.out.println("     │     [正在播放...]       │");
        System.out.println("     │                         │");
        System.out.println("     └─────────────────────────┘");
    }

    @Override
    public String toString() {
        return title + "(" + width + "x" + height + ")";
    }
}