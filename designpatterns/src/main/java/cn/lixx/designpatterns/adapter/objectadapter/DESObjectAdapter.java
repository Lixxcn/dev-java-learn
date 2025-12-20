package cn.lixx.designpatterns.adapter.objectadapter;

import cn.lixx.designpatterns.adapter.Encryptor;
import cn.lixx.designpatterns.adapter.thirdparty.DESEncrypt;

/**
 * DES加密对象适配器
 * 使用对象适配器模式，将第三方DES加密工具适配到我们的Encryptor接口
 */
public class DESObjectAdapter implements Encryptor {
    private String desKey;

    public DESObjectAdapter(String desKey) {
        this.desKey = desKey;
    }

    @Override
    public String encrypt(String data) {
        // 调用第三方DES加密方法
        return DESEncrypt.doDESEncrypt(data, desKey);
    }

    @Override
    public String decrypt(String encryptedData) {
        // 调用第三方DES解密方法
        return DESEncrypt.doDESDecrypt(encryptedData, desKey);
    }

    /**
     * 获取密钥长度
     * @return 密钥长度
     */
    public int getKeyLength() {
        return desKey.length();
    }
}