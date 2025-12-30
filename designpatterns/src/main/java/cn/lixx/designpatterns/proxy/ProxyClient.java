package cn.lixx.designpatterns.proxy;

import java.util.ArrayList;
import java.util.List;

/**
 * 虚拟代理模式客户端测试类
 * 演示基于C/S的网络图片查看器
 */
public class ProxyClient {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("======== Sunny软件公司 - 网络图片查看器 ========\n");
        System.out.println("使用虚拟代理模式设计，支持延迟加载和多线程\n");

        // ========== 示例1：基本使用 ==========
        System.out.println("【示例1：基本使用 - 查看单张图片】");
        System.out.println("================================================\n");

        String url1 = "https://example.com/images/sunset.jpg";
        String fileName1 = "sunset.jpg";

        // 创建图片代理
        Image image1 = new ImageProxy(url1, fileName1);

        // 首次显示：只显示图标，启动后台加载
        System.out.println(">>> 首次显示图片（只显示图标）：");
        image1.display();

        // 等待一段时间让图片加载
        System.out.println("\n... 等待图片加载 ...\n");
        Thread.sleep(3000);

        // 再次显示：显示完整图片
        System.out.println("\n>>> 再次显示图片（显示完整图片）：");
        image1.display();

        System.out.println("\n");

        // ========== 示例2：多图片场景 - 模拟网页图片列表 ==========
        System.out.println("【示例2：网页图片列表 - 先显示所有图标】");
        System.out.println("================================================\n");

        String webpageUrl = "https://example.com/gallery.html";
        System.out.println("正在解析网页: " + webpageUrl);
        System.out.println("找到 5 张图片\n");

        List<Image> images = new ArrayList<>();
        images.add(new ImageProxy("https://example.com/img1.jpg", "mountain.jpg"));
        images.add(new ImageProxy("https://example.com/img2.png", "river.png"));
        images.add(new ImageProxy("https://example.com/img3.gif", "waterfall.gif"));
        images.add(new ImageProxy("https://example.com/img4.jpg", "forest.jpg"));
        images.add(new ImageProxy("https://example.com/img5.webp", "sky.webp"));

        // 快速显示所有图标
        System.out.println(">>> 显示所有图片图标（快速响应）：");
        for (int i = 0; i < images.size(); i++) {
            System.out.printf("\n[图片 %d]\n", i + 1);
            images.get(i).display();
        }

        System.out.println("\n所有图标已显示！原图正在后台加载中...\n");
        Thread.sleep(5000);

        System.out.println("\n>>> 点击某张图片查看原图：");
        System.out.println("================================================\n");

        // 模拟用户点击第3张图片
        ImageProxy selectedImage = (ImageProxy) images.get(2);
        System.out.println("用户点击了第3张图片: " + selectedImage.getFileName());
        selectedImage.onClick();

        System.out.println("\n");

        // ========== 示例3：预加载机制 ==========
        System.out.println("【示例3：智能预加载 - 提升用户体验】");
        System.out.println("================================================\n");

        List<Image> gallery = new ArrayList<>();
        gallery.add(new ImageProxy("https://gallery.com/photo1.jpg", "beach.jpg"));
        gallery.add(new ImageProxy("https://gallery.com/photo2.png", "city.png"));
        gallery.add(new ImageProxy("https://gallery.com/photo3.jpg", "night.jpg"));

        System.out.println(">>> 加载画廊图片（只显示图标）：");
        for (int i = 0; i < gallery.size(); i++) {
            System.out.printf("\n图片 %d: ", i + 1);
            gallery.get(i).display();
        }

        System.out.println("\n");

        // 预加载下一批图片
        System.out.println(">>> 预加载下一批图片：");
        List<Image> nextBatch = new ArrayList<>();
        nextBatch.add(new ImageProxy("https://gallery.com/photo4.jpg", "winter.jpg"));
        nextBatch.add(new ImageProxy("https://gallery.com/photo5.png", "spring.png"));

        for (Image img : nextBatch) {
            ((ImageProxy) img).preload();
        }

        System.out.println("\n预加载已启动，用户浏览时图片可能已就绪\n");

        Thread.sleep(4000);

        System.out.println(">>> 用户浏览到预加载的图片（可能已加载完成）：");
        nextBatch.get(0).display();

        System.out.println("\n");

        // ========== 示例4：不同图片类型的图标 ==========
        System.out.println("【示例4：不同图片类型显示不同图标】");
        System.out.println("================================================\n");

        ImageType[] types = ImageType.values();
        System.out.println("支持的图片类型及对应图标：\n");

        for (ImageType type : types) {
            if (type != ImageType.UNKNOWN) {
                String fileName = "example." + type.getExtension();
                ImageIcon icon = new ImageIcon(fileName, type);
                System.out.printf("%-6s: ", type.getExtension().toUpperCase());
                System.out.println(type.getIcon());
            }
        }

        System.out.println("\n");

        // ========== 示例5：性能对比 ==========
        System.out.println("【示例5：使用代理模式 vs 直接加载 - 性能对比】");
        System.out.println("================================================\n");

        // 模拟10张大图片
        final int IMAGE_COUNT = 10;
        final double AVG_IMAGE_SIZE = 2_000_000; // 2MB
        final long AVG_DOWNLOAD_TIME = 2000; // 2秒

