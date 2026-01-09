package cn.lixx.designpatterns.observer;

public class ObserverClient {
    public static void main(String[] args) {
        // 创建股票
        Stock tencent = new ConcreteStock("腾讯控股", 300.00);
        
        // 创建股民
        Observer investor1 = new ConcreteInvestor("张三");
        Observer investor2 = new ConcreteInvestor("李四");
        Observer investor3 = new ConcreteInvestor("王五");
        
        // 股民订阅股票
        tencent.attach(investor1);
        tencent.attach(investor2);
        tencent.attach(investor3);
        
        System.out.println("------- 股市开盘，初始价格: 300.00 ------- ");
        
        // 波动 1: 300 -> 310 (+3.33%), 不触发通知
        System.out.println("\n--- 模拟交易 1 ---");
        tencent.setPrice(310.00);
        
        // 波动 2: 310 -> 330 (+6.45%), 触发通知
        System.out.println("\n--- 模拟交易 2 ---");
        tencent.setPrice(330.00);
        
        // 波动 3: 330 -> 335 (+1.51%), 不触发通知
        System.out.println("\n--- 模拟交易 3 ---");
        tencent.setPrice(335.00);
        
        // 波动 4: 335 -> 300 (-10.45%), 触发通知
        System.out.println("\n--- 模拟交易 4 ---");
        tencent.setPrice(300.00);
    }
}
