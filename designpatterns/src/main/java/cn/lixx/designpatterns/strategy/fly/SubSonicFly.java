package cn.lixx.designpatterns.strategy.fly;

/**
 * 具体策略：亚音速飞行
 */
public class SubSonicFly implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("飞行特征：亚音速飞行，平稳巡航。");
    }
}