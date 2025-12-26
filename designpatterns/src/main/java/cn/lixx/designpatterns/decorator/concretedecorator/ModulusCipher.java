package cn.lixx.designpatterns.decorator.concretedecorator;

import cn.lixx.designpatterns.decorator.Cipher;
import cn.lixx.designpatterns.decorator.concretecomponent.SimpleShiftCipher;
import cn.lixx.designpatterns.decorator.decorator.CipherDecorator;

/**
 * 求模加密装饰器（具体装饰器）
 * 对加密结果进行求模运算，实现更高级的加密
 */
public class ModulusCipher extends CipherDecorator {
    private int modulus; // 模数

    public ModulusCipher(Cipher cipher) {
        this(cipher, 128);
    }

    public ModulusCipher(Cipher cipher, int modulus) {
        super(cipher);
        this.modulus = modulus;
    }

    @Override
    public String encrypt(String plainText) {
        // 先调用被装饰对象的encrypt方法进行加密
        String encrypted = decoratedCipher.encrypt(plainText);

        // 然后对加密结果进行求模运算
        return applyModulus(encrypted);
    }

    /**
     * 应用求模运算
     * 将每个字符的ASCII码与模数进行运算
     * 
     * @param text 输入文本
     * @return 求模后的结果
     */
    private String applyModulus(String text) {
        if (text == null || text.isEmpty()) {
            return text;
        }

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);

            // 对字符的ASCII值进行求模运算
            int modValue = (int) c % modulus;

            // 将结果转换回字符（添加模数以保持在可打印范围内）
            char newChar = (char) (modValue + 33); // 从33开始以确保可打印

            result.append(newChar);
        }

        return result.toString();
    }

    @Override
    public String getDescription() {
        return decoratedCipher.getDescription() + " + 求模加密(模" + modulus + ")";
    }

    /**
     * 解密（逆向求模运算）
     * 
     * @param cipherText 密文
     * @return 明文
     */
    public String decrypt(String cipherText) {
        if (cipherText == null || cipherText.isEmpty()) {
            return cipherText;
        }

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < cipherText.length(); i++) {
            char c = cipherText.charAt(i);
            int originalValue = ((int) c - 33);

            // 尝试还原（可能有多个解，取最小值）
            char restoredChar = (char) (originalValue);

            result.append(restoredChar);
        }

        // 如果被装饰对象是SimpleShiftCipher，可以继续解密
        if (decoratedCipher instanceof SimpleShiftCipher) {
            return ((SimpleShiftCipher) decoratedCipher).decrypt(result.toString());
        }

        return result.toString();
    }

    /**
     * 设置模数
     * 
     * @param modulus 模数
     */
    public void setModulus(int modulus) {
        this.modulus = modulus;
    }

    /**
     * 获取模数
     * 
     * @return 模数
     */
    public int getModulus() {
        return modulus;
    }
}