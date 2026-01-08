package cn.lixx.designpatterns.mediator;

/**
 * 具体组件：ListPane
 */
public class ListPane extends Pane {
    public void selectItem(String item) {
        System.out.println("ListPane: 选中列表项 - " + item);
        changed(); // 通知中介者
    }

    @Override
    public void update() {
        System.out.println("ListPane: 刷新列表数据");
    }
}
