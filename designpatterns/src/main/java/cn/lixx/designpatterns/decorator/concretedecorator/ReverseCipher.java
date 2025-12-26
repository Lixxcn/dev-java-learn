package cn.lixx.designpatterns.decorator.concretedecorator;

import cn.lixx.designpatterns.decorator.Cipher;
import cn.lixx.designpatterns.decorator.concretecomponent.SimpleShiftCipher;
import cn.lixx.designpatterns.decorator.decorator.CipherDecorator;

/**
 * 逆向输出加密装饰器（具体装饰器）
 * 对加密结果进行逆向输出
 */
public class ReverseCipher extends CipherDecorator {

    public ReverseCipher(Cipher cipher) {
        super(cipher);
    }

    @Override
    public String encrypt(String plainText) {
        // 先调用被装饰对象的encrypt方法进行加密
        String encrypted = decoratedCipher.encrypt(plainText);

        // 然后对加密结果进行逆向
        return reverse(encrypted);
    }

    /**
     * 反转字符串
     * 
     * @param text 原始字符串
     * @return 反转后的字符串
     */
    private String reverse(String text) {
        if (text == null || text.isEmpty()) {
            return text;
        }

        StringBuilder reversed = new StringBuilder(text.length());
        for (int i = text.length() - 1; i >= 0; i--) {
            reversed.append(text.charAt(i));
        }

        return reversed.toString();
    }

    @Override
    public String getDescription() {
        return decoratedCipher.getDescription() + " + 逆向输出加密";
    }

    /**
     * 解密（需要先反转，再调用被装饰对象的解密）
     * 
     * @param cipherText 密文
     * @return 明文
     */
    public String decrypt(String cipherText) {
        // 先反转
        String reversed = reverse(cipherText);

        // 如果被装饰对象是SimpleShiftCipher，可以调用其decrypt方法
        if (decoratedCipher instanceof SimpleShiftCipher) {
            return ((SimpleShiftCipher) decoratedCipher).decrypt(reversed);
        }

        // 否则返回反转后的字符串（不支持完整解密）
        return reversed;
    }
}