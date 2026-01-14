package cn.lixx.designpatterns.strategy.aircraft;

import cn.lixx.designpatterns.strategy.Aircraft;
import cn.lixx.designpatterns.strategy.fly.SubSonicFly;
import cn.lixx.designpatterns.strategy.takeoff.VerticalTakeOff;

/**
 * 具体环境类：直升机 (Helicopter)
 */
public class Helicopter extends Aircraft {
    public Helicopter(String name) {
        super(name);
        this.takeOffBehavior = new VerticalTakeOff();
        this.flyBehavior = new SubSonicFly();
    }
}