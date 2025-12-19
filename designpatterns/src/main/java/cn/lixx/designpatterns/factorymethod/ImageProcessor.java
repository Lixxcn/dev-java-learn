package cn.lixx.designpatterns.factorymethod;

import cn.lixx.designpatterns.factorymethod.reader.ImageReader;
import cn.lixx.designpatterns.factorymethod.factory.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 图片处理器演示类
 * 展示工厂方法模式的使用
 */
public class ImageProcessor {

    public static void main(String[] args) {
        System.out.println("=== 工厂方法模式图片读取器演示 ===\n");

        // 创建工厂列表
        List<ImageReaderFactory> factories = createFactories();

        // 演示基本工厂方法
        demonstrateBasicFactoryMethod(factories);

        // 演示扩展的工厂方法
        demonstrateExtendedFactoryMethods();

        // 演示动态选择工厂
        demonstrateDynamicFactorySelection();

        // 演示系统的扩展性
        demonstrateExtensibility();
    }

    /**
     * 创建所有工厂实例
     */
    private static List<ImageReaderFactory> createFactories() {
        List<ImageReaderFactory> factories = new ArrayList<>();
        factories.add(new GifReaderFactory());
        factories.add(new JpgReaderFactory());
        factories.add(new PngReaderFactory());
        factories.add(new BmpReaderFactory());
        return factories;
    }

    /**
     * 演示基本的工厂方法
     */
    private static void demonstrateBasicFactoryMethod(List<ImageReaderFactory> factories) {
        System.out.println("1. 基本工厂方法演示：");

        for (ImageReaderFactory factory : factories) {
            // 使用工厂方法创建读取器
            ImageReader reader = factory.createImageReader();
            String format = factory.getSupportedFormat();

            // 测试读取功能
            String testFile = "test." + format.toLowerCase();
            try {
                String result = reader.readImage(testFile);
                System.out.println("  " + result);
            } catch (IllegalArgumentException e) {
                System.out.println("  错误: " + e.getMessage());
            }
        }
        System.out.println();
    }

    /**
     * 演示扩展的工厂方法
     */
    private static void demonstrateExtendedFactoryMethods() {
        System.out.println("2. 扩展工厂方法演示：");

        // 使用GIF工厂的扩展方法
        GifReaderFactory gifFactory = new GifReaderFactory();
        ImageReader gifReader = gifFactory.createGifReader(true);
        System.out.println("  " + gifReader.readImage("animation.gif"));

        // 使用JPG工厂的扩展方法
        JpgReaderFactory jpgFactory = new JpgReaderFactory();
        ImageReader jpgReader = jpgFactory.createJpgReader(95);
        System.out.println("  " + jpgReader.readImage("photo.jpg"));

        // 使用PNG工厂的扩展方法
        PngReaderFactory pngFactory = new PngReaderFactory();
        ImageReader pngReader = pngFactory.createPngReader(true);
        System.out.println("  " + pngReader.readImage("logo.png"));

        System.out.println();
    }

    /**
     * 演示动态工厂选择
     */
    private static void demonstrateDynamicFactorySelection() {
        System.out.println("3. 动态工厂选择演示：");

        String[] testFiles = {
            "image1.gif",
            "image2.jpg",
            "image3.png",
            "image4.bmp",
            "image5.webp",  // 不支持的格式
            "image6.jpeg"   // JPG的另一种写法
        };

        List<ImageReaderFactory> factories = createFactories();

        for (String file : testFiles) {
            ImageReaderFactory suitableFactory = findSuitableFactory(factories, file);
            if (suitableFactory != null) {
                ImageReader reader = suitableFactory.createImageReader();
                String result = reader.readImage(file);
                System.out.println("  " + result);
            } else {
                System.out.println("  没有找到支持格式的工厂: " + file);
            }
        }
        System.out.println();
    }

    /**
     * 查找适合处理该文件的工厂
     */
    private static ImageReaderFactory findSuitableFactory(List<ImageReaderFactory> factories, String filePath) {
        for (ImageReaderFactory factory : factories) {
            // 使用工厂的canHandle方法判断是否能处理该文件
            if (factory.canHandle(filePath)) {
                return factory;
            }
        }
        return null;
    }

    /**
     * 演示系统的扩展性
     */
    private static void demonstrateExtensibility() {
        System.out.println("4. 系统扩展性演示：");
        System.out.println("  要添加新的图片格式支持，只需要：");
        System.out.println("  1. 创建实现ImageReader接口的新读取器类");
        System.out.println("  2. 创建实现ImageReaderFactory接口的新工厂类");
        System.out.println("  3. 将新工厂注册到系统中");
        System.out.println("  4. 无需修改现有代码，符合开闭原则");
        System.out.println("\n  例如，要添加WebP支持：");
        System.out.println("  - 创建WebpReader类");
        System.out.println("  - 创建WebpReaderFactory类");
        System.out.println("  - 将WebpReaderFactory添加到工厂列表中");
    }

    /**
     * 获取文件扩展名
     */
    private static String getExtension(String filePath) {
        if (filePath == null || filePath.isEmpty()) {
            return "";
        }
        int lastDot = filePath.lastIndexOf('.');
        return lastDot > 0 ? filePath.substring(lastDot + 1).toUpperCase() : "";
    }
}