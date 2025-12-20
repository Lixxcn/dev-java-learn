package cn.lixx.designpatterns.adapter.objectadapter;

import cn.lixx.designpatterns.adapter.Encryptor;
import cn.lixx.designpatterns.adapter.thirdparty.MD5EncryptUtil;

/**
 * MD5加密对象适配器
 * 使用对象适配器模式，将第三方MD5加密工具适配到我们的Encryptor接口
 * 注意：MD5是单向加密，无法解密，这里做模拟处理
 */
public class MD5ObjectAdapter implements Encryptor {
    public MD5ObjectAdapter() {
        // MD5EncryptUtil是静态工具类，无需实例化
    }

    @Override
    public String encrypt(String data) {
        // 调用第三方MD5加密方法
        String encrypted = MD5EncryptUtil.encode(data);
        String salt = MD5EncryptUtil.getSalt(data);
        return encrypted + "|" + salt;
    }

    @Override
    public String decrypt(String encryptedData) {
        // MD5是单向加密，无法解密
        // 这里返回提示信息，实际应用中可能需要其他处理方式
        return "MD5为单向加密，无法解密原始数据";
    }
}