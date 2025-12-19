package cn.lixx.designpatterns.factorymethod.factory;

import cn.lixx.designpatterns.factorymethod.reader.ImageReader;
import cn.lixx.designpatterns.factorymethod.reader.GifReader;

/**
 * GIF图片读取器工厂
 * 负责创建GIF格式的图片读取器
 */
public class GifReaderFactory implements ImageReaderFactory {

    @Override
    public ImageReader createImageReader() {
        return new GifReader();
    }

    @Override
    public String getSupportedFormat() {
        return "GIF";
    }

    /**
     * 工厂特有的初始化方法
     * 可以在创建读取器前进行一些特殊配置
     * @param enableAnimation 是否启用动画支持
     * @return 配置好的GIF读取器
     */
    public ImageReader createGifReader(boolean enableAnimation) {
        GifReader reader = new GifReader();
        // 这里可以根据参数进行额外配置
        if (enableAnimation) {
            System.out.println("启用GIF动画支持");
        }
        return reader;
    }
}