package cn.lixx.designpatterns.state;

/**
 * 环境类：Player (玩家)
 * 维护当前状态 (Level) 和积分 (Score)。
 */
public class Player {
    private Level level;
    private String name;
    private int score;

    public Player(String name) {
        this.name = name;
        this.score = 0;
        // 初始状态为入门级
        this.level = new PrimaryState(this);
        System.out.println("欢迎玩家 [" + name + "] 加入游戏！初始等级：入门级");
    }

    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
        this.level.setPlayer(this);
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
        System.out.println("当前积分：" + this.score);
        // 积分改变后，委托状态对象检查是否需要升级/降级
        level.checkState();
    }

    public String getName() {
        return name;
    }

    // 业务方法，委托给 State 对象处理
    public void play() {
        level.play();
    }

    public void doubleScore() {
        level.doubleScore();
    }

    public void changeCards() {
        level.changeCards();
    }

    public void peekCards() {
        level.peekCards();
    }
}
