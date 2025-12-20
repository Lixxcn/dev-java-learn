package cn.lixx.designpatterns.adapter.thirdparty;

/**
 * 第三方DES加密类（模拟没有源代码的第三方类）
 */
public class DESEncrypt {
    /**
     * DES加密算法
     * @param message 原始消息
     * @param key 密钥
     * @return 加密后的字符串
     */
    public static String doDESEncrypt(String message, String key) {
        // 模拟DES加密过程
        StringBuilder result = new StringBuilder();
        int keyIndex = 0;
        for (int i = 0; i < message.length(); i++) {
            char msgChar = message.charAt(i);
            char keyChar = key.charAt(keyIndex % key.length());
            char encrypted = (char) ((msgChar + keyChar) % 256);
            result.append(encrypted);
            keyIndex++;
        }
        return "DES:" + result.toString() + ":" + key.hashCode();
    }

    /**
     * DES解密算法
     * @param encryptedMessage 加密的消息
     * @param key 密钥
     * @return 解密后的字符串
     */
    public static String doDESDecrypt(String encryptedMessage, String key) {
        // 模拟DES解密过程
        if (!encryptedMessage.startsWith("DES:")) {
            return "解密失败：格式错误";
        }

        String encryptedPart = encryptedMessage.substring(4, encryptedMessage.lastIndexOf(":"));
        StringBuilder result = new StringBuilder();
        int keyIndex = 0;
        for (int i = 0; i < encryptedPart.length(); i++) {
            char encryptedChar = encryptedPart.charAt(i);
            char keyChar = key.charAt(keyIndex % key.length());
            char decrypted = (char) ((encryptedChar - keyChar + 256) % 256);
            result.append(decrypted);
            keyIndex++;
        }
        return result.toString();
    }
}