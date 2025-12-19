package cn.lixx.designpatterns.simplefactory.factory;

import cn.lixx.designpatterns.simplefactory.exception.UnSupportedShapeException;
import cn.lixx.designpatterns.simplefactory.shape.Circle;
import cn.lixx.designpatterns.simplefactory.shape.Shape;
import cn.lixx.designpatterns.simplefactory.shape.Square;
import cn.lixx.designpatterns.simplefactory.shape.Triangle;

/**
 * 简单工厂类
 * 负责创建不同类型的图形对象
 */
public class ShapeFactory {

    /**
     * 根据图形类型创建相应的图形对象
     * 
     * @param shapeType  图形类型
     * @param parameters 图形参数（可变参数）
     * @return 图形对象
     * @throws UnSupportedShapeException 当图形类型不支持时抛出
     */
    public static Shape createShape(String shapeType, double... parameters) {
        if (shapeType == null || shapeType.trim().isEmpty()) {
            throw new UnSupportedShapeException("图形类型不能为空");
        }

        switch (shapeType.toLowerCase()) {
            case "circle":
                if (parameters.length < 1) {
                    throw new UnSupportedShapeException("创建圆形需要半径参数");
                }
                return new Circle(parameters[0]);

            case "square":
                if (parameters.length < 1) {
                    throw new UnSupportedShapeException("创建方形需要边长参数");
                }
                return new Square(parameters[0]);

            case "triangle":
                if (parameters.length < 2) {
                    throw new UnSupportedShapeException("创建三角形需要底和高两个参数");
                }
                return new Triangle(parameters[0], parameters[1]);

            default:
                throw new UnSupportedShapeException("不支持的图形类型: " + shapeType);
        }
    }

    /**
     * 获取支持的图形类型列表
     * 
     * @return 支持的图形类型数组
     */
    public static String[] getSupportedShapes() {
        return new String[] { "circle", "square", "triangle" };
    }
}