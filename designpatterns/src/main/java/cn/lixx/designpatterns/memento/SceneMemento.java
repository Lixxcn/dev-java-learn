package cn.lixx.designpatterns.memento;

/**
 * Memento: SceneMemento
 * 存储 GameScene (Originator) 的内部状态。
 * Memento 对 Caretaker 通常是不可变的。
 */
public class SceneMemento {
    private String sceneName;
    private int lifeValue;
    private String equipment;

    // 构造函数通常是包私有或公共的，取决于严格程度。
    // 理想情况下，只有 Originator 应该广泛访问设置器/构造函数，
    // 但为了在 Java 中保持简单，我们使用公共构造函数/获取器。
    public SceneMemento(String sceneName, int lifeValue, String equipment) {
        this.sceneName = sceneName;
        this.lifeValue = lifeValue;
        this.equipment = equipment;
    }

    public String getSceneName() {
        return sceneName;
    }

    public int getLifeValue() {
        return lifeValue;
    }

    public String getEquipment() {
        return equipment;
    }
}