        System.out.println("场景：网页包含 " + IMAGE_COUNT + " 张大图片\n");

        System.out.println("不使用代理模式（直接加载所有图片）：");
        System.out.println("- 需要等待时间: " + IMAGE_COUNT + " × " + (AVG_DOWNLOAD_TIME / 1000) + "秒 = " +
                (IMAGE_COUNT * AVG_DOWNLOAD_TIME / 1000) + "秒");
        System.out.println("- 用户体验: 需要等待很长时间才能看到任何内容");
        System.out.println("- 内存占用: " + IMAGE_COUNT + " × " + (AVG_IMAGE_SIZE / 1024 / 1024) + "MB = " +
                (IMAGE_COUNT * AVG_IMAGE_SIZE / 1024 / 1024) + "MB");

        System.out.println("\n使用代理模式（先显示图标，按需加载）：");
        System.out.println("- 首次显示时间: < 0.1秒（只显示图标）");
        System.out.println("- 用户体验: 立即看到内容，可以快速浏览");
        System.out.println("- 内存占用: 根据实际查看的图片计算");
        System.out.println("- 后台加载: 用户浏览时图片在后台加载");

        System.out.println("\n性能提升：");
        System.out.println("- 响应时间: 从 " + (IMAGE_COUNT * AVG_DOWNLOAD_TIME / 1000) + "秒 降至 < 0.1秒");
        System.out.println("- 提升倍数: " + (IMAGE_COUNT * AVG_DOWNLOAD_TIME / 100) + "倍+");

        System.out.println("\n");

        // ========== 示例6：实际应用场景演示 ==========
        System.out.println("【示例6：完整应用场景演示】");
        System.out.println("================================================\n");

        simulateRealWorldUsage();

        System.out.println("\n");

        // ========== 总结 ==========
        System.out.println("【虚拟代理模式总结】");
        System.out.println("================================================\n");

        System.out.println("代理模式的优势：");
        System.out.println("  1. 延迟加载：只在需要时才加载真实对象");
        System.out.println("  2. 提升性能：先显示轻量级代理，快速响应用户");
        System.out.println("  3. 节省资源：按需加载大对象，减少内存占用");
        System.out.println("  4. 多线程支持：后台加载，不影响用户操作");
        System.out.println("  5. 透明访问：代理与真实对象接口一致，对客户端透明");

        System.out.println("\n在本图片查看器中：");
        System.out.println("  - ImageIcon: 轻量级图标，可立即显示");
        System.out.println("  - RealImage: 真实图片，需要从网络下载");
        System.out.println("  - ImageProxy: 代理类，先显示图标，延迟加载原图");
        System.out.println("  - 多线程: 后台加载，用户可继续浏览其他图片");

        System.out.println("\n适用场景：");
        System.out.println("  - 大对象初始化耗时较长");
        System.out.println("  - 需要延迟加载或按需加载");
        System.out.println("  - 需要控制访问或添加额外功能（如缓存、日志）");
        System.out.println("  - 远程对象访问（如RPC、Web服务）");
    }

    /**
     * 模拟真实世界使用场景
     */
    private static void simulateRealWorldUsage() throws InterruptedException {
        System.out.println("场景：用户访问一个包含多张图片的网页\n");

        // 步骤1：用户输入网页URL
        String url = "https://example.com/travel-blog";
        System.out.println("步骤1：用户输入网页URL");
        System.out.println("  URL: " + url);

        // 步骤2：解析网页，获取图片列表
        Thread.sleep(500);
        System.out.println("\n步骤2：解析网页，提取图片链接");
        String[] imageUrls = {
                "https://cdn.example.com/travel/beach.jpg",
                "https://cdn.example.com/travel/mountain.png",
                "https://cdn.example.com/travel/city.gif"
        };

        // 创建图片代理列表
        List<Image> travelImages = new ArrayList<>();
        for (String imageUrl : imageUrls) {
            String fileName = imageUrl.substring(imageUrl.lastIndexOf('/') + 1);
            travelImages.add(new ImageProxy(imageUrl, fileName));
        }

        System.out.println("  找到 " + travelImages.size() + " 张图片");

        // 步骤3：显示所有图片的图标（快速）
        Thread.sleep(500);
        System.out.println("\n步骤3：立即显示所有图片图标（快速响应）");
        for (int i = 0; i < travelImages.size(); i++) {
            Image img = travelImages.get(i);
            System.out.printf("\n  图片 %d: %s\n", i + 1, img.getFileName());
            System.out.println("  类型: " + img.getType().getExtension().toUpperCase());
            System.out.println("  状态: 图标已显示，原图加载中...");
        }

        // 步骤4：用户点击查看某张图片
        Thread.sleep(2000);
        System.out.println("\n\n步骤4：用户点击第1张图片查看原图");
        ImageProxy img1 = (ImageProxy) travelImages.get(0);
        img1.onClick();

        // 步骤5：用户继续浏览其他图片
        Thread.sleep(2000);
        System.out.println("\n步骤5：用户浏览第2张图片");
        ImageProxy img2 = (ImageProxy) travelImages.get(1);
        img2.display();

        System.out.println("\n\n演示完成！");
    }
}
