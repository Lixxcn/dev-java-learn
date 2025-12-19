package cn.lixx;

import cn.lixx.designpatterns.simplefactory.shape.DrawingTool;
import cn.lixx.designpatterns.factorymethod.ImageProcessor;

/**
 * 主程序入口
 * 演示不同的设计模式
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("设计模式学习项目\n");
        System.out.println("请选择要演示的设计模式：");
        System.out.println("1. 简单工厂模式 - 绘图工具");
        System.out.println("2. 工厂方法模式 - 图片读取器");
        System.out.println("3. 运行所有演示");

        // 这里可以根据命令行参数或用户输入选择不同的演示
        // 为了简化，我们运行所有演示

        System.out.println("\n========================================\n");

        // 演示简单工厂模式
        System.out.println("演示 1: 简单工厂模式");
        System.out.println("========================================");
        DrawingTool.main(args);

        System.out.println("\n========================================\n");

        // 演示工厂方法模式
        System.out.println("演示 2: 工厂方法模式");
        System.out.println("========================================");
        ImageProcessor.main(args);
    }
}