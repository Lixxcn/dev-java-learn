package cn.lixx.designpatterns.factorymethod.factory;

import cn.lixx.designpatterns.factorymethod.reader.ImageReader;
import cn.lixx.designpatterns.factorymethod.reader.BmpReader;

/**
 * BMP图片读取器工厂
 * 负责创建BMP格式的图片读取器
 */
public class BmpReaderFactory implements ImageReaderFactory {

    @Override
    public ImageReader createImageReader() {
        return new BmpReader();
    }

    @Override
    public String getSupportedFormat() {
        return "BMP";
    }

    /**
     * 工厂特有的初始化方法
     * @param optimizeMemory 是否优化内存使用
     * @return 配置好的BMP读取器
     */
    public ImageReader createBmpReader(boolean optimizeMemory) {
        BmpReader reader = new BmpReader();
        // 这里可以根据内存优化设置进行额外配置
        if (optimizeMemory) {
            System.out.println("使用内存优化模式读取BMP");
        }
        return reader;
    }
}