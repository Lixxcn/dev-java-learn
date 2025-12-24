package cn.lixx.designpatterns.composite.leaf;

import cn.lixx.designpatterns.composite.Component;

/**
 * 文本框类（叶子构件）
 * 用于输入或显示文本的单元控件
 */
public class TextBox extends Component {
    private String placeholder; // 占位符文本
    private String value;       // 当前值
    private boolean isEditable; // 是否可编辑
    private int maxLength;      // 最大长度

    public TextBox(String name) {
        super(name);
        this.placeholder = "请输入...";
        this.value = "";
        this.isEditable = true;
        this.maxLength = 100;
    }

    public TextBox(String name, String placeholder) {
        super(name);
        this.placeholder = placeholder;
        this.value = "";
        this.isEditable = true;
        this.maxLength = 100;
    }

    @Override
    public void display() {
        System.out.println("┌─ " + name + " (文本框) ───────────────┐");
        System.out.println("│ 占位符: " + placeholder);
        System.out.println("│ 当前值: " + (value.isEmpty() ? "(空)" : value));
        System.out.println("│ 可编辑: " + (isEditable ? "是" : "否"));
        System.out.println("│ 最大长度: " + maxLength);
        System.out.println("│ 类型: 单元控件");
        System.out.println("└────────────────────────────────────┘");
    }

    /**
     * 设置文本框的值
     * @param value 值
     */
    public void setValue(String value) {
        if (!isEditable) {
            System.out.println("文本框 [" + name + "] 不可编辑！");
            return;
        }
        if (value.length() > maxLength) {
            System.out.println("输入内容超过最大长度限制！");
            return;
        }
        this.value = value;
        System.out.println("文本框 [" + name + "] 的值已设置为: " + value);
    }

    /**
     * 获取文本框的值
     * @return 当前值
     */
    public String getValue() {
        return value;
    }

    /**
     * 清空文本框
     */
    public void clear() {
        this.value = "";
        System.out.println("文本框 [" + name + "] 已清空");
    }

    // Getter和Setter方法
    public String getPlaceholder() {
        return placeholder;
    }

    public void setPlaceholder(String placeholder) {
        this.placeholder = placeholder;
    }

    public boolean isEditable() {
        return isEditable;
    }

    public void setEditable(boolean editable) {
        isEditable = editable;
    }

    public int getMaxLength() {
        return maxLength;
    }

    public void setMaxLength(int maxLength) {
        this.maxLength = maxLength;
    }
}