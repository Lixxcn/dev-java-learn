package cn.lixx.designpatterns.state;

/**
 * 具体状态：ProfessionalState (高手级)
 * 积分范围: 200 <= score < 300
 * 新增功能: changeCards
 */
public class ProfessionalState extends Level {

    public ProfessionalState(Level state) {
        this.player = state.player;
        this.player.setLevel(this);
        checkState();
    }

    @Override
    public void play() {
        System.out.println("高手级玩家正在玩游戏...");
    }

    @Override
    public void doubleScore() {
        System.out.println("使用技能 [积分加倍]：胜利积分 x2 !");
    }

    @Override
    public void changeCards() {
        System.out.println("使用技能 [换牌]：手气不好，换一组牌！");
    }

    @Override
    public void checkState() {
        int score = player.getScore();
        if (score < 200) {
            System.out.println("<<< 遗憾！降级为 [熟练级]");
            new SecondaryState(this);
        } else if (score >= 300) {
            System.out.println(">>> 恭喜！升级为 [骨灰级]");
            new FinalState(this);
        }
    }
}
