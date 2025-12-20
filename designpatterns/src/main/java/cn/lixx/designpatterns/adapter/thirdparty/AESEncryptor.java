package cn.lixx.designpatterns.adapter.thirdparty;

/**
 * 第三方AES加密器类（模拟没有源代码的第三方类）
 */
public class AESEncryptor {
    private String secretKey;

    public AESEncryptor(String secretKey) {
        this.secretKey = secretKey;
    }

    /**
     * AES加密数据
     * @param plaintext 明文
     * @return 加密后的密文
     */
    public String aesEncode(String plaintext) {
        // 模拟AES加密过程
        StringBuilder encrypted = new StringBuilder();
        for (int i = 0; i < plaintext.length(); i++) {
            char c = plaintext.charAt(i);
            encrypted.append((char) (c ^ (secretKey.charAt(i % secretKey.length()))));
        }
        return "AES:" + encrypted.toString() + ":Key" + secretKey.hashCode();
    }

    /**
     * AES解密数据
     * @param ciphertext 密文
     * @return 解密后的明文
     */
    public String aesDecode(String ciphertext) {
        // 模拟AES解密过程
        if (!ciphertext.startsWith("AES:")) {
            return "解密失败：无效的密文格式";
        }

        String encryptedPart = ciphertext.substring(4, ciphertext.lastIndexOf(":Key"));
        StringBuilder decrypted = new StringBuilder();
        for (int i = 0; i < encryptedPart.length(); i++) {
            char c = encryptedPart.charAt(i);
            decrypted.append((char) (c ^ (secretKey.charAt(i % secretKey.length()))));
        }
        return decrypted.toString();
    }

    /**
     * 获取密钥信息
     * @return 密钥信息
     */
    public String getKeyInfo() {
        return "AES加密器，密钥长度：" + secretKey.length();
    }
}