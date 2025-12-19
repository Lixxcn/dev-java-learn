package cn.lixx.designpatterns.builder.component;

/**
 * 状态栏组件
 */
public class StatusBar {
    private String info;  // 状态信息

    public StatusBar(String info) {
        this.info = info;
    }

    public void display() {
        System.out.println("  📊 状态栏: " + info);
        System.out.println("     分辨率: 1920x1080 | 帧率: 60fps | 编码: H.264");
    }

    @Override
    public String toString() {
        return "状态栏(" + info + ")";
    }
}