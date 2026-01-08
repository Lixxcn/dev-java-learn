package cn.lixx.designpatterns.mediator;

/**
 * 具体中介者：Window
 * 协调各个 Pane 之间的交互。
 */
public class Window implements Mediator {
    private TextPane textPane;
    private ListPane listPane;
    private GraphicPane graphicPane;

    public void setTextPane(TextPane textPane) {
        this.textPane = textPane;
        this.textPane.setMediator(this);
    }

    public void setListPane(ListPane listPane) {
        this.listPane = listPane;
        this.listPane.setMediator(this);
    }

    public void setGraphicPane(GraphicPane graphicPane) {
        this.graphicPane = graphicPane;
        this.graphicPane.setMediator(this);
    }

    @Override
    public void componentChanged(Pane pane) {
        // 核心协调逻辑
        if (pane == listPane) {
            System.out.println(">> 中介者(Window)检测到 ListPane 变化，正在协调其他组件...");
            textPane.update();    // 列表选中 -> 更新文本详情
            graphicPane.update(); // 列表选中 -> 更新关联图形
        } else if (pane == textPane) {
            System.out.println(">> 中介者(Window)检测到 TextPane 变化，正在协调其他组件...");
            listPane.update();    // 文本修改 -> 刷新列表显示
        } else if (pane == graphicPane) {
            System.out.println(">> 中介者(Window)检测到 GraphicPane 变化，不需要联动其他组件。");
        }
    }
}
