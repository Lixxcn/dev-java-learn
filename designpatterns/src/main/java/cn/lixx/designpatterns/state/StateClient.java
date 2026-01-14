package cn.lixx.designpatterns.state;

public class StateClient {
    public static void main(String[] args) {
        Player player = new Player("赌神高进");
        System.out.println("--------------------------------------------------");

        // 1. 入门级测试 (0 分)
        player.play();
        player.doubleScore(); // 不支持
        System.out.println("--------------------------------------------------");

        // 2. 赢积分 -> 升级到熟练级 (100 分)
        System.out.println(">> 赢了一局大满贯！");
        player.setScore(120);
        player.play();
        player.doubleScore(); // 支持
        player.changeCards(); // 不支持
        System.out.println("--------------------------------------------------");

        // 3. 赢积分 -> 升级到高手级 (200 分)
        System.out.println(">> 连胜！");
        player.setScore(250);
        player.play();
        player.changeCards(); // 支持
        player.peekCards(); // 不支持
        System.out.println("--------------------------------------------------");

        // 4. 赢积分 -> 升级到骨灰级 (300 分)
        System.out.println(">> 成为传说！");
        player.setScore(350);
        player.play();
        player.peekCards(); // 支持
        System.out.println("--------------------------------------------------");

        // 5. 输积分 -> 降级
        System.out.println(">> 遭遇滑铁卢...");
        player.setScore(150); // 降级回熟练级
        player.changeCards(); // 不支持了
        System.out.println("--------------------------------------------------");

        // 6. 赢积分 -> 升级
        System.out.println(">> 东山再起！");
        player.setScore(320); // 升级到骨灰级
        player.peekCards(); // 支持
    }
}
