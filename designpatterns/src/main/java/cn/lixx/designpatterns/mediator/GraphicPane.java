package cn.lixx.designpatterns.mediator;

/**
 * 具体组件：GraphicPane
 */
public class GraphicPane extends Pane {
    public void draw() {
        System.out.println("GraphicPane: 绘制图形");
        changed();
    }

    @Override
    public void update() {
        System.out.println("GraphicPane: 重绘图形视图");
    }
}
