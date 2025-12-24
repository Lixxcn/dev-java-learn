package cn.lixx.designpatterns.composite.leaf;

import cn.lixx.designpatterns.composite.Component;

/**
 * 复选框类（叶子构件）
 * 用于进行选择的单元控件
 */
public class CheckBox extends Component {
    private String label;     // 复选框标签
    private boolean checked;  // 是否选中

    public CheckBox(String name) {
        super(name);
        this.label = "选项";
        this.checked = false;
    }

    public CheckBox(String name, String label) {
        super(name);
        this.label = label;
        this.checked = false;
    }

    @Override
    public void display() {
        System.out.println("┌─ " + name + " (复选框) ───────────────┐");
        System.out.println("│ 标签: " + label);
        System.out.println("│ 状态: " + (checked ? "☑ 已选中" : "☐ 未选中"));
        System.out.println("│ 类型: 单元控件");
        System.out.println("└────────────────────────────────────┘");
    }

    /**
     * 切换复选框状态
     */
    public void toggle() {
        checked = !checked;
        System.out.println("复选框 [" + name + "] 状态: " + (checked ? "已选中" : "未选中"));
    }

    /**
     * 设置复选框状态
     * @param checked 是否选中
     */
    public void setChecked(boolean checked) {
        this.checked = checked;
        System.out.println("复选框 [" + name + "] " + (checked ? "已选中" : "已取消"));
    }

    /**
     * 检查是否选中
     * @return 是否选中
     */
    public boolean isChecked() {
        return checked;
    }

    // Getter和Setter方法
    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
}