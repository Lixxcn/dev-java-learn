package cn.lixx.designpatterns.interpreter.db;

/**
 * 环境类：DBContext
 * 模拟数据库环境及指令的执行。
 */
public class DBContext {
    
    public void execute(String action, String type, String name, String src, String dest) {
        if ("COPY".equalsIgnoreCase(action)) {
            handleCopy(type, name, src, dest);
        } else if ("MOVE".equalsIgnoreCase(action)) {
            handleMove(type, name, src, dest);
        } else {
            System.err.println("无效动作: " + action);
        }
    }

    private void handleCopy(String type, String name, String src, String dest) {
        if ("VIEW".equalsIgnoreCase(type)) {
            System.out.println("已将所有 视图(VIEW) 从 '" + src + "' 复制到 '" + dest + "'。");
        } else if ("TABLE".equalsIgnoreCase(type)) {
             System.out.println("已将 表(TABLE) '" + name + "' 从 '" + src + "' 复制到 '" + dest + "'。");
        } else {
            System.err.println("未知的复制类型: " + type);
        }
    }

    private void handleMove(String type, String name, String src, String dest) {
        if ("VIEW".equalsIgnoreCase(type)) {
             // 通常我们不移动所有视图，但为了逻辑完整性：
             System.out.println("已将所有 视图(VIEW) 从 '" + src + "' 移动到 '" + dest + "'。");
        } else if ("TABLE".equalsIgnoreCase(type)) {
             System.out.println("已将 表(TABLE) '" + name + "' 从 '" + src + "' 移动到 '" + dest + "'。");
        } else {
            System.err.println("未知的移动类型: " + type);
        }
    }
}