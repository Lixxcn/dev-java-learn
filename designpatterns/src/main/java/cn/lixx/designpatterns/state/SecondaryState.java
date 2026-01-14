package cn.lixx.designpatterns.state;

/**
 * 具体状态：SecondaryState (熟练级)
 * 积分范围: 100 <= score < 200
 * 新增功能: doubleScore
 */
public class SecondaryState extends Level {

    public SecondaryState(Level state) {
        this.player = state.player;
        this.player.setLevel(this);
        checkState();
    }

    @Override
    public void play() {
        System.out.println("熟练级玩家正在玩游戏...");
    }

    @Override
    public void doubleScore() {
        System.out.println("使用技能 [积分加倍]：胜利积分 x2 !");
    }

    @Override
    public void checkState() {
        int score = player.getScore();
        if (score < 100) {
            System.out.println("<<< 遗憾！降级为 [入门级]");
            new PrimaryState(this);
        } else if (score >= 200) {
            System.out.println(">>> 恭喜！升级为 [高手级]");
            new ProfessionalState(this);
        }
    }
}
