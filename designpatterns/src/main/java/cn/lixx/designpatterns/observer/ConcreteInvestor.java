package cn.lixx.designpatterns.observer;

/**
 * 具体观察者：ConcreteInvestor (股民)
 */
public class ConcreteInvestor implements Observer {
    private String name;

    public ConcreteInvestor(String name) {
        this.name = name;
    }

    @Override
    public void update(Stock stock) {
        System.out.println("    [通知] 尊敬的股民 " + name + "，您关注的股票 [" + stock.getStockName() + "] 价格发生大幅波动，最新报价: " + stock.getPrice());
    }
}
