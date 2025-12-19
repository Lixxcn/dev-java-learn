package cn.lixx.designpatterns.factorymethod.reader;

/**
 * JPG图片读取器
 * 专门用于读取JPG/JPEG格式的图片
 */
public class JpgReader implements ImageReader {

    @Override
    public String readImage(String filePath) {
        if (!isFormatSupported(filePath)) {
            throw new IllegalArgumentException("不支持的文件格式，期望: JPG/JPEG, 实际: " + getExtension(filePath));
        }

        // 模拟读取JPG图片的过程
        System.out.println("正在读取JPG图片: " + filePath);

        // 模拟JPG特有的处理
        int quality = extractQuality(filePath);
        String colorSpace = extractColorSpace(filePath);

        return String.format("成功读取JPG图片 '%s'，质量: %d%%, 色彩空间: %s",
                           filePath, quality, colorSpace);
    }

    @Override
    public String getSupportedFormat() {
        return "JPG";
    }

    /**
     * 重写isFormatSupported方法，支持.jpg和.jpeg两种扩展名
     */
    @Override
    public boolean isFormatSupported(String filePath) {
        if (filePath == null || filePath.isEmpty()) {
            return false;
        }
        String extension = filePath.substring(filePath.lastIndexOf('.') + 1).toLowerCase();
        // JPG格式支持.jpg和.jpeg两种扩展名
        return "jpg".equals(extension) || "jpeg".equals(extension);
    }

    /**
     * 模拟提取JPG质量
     */
    private int extractQuality(String filePath) {
        // 这里模拟实现，实际应该解析JPG文件头
        return (int) (Math.random() * 40) + 60; // 随机返回60-99%质量
    }

    /**
     * 模拟提取色彩空间
     */
    private String extractColorSpace(String filePath) {
        String[] colorSpaces = {"RGB", "YCbCr", "Grayscale", "CMYK"};
        return colorSpaces[(int) (Math.random() * colorSpaces.length)];
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