package cn.lixx.designpatterns.bridge;

/**
 * 数据转换器抽象类（抽象部分）
 * 定义了数据转换的基本框架，包含对数据库接口的引用
 */
public abstract class DataConverter {
    // 桥接：持有数据库接口的引用
    protected Database database;

    /**
     * 构造函数，注入数据库实现
     * @param database 数据库实现
     */
    public DataConverter(Database database) {
        this.database = database;
    }

    /**
     * 模板方法：转换数据的核心流程
     * @param tableName 表名
     * @return 转换后的文件内容
     */
    public String convertData(String tableName) {
        System.out.println("开始数据转换流程...");

        // 1. 连接数据库
        database.connect();

        // 2. 获取数据
        String data = database.getData(tableName);

        // 3. 格式化数据（由子类实现具体格式）
        String formattedData = formatData(data);

        // 4. 保存文件（由子类实现具体文件格式）
        String filePath = saveFile(tableName, formattedData);

        // 5. 关闭数据库
        database.disconnect();

        System.out.println("数据转换完成！");
        return filePath;
    }

    /**
     * 格式化数据（抽象方法，由子类实现）
     * @param data 原始数据
     * @return 格式化后的数据
     */
    protected abstract String formatData(String data);

    /**
     * 保存文件（抽象方法，由子类实现）
     * @param tableName 表名
     * @param formattedData 格式化后的数据
     * @return 文件路径
     */
    protected abstract String saveFile(String tableName, String formattedData);
}