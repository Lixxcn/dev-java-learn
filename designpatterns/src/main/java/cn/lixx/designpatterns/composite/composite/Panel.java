package cn.lixx.designpatterns.composite.composite;

import cn.lixx.designpatterns.composite.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * 面板类（容器构件）
 * 可以包含其他控件的面板容器
 */
public class Panel extends Component {
    // 存储子控件的列表
    private List<Component> children = new ArrayList<>();
    private String layout;     // 布局方式
    private String backgroundColor; // 背景颜色

    public Panel(String name) {
        super(name);
        this.layout = "Flow";
        this.backgroundColor = "#FFFFFF";
    }

    public Panel(String name, String layout) {
        super(name);
        this.layout = layout;
        this.backgroundColor = "#FFFFFF";
    }

    @Override
    public void add(Component component) {
        children.add(component);
        System.out.println("面板 [" + name + "] 添加了控件: " + component.getName());
    }

    @Override
    public void remove(Component component) {
        children.remove(component);
        System.out.println("面板 [" + name + "] 移除了控件: " + component.getName());
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
        System.out.println("╔══ " + name + " (面板) ════════════════════════╗");
        System.out.println("║ 布局方式: " + layout);
        System.out.println("║ 背景颜色: " + backgroundColor);
        System.out.println("║ 子控件数量: " + children.size());
        System.out.println("║ 类型: 容器控件");
        System.out.println("╠══════════════════════════════════════════════╣");

        // 递归显示所有子控件
        for (Component child : children) {
            child.display();
        }

        System.out.println("╚══════════════════════════════════════════════╝");
    }

    /**
     * 清空所有子控件
     */
    public void clear() {
        children.clear();
        System.out.println("面板 [" + name + "] 已清空所有子控件");
    }

    /**
     * 获取子控件数量
     * @return 子控件数量
     */
    public int getChildCount() {
        return children.size();
    }

    // Getter和Setter方法
    public String getLayout() {
        return layout;
    }

    public void setLayout(String layout) {
        this.layout = layout;
    }

    public String getBackgroundColor() {
        return backgroundColor;
    }

    public void setBackgroundColor(String backgroundColor) {
        this.backgroundColor = backgroundColor;
    }
}