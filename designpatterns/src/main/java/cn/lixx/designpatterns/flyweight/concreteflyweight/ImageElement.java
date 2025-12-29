package cn.lixx.designpatterns.flyweight.concreteflyweight;

import cn.lixx.designpatterns.flyweight.ElementState;

/**
 * 图片元素类（具体享元）
 * 图片是共享的，相同的图片只保存一份
 */
public class ImageElement extends AbstractMultimediaElement {
    private int width;          // 原始宽度
    private int height;         // 原始高度
    private String colorMode;   // 色彩模式（RGB、CMYK等）
    private int dpi;            // 分辨率

    public ImageElement(String id, String filePath) {
        super(id, filePath);
        // 模拟获取图片属性
        this.width = (int)(Math.random() * 4000) + 100;  // 100-4100
        this.height = (int)(Math.random() * 3000) + 100; // 100-3100
        this.colorMode = "RGB";
        this.dpi = 72;
    }

    public ImageElement(String id, String filePath, int width, int height, String colorMode, int dpi) {
        super(id, filePath);
        this.width = width;
        this.height = height;
        this.colorMode = colorMode;
        this.dpi = dpi;
    }

    @Override
    public void display(ElementState externalState) {
        System.out.printf("📷 显示图片: %s | 原始尺寸: %dx%d | %s%n",
            fileName, width, height, externalState.getFullInfo());
        System.out.println("   └─ 内部状态: " + getInternalStateInfo());
    }

    @Override
    public String getType() {
        return "图片";
    }

    @Override
    public String getInternalStateInfo() {
        return String.format("%s, 原始尺寸: %dx%d, 色彩模式: %s, 分辨率: %d DPI",
            super.getInternalStateInfo(), width, height, colorMode, dpi);
    }

    // Getter方法
    public int getOriginalWidth() {
        return width;
    }

    public int getOriginalHeight() {
        return height;
    }

    public String getColorMode() {
        return colorMode;
    }

    public int getDpi() {
        return dpi;
    }
}