package cn.lixx.designpatterns.factorymethod.reader;

/**
 * PNG图片读取器
 * 专门用于读取PNG格式的图片
 */
public class PngReader implements ImageReader {

    @Override
    public String readImage(String filePath) {
        if (!isFormatSupported(filePath)) {
            throw new IllegalArgumentException("不支持的文件格式，期望: PNG, 实际: " + getExtension(filePath));
        }

        // 模拟读取PNG图片的过程
        System.out.println("正在读取PNG图片: " + filePath);

        // 模拟PNG特有的处理
        boolean hasTransparency = hasTransparency(filePath);
        int bitDepth = extractBitDepth(filePath);
        String compression = extractCompressionType(filePath);

        return String.format("成功读取PNG图片 '%s'，位深度: %d位, 透明度: %s, 压缩: %s",
                           filePath, bitDepth, hasTransparency ? "支持" : "不支持", compression);
    }

    @Override
    public String getSupportedFormat() {
        return "PNG";
    }

    /**
     * 模拟检查是否支持透明度
     */
    private boolean hasTransparency(String filePath) {
        // PNG天然支持透明度
        return true;
    }

    /**
     * 模拟提取位深度
     */
    private int extractBitDepth(String filePath) {
        int[] bitDepths = {8, 16, 24, 32};
        return bitDepths[(int) (Math.random() * bitDepths.length)];
    }

    /**
     * 模拟提取压缩类型
     */
    private String extractCompressionType(String filePath) {
        return "DEFLATE"; // PNG只使用DEFLATE压缩
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