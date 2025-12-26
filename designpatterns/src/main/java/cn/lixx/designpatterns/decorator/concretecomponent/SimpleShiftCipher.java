package cn.lixx.designpatterns.decorator.concretecomponent;

import cn.lixx.designpatterns.decorator.Cipher;

/**
 * 简单移位加密器（具体构件）
 * 通过对字母进行移位实现最简单的加密算法
 * 这是最基础的加密实现，其他装饰器可以在此基础上添加更多加密功能
 */
public class SimpleShiftCipher implements Cipher {
    private int shift; // 移位位数

    public SimpleShiftCipher() {
        this.shift = 3; // 默认移位3位
    }

    public SimpleShiftCipher(int shift) {
        this.shift = shift;
    }

    @Override
    public String encrypt(String plainText) {
        if (plainText == null || plainText.isEmpty()) {
            return plainText;
        }

        StringBuilder encrypted = new StringBuilder();

        for (int i = 0; i < plainText.length(); i++) {
            char c = plainText.charAt(i);

            if (Character.isLetter(c)) {
                // 保存大小写信息
                boolean isUpperCase = Character.isUpperCase(c);
                char base = isUpperCase ? 'A' : 'a';

                // 移位计算
                char shifted = (char) ((c - base + shift) % 26 + base);
                encrypted.append(shifted);
            } else {
                // 非字母字符保持不变
                encrypted.append(c);
            }
        }

        return encrypted.toString();
    }

    @Override
    public String getDescription() {
        return "简单移位加密器（移位" + shift + "位）";
    }

    /**
     * 解密（移位加密的逆操作）
     * @param cipherText 密文
     * @return 明文
     */
    public String decrypt(String cipherText) {
        if (cipherText == null || cipherText.isEmpty()) {
            return cipherText;
        }

        StringBuilder decrypted = new StringBuilder();

        for (int i = 0; i < cipherText.length(); i++) {
            char c = cipherText.charAt(i);

            if (Character.isLetter(c)) {
                boolean isUpperCase = Character.isUpperCase(c);
                char base = isUpperCase ? 'A' : 'a';

                // 反向移位
                char shifted = (char) ((c - base - shift + 26) % 26 + base);
                decrypted.append(shifted);
            } else {
                decrypted.append(c);
            }
        }

        return decrypted.toString();
    }

    /**
     * 设置移位位数
     * @param shift 移位位数
     */
    public void setShift(int shift) {
        this.shift = shift;
    }

    /**
     * 获取移位位数
     * @return 移位位数
     */
    public int getShift() {
        return shift;
    }
}