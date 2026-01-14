package cn.lixx.designpatterns.strategy.aircraft;

import cn.lixx.designpatterns.strategy.Aircraft;
import cn.lixx.designpatterns.strategy.fly.SuperSonicFly;
import cn.lixx.designpatterns.strategy.takeoff.VerticalTakeOff;

/**
 * 具体环境类：鹞式战斗机 (Harrier)
 */
public class Harrier extends Aircraft {
    public Harrier(String name) {
        super(name);
        this.takeOffBehavior = new VerticalTakeOff();
        this.flyBehavior = new SuperSonicFly();
    }
}