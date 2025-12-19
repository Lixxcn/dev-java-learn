package cn.lixx.designpatterns.simplefactory.shape;

import cn.lixx.designpatterns.simplefactory.exception.UnSupportedShapeException;
import cn.lixx.designpatterns.simplefactory.factory.ShapeFactory;

/**
 * 绘图工具测试类
 */
public class DrawingTool {
    public static void main(String[] args) {
        System.out.println("=== 简单工厂模式绘图工具演示 ===\n");

        // 测试支持的图形
        testSupportedShapes();

        // 测试不支持的图形
        testUnsupportedShapes();
    }

    /**
     * 测试支持的图形
     */
    private static void testSupportedShapes() {
        System.out.println("1. 测试支持的图形：");

        // 创建并使用圆形
        try {
            Shape circle = ShapeFactory.createShape("circle", 5.0);
            circle.draw();
            circle.erase();
        } catch (UnSupportedShapeException e) {
            System.out.println("错误: " + e.getMessage());
        }

        // 创建并使用方形
        try {
            Shape square = ShapeFactory.createShape("square", 4.0);
            square.draw();
            square.erase();
        } catch (UnSupportedShapeException e) {
            System.out.println("错误: " + e.getMessage());
        }

        // 创建并使用三角形
        try {
            Shape triangle = ShapeFactory.createShape("triangle", 3.0, 4.0);
            triangle.draw();
            triangle.erase();
        } catch (UnSupportedShapeException e) {
            System.out.println("错误: " + e.getMessage());
        }

        System.out.println("\n2. 显示支持的图形类型：");
        String[] supportedShapes = ShapeFactory.getSupportedShapes();
        System.out.print("支持的图形类型: ");
        for (String shape : supportedShapes) {
            System.out.print(shape + " ");
        }
        System.out.println("\n");
    }

    /**
     * 测试不支持的图形
     */
    private static void testUnsupportedShapes() {
        System.out.println("3. 测试不支持的图形和错误情况：");

        // 测试不支持的图形类型
        try {
            Shape pentagon = ShapeFactory.createShape("pentagon", 5.0);
            pentagon.draw();
        } catch (UnSupportedShapeException e) {
            System.out.println("捕获预期异常: " + e.getMessage());
        }

        // 测试空字符串
        try {
            Shape emptyShape = ShapeFactory.createShape("", 5.0);
            emptyShape.draw();
        } catch (UnSupportedShapeException e) {
            System.out.println("捕获预期异常: " + e.getMessage());
        }

        // 测试参数不足的情况
        try {
            Shape incompleteTriangle = ShapeFactory.createShape("triangle", 3.0);
            incompleteTriangle.draw();
        } catch (UnSupportedShapeException e) {
            System.out.println("捕获预期异常: " + e.getMessage());
        }

        // 测试参数过多的情况（应该只使用需要的参数）
        try {
            Shape overParameterizedCircle = ShapeFactory.createShape("circle", 5.0, 10.0, 15.0);
            overParameterizedCircle.draw();
            overParameterizedCircle.erase();
            System.out.println("注意：多余的参数被忽略了");
        } catch (UnSupportedShapeException e) {
            System.out.println("错误: " + e.getMessage());
        }
    }
}