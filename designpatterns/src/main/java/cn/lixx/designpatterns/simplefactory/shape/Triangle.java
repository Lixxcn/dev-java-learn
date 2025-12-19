package cn.lixx.designpatterns.simplefactory.shape;

/**
 * 三角形类
 * 实现Shape接口
 */
public class Triangle implements Shape {
    private double base;
    private double height;

    public Triangle(double base, double height) {
        this.base = base;
        this.height = height;
    }

    @Override
    public void draw() {
        System.out.println("绘制一个底为 " + base + "，高为 " + height + " 的三角形");
    }

    @Override
    public void erase() {
        System.out.println("擦除三角形");
    }

    public double getBase() {
        return base;
    }

    public void setBase(double base) {
        this.base = base;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }
}