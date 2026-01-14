package cn.lixx.designpatterns.strategy.aircraft;

import cn.lixx.designpatterns.strategy.Aircraft;
import cn.lixx.designpatterns.strategy.fly.SuperSonicFly;
import cn.lixx.designpatterns.strategy.takeoff.LongDistanceTakeOff;

/**
 * 具体环境类：战斗机 (Fighter)
 */
public class Fighter extends Aircraft {
    public Fighter(String name) {
        super(name);
        this.takeOffBehavior = new LongDistanceTakeOff();
        this.flyBehavior = new SuperSonicFly();
    }
}