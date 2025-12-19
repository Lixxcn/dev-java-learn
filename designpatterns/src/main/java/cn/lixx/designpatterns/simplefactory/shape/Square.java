package cn.lixx.designpatterns.simplefactory.shape;

/**
 * 方形类
 * 实现Shape接口
 */
public class Square implements Shape {
    private double side;

    public Square(double side) {
        this.side = side;
    }

    @Override
    public void draw() {
        System.out.println("绘制一个边长为 " + side + " 的方形");
    }

    @Override
    public void erase() {
        System.out.println("擦除方形");
    }

    public double getSide() {
        return side;
    }

    public void setSide(double side) {
        this.side = side;
    }
}