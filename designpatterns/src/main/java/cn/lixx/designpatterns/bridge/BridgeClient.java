package cn.lixx.designpatterns.bridge;

import cn.lixx.designpatterns.bridge.converter.PDFConverter;
import cn.lixx.designpatterns.bridge.converter.TXTConverter;
import cn.lixx.designpatterns.bridge.converter.XMLConverter;
import cn.lixx.designpatterns.bridge.database.MySQLDatabase;
import cn.lixx.designpatterns.bridge.database.OracleDatabase;
import cn.lixx.designpatterns.bridge.database.SQLServerDatabase;

/**
 * 桥接模式客户端测试类
 * 演示如何使用桥接模式实现多种数据库与多种文件格式的灵活组合
 */
public class BridgeClient {

    public static void main(String[] args) {
        System.out.println("======== Sunny软件公司数据转换工具测试 ========\n");

        // 创建数据库实例（实现部分）
        Database mysql = new MySQLDatabase("localhost:3306/sunny_db");
        Database oracle = new OracleDatabase("192.168.1.100:1521/orcl");
        Database sqlserver = new SQLServerDatabase("192.168.1.200:1433/sunny_db");

        // 测试数据
        String[] tables = {"users", "orders", "products"};

        // ========== 组合1: MySQL + TXT格式 ==========
        System.out.println("【组合1: MySQL数据库 → TXT文件格式】");
        System.out.println("========================================");
        DataConverter mysqlToTxt = new TXTConverter(mysql);
        mysqlToTxt.convertData(tables[0]);

        System.out.println("\n");

        // ========== 组合2: MySQL + XML格式 ==========
        System.out.println("【组合2: MySQL数据库 → XML文件格式】");
        System.out.println("========================================");
        DataConverter mysqlToXml = new XMLConverter(mysql);
        mysqlToXml.convertData(tables[1]);

        System.out.println("\n");

        // ========== 组合3: MySQL + PDF格式 ==========
        System.out.println("【组合3: MySQL数据库 → PDF文件格式】");
        System.out.println("========================================");
        DataConverter mysqlToPdf = new PDFConverter(mysql);
        mysqlToPdf.convertData(tables[0]);

        System.out.println("\n\n");

        // ========== 组合4: Oracle + TXT格式 ==========
        System.out.println("【组合4: Oracle数据库 → TXT文件格式】");
        System.out.println("========================================");
        DataConverter oracleToTxt = new TXTConverter(oracle);
        oracleToTxt.convertData("EMPLOYEES");

        System.out.println("\n");

        // ========== 组合5: Oracle + XML格式 ==========
        System.out.println("【组合5: Oracle数据库 → XML文件格式】");
        System.out.println("========================================");
        DataConverter oracleToXml = new XMLConverter(oracle);
        oracleToXml.convertData("PRODUCTS");

        System.out.println("\n\n");

        // ========== 组合6: SQL Server + PDF格式 ==========
        System.out.println("【组合6: SQL Server数据库 → PDF文件格式】");
        System.out.println("========================================");
        DataConverter sqlserverToPdf = new PDFConverter(sqlserver);
        sqlserverToPdf.convertData("Customers");

        System.out.println("\n\n");

        // ========== 演示桥接模式的灵活性 ==========
        System.out.println("【桥接模式灵活性演示】");
        System.out.println("========================");

        System.out.println("\n场景1: 增加新的数据库支持（如PostgreSQL）");
        System.out.println("只需实现Database接口，无需修改转换器代码");

        System.out.println("\n场景2: 增加新的文件格式支持（如Excel、JSON）");
        System.out.println("只需继承DataConverter类，无需修改数据库代码");

        System.out.println("\n场景3: 运行时动态切换数据库和文件格式");
        System.out.println("可以任意组合现有的数据库和文件格式");

        // 动态组合示例
        System.out.println("\n动态组合示例：");
        Database[] databases = {mysql, oracle, sqlserver};
        String[] converterTypes = {"TXT", "XML", "PDF"};

        for (int i = 0; i < databases.length; i++) {
            for (int j = 0; j < converterTypes.length; j++) {
                System.out.printf("- %s → %s%n",
                    databases[i].getDatabaseType(),
                    converterTypes[j]);
            }
        }

        // ========== 总结 ==========
        System.out.println("\n\n【总结】");
        System.out.println("========================================");
        System.out.println("桥接模式的优势：");
        System.out.println("1. 将抽象部分与实现部分分离，使它们都可以独立地变化");
        System.out.println("2. 提高了系统的可扩展性，可以独立增加新的抽象或实现");
        System.out.println("3. 实现了细节对客户透明，客户端不必关心实现的细节");
        System.out.println("4. 符合开闭原则，对扩展开放，对修改关闭");
        System.out.println("5. 符合合成/聚合复用原则，优先使用组合而非继承");
    }
}