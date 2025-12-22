package cn.lixx.designpatterns.bridge.converter;

import cn.lixx.designpatterns.bridge.DataConverter;
import cn.lixx.designpatterns.bridge.Database;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * PDF文件格式转换器
 * 将数据库数据转换为PDF格式文件（模拟实现）
 */
public class PDFConverter extends DataConverter {

    public PDFConverter(Database database) {
        super(database);
    }

    @Override
    protected String formatData(String data) {
        System.out.println("正在格式化数据为PDF格式...");

        // 创建PDF格式的内容（实际应该使用PDF库，这里模拟）
        StringBuilder pdfContent = new StringBuilder();
        pdfContent.append("%PDF-1.4\n");
        pdfContent.append("1 0 obj\n");
        pdfContent.append("<<\n");
        pdfContent.append("/Title (数据导出报告)\n");
        pdfContent.append("/Creator (Sunny数据转换工具)\n");
        pdfContent.append("/Producer (Bridge Pattern Converter)\n");
        pdfContent.append("/CreationDate (D:").append(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"))).append(")\n");
        pdfContent.append(">>\n");
        pdfContent.append("endobj\n");
        pdfContent.append("2 0 obj\n");
        pdfContent.append("<<\n");
        pdfContent.append("/Type /Catalog\n");
        pdfContent.append("/Pages 3 0 R\n");
        pdfContent.append(">>\n");
        pdfContent.append("endobj\n");
        pdfContent.append("3 0 obj\n");
        pdfContent.append("<<\n");
        pdfContent.append("/Type /Pages\n");
        pdfContent.append("/Kids [4 0 R]\n");
        pdfContent.append("/Count 1\n");
        pdfContent.append(">>\n");
        pdfContent.append("endobj\n");
        pdfContent.append("4 0 obj\n");
        pdfContent.append("<<\n");
        pdfContent.append("/Type /Page\n");
        pdfContent.append("/Parent 3 0 R\n");
        pdfContent.append("/Resources <<\n");
        pdfContent.append("/Font <<\n");
        pdfContent.append("/F1 5 0 R\n");
        pdfContent.append(">>\n");
        pdfContent.append(">>\n");
        pdfContent.append("/MediaBox [0 0 595 842]\n");
        pdfContent.append("/Contents 6 0 R\n");
        pdfContent.append(">>\n");
        pdfContent.append("endobj\n");
        pdfContent.append("5 0 obj\n");
        pdfContent.append("<<\n");
        pdfContent.append("/Type /Font\n");
        pdfContent.append("/Subtype /Type1\n");
        pdfContent.append("/BaseFont /Arial\n");
        pdfContent.append(">>\n");
        pdfContent.append("endobj\n");
        pdfContent.append("6 0 obj\n");
        pdfContent.append("<<\n");
        pdfContent.append("/Length 100\n");
        pdfContent.append(">>\n");
        pdfContent.append("stream\n");
        pdfContent.append("BT\n");
        pdfContent.append("/F1 12 Tf\n");
        pdfContent.append("72 720 Td\n");
        pdfContent.append("(数据库类型: ").append(database.getDatabaseType()).append(") Tj\n");
        pdfContent.append("0 -14 Td\n");
        pdfContent.append("(导出时间: ").append(LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME)).append(") Tj\n");
        pdfContent.append("0 -28 Td\n");
        pdfContent.append("(数据内容:) Tj\n");

        // 简化的数据内容
        String[] lines = data.split("\n");
        for (int i = 0; i < Math.min(lines.length, 10); i++) {
            pdfContent.append("0 -14 Td\n");
            pdfContent.append("(").append(lines[i].length() > 50 ? lines[i].substring(0, 47) + "..." : lines[i]).append(") Tj\n");
        }

        pdfContent.append("ET\n");
        pdfContent.append("endstream\n");
        pdfContent.append("endobj\n");
        pdfContent.append("xref\n");
        pdfContent.append("0 7\n");
        pdfContent.append("0000000000 65535 f\n");
        pdfContent.append("0000000009 00000 n\n");
        pdfContent.append("0000000158 00000 n\n");
        pdfContent.append("0000000249 00000 n\n");
        pdfContent.append("0000000324 00000 n\n");
        pdfContent.append("0000000466 00000 n\n");
        pdfContent.append("0000000531 00000 n\n");
        pdfContent.append("trailer\n");
        pdfContent.append("<<\n");
        pdfContent.append("/Size 7\n");
        pdfContent.append("/Root 2 0 R\n");
        pdfContent.append(">>\n");
        pdfContent.append("startxref\n");
        pdfContent.append("650\n");
        pdfContent.append("%%EOF\n");

        return pdfContent.toString();
    }

    @Override
    protected String saveFile(String tableName, String formattedData) {
        String fileName = tableName + "_" + System.currentTimeMillis() + ".pdf";
        System.out.println("正在保存PDF文件: " + fileName);

        // 模拟保存文件过程
        System.out.println("PDF文件生成完成，包含以下信息:");
        System.out.println("- 数据库类型: " + database.getDatabaseType());
        System.out.println("- 文件大小: " + formattedData.length() + " 字节");
        System.out.println("- 页数: 1页");

        String filePath = "output/pdf/" + fileName;
        System.out.println("PDF文件已保存至: " + filePath);
        return filePath;
    }
}