package cn.lixx.designpatterns.composite.composite;

import cn.lixx.designpatterns.composite.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * 窗口类（容器构件）
 * 顶层窗口容器，可以包含其他控件
 */
public class Window extends Component {
    // 存储子控件的列表
    private List<Component> children = new ArrayList<>();
    private String title;           // 窗口标题
    private int width;              // 窗口宽度
    private int height;             // 窗口高度
    private boolean isResizable;    // 是否可调整大小
    private boolean isVisible;      // 是否可见

    public Window(String name, String title) {
        super(name);
        this.title = title;
        this.width = 800;
        this.height = 600;
        this.isResizable = true;
        this.isVisible = false;
    }

    public Window(String name, String title, int width, int height) {
        super(name);
        this.title = title;
        this.width = width;
        this.height = height;
        this.isResizable = true;
        this.isVisible = false;
    }

    @Override
    public void add(Component component) {
        children.add(component);
        System.out.println("窗口 [" + name + "] 添加了控件: " + component.getName());
    }

    @Override
    public void remove(Component component) {
        children.remove(component);
        System.out.println("窗口 [" + name + "] 移除了控件: " + component.getName());
    }

    @Override
    public Component getChild(int index) {
        if (index >= 0 && index < children.size()) {
            return children.get(index);
        }
        return null;
    }

    @Override
    public List<Component> getChildren() {
        return children;
    }

    @Override
    public void display() {
        System.out.println("╔══════════════════════════════════════════════════╗");
        System.out.println("║  " + title + " - " + name + " (窗口)");
        System.out.println("╠══════════════════════════════════════════════════╣");
        System.out.println("║  窗口尺寸: " + width + " × " + height);
        System.out.println("║  可调整大小: " + (isResizable ? "是" : "否"));
        System.out.println("║  可见性: " + (isVisible ? "可见" : "隐藏"));
        System.out.println("║  子控件数量: " + children.size());
        System.out.println("║  类型: 容器控件（顶层窗口）");
        System.out.println("╠══════════════════════════════════════════════════╣");

        // 递归显示所有子控件
        for (Component child : children) {
            child.display();
        }

        System.out.println("╚══════════════════════════════════════════════════╝");
    }

    /**
     * 显示窗口
     */
    public void show() {
        this.isVisible = true;
        System.out.println("窗口 [" + name + "] 已显示");
    }

    /**
     * 隐藏窗口
     */
    public void hide() {
        this.isVisible = false;
        System.out.println("窗口 [" + name + "] 已隐藏");
    }

    /**
     * 关闭窗口
     */
    public void close() {
        System.out.println("窗口 [" + name + "] 正在关闭...");
        // 清理资源
        children.clear();
        System.out.println("窗口 [" + name + "] 已关闭");
    }

    /**
     * 获取窗口信息
     * @return 窗口信息字符串
     */
    public String getWindowInfo() {
        return String.format("窗口[名称:%s, 标题:%s, 尺寸:%dx%d]",
            name, title, width, height);
    }

    // Getter和Setter方法
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public boolean isResizable() {
        return isResizable;
    }

    public void setResizable(boolean resizable) {
        isResizable = resizable;
    }

    public boolean isVisible() {
        return isVisible;
    }
}