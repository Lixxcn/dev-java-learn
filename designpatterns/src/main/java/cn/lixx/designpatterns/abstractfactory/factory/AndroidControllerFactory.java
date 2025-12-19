package cn.lixx.designpatterns.abstractfactory.factory;

import cn.lixx.designpatterns.abstractfactory.controller.InterfaceController;
import cn.lixx.designpatterns.abstractfactory.controller.OperationController;
import cn.lixx.designpatterns.abstractfactory.controller.AndroidInterfaceController;
import cn.lixx.designpatterns.abstractfactory.controller.AndroidOperationController;

/**
 * Android平台控制器工厂（具体工厂2）
 */
public class AndroidControllerFactory implements ControllerFactory {

    @Override
    public OperationController createOperationController() {
        return new AndroidOperationController();
    }

    @Override
    public InterfaceController createInterfaceController() {
        return new AndroidInterfaceController();
    }
}