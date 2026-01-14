package cn.lixx.designpatterns.strategy.takeoff;

/**
 * 具体策略：长距离滑行起飞
 */
public class LongDistanceTakeOff implements TakeOffBehavior {
    @Override
    public void takeOff() {
        System.out.println("起飞特征：长距离滑行起飞 (Long Distance Take-Off)。");
    }
}