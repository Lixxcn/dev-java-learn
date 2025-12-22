package cn.lixx.designpatterns.bridge.database;

import cn.lixx.designpatterns.bridge.Database;

import java.util.HashMap;
import java.util.Map;

/**
 * Oracle数据库实现
 */
public class OracleDatabase implements Database {
    private String connectionString;
    private boolean connected = false;
    private Map<String, String> tables;

    public OracleDatabase(String connectionString) {
        this.connectionString = connectionString;
        this.tables = new HashMap<>();
        initSampleData();
    }

    @Override
    public void connect() {
        System.out.println("正在连接Oracle数据库: " + connectionString);
        // 模拟连接过程
        try {
            Thread.sleep(800); // Oracle连接通常较慢
            connected = true;
            System.out.println("Oracle数据库连接成功！");
        } catch (InterruptedException e) {
            System.out.println("Oracle数据库连接失败！");
        }
    }

    @Override
    public String getData(String tableName) {
        if (!connected) {
            return "错误：数据库未连接";
        }
        System.out.println("从Oracle数据库获取表 " + tableName + " 的数据...");
        // Oracle特定的数据格式
        String data = tables.getOrDefault(tableName, "表 " + tableName + " 不存在");
        return "ORACLE_DATA[" + tableName + "]:\n" + data;
    }

    @Override
    public void disconnect() {
        if (connected) {
            System.out.println("正在断开Oracle数据库连接...");
            connected = false;
            System.out.println("Oracle数据库已断开连接");
        }
    }

    @Override
    public String getDatabaseType() {
        return "Oracle";
    }

    @Override
    public String getVersion() {
        return "Oracle Database 19c Enterprise Edition";
    }

    /**
     * 初始化示例数据
     */
    private void initSampleData() {
        // Oracle风格的示例数据
        tables.put("EMPLOYEES",
            "EMP_ID:1|NAME:张三|AGE:28|EMAIL:zhangsan@company.com\n" +
            "EMP_ID:2|NAME:李四|AGE:32|EMAIL:lisi@company.com\n" +
            "EMP_ID:3|NAME:王五|AGE:25|EMAIL:wangwu@company.com"
        );

        tables.put("PRODUCTS",
            "PROD_ID:P001|NAME:笔记本电脑|PRICE:5999.99|STOCK:50\n" +
            "PROD_ID:P002|NAME:手机|PRICE:2999.00|STOCK:120\n" +
            "PROD_ID:P003|NAME:平板电脑|PRICE:1999.50|STOCK:80"
        );
    }
}