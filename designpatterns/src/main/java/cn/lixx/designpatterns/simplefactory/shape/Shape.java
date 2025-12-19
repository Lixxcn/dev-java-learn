package cn.lixx.designpatterns.simplefactory.shape;

/**
 * 图形接口
 * 定义所有图形必须实现的方法
 */
public interface Shape {
    /**
     * 绘制图形
     */
    void draw();

    /**
     * 擦除图形
     */
    void erase();
}