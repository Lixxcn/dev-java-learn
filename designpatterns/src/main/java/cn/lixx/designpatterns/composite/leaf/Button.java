package cn.lixx.designpatterns.composite.leaf;

import cn.lixx.designpatterns.composite.Component;

/**
 * 按钮类（叶子构件）
 * 最基本的单元控件，不能包含其他控件
 */
public class Button extends Component {
    private String text;  // 按钮文字
    private String width;  // 按钮宽度
    private String height; // 按钮高度

    public Button(String name) {
        super(name);
        this.text = "按钮";
        this.width = "100";
        this.height = "30";
    }

    public Button(String name, String text) {
        super(name);
        this.text = text;
        this.width = "100";
        this.height = "30";
    }

    public Button(String name, String text, String width, String height) {
        super(name);
        this.text = text;
        this.width = width;
        this.height = height;
    }

    @Override
    public void display() {
        System.out.println("┌─ " + name + " (按钮) ─────────────────┐");
        System.out.println("│ 文字: " + text);
        System.out.println("│ 尺寸: " + width + " × " + height);
        System.out.println("│ 类型: 单元控件");
        System.out.println("└────────────────────────────────────┘");
    }

    /**
     * 点击按钮
     */
    public void click() {
        System.out.println("按钮 [" + name + "] 被点击了！");
    }

    // Getter和Setter方法
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getWidth() {
        return width;
    }

    public void setWidth(String width) {
        this.width = width;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }
}