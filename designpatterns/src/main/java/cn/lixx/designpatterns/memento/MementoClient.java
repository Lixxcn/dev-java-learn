package cn.lixx.designpatterns.memento;

public class MementoClient {
    public static void main(String[] args) {
        // 1. 初始化游戏
        GameScene player = new GameScene();
        Caretaker caretaker = new Caretaker();

        // 2. 游玩关卡 1
        player.setSceneName("黑暗森林 - 第1关");
        player.setLifeValue(100);
        player.setEquipment("木剑");
        System.out.println("--- 开始游戏 ---");
        player.display();

        // 3. 保存游戏 (创建备忘录)
        System.out.println(">>> 保存游戏 (存档点)...");
        caretaker.setMemento(player.save());

        // 4. 游玩关卡 2 (Boss 战)
        System.out.println("\n--- 进入 Boss 战 ---");
        player.setSceneName("Boss 巢穴 - 第2关");
        player.setLifeValue(50); // 受伤
        player.setEquipment("铁剑"); // 升级
        player.display();

        // 5. 玩家死亡
        System.out.println("!!! 玩家死亡 !!!");
        player.setLifeValue(0);
        player.display();

        // 6. 恢复游戏
        System.out.println(">>> 读取存档点...");
        player.restore(caretaker.getMemento());
        player.display();
    }
}