package cn.lixx.designpatterns.adapter;

/**
 * 加密器接口（目标接口）
 * 系统需要使用的加密接口标准
 */
public interface Encryptor {
    /**
     * 加密数据
     * @param data 需要加密的数据
     * @return 加密后的数据
     */
    String encrypt(String data);

    /**
     * 解密数据
     * @param encryptedData 加密的数据
     * @return 解密后的数据
     */
    String decrypt(String encryptedData);
}