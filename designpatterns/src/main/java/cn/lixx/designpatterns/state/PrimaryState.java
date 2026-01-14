package cn.lixx.designpatterns.state;

/**
 * 具体状态：PrimaryState (入门级)
 * 积分范围: < 100
 * 功能: play
 */
public class PrimaryState extends Level {

    public PrimaryState(Player player) {
        this.player = player;
        this.player.setLevel(this);
        checkState();
    }
    
    // 用于状态转换时的构造
    public PrimaryState(Level state) {
        this.player = state.player;
        this.player.setLevel(this);
        checkState();
    }

    @Override
    public void play() {
        System.out.println("入门级玩家正在玩游戏... (无特殊技能)");
    }

    @Override
    public void checkState() {
        int score = player.getScore();
        if (score >= 100) {
            System.out.println(">>> 恭喜！升级为 [熟练级]");
            new SecondaryState(this);
        }
    }
}