package cn.lixx.designpatterns.observer;

/**
 * 抽象目标类：Stock (股票)
 */
import java.util.ArrayList;
import java.util.List;

public abstract class Stock {
    protected List<Observer> observers = new ArrayList<>();
    protected String stockName;
    protected double price;

    public Stock(String stockName, double price) {
        this.stockName = stockName;
        this.price = price;
    }

    public void attach(Observer observer) {
        observers.add(observer);
    }

    public void detach(Observer observer) {
        observers.remove(observer);
    }

    public void notifyObservers() {
        for (Observer obs : observers) {
            obs.update(this);
        }
    }

    public String getStockName() {
        return stockName;
    }

    public double getPrice() {
        return price;
    }

    public abstract void setPrice(double price);
}
