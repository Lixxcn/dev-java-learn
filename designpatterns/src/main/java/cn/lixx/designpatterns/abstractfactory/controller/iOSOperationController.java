package cn.lixx.designpatterns.abstractfactory.controller;

/**
 * iOS平台游戏操作控制器（具体产品A1）
 */
public class iOSOperationController implements OperationController {
    private String type = "iOS";

    @Override
    public void init() {
        System.out.println("初始化iOS游戏操作控制器");
        System.out.println("配置触摸手势识别");
        System.out.println("加载iOS平台特定的操作配置");
    }

    @Override
    public void handleOperation() {
        System.out.println("处理iOS游戏操作");
        System.out.println("- 支持多点触控操作");
        System.out.println("- 支持滑动、轻点手势");
        System.out.println("- 支持重力感应操作");
    }

    @Override
    public String getType() {
        return type;
    }
}