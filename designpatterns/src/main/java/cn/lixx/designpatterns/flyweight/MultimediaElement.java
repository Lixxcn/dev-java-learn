package cn.lixx.designpatterns.flyweight;

/**
 * 多媒体元素接口（抽象享元）
 * 定义多媒体元素的公共接口
 */
public interface MultimediaElement {
    /**
     * 显示多媒体元素
     * @param externalState 外部状态（位置、大小等信息）
     */
    void display(ElementState externalState);

    /**
     * 获取元素类型
     * @return 元素类型
     */
    String getType();

    /**
     * 获取元素ID（作为共享的键）
     * @return 元素ID
     */
    String getId();

    /**
     * 获取文件路径（内部状态）
     * @return 文件路径
     */
    String getFilePath();

    /**
     * 获取文件大小（内部状态）
     * @return 文件大小（字节）
     */
    long getFileSize();

    /**
     * 获取内部状态信息
     * @return 内部状态描述
     */
    String getInternalStateInfo();
}