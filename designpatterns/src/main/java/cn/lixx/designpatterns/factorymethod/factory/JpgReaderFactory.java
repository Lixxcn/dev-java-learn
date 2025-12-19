package cn.lixx.designpatterns.factorymethod.factory;

import cn.lixx.designpatterns.factorymethod.reader.ImageReader;
import cn.lixx.designpatterns.factorymethod.reader.JpgReader;

/**
 * JPG图片读取器工厂
 * 负责创建JPG/JPEG格式的图片读取器
 */
public class JpgReaderFactory implements ImageReaderFactory {

    @Override
    public ImageReader createImageReader() {
        return new JpgReader();
    }

    @Override
    public String getSupportedFormat() {
        return "JPG";
    }

    /**
     * 重写canHandle方法，支持.jpg和.jpeg两种扩展名
     */
    @Override
    public boolean canHandle(String filePath) {
        if (filePath == null || filePath.isEmpty()) {
            return false;
        }
        String extension = filePath.substring(filePath.lastIndexOf('.') + 1).toLowerCase();
        // JPG工厂支持.jpg和.jpeg两种扩展名
        return "jpg".equals(extension) || "jpeg".equals(extension);
    }

    /**
     * 工厂特有的初始化方法
     * @param qualityHint 质量提示参数
     * @return 配置好的JPG读取器
     */
    public ImageReader createJpgReader(int qualityHint) {
        JpgReader reader = new JpgReader();
        // 这里可以根据质量提示进行额外配置
        if (qualityHint > 90) {
            System.out.println("使用高质量模式读取JPG");
        } else if (qualityHint < 50) {
            System.out.println("使用快速模式读取JPG");
        }
        return reader;
    }
}