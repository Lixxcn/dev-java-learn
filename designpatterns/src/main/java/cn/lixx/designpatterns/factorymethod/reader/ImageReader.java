package cn.lixx.designpatterns.factorymethod.reader;

/**
 * 图片读取器接口
 * 定义了读取图片的基本操作
 */
public interface ImageReader {

    /**
     * 读取图片
     * @param filePath 图片文件路径
     * @return 读取结果信息
     */
    String readImage(String filePath);

    /**
     * 获取支持的图片格式
     * @return 支持的格式名称
     */
    String getSupportedFormat();

    /**
     * 验证文件格式是否支持
     * @param filePath 文件路径
     * @return 是否支持
     */
    default boolean isFormatSupported(String filePath) {
        if (filePath == null || filePath.isEmpty()) {
            return false;
        }
        String extension = filePath.substring(filePath.lastIndexOf('.') + 1).toLowerCase();
        return getSupportedFormat().equalsIgnoreCase(extension);
    }
}