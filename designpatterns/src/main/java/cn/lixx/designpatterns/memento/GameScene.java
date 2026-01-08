package cn.lixx.designpatterns.memento;

/**
 * Originator: GameScene
 * 拥有需要保存的内部状态的对象。
 * 创建一个包含其当前内部状态快照的 memento。
 * 使用 memento 恢复其内部状态。
 */
public class GameScene {
    private String sceneName;
    private int lifeValue;
    private String equipment;

    public void setSceneName(String sceneName) {
        this.sceneName = sceneName;
    }

    public void setLifeValue(int lifeValue) {
        this.lifeValue = lifeValue;
    }

    public void setEquipment(String equipment) {
        this.equipment = equipment;
    }

    /**
     * 创建备忘录 (存档点)
     */
    public SceneMemento save() {
        return new SceneMemento(this.sceneName, this.lifeValue, this.equipment);
    }

    /**
     * 从备忘录恢复状态
     */
    public void restore(SceneMemento memento) {
        if (memento != null) {
            this.sceneName = memento.getSceneName();
            this.lifeValue = memento.getLifeValue();
            this.equipment = memento.getEquipment();
            System.out.println("正在恢复游戏状态...");
        }
    }

    public void display() {
        System.out.println("当前游戏状态:");
        System.out.println(" - 场景: " + this.sceneName);
        System.out.println(" - 生命值: " + this.lifeValue);
        System.out.println(" - 装备: " + this.equipment);
        System.out.println("-------------------------");
    }
}