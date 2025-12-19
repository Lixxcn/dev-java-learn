package cn.lixx.designpatterns.builder.component;

/**
 * 控制条组件
 */
public class ControlBar {
    private String style;  // 控制条样式

    public ControlBar(String style) {
        this.style = style;
    }

    public void display() {
        System.out.println("  🎮 " + style + "控制条");
        System.out.println("     ⏮️  ⏯️  ⏹️  ⏭️     🔊🔇");
        System.out.println("     ━━━━━━━━⚪━━━━━━━━━ 00:00/00:00");
    }

    @Override
    public String toString() {
        return style + "控制条";
    }
}