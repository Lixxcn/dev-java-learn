package cn.lixx.designpatterns.mediator;

public class MediatorClient {
    public static void main(String[] args) {
        // 1. 创建具体中介者
        Window window = new Window();

        // 2. 创建组件
        TextPane textPane = new TextPane();
        ListPane listPane = new ListPane();
        GraphicPane graphicPane = new GraphicPane();

        // 3. 将组件注册到中介者
        window.setTextPane(textPane);
        window.setListPane(listPane);
        window.setGraphicPane(graphicPane);

        // 4. 模拟交互
        System.out.println("------ 场景 1: 用户选中列表项 ------");
        listPane.selectItem("Item 1");

        System.out.println("\n------ 场景 2: 用户编辑文本 ------");
        textPane.select(); // 触发变化

        System.out.println("\n------ 场景 3: 用户绘制图形 ------");
        graphicPane.draw();
    }
}
