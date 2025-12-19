package cn.lixx.designpatterns.abstractfactory.controller;

/**
 * Android平台游戏界面控制器（具体产品B2）
 */
public class AndroidInterfaceController implements InterfaceController {
    private String type = "Android";

    @Override
    public void init() {
        System.out.println("初始化Android游戏界面控制器");
        System.out.println("加载Android UI组件");
        System.out.println("配置Material Design风格");
    }

    @Override
    public void displayInterface() {
        System.out.println("显示Android游戏界面");
        System.out.println("- 使用Android原生UI组件");
        System.out.println("- 采用Material Design设计规范");
        System.out.println("- 支持多种屏幕分辨率适配");
    }

    @Override
    public String getType() {
        return type;
    }
}