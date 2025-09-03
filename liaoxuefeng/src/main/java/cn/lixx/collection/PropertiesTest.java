package cn.lixx.collection;

import java.io.ByteArrayInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.util.Properties;

public class PropertiesTest {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        String f = "/root/codes/self/java-learn/liaoxuefeng/src/main/java/cn/lixx/collection/setting.properties";
        Properties props = new Properties();
        props.load(new java.io.FileInputStream(f));

        String filepath = props.getProperty("last_open_file");
        String interval = props.getProperty("auto_save_interval", "120");
        System.err.println(filepath);
        System.err.println(interval);

        f1();

        f2();
    }

    public static void f1() throws IOException {
        System.out.println("====================f1");
        String settings = "# test" + "\n" + "course=Java" + "\n" + "last_open_date=2019-08-07T12:35:01";
        ByteArrayInputStream input = new ByteArrayInputStream(settings.getBytes("UTF-8"));
        Properties props = new Properties();
        props.load(input);

        System.out.println("course: " + props.getProperty("course"));
        System.out.println("last_open_date: " + props.getProperty("last_open_date"));
        System.out.println("last_open_file: " + props.getProperty("last_open_file"));
        System.out.println("auto_save: " + props.getProperty("auto_save", "60"));
    }

    public static void f2() throws IOException {
        System.out.println("====================f2");
        Properties props = new Properties();
        props.setProperty("url", "http://www.liaoxuefeng.com");
        props.setProperty("language", "Java");
        
        // 方法1：使用storeToXML保持中文字符不被转义
        props.storeToXML(
                new FileOutputStream(
                        "/root/codes/self/java-learn/liaoxuefeng/src/main/java/cn/lixx/collection/setting1.xml"),
                "这是写入的properties注释",
                StandardCharsets.UTF_8.name());
        
        // 方法2：如果需要.properties格式，使用OutputStreamWriter但中文仍会被转义（这是Properties格式的标准行为）
        props.store(
                new OutputStreamWriter(
                        new FileOutputStream(
                                "/root/codes/self/java-learn/liaoxuefeng/src/main/java/cn/lixx/collection/setting1.properties"),
                        StandardCharsets.UTF_8),
                "这是写入的properties注释");
        
        System.out.println("注意：.properties文件中的中文注释会被转换为Unicode转义序列，这是Properties格式的标准行为。");
        System.out.println("如果需要保持中文字符，建议使用XML格式（已生成setting1.xml文件）。");

    }

}
