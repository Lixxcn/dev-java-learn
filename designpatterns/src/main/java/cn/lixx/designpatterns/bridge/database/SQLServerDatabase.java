package cn.lixx.designpatterns.bridge.database;

import cn.lixx.designpatterns.bridge.Database;

import java.util.HashMap;
import java.util.Map;

/**
 * SQL Server数据库实现
 */
public class SQLServerDatabase implements Database {
    private String connectionString;
    private boolean connected = false;
    private Map<String, String> tables;

    public SQLServerDatabase(String connectionString) {
        this.connectionString = connectionString;
        this.tables = new HashMap<>();
        initSampleData();
    }

    @Override
    public void connect() {
        System.out.println("正在连接SQL Server数据库: " + connectionString);
        // 模拟连接过程
        try {
            Thread.sleep(600);
            connected = true;
            System.out.println("SQL Server数据库连接成功！");
        } catch (InterruptedException e) {
            System.out.println("SQL Server数据库连接失败！");
        }
    }

    @Override
    public String getData(String tableName) {
        if (!connected) {
            return "错误：数据库未连接";
        }
        System.out.println("从SQL Server数据库获取表 " + tableName + " 的数据...");
        // SQL Server特定的数据格式
        String data = tables.getOrDefault(tableName, "表 " + tableName + " 不存在");
        return "SQLSERVER_RESULT[" + tableName + "]\n" + data;
    }

    @Override
    public void disconnect() {
        if (connected) {
            System.out.println("正在断开SQL Server数据库连接...");
            connected = false;
            System.out.println("SQL Server数据库已断开连接");
        }
    }

    @Override
    public String getDatabaseType() {
        return "Microsoft SQL Server";
    }

    @Override
    public String getVersion() {
        return "SQL Server 2019 Enterprise";
    }

    /**
     * 初始化示例数据
     */
    private void initSampleData() {
        // SQL Server风格的示例数据
        tables.put("Customers",
            "[CustomerID], [Name], [City], [Country]\n" +
            "1, '张三', '北京', '中国'\n" +
            "2, '李四', '上海', '中国'\n" +
            "3, '王五', '广州', '中国'"
        );

        tables.put("Sales",
            "[OrderID], [CustomerID], [OrderDate], [Amount]\n" +
            "S001, 1, '2024-01-15 10:30:00', 1500.00\n" +
            "S002, 2, '2024-01-15 14:20:00', 2800.50\n" +
            "S003, 3, '2024-01-16 09:15:00', 950.75"
        );
    }
}