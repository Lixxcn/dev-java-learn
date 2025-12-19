package cn.lixx.designpatterns.abstractfactory.controller;

/**
 * Android平台游戏操作控制器（具体产品A2）
 */
public class AndroidOperationController implements OperationController {
    private String type = "Android";

    @Override
    public void init() {
        System.out.println("初始化Android游戏操作控制器");
        System.out.println("配置Android触摸事件处理");
        System.out.println("加载Android平台特定的操作配置");
    }

    @Override
    public void handleOperation() {
        System.out.println("处理Android游戏操作");
        System.out.println("- 支持触摸屏操作");
        System.out.println("- 支持虚拟按键");
        System.out.println("- 支持物理键盘映射");
    }

    @Override
    public String getType() {
        return type;
    }
}