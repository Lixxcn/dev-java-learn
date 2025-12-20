package cn.lixx.designpatterns.adapter;

import cn.lixx.designpatterns.adapter.classadapter.AESClassAdapter;
import cn.lixx.designpatterns.adapter.classadapter.DESClassAdapter;
import cn.lixx.designpatterns.adapter.database.DatabaseManager;
import cn.lixx.designpatterns.adapter.objectadapter.AESObjectAdapter;
import cn.lixx.designpatterns.adapter.objectadapter.DESObjectAdapter;
import cn.lixx.designpatterns.adapter.objectadapter.MD5ObjectAdapter;

import java.util.Map;

/**
 * 适配器模式客户端测试类
 * 演示如何使用对象适配器和类适配器来重用第三方加密算法
 */
public class AdapterClient {

    public static void main(String[] args) {
        System.out.println("======== Sunny软件公司OA系统加密模块测试 ========\n");

        // 测试数据
        String username = "zhangsan";
        String password = "mypassword123";
        String email = "zhangsan@example.com";

        // ========== 对象适配器模式测试 ==========
        System.out.println("【对象适配器模式测试】");
        System.out.println("----------------------------");

        // 1. 使用MD5对象适配器（单向加密）
        System.out.println("\n1. MD5对象适配器测试（单向加密）：");
        Encryptor md5Adapter = new MD5ObjectAdapter();
        DatabaseManager dbMD5 = new DatabaseManager(md5Adapter);
        dbMD5.storeUserInfo(username, password, email);
        Map<String, String> md5Result = dbMD5.getUserInfo(username);
        System.out.println("解密结果：" + md5Result.get("password"));

        // 2. 使用AES对象适配器（双向加密）
        System.out.println("\n2. AES对象适配器测试（双向加密）：");
        Encryptor aesObjectAdapter = new AESObjectAdapter("mySecretKey123");
        DatabaseManager dbAES = new DatabaseManager(aesObjectAdapter);
        dbAES.storeUserInfo(username, password, email);
        Map<String, String> aesResult = dbAES.getUserInfo(username);
        System.out.println("解密结果 - 密码：" + aesResult.get("password"));
        System.out.println("解密结果 - 邮箱：" + aesResult.get("email"));

        // 3. 使用DES对象适配器（双向加密）
        System.out.println("\n3. DES对象适配器测试（双向加密）：");
        Encryptor desObjectAdapter = new DESObjectAdapter("desKey567");
        DatabaseManager dbDES = new DatabaseManager(desObjectAdapter);
        dbDES.storeUserInfo(username + "_DES", password, email);
        Map<String, String> desResult = dbDES.getUserInfo(username + "_DES");
        System.out.println("解密结果 - 密码：" + desResult.get("password"));
        System.out.println("解密结果 - 邮箱：" + desResult.get("email"));

        // ========== 类适配器模式测试 ==========
        System.out.println("\n\n【类适配器模式测试】");
        System.out.println("----------------------------");

        // 1. 使用AES类适配器
        System.out.println("\n1. AES类适配器测试：");
        Encryptor aesClassAdapter = new AESClassAdapter("myAESKey456");
        DatabaseManager dbAESClass = new DatabaseManager(aesClassAdapter);
        dbAESClass.storeUserInfo(username + "_AESClass", password, email);
        Map<String, String> aesClassResult = dbAESClass.getUserInfo(username + "_AESClass");
        System.out.println("解密结果 - 密码：" + aesClassResult.get("password"));
        System.out.println("解密结果 - 邮箱：" + aesClassResult.get("email"));

        // 2. 使用DES类适配器
        System.out.println("\n2. DES类适配器测试：");
        DESClassAdapter desClassAdapter = new DESClassAdapter("desClassKey890");
        DatabaseManager dbDESClass = new DatabaseManager(desClassAdapter);
        dbDESClass.storeUserInfo(username + "_DESClass", password, email);
        Map<String, String> desClassResult = dbDESClass.getUserInfo(username + "_DESClass");
        System.out.println("解密结果 - 密码：" + desClassResult.get("password"));
        System.out.println("解密结果 - 邮箱：" + desClassResult.get("email"));
        System.out.println(desClassAdapter.getKeyInfo());

        // ========== 总结 ==========
        System.out.println("\n\n【总结】");
        System.out.println("----------------------------");
        System.out.println("1. 对象适配器模式：");
        System.out.println("   - 通过组合方式持有第三方类实例");
        System.out.println("   - 灵活性高，可以适配多个第三方类");
        System.out.println("   - 符合组合优于继承的原则");

        System.out.println("\n2. 类适配器模式：");
        System.out.println("   - 通过继承第三方类实现适配");
        System.out.println("   - 可以重写父类方法，扩展性强");
        System.out.println("   - 但由于Java单继承，限制了灵活性");

        System.out.println("\n两种模式都成功实现了在不修改第三方类的基础上，");
        System.out.println("将其加密功能适配到系统的标准接口中。");
    }
}