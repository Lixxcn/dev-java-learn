package cn.lixx.designpatterns.factorymethod.reader;

/**
 * GIF图片读取器
 * 专门用于读取GIF格式的图片
 */
public class GifReader implements ImageReader {

    @Override
    public String readImage(String filePath) {
        if (!isFormatSupported(filePath)) {
            throw new IllegalArgumentException("不支持的文件格式，期望: GIF, 实际: " + getExtension(filePath));
        }

        // 模拟读取GIF图片的过程
        System.out.println("正在读取GIF图片: " + filePath);

        // 模拟GIF特有的处理
        int frames = extractFrameCount(filePath);
        return String.format("成功读取GIF图片 '%s'，共 %d 帧", filePath, frames);
    }

    @Override
    public String getSupportedFormat() {
        return "GIF";
    }

    /**
     * 模拟提取GIF帧数
     * @param filePath 文件路径
     * @return 帧数
     */
    private int extractFrameCount(String filePath) {
        // 这里模拟实现，实际应该解析GIF文件头
        return (int) (Math.random() * 50) + 1; // 随机返回1-50帧
    }

    /**
     * 获取文件扩展名
     */
    private String getExtension(String filePath) {
        if (filePath == null || filePath.isEmpty()) {
            return "";
        }
        int lastDot = filePath.lastIndexOf('.');
        return lastDot > 0 ? filePath.substring(lastDot + 1) : "";
    }
}