package cn.lixx.designpatterns.bridge.converter;

import cn.lixx.designpatterns.bridge.DataConverter;
import cn.lixx.designpatterns.bridge.Database;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * TXT文件格式转换器
 * 将数据库数据转换为TXT格式文件
 */
public class TXTConverter extends DataConverter {

    public TXTConverter(Database database) {
        super(database);
    }

    @Override
    protected String formatData(String data) {
        System.out.println("正在格式化数据为TXT格式...");

        // 创建TXT格式的内容
        StringBuilder formattedData = new StringBuilder();
        formattedData.append("=====================================\n");
        formattedData.append("数据导出报告\n");
        formattedData.append("=====================================\n");
        formattedData.append("数据库类型: ").append(database.getDatabaseType()).append("\n");
        formattedData.append("数据库版本: ").append(database.getVersion()).append("\n");
        formattedData.append("导出时间: ").append(LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME)).append("\n");
        formattedData.append("-------------------------------------\n");
        formattedData.append("数据内容:\n");
        formattedData.append(data).append("\n");
        formattedData.append("-------------------------------------\n");
        formattedData.append("导出完成\n");
        formattedData.append("=====================================\n");

        return formattedData.toString();
    }

    @Override
    protected String saveFile(String tableName, String formattedData) {
        String fileName = tableName + "_" + System.currentTimeMillis() + ".txt";
        System.out.println("正在保存TXT文件: " + fileName);

        // 模拟保存文件过程
        System.out.println("文件内容预览:");
        System.out.println(formattedData);

        String filePath = "output/txt/" + fileName;
        System.out.println("TXT文件已保存至: " + filePath);
        return filePath;
    }
}