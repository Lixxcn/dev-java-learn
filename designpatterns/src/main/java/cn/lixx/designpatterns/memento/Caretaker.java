package cn.lixx.designpatterns.memento;

/**
 * Caretaker (负责人)
 * 负责保管备忘录。
 * 绝不能操作或检查备忘录的内容。
 */
public class Caretaker {
    private SceneMemento memento;

    public SceneMemento getMemento() {
        return memento;
    }

    public void setMemento(SceneMemento memento) {
        this.memento = memento;
    }
}