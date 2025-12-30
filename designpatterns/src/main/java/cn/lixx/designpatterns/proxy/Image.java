package cn.lixx.designpatterns.proxy;

/**
 * 抽象主题：图片接口
 * 定义图片的显示操作
 */
public interface Image {

    /**
     * 显示图片
     * 在代理模式下，首次调用时只显示图标，点击后才加载原图
     */
    void display();

    /**
     * 获取图片文件名
     */
    String getFileName();

    /**
     * 获取图片URL
     */
    String getUrl();

    /**
     * 获取图片大小（字节）
     * 如果图片未加载完成，返回-1
     */
    long getSize();

    /**
     * 检查图片是否已加载
     */
    boolean isLoaded();

    /**
     * 获取图片类型
     */
    ImageType getType();
}
