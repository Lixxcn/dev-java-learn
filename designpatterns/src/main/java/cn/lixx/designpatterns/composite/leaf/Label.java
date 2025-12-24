package cn.lixx.designpatterns.composite.leaf;

import cn.lixx.designpatterns.composite.Component;

/**
 * 标签类（叶子构件）
 * 用于显示文本信息的单元控件
 */
public class Label extends Component {
    private String text;      // 显示文本
    private String fontSize;  // 字体大小
    private boolean isBold;   // 是否加粗

    public Label(String name) {
        super(name);
        this.text = "标签";
        this.fontSize = "12";
        this.isBold = false;
    }

    public Label(String name, String text) {
        super(name);
        this.text = text;
        this.fontSize = "12";
        this.isBold = false;
    }

    public Label(String name, String text, String fontSize, boolean isBold) {
        super(name);
        this.text = text;
        this.fontSize = fontSize;
        this.isBold = isBold;
    }

    @Override
    public void display() {
        System.out.println("┌─ " + name + " (标签) ─────────────────┐");
        System.out.println("│ 文本: " + text);
        System.out.println("│ 字体大小: " + fontSize);
        System.out.println("│ 加粗: " + (isBold ? "是" : "否"));
        System.out.println("│ 类型: 单元控件");
        System.out.println("└────────────────────────────────────┘");
    }

    /**
     * 设置标签文本
     * @param text 文本
     */
    public void setText(String text) {
        this.text = text;
    }

    /**
     * 获取标签文本
     * @return 文本内容
     */
    public String getText() {
        return text;
    }

    // Getter和Setter方法
    public String getFontSize() {
        return fontSize;
    }

    public void setFontSize(String fontSize) {
        this.fontSize = fontSize;
    }

    public boolean isBold() {
        return isBold;
    }

    public void setBold(boolean bold) {
        isBold = bold;
    }
}