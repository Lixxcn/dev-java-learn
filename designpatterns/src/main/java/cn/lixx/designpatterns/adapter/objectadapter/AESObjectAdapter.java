package cn.lixx.designpatterns.adapter.objectadapter;

import cn.lixx.designpatterns.adapter.Encryptor;
import cn.lixx.designpatterns.adapter.thirdparty.AESEncryptor;

/**
 * AES加密对象适配器
 * 使用对象适配器模式，将第三方AES加密器适配到我们的Encryptor接口
 */
public class AESObjectAdapter implements Encryptor {
    private AESEncryptor aesEncryptor;

    public AESObjectAdapter(String secretKey) {
        // 持有第三方AES加密器的实例
        this.aesEncryptor = new AESEncryptor(secretKey);
    }

    @Override
    public String encrypt(String data) {
        // 调用第三方AES加密方法
        return aesEncryptor.aesEncode(data);
    }

    @Override
    public String decrypt(String encryptedData) {
        // 调用第三方AES解密方法
        return aesEncryptor.aesDecode(encryptedData);
    }

    /**
     * 获取密钥信息
     * @return 密钥信息
     */
    public String getKeyInfo() {
        return aesEncryptor.getKeyInfo();
    }
}