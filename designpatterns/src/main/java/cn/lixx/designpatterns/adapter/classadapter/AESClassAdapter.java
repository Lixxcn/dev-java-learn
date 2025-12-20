package cn.lixx.designpatterns.adapter.classadapter;

import cn.lixx.designpatterns.adapter.Encryptor;
import cn.lixx.designpatterns.adapter.thirdparty.AESEncryptor;

/**
 * AES加密类适配器
 * 使用类适配器模式，通过继承第三方AES加密器并实现Encryptor接口
 * 将第三方AES加密功能适配到系统的标准加密接口
 */
public class AESClassAdapter extends AESEncryptor implements Encryptor {

    public AESClassAdapter(String secretKey) {
        super(secretKey);
    }

    /**
     * 直接使用父类的aesEncode方法实现加密
     * @param data 需要加密的数据
     * @return 加密后的数据
     */
    @Override
    public String encrypt(String data) {
        return super.aesEncode(data);
    }

    /**
     * 直接使用父类的aesDecode方法实现解密
     * @param encryptedData 加密的数据
     * @return 解密后的数据
     */
    @Override
    public String decrypt(String encryptedData) {
        return super.aesDecode(encryptedData);
    }
}