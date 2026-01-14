package cn.lixx.designpatterns.strategy.takeoff;

/**
 * 具体策略：垂直起飞
 */
public class VerticalTakeOff implements TakeOffBehavior {
    @Override
    public void takeOff() {
        System.out.println("起飞特征：垂直起飞 (Vertical Take-Off)。");
    }
}