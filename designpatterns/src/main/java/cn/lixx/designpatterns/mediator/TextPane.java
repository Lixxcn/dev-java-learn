package cn.lixx.designpatterns.mediator;

/**
 * 具体组件：TextPane
 */
public class TextPane extends Pane {
    public void addText(String text) {
        System.out.println("TextPane: 添加文本 - " + text);
    }

    public void select() {
        System.out.println("TextPane: 文本被选中");
        changed(); // 通知中介者
    }

    @Override
    public void update() {
        System.out.println("TextPane: 更新显示内容");
    }
}
