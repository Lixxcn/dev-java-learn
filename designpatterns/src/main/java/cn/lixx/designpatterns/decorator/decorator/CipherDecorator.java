package cn.lixx.designpatterns.decorator.decorator;

import cn.lixx.designpatterns.decorator.Cipher;

/**
 * 加密器装饰器抽象类（装饰器）
 * 持有对抽象构件的引用，并实现Cipher接口
 * 所有具体装饰器的基类
 */
public abstract class CipherDecorator implements Cipher {
    // 持有对被装饰对象的引用
    protected Cipher decoratedCipher;

    /**
     * 构造函数，注入被装饰的加密器
     * @param cipher 被装饰的加密器
     */
    public CipherDecorator(Cipher cipher) {
        this.decoratedCipher = cipher;
    }

    @Override
    public String encrypt(String plainText) {
        // 默认调用被装饰对象的encrypt方法
        // 具体装饰器可以在此基础上添加额外功能
        return decoratedCipher.encrypt(plainText);
    }

    @Override
    public String getDescription() {
        // 默认返回被装饰对象的描述
        // 具体装饰器可以在此基础上添加自己的描述
        return decoratedCipher.getDescription();
    }
}