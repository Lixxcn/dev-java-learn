package cn.lixx.designpatterns.abstractfactory.factory;

import cn.lixx.designpatterns.abstractfactory.controller.InterfaceController;
import cn.lixx.designpatterns.abstractfactory.controller.OperationController;
import cn.lixx.designpatterns.abstractfactory.controller.iOSInterfaceController;
import cn.lixx.designpatterns.abstractfactory.controller.iOSOperationController;

/**
 * iOS平台控制器工厂（具体工厂1）
 */
public class iOSControllerFactory implements ControllerFactory {

    @Override
    public OperationController createOperationController() {
        return new iOSOperationController();
    }

    @Override
    public InterfaceController createInterfaceController() {
        return new iOSInterfaceController();
    }
}