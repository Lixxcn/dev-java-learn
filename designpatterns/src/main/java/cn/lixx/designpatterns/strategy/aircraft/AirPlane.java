package cn.lixx.designpatterns.strategy.aircraft;

import cn.lixx.designpatterns.strategy.Aircraft;
import cn.lixx.designpatterns.strategy.fly.SubSonicFly;
import cn.lixx.designpatterns.strategy.takeoff.LongDistanceTakeOff;

/**
 * 具体环境类：客机 (AirPlane)
 */
public class AirPlane extends Aircraft {
    public AirPlane(String name) {
        super(name);
        this.takeOffBehavior = new LongDistanceTakeOff();
        this.flyBehavior = new SubSonicFly();
    }
}