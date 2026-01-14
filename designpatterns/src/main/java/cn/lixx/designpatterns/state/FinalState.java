package cn.lixx.designpatterns.state;

/**
 * 具体状态：FinalState (骨灰级)
 * 积分范围: >= 300
 * 新增功能: peekCards
 */
public class FinalState extends Level {

    public FinalState(Level state) {
        this.player = state.player;
        this.player.setLevel(this);
        checkState();
    }

    @Override
    public void play() {
        System.out.println("骨灰级玩家正在玩游戏...");
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
    public void peekCards() {
        System.out.println("使用技能 [偷看牌]：嘿嘿，看到对方的底牌了！");
    }

    @Override
    public void checkState() {
        int score = player.getScore();
        if (score < 300) {
            System.out.println("<<< 遗憾！降级为 [高手级]");
            new ProfessionalState(this);
        }
    }
}
