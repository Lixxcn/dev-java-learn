package cn.lixx.designpatterns.factorymethod.factory;

import cn.lixx.designpatterns.factorymethod.reader.ImageReader;
import cn.lixx.designpatterns.factorymethod.reader.PngReader;

/**
 * PNG图片读取器工厂
 * 负责创建PNG格式的图片读取器
 */
public class PngReaderFactory implements ImageReaderFactory {

    @Override
    public ImageReader createImageReader() {
        return new PngReader();
    }

    @Override
    public String getSupportedFormat() {
        return "PNG";
    }

    /**
     * 工厂特有的初始化方法
     * @param preserveTransparency 是否保留透明度信息
     * @return 配置好的PNG读取器
     */
    public ImageReader createPngReader(boolean preserveTransparency) {
        PngReader reader = new PngReader();
        // 这里可以根据透明度设置进行额外配置
        if (preserveTransparency) {
            System.out.println("保留PNG透明度信息");
        }
        return reader;
    }
}