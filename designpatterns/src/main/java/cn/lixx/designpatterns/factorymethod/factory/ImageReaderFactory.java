package cn.lixx.designpatterns.factorymethod.factory;

import cn.lixx.designpatterns.factorymethod.reader.ImageReader;

/**
 * 图片读取器工厂接口
 * 定义了创建图片读取器的工厂方法
 */
public interface ImageReaderFactory {

    /**
     * 工厂方法：创建图片读取器
     * @return 图片读取器实例
     */
    ImageReader createImageReader();

    /**
     * 获取工厂支持的图片格式
     * @return 支持的格式名称
     */
    String getSupportedFormat();

    /**
     * 验证文件路径是否适合此工厂
     * @param filePath 文件路径
     * @return 是否适合
     */
    default boolean canHandle(String filePath) {
        if (filePath == null || filePath.isEmpty()) {
            return false;
        }
        String extension = filePath.substring(filePath.lastIndexOf('.') + 1).toLowerCase();
        return getSupportedFormat().equalsIgnoreCase(extension);
    }
}