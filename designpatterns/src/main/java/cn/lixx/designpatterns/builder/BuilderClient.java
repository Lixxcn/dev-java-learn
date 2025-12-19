package cn.lixx.designpatterns.builder;

import cn.lixx.designpatterns.builder.builder.*;
import cn.lixx.designpatterns.builder.director.VideoPlayerDirector;
import cn.lixx.designpatterns.builder.product.VideoPlayer;

/**
 * 建造者模式客户端测试代码
 */
public class BuilderClient {
    public static void main(String[] args) {
        System.out.println("🎬 Sunny软件公司视频播放器演示");
        System.out.println("================================\n");

        // ========== 使用指挥者构建不同模式的播放器 ==========

        // 1. 完整模式
        System.out.println("📺 1. 完整模式播放器:");
        VideoPlayerDirector fullDirector = new VideoPlayerDirector(new FullModeBuilder());
        VideoPlayer fullPlayer = fullDirector.constructFullPlayer();
        fullPlayer.display();

        // 2. 精简模式
        System.out.println("\n📱 2. 精简模式播放器:");
        VideoPlayerDirector simpleDirector = new VideoPlayerDirector(new SimpleModeBuilder());
        VideoPlayer simplePlayer = simpleDirector.constructSimplePlayer();
        simplePlayer.display();

        // 3. 记忆模式
        System.out.println("\n🧠 3. 记忆模式播放器:");
        VideoPlayerDirector memoryDirector = new VideoPlayerDirector(new MemoryModeBuilder());
        VideoPlayer memoryPlayer = memoryDirector.constructMemoryPlayer();
        memoryPlayer.display();

        // 4. 网络模式
        System.out.println("\n🌐 4. 网络模式播放器:");
        VideoPlayerDirector networkDirector = new VideoPlayerDirector(new NetworkModeBuilder());
        VideoPlayer networkPlayer = networkDirector.constructNetworkPlayer();
        networkPlayer.display();

        // ========== 直接使用建造者（不通过指挥者） ==========
        System.out.println("\n🔧 5. 直接使用建造者（无指挥者）:");
        FullModeBuilder builder = new FullModeBuilder();
        builder.buildMenu();
        builder.buildMainWindow();
        builder.buildControlBar();
        VideoPlayer customPlayer = builder.getVideoPlayer();
        customPlayer.display();

        // ========== 自定义构建模式 ==========
        System.out.println("\n🎨 6. 自定义构建模式:");
        VideoPlayerDirector customDirector = new VideoPlayerDirector(new FullModeBuilder());
        VideoPlayer miniPlayer = customDirector.constructCustomPlayer(
            false,  // 不要菜单
            false,  // 不要播放列表
            true,   // 要主窗口
            true,   // 要控制条
            false,  // 不要收藏列表
            false   // 不要状态栏
        );
        System.out.println("自定义迷你播放器:");
        miniPlayer.display();

        // ========== 建造者模式总结 ==========
        System.out.println("\n" + "=".repeat(50));
        System.out.println("📚 建造者模式总结:");
        System.out.println("=".repeat(50));
        System.out.println("1. 优点:");
        System.out.println("   - 分离了对象的构建过程和表示");
        System.out.println("   - 相同的构建过程可以创建不同的表示");
        System.out.println("   - 建造者独立，容易扩展");
        System.out.println("   - 可以对构建过程进行更精细的控制");

        System.out.println("\n2. 适用场景:");
        System.out.println("   - 需要生成的对象具有复杂的内部结构");
        System.out.println("   - 需要生成的对象内部属性相互依赖");
        System.out.println("   - 需要隔离复杂对象的创建和使用");

        System.out.println("\n3. 与其他模式的区别:");
        System.out.println("   - 与抽象工厂模式：建造者注重一步步构建，抽象工厂注重产品族");
        System.out.println("   - 与工厂方法模式：建造者创建复杂对象，工厂创建简单对象");

        System.out.println("\n4. 在本例中的应用:");
        System.out.println("   - VideoPlayer: 复杂产品，包含多个组件");
        System.out.println("   - Builder: 抽象建造者，定义构建步骤");
        System.out.println("   - 具体Builder: 实现不同模式的构建");
        System.out.println("   - Director: 控制构建流程，封装常用构建组合");
        System.out.println("=".repeat(50));
    }
}