package cn.lixx.designpatterns.strategy;

import cn.lixx.designpatterns.strategy.fly.FlyBehavior;
import cn.lixx.designpatterns.strategy.takeoff.TakeOffBehavior;

/**
 * 环境类：飞机 (Aircraft)
 */
public abstract class Aircraft {
    protected FlyBehavior flyBehavior;
    protected TakeOffBehavior takeOffBehavior;
    protected String name;

    public Aircraft(String name) {
        this.name = name;
    }

    public void setFlyBehavior(FlyBehavior flyBehavior) {
        this.flyBehavior = flyBehavior;
    }

    public void setTakeOffBehavior(TakeOffBehavior takeOffBehavior) {
        this.takeOffBehavior = takeOffBehavior;
    }

    public void fly() {
        System.out.print("[" + name + "] ");
        if (flyBehavior != null) {
            flyBehavior.fly();
        }
    }

    public void takeOff() {
        System.out.print("[" + name + "] ");
        if (takeOffBehavior != null) {
            takeOffBehavior.takeOff();
        }
    }
}