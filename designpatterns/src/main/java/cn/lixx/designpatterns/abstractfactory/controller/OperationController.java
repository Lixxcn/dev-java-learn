package cn.lixx.designpatterns.abstractfactory.controller;

/**
 * 游戏操作控制器接口（抽象产品A）
 */
public interface OperationController {
    /**
     * 初始化游戏操作控制器
     */
    void init();

    /**
     * 处理游戏操作
     */
    void handleOperation();

    /**
     * 获取操作控制器类型
     */
    String getType();
}