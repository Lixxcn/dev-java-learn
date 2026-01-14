package cn.lixx.designpatterns.strategy;

import cn.lixx.designpatterns.strategy.aircraft.AirPlane;
import cn.lixx.designpatterns.strategy.aircraft.Fighter;
import cn.lixx.designpatterns.strategy.aircraft.Harrier;
import cn.lixx.designpatterns.strategy.aircraft.Helicopter;
import cn.lixx.designpatterns.strategy.fly.SuperSonicFly;

public class StrategyClient {
    public static void main(String[] args) {
        System.out.println("------------ 飞机模拟系统启动 ------------");
        Aircraft helicopter = new Helicopter("直升机");
        helicopter.takeOff();
        helicopter.fly();

        Aircraft airPlane = new AirPlane("客机");
        airPlane.takeOff();
        airPlane.fly();

        Aircraft fighter = new Fighter("战斗机");
        fighter.takeOff();
        fighter.fly();

        Aircraft harrier = new Harrier("鹞式战斗机");
        harrier.takeOff();
        harrier.fly();
        
        System.out.println(">> 动态改变策略：给直升机安装火箭助推器");
        helicopter.setFlyBehavior(new SuperSonicFly());
        helicopter.fly();
    }
}