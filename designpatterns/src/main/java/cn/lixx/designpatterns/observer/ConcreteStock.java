package cn.lixx.designpatterns.observer;

/**
 * 具体目标类：ConcreteStock
 */
public class ConcreteStock extends Stock {
    public ConcreteStock(String stockName, double price) {
        super(stockName, price);
    }

    @Override
    public void setPrice(double newPrice) {
        double range = Math.abs(newPrice - this.price) / this.price;
        System.out.println("交易播报: [" + this.stockName + "] 价格变动 " + this.price + " -> " + newPrice + " (幅度: " + String.format("%.2f", range * 100) + "%)");
        
        this.price = newPrice;
        
        if (range >= 0.05) {
            System.out.println(">> 系统警告: [" + this.stockName + "] 价格波动超过 5%！正在通知所有订阅股民...");
            notifyObservers();
        }
    }
}
