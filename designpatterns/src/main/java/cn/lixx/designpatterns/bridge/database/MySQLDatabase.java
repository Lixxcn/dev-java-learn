package cn.lixx.designpatterns.bridge.database;

import cn.lixx.designpatterns.bridge.Database;

import java.util.HashMap;
import java.util.Map;

/**
 * MySQL数据库实现
 */
public class MySQLDatabase implements Database {
    private String connectionString;
    private boolean connected = false;
    private Map<String, String> tables;

    public MySQLDatabase(String connectionString) {
        this.connectionString = connectionString;
        this.tables = new HashMap<>();
        initSampleData();
    }

    @Override
    public void connect() {
        System.out.println("正在连接MySQL数据库: " + connectionString);
        // 模拟连接过程
        try {
            Thread.sleep(500); // 模拟连接耗时
            connected = true;
            System.out.println("MySQL数据库连接成功！");
        } catch (InterruptedException e) {
            System.out.println("MySQL数据库连接失败！");
        }
    }

    @Override
    public String getData(String tableName) {
        if (!connected) {
            return "错误：数据库未连接";
        }
        System.out.println("从MySQL数据库获取表 " + tableName + " 的数据...");
        return tables.getOrDefault(tableName, "表 " + tableName + " 不存在");
    }

    @Override
    public void disconnect() {
        if (connected) {
            System.out.println("正在断开MySQL数据库连接...");
            connected = false;
            System.out.println("MySQL数据库已断开连接");
        }
    }

    @Override
    public String getDatabaseType() {
        return "MySQL";
    }

    @Override
    public String getVersion() {
        return "MySQL 8.0.25";
    }

    /**
     * 初始化示例数据
     */
    private void initSampleData() {
        // 模拟用户表数据
        tables.put("users",
            "1,张三,28,zhangsan@email.com\n" +
            "2,李四,32,lisi@email.com\n" +
            "3,王五,25,wangwu@email.com"
        );

        // 模拟订单表数据
        tables.put("orders",
            "1001,1,2024-01-15,299.99\n" +
            "1002,2,2024-01-16,599.50\n" +
            "1003,1,2024-01-17,199.00"
        );
    }
}