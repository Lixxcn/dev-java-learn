package cn.lixx.designpatterns.adapter.classadapter;

import cn.lixx.designpatterns.adapter.Encryptor;
import cn.lixx.designpatterns.adapter.thirdparty.DESEncrypt;

/**
 * DES加密类适配器
 * 使用类适配器模式，通过继承第三方DES加密类并实现Encryptor接口
 * 将第三方DES加密功能适配到系统的标准加密接口
 */
public class DESClassAdapter extends DESEncrypt implements Encryptor {
    private String desKey;

    public DESClassAdapter(String desKey) {
        super();
        this.desKey = desKey;
    }

    /**
     * 使用继承的静态方法实现加密
     * @param data 需要加密的数据
     * @return 加密后的数据
     */
    @Override
    public String encrypt(String data) {
        return super.doDESEncrypt(data, desKey);
    }

    /**
     * 使用继承的静态方法实现解密
     * @param encryptedData 加密的数据
     * @return 解密后的数据
     */
    @Override
    public String decrypt(String encryptedData) {
        return super.doDESDecrypt(encryptedData, desKey);
    }

    /**
     * 获取密钥信息
     * @return 密钥信息
     */
    public String getKeyInfo() {
        return "DES加密器，密钥长度: " + desKey.length();
    }
}