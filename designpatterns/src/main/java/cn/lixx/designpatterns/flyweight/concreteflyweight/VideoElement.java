package cn.lixx.designpatterns.flyweight.concreteflyweight;

import cn.lixx.designpatterns.flyweight.ElementState;

/**
 * 视频元素类（具体享元）
 * 视频是共享的，相同的视频只保存一份
 */
public class VideoElement extends AbstractMultimediaElement {
    private int width;          // 宽度
    private int height;         // 高度
    private int duration;       // 时长（秒）
    private int bitRate;        // 比特率（kbps）
    private String codec;       // 编码格式
    private boolean hasAudio;   // 是否有音频

    public VideoElement(String id, String filePath) {
        super(id, filePath);
        // 模拟获取视频属性
        this.width = (int)(Math.random() * 3000) + 640;   // 640-3640
        this.height = (int)(Math.random() * 2000) + 480;  // 480-2480
        this.duration = (int)(Math.random() * 600) + 30;  // 30-630秒
        this.bitRate = (int)(Math.random() * 5000) + 1000; // 1000-6000 kbps
        this.codec = "H.264";
        this.hasAudio = true;
    }

    public VideoElement(String id, String filePath, int width, int height,
                       int duration, int bitRate, String codec, boolean hasAudio) {
        super(id, filePath);
        this.width = width;
        this.height = height;
        this.duration = duration;
        this.bitRate = bitRate;
        this.codec = codec;
        this.hasAudio = hasAudio;
    }

    @Override
    public void display(ElementState externalState) {
        System.out.printf("🎥 显示视频: %s | 尺寸: %dx%d | %d分%d秒 | %s | %s%n",
            fileName, width, height, duration / 60, duration % 60,
            formatBitRate(), externalState.getFullInfo());
        System.out.println("   └─ 内部状态: " + getInternalStateInfo());
    }

    @Override
    public String getType() {
        return "视频";
    }

    @Override
    public String getInternalStateInfo() {
        return String.format("%s, 尺寸: %dx%d, 时长: %d分%d秒, 比特率: %s, 编码: %s, 音频: %s",
            super.getInternalStateInfo(), width, height,
            duration / 60, duration % 60, formatBitRate(), codec, hasAudio ? "是" : "否");
    }

    /**
     * 格式化比特率
     * @return 格式化后的比特率
     */
    private String formatBitRate() {
        if (bitRate < 1000) {
            return bitRate + " kbps";
        } else {
            return String.format("%.2f Mbps", bitRate / 1000.0);
        }
    }

    /**
     * 格式化时长
     * @return 格式化后的时长
     */
    public String formatDuration() {
        int minutes = duration / 60;
        int seconds = duration % 60;
        return String.format("%d:%02d", minutes, seconds);
    }

    // Getter方法
    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getDuration() {
        return duration;
    }

    public int getBitRate() {
        return bitRate;
    }

    public String getCodec() {
        return codec;
    }

    public boolean hasAudio() {
        return hasAudio;
    }
}