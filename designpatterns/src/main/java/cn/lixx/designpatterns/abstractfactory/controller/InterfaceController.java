package cn.lixx.designpatterns.abstractfactory.controller;

/**
 * 游戏界面控制器接口（抽象产品B）
 */
public interface InterfaceController {
    /**
     * 初始化游戏界面控制器
     */
    void init();

    /**
     * 显示游戏界面
     */
    void displayInterface();

    /**
     * 获取界面控制器类型
     */
    String getType();
}