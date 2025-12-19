package cn.lixx.designpatterns.factorymethod.reader;

/**
 * BMP图片读取器
 * 专门用于读取BMP格式的图片
 */
public class BmpReader implements ImageReader {

    @Override
    public String readImage(String filePath) {
        if (!isFormatSupported(filePath)) {
            throw new IllegalArgumentException("不支持的文件格式，期望: BMP, 实际: " + getExtension(filePath));
        }

        // 模拟读取BMP图片的过程
        System.out.println("正在读取BMP图片: " + filePath);

        // 模拟BMP特有的处理
        int colorDepth = extractColorDepth(filePath);
        long fileSize = extractFileSize(filePath);
        boolean isCompressed = isCompressed(filePath);

        return String.format("成功读取BMP图片 '%s'，色深: %d位, 文件大小: %dKB, 压缩: %s",
                           filePath, colorDepth, fileSize, isCompressed ? "是" : "否");
    }

    @Override
    public String getSupportedFormat() {
        return "BMP";
    }

    /**
     * 模拟提取颜色深度
     */
    private int extractColorDepth(String filePath) {
        int[] colorDepths = {1, 4, 8, 16, 24, 32};
        return colorDepths[(int) (Math.random() * colorDepths.length)];
    }

    /**
     * 模拟提取文件大小
     */
    private long extractFileSize(String filePath) {
        // 模拟文件大小，返回10KB到10MB之间的值
        return (long) (Math.random() * 10000 + 10);
    }

    /**
     * 模拟检查是否压缩
     */
    private boolean isCompressed(String filePath) {
        // BMP通常不压缩，但也可以有RLE压缩
        return Math.random() < 0.2; // 20%的概率是压缩的
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