package cn.lixx.designpatterns.adapter.database;

import cn.lixx.designpatterns.adapter.Encryptor;

import java.util.HashMap;
import java.util.Map;

/**
 * 数据库操作类
 * 负责将加密后的用户信息存储到数据库
 */
public class DatabaseManager {
    private Map<String, String> userDataStore = new HashMap<>();
    private Encryptor encryptor;

    public DatabaseManager(Encryptor encryptor) {
        this.encryptor = encryptor;
    }

    /**
     * 存储用户信息（会自动加密）
     * @param username 用户名
     * @param password 密码
     * @param email 邮箱
     */
    public void storeUserInfo(String username, String password, String email) {
        System.out.println("正在存储用户信息到数据库...");

        // 加密敏感信息
        String encryptedPassword = encryptor.encrypt(password);
        String encryptedEmail = encryptor.encrypt(email);

        // 模拟存储到数据库
        userDataStore.put(username + "_pwd", encryptedPassword);
        userDataStore.put(username + "_email", encryptedEmail);

        System.out.println("用户信息已加密并存储完成");
        System.out.println("- 用户名: " + username);
        System.out.println("- 加密后的密码: " + encryptedPassword);
        System.out.println("- 加密后的邮箱: " + encryptedEmail);
    }

    /**
     * 获取用户信息（会自动解密）
     * @param username 用户名
     * @return 用户信息（包含解密后的密码和邮箱）
     */
    public Map<String, String> getUserInfo(String username) {
        System.out.println("正在从数据库获取用户信息...");

        Map<String, String> result = new HashMap<>();

        // 从数据库获取加密数据
        String encryptedPassword = userDataStore.get(username + "_pwd");
        String encryptedEmail = userDataStore.get(username + "_email");

        if (encryptedPassword != null && encryptedEmail != null) {
            // 解密数据
            String decryptedPassword = encryptor.decrypt(encryptedPassword);
            String decryptedEmail = encryptor.decrypt(encryptedEmail);

            result.put("username", username);
            result.put("password", decryptedPassword);
            result.put("email", decryptedEmail);

            System.out.println("用户信息已获取并解密完成");
        } else {
            System.out.println("未找到用户信息");
        }

        return result;
    }

    /**
     * 显示数据库中所有存储的加密数据
     */
    public void showEncryptedData() {
        System.out.println("\n=== 数据库中存储的加密数据 ===");
        userDataStore.forEach((key, value) -> {
            System.out.println(key + ": " + value);
        });
        System.out.println("==============================\n");
    }
}