package cn.lixx.designpatterns.iterator.page;

import java.util.ArrayList;
import java.util.List;

public class PageIteratorClient {
    public static void main(String[] args) {
        // 准备数据
        List<String> data = new ArrayList<>();
        for (int i = 1; i <= 25; i++) {
            data.add("项目 " + i);
        }

        int pageSize = 10;
        System.out.println("数据总数: " + data.size() + ", 每页大小: " + pageSize);

        // 创建迭代器
        PageIterator<String> pageIterator = new PageIterator<>(data, pageSize);

        int pageNum = 1;
        while (pageIterator.hasNext()) {
            System.out.println("--- 第 " + pageNum + " 页 ---");
            List<String> page = pageIterator.next();
            for (String item : page) {
                System.out.println(item);
            }
            pageNum++;
        }
    }
}