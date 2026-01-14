package cn.lixx.designpatterns.state;

/**
 * 抽象状态类：Level (等级)
 * 定义了所有可能的行为接口，并维护一个 Context (Player) 的引用。
 */
public abstract class Level {
    protected Player player;

    public void setPlayer(Player player) {
        this.player = player;
    }

    // 基本游戏功能 (所有等级都有)
    public abstract void play();

    // 胜利积分加倍 (熟练级及以上)
    public void doubleScore() {
        System.out.println("系统提示：当前等级 [" + this.getClass().getSimpleName() + "] 不支持 [积分加倍] 功能。");
    }

    // 换牌 (高手级及以上)
    public void changeCards() {
        System.out.println("系统提示：当前等级 [" + this.getClass().getSimpleName() + "] 不支持 [换牌] 功能。");
    }

    // 偷看牌 (骨灰级)
    public void peekCards() {
        System.out.println("系统提示：当前等级 [" + this.getClass().getSimpleName() + "] 不支持 [偷看牌] 功能。");
    }

    // 检查并进行状态转换
    public abstract void checkState();
}
