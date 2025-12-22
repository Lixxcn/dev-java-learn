package cn.lixx.designpatterns.bridge.converter;

import cn.lixx.designpatterns.bridge.DataConverter;
import cn.lixx.designpatterns.bridge.Database;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * XML文件格式转换器
 * 将数据库数据转换为XML格式文件
 */
public class XMLConverter extends DataConverter {

    public XMLConverter(Database database) {
        super(database);
    }

    @Override
    protected String formatData(String data) {
        System.out.println("正在格式化数据为XML格式...");

        // 创建XML格式的内容
        StringBuilder xmlContent = new StringBuilder();
        xmlContent.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
        xmlContent.append("<DataExport>\n");
        xmlContent.append("  <MetaData>\n");
        xmlContent.append("    <DatabaseType>").append(database.getDatabaseType()).append("</DatabaseType>\n");
        xmlContent.append("    <DatabaseVersion>").append(database.getVersion()).append("</DatabaseVersion>\n");
        xmlContent.append("    <ExportTime>").append(LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME)).append("</ExportTime>\n");
        xmlContent.append("  </MetaData>\n");
        xmlContent.append("  <Content>\n");

        // 将数据转换为XML行格式
        String[] lines = data.split("\n");
        for (int i = 0; i < lines.length; i++) {
            xmlContent.append("    <Row id=\"").append(i + 1).append("\">\n");
            xmlContent.append("      <Data><![CDATA[").append(lines[i]).append("]]></Data>\n");
            xmlContent.append("    </Row>\n");
        }

        xmlContent.append("  </Content>\n");
        xmlContent.append("</DataExport>");

        return xmlContent.toString();
    }

    @Override
    protected String saveFile(String tableName, String formattedData) {
        String fileName = tableName + "_" + System.currentTimeMillis() + ".xml";
        System.out.println("正在保存XML文件: " + fileName);

        // 模拟保存文件过程
        System.out.println("文件内容预览:");
        System.out.println(formattedData);

        String filePath = "output/xml/" + fileName;
        System.out.println("XML文件已保存至: " + filePath);
        return filePath;
    }
}