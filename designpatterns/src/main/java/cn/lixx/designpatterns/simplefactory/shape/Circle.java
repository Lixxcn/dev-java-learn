package cn.lixx.designpatterns.simplefactory.shape;

/**
 * 圆形类
 * 实现Shape接口
 */
public class Circle implements Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public void draw() {
        System.out.println("绘制一个半径为 " + radius + " 的圆形");
    }

    @Override
    public void erase() {
        System.out.println("擦除圆形");
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }
}