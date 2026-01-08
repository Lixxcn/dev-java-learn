package cn.lixx.designpatterns.mediator;

/**
 * 抽象组件类：Pane (Colleague)
 * 维持一个对中介者对象的引用。
 */
public abstract class Pane {
    protected Mediator mediator;

    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }

    /**
     * 通知中介者组件状态已改变
     */
    public void changed() {
        if (mediator != null) {
            mediator.componentChanged(this);
        }
    }

    public abstract void update();
}
