package cn.lixx.designpatterns.decorator;

import cn.lixx.designpatterns.decorator.concretecomponent.SimpleShiftCipher;
import cn.lixx.designpatterns.decorator.concretedecorator.ModulusCipher;
import cn.lixx.designpatterns.decorator.concretedecorator.ReverseCipher;

/**
 * 装饰模式客户端测试类
 * 演示如何使用装饰模式实现多重加密系统
 */
public class DecoratorClient {

    public static void main(String[] args) {
        System.out.println("======== Sunny软件公司数据加密模块测试 ========\n");

        String originalText = "HelloWorld2024";
        System.out.println("原始明文: " + originalText);
        System.out.println("========================================\n");

        // ========== 测试1：简单移位加密 ==========
        System.out.println("【测试1：简单移位加密】");
        System.out.println("----------------------------------------");

        Cipher simpleCipher = new SimpleShiftCipher(3);
        String encrypted1 = simpleCipher.encrypt(originalText);
        System.out.println("加密器描述: " + simpleCipher.getDescription());
        System.out.println("加密结果: " + encrypted1);

        SimpleShiftCipher shiftCipher = new SimpleShiftCipher(3);
        String decrypted1 = shiftCipher.decrypt(encrypted1);
        System.out.println("解密结果: " + decrypted1);
        System.out.println("验证: " + (originalText.equals(decrypted1) ? "✓ 成功" : "✗ 失败"));

        System.out.println("\n");

        // ========== 测试2：移位 + 逆向加密 ==========
        System.out.println("【测试2：移位加密 + 逆向加密】");
        System.out.println("----------------------------------------");

        Cipher reverseCipher = new ReverseCipher(new SimpleShiftCipher(3));
        String encrypted2 = reverseCipher.encrypt(originalText);
        System.out.println("加密器描述: " + reverseCipher.getDescription());
        System.out.println("加密过程: 移位加密 → 逆向输出");
        System.out.println("加密结果: " + encrypted2);

        System.out.println("\n");

        // ========== 测试3：移位 + 求模加密 ==========
        System.out.println("【测试3：移位加密 + 求模加密】");
        System.out.println("----------------------------------------");

        Cipher modulusCipher = new ModulusCipher(new SimpleShiftCipher(3), 128);
        String encrypted3 = modulusCipher.encrypt(originalText);
        System.out.println("加密器描述: " + modulusCipher.getDescription());
        System.out.println("加密过程: 移位加密 → 求模运算");
        System.out.println("加密结果: " + encrypted3);

        System.out.println("\n");

        // ========== 测试4：移位 + 逆向 + 求模加密（三层加密）==========
        System.out.println("【测试4：移位 + 逆向 + 求模（三层加密）】");
        System.out.println("----------------------------------------");

        Cipher complexCipher = new ModulusCipher(
                new ReverseCipher(
                        new SimpleShiftCipher(3)
                ),
                128
        );
        String encrypted4 = complexCipher.encrypt(originalText);
        System.out.println("加密器描述: " + complexCipher.getDescription());
        System.out.println("加密过程: 移位加密 → 逆向输出 → 求模运算");
        System.out.println("加密结果: " + encrypted4);

        System.out.println("\n");

        // ========== 测试5：更多层级的加密 ==========
        System.out.println("【测试5：五层加密】");
        System.out.println("----------------------------------------");

        Cipher ultraCipher = new ModulusCipher(
                new ReverseCipher(
                        new ModulusCipher(
                                new ReverseCipher(
                                        new SimpleShiftCipher(5)
                                ),
                                64
                        )
                ),
                256
        );
        String encrypted5 = ultraCipher.encrypt(originalText);
        System.out.println("加密器描述: " + ultraCipher.getDescription());
        System.out.println("加密过程: 移位(5) → 逆向 → 求模(64) → 逆向 → 求模(256)");
        System.out.println("加密结果: " + encrypted5);

        System.out.println("\n");

        // ========== 测试6：对比不同加密强度 ==========
        System.out.println("【测试6：对比不同加密强度】");
        System.out.println("========================================");

        String[] testTexts = {
                "Password123",
                "SecretMessage",
                "Confidential2024"
        };

        System.out.printf("%-20s %-30s %-30s%n", "明文", "单层加密", "三层加密");
        System.out.println("----------------------------------------------------------------");

        for (String text : testTexts) {
            Cipher single = new SimpleShiftCipher(3);
            Cipher triple = new ModulusCipher(
                    new ReverseCipher(
                            new SimpleShiftCipher(3)
                    ),
                    128
            );

            String singleEncrypted = single.encrypt(text);
            String tripleEncrypted = triple.encrypt(text);

            System.out.printf("%-20s %-30s %-30s%n",
                    text,
                    singleEncrypted,
                    tripleEncrypted);
        }

        System.out.println("\n");

        // ========== 测试7：动态添加加密层 ==========
        System.out.println("【测试7：动态添加加密层】");
        System.out.println("========================================");
        System.out.println("演示装饰模式的核心优势：可以动态地给对象添加职责\n");

        // 从基础加密开始
        Cipher cipher = new SimpleShiftCipher(3);
        System.out.println("步骤1: " + cipher.getDescription());
        String result = cipher.encrypt(originalText);
        System.out.println("中间结果: " + result);

        // 动态添加逆向加密
        cipher = new ReverseCipher(cipher);
        System.out.println("\n步骤2: " + cipher.getDescription());
        result = cipher.encrypt(originalText);
        System.out.println("中间结果: " + result);

        // 动态添加求模加密
        cipher = new ModulusCipher(cipher, 128);
        System.out.println("\n步骤3: " + cipher.getDescription());
        result = cipher.encrypt(originalText);
        System.out.println("最终结果: " + result);

        System.out.println("\n");

        // ========== 总结 ==========
        System.out.println("【总结】");
        System.out.println("========================================");
        System.out.println("装饰模式的优势：");
        System.out.println("1. 不改变原有对象结构，动态扩展功能");
        System.out.println("2. 可以多层嵌套，实现复杂的功能组合");
        System.out.println("3. 每个装饰器只关注自己的职责（单一职责原则）");
        System.out.println("4. 比继承更灵活，避免了类爆炸");
        System.out.println("5. 符合开闭原则，对扩展开放，对修改关闭");
        System.out.println("\n在本多重加密系统中：");
        System.out.println("- 基础组件：SimpleShiftCipher（移位加密）");
        System.out.println("- 装饰器：ReverseCipher（逆向）、ModulusCipher（求模）");
        System.out.println("- 可以任意组合和嵌套，实现任意层级的加密");
    }
}