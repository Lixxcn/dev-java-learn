package cn.lixx.designpatterns.flyweight.concreteflyweight;

import cn.lixx.designpatterns.flyweight.ElementState;

/**
 * 动画元素类（具体享元）
 * 动画是共享的，相同的动画只保存一份
 */
public class AnimationElement extends AbstractMultimediaElement {
    private int width;          // 宽度
    private int height;         // 高度
    private int frameCount;     // 帧数
    private int frameRate;      // 帧率（FPS）
    private int duration;       // 时长（秒）

    public AnimationElement(String id, String filePath) {
        super(id, filePath);
        // 模拟获取动画属性
        this.width = (int)(Math.random() * 2000) + 200;  // 200-2200
        this.height = (int)(Math.random() * 1500) + 200; // 200-1700
        this.frameCount = (int)(Math.random() * 100) + 10;     // 10-110帧
        this.frameRate = 24;  // 默认24帧/秒
        this.duration = frameCount / frameRate;
    }

    public AnimationElement(String id, String filePath, int width, int height,
                           int frameCount, int frameRate) {
        super(id, filePath);
        this.width = width;
        this.height = height;
        this.frameCount = frameCount;
        this.frameRate = frameRate;
        this.duration = frameCount / frameRate;
    }

    @Override
    public void display(ElementState externalState) {
        System.out.printf("🎬 显示动画: %s | 尺寸: %dx%d | %d帧 | %d秒 | %s%n",
            fileName, width, height, frameCount, duration, externalState.getFullInfo());
        System.out.println("   └─ 内部状态: " + getInternalStateInfo());
    }

    @Override
    public String getType() {
        return "动画";
    }

    @Override
    public String getInternalStateInfo() {
        return String.format("%s, 尺寸: %dx%d, 帧数: %d, 帧率: %d FPS, 时长: %d秒",
            super.getInternalStateInfo(), width, height, frameCount, frameRate, duration);
    }

    // Getter方法
    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getFrameCount() {
        return frameCount;
    }

    public int getFrameRate() {
        return frameRate;
    }

    public int getDuration() {
        return duration;
    }
}