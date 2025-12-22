package cn.lixx.designpatterns.bridge;

/**
 * 数据库接口（实现部分）
 * 定义了数据库操作的基本接口
 */
public interface Database {
    /**
     * 连接数据库
     */
    void connect();

    /**
     * 获取指定表的数据
     * @param tableName 表名
     * @return 表中的数据
     */
    String getData(String tableName);

    /**
     * 断开数据库连接
     */
    void disconnect();

    /**
     * 获取数据库类型信息
     * @return 数据库类型
     */
    String getDatabaseType();

    /**
     * 获取数据库版本信息
     * @return 版本信息
     */
    String getVersion();
}