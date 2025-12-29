package cn.lixx.designpatterns.flyweight;

import cn.lixx.designpatterns.flyweight.MultimediaFactory.ElementType;

/**
 * 享元模式客户端测试类
 * 演示如何使用享元模式设计多功能文档编辑器
 */
public class FlyweightClient {

    public static void main(String[] args) {
        System.out.println("======== Sunny软件公司多功能文档编辑器测试 ========\n");

        // 创建享元工厂
        MultimediaFactory factory = new MultimediaFactory();

        // ========== 示例1：基本使用 ==========
        System.out.println("【示例1：基本使用 - 同一图片多次出现】");
        System.out.println("========================================");

        // 获取同一张图片
        MultimediaElement logo = factory.getElement("logo", "/images/logo.png", ElementType.IMAGE);
        MultimediaElement logo2 = factory.getElement("logo", "/images/logo.png", ElementType.IMAGE);
        MultimediaElement logo3 = factory.getElement("logo", "/images/logo.png", ElementType.IMAGE);

        System.out.println("\n验证对象是否相同:");
        System.out.println("logo == logo2: " + (logo == logo2));
        System.out.println("logo == logo3: " + (logo == logo3));
        System.out.println("logo2 == logo3: " + (logo2 == logo3));

        // 使用不同的外部状态显示同一张图片
        System.out.println("\n在不同位置显示相同的图片:");
        logo.display(new ElementState(100, 100, 200, 80));
        logo.display(new ElementState(300, 200, 300, 120));
        logo.display(new ElementState(500, 100, 150, 60));

        System.out.println("\n");

        // ========== 示例2：共享不同的多媒体元素 ==========
        System.out.println("【示例2：共享不同的多媒体元素】");
        System.out.println("========================================");

        // 获取不同的图片
        MultimediaElement img1 = factory.getElement("img001", "/images/photo1.jpg", ElementType.IMAGE);
        MultimediaElement img2 = factory.getElement("img002", "/images/photo2.jpg", ElementType.IMAGE);
        MultimediaElement img3 = factory.getElement("img001", "/images/photo1.jpg", ElementType.IMAGE); // 重复请求

        // 获取动画
        MultimediaElement anim1 = factory.getElement("anim001", "/animations/intro.gif", ElementType.ANIMATION);
        MultimediaElement anim2 = factory.getElement("anim002", "/animations/loop.gif", ElementType.ANIMATION);
        MultimediaElement anim3 = factory.getElement("anim001", "/animations/intro.gif", ElementType.ANIMATION); // 重复请求

        // 获取视频
        MultimediaElement video1 = factory.getElement("video001", "/videos/demo.mp4", ElementType.VIDEO);
        MultimediaElement video2 = factory.getElement("video002", "/videos/tutorial.mp4", ElementType.VIDEO);
        MultimediaElement video3 = factory.getElement("video001", "/videos/demo.mp4", ElementType.VIDEO); // 重复请求

        System.out.println("\n享元池统计:");
        System.out.println(factory.getStatistics());

        System.out.println("\n");

        // ========== 示例3：复杂文档场景 ==========
        System.out.println("【示例3：复杂文档 - 多处引用相同资源】");
        System.out.println("========================================");

        System.out.println("\n场景：一个包含10页的文档，每页都有相同的logo和水印\n");

        // 第一页
        System.out.println("=== 第1页 ===");
        factory.getElement("logo", "/images/logo.png", ElementType.IMAGE)
                .display(new ElementState(50, 50, 150, 60));
        factory.getElement("watermark", "/images/watermark.png", ElementType.IMAGE)
                .display(new ElementState(200, 800, 400, 200, 0, 0.3, 0, "", "none"));

        // 第二页
        System.out.println("\n=== 第2页 ===");
        factory.getElement("logo", "/images/logo.png", ElementType.IMAGE)
                .display(new ElementState(50, 50, 150, 60));
        factory.getElement("watermark", "/images/watermark.png", ElementType.IMAGE)
                .display(new ElementState(200, 800, 400, 200, 0, 0.3, 0, "", "none"));

        // 第3-10页（简化演示）
        System.out.println("\n=== 第3-10页（每页都使用相同的logo和水印）===");
        for (int i = 3; i <= 10; i++) {
            factory.getElement("logo", "/images/logo.png", ElementType.IMAGE);
            factory.getElement("watermark", "/images/watermark.png", ElementType.IMAGE);
        }

        System.out.println("\n享元池统计:");
        System.out.println(factory.getStatistics());

        System.out.println("\n享元池内容:");
        factory.displayPoolContents();

        System.out.println("\n");

        // ========== 示例4：对比使用享元模式和不使用享元模式 ==========
        System.out.println("【示例4：内存使用对比】");
        System.out.println("========================================");

        System.out.println("\n不使用享元模式（每次都创建新对象）：");
        System.out.println("- 10页文档，每页有logo和水印");
        System.out.println("- 需要创建对象数: 10页 × 2个元素 = 20个对象");
        System.out.println("- 即使是相同的图片，也要保存20份！");

        System.out.println("\n使用享元模式（共享对象）：");
        System.out.println("- 10页文档，每页有logo和水印");
        System.out.println("- 需要创建对象数: 2个（logo + watermark）");
        System.out.println("- 20次引用，只保存2份，节省90%内存！");

        // 模拟内存节省计算
        System.out.println("\n假设每个图片对象占用5MB内存:");
        System.out.println("- 不使用享元模式: 20 × 5MB = 100MB");
        System.out.println("- 使用享元模式: 2 × 5MB = 10MB");
        System.out.println("- 节省内存: 90MB (90%)");

        System.out.println("\n");

        // ========== 示例5：动态添加和删除 ==========
        System.out.println("【示例5：动态管理享元池】");
        System.out.println("========================================");

        System.out.println("\n当前享元池:");
        factory.displayPoolContents();

        System.out.println("添加新的多媒体元素...");
        factory.getElement("new_image", "/images/new.jpg", ElementType.IMAGE);
        factory.getElement("new_video", "/videos/new.mp4", ElementType.VIDEO);
        factory.getElement("new_anim", "/animations/new.gif", ElementType.ANIMATION);

        System.out.println("\n更新后的享元池:");
        factory.displayPoolContents();

        System.out.println("移除指定元素...");
        factory.removeElement("new_image");
        factory.removeElement("logo");

        System.out.println("\n移除后的享元池:");
        factory.displayPoolContents();

        System.out.println("\n");

        // ========== 总结 ==========
        System.out.println("【总结】");
        System.out.println("========================================");
        System.out.println("享元模式的优势：");
        System.out.println("1. 减少内存占用：相同对象只创建一次，多次复用");
        System.out.println("2. 提高性能：减少对象创建和销毁的开销");
        System.out.println("3. 集中管理：所有共享对象由工厂统一管理");
        System.out.println("4. 内部状态与外部状态分离：");
        System.out.println("   - 内部状态：可共享（如文件路径、大小）");
        System.out.println("   - 外部状态：不可共享（如位置、尺寸）");
        System.out.println("\n在本文档编辑器中：");
        System.out.println("- 相同的图片/动画/视频只在内存中保存一份");
        System.out.println("- 可以在不同位置、不同大小多次显示");
        System.out.println("- 大大节约了系统资源");

        System.out.println("\n\n最终享元池统计:");
        System.out.println(factory.getStatistics());
    }
}