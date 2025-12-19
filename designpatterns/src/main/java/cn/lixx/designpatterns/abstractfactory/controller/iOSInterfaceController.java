package cn.lixx.designpatterns.abstractfactory.controller;

/**
 * iOS平台游戏界面控制器（具体产品B1）
 */
public class iOSInterfaceController implements InterfaceController {
    private String type = "iOS";

    @Override
    public void init() {
        System.out.println("初始化iOS游戏界面控制器");
        System.out.println("加载iOS UI组件");
        System.out.println("配置iOS界面风格");
    }

    @Override
    public void displayInterface() {
        System.out.println("显示iOS游戏界面");
        System.out.println("- 使用iOS原生UI组件");
        System.out.println("- 采用iOS设计规范");
        System.out.println("- 支持Retina高清显示");
    }

    @Override
    public String getType() {
        return type;
    }
}