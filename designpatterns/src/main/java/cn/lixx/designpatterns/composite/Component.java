package cn.lixx.designpatterns.composite;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 抽象控件类（抽象构件）
 * 定义所有控件的公共接口，默认实现添加/删除子控件的方法
 * 用于管理树形结构的控件层次
 */
public abstract class Component {
    // 控件名称
    protected String name;

    public Component(String name) {
        this.name = name;
    }

    /**
     * 添加子控件（默认实现，容器控件需要重写）
     * @param component 子控件
     */
    public void add(Component component) {
        throw new UnsupportedOperationException("不支持添加子控件");
    }

    /**
     * 移除子控件（默认实现，容器控件需要重写）
     * @param component 子控件
     */
    public void remove(Component component) {
        throw new UnsupportedOperationException("不支持移除子控件");
    }

    /**
     * 获取子控件（默认实现，容器控件需要重写）
     * @param index 子控件索引
     * @return 子控件
     */
    public Component getChild(int index) {
        throw new UnsupportedOperationException("不支持获取子控件");
    }

    /**
     * 获取所有子控件（默认实现，返回空列表，容器控件需要重写）
     * @return 子控件列表
     */
    public List<Component> getChildren() {
        // 返回不可变的空列表，而不是抛出异常
        // 这样客户端代码可以统一地处理所有控件
        return Collections.emptyList();
    }

    /**
     * 显示控件（抽象方法，由子类实现）
     */
    public abstract void display();

    /**
     * 获取控件名称
     * @return 控件名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置控件名称
     * @param name 控件名称
     */
    public void setName(String name) {
        this.name = name;
    }
}