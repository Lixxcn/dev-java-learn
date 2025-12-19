package cn.lixx.designpatterns.abstractfactory.factory;

import cn.lixx.designpatterns.abstractfactory.controller.InterfaceController;
import cn.lixx.designpatterns.abstractfactory.controller.OperationController;

/**
 * 控制器工厂接口（抽象工厂）
 */
public interface ControllerFactory {
    /**
     * 创建操作控制器
     * @return 操作控制器实例
     */
    OperationController createOperationController();

    /**
     * 创建界面控制器
     * @return 界面控制器实例
     */
    InterfaceController createInterfaceController();
}