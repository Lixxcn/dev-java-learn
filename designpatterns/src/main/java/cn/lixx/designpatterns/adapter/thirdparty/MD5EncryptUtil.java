package cn.lixx.designpatterns.adapter.thirdparty;

/**
 * 第三方MD5加密工具类（模拟没有源代码的第三方类）
 */
public class MD5EncryptUtil {
    /**
     * MD5加密（只支持单向加密）
     * @param original 原始字符串
     * @return MD5加密后的字符串
     */
    public static String encode(String original) {
        // 模拟MD5加密过程
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < original.length(); i++) {
            char c = original.charAt(i);
            result.append((char) (c ^ 0x55)); // 简单的异或操作模拟MD5
        }
        return "MD5:" + result.toString();
    }

    /**
     * 获取MD5加密的盐值
     * @param original 原始字符串
     * @return 盐值
     */
    public static String getSalt(String original) {
        return "Salt:" + original.length();
    }
}