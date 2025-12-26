package cn.lixx.designpatterns.decorator;

/**
 * 加密器接口（抽象构件）
 * 定义了加密操作的抽象接口
 */
public interface Cipher {
    /**
     * 加密字符串
     * @param plainText 明文
     * @return 密文
     */
    String encrypt(String plainText);

    /**
     * 获取加密器描述信息
     * @return 描述信息
     */
    default String getDescription() {
        return "基础加密器";
    }
}