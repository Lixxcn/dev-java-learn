package cn.lixx.designpatterns.mediator;

/**
 * 抽象中介者：Mediator
 * 定义组件之间通信的接口。
 */
public interface Mediator {
    void componentChanged(Pane pane);
}
