package cn.lixx.designpatterns.strategy.fly;

/**
 * 具体策略：超音速飞行
 */
public class SuperSonicFly implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("飞行特征：超音速飞行，极速穿梭！");
    }
}