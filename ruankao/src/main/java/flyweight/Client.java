package flyweight;

import java.util.Date;

public class Client {
    static void main(String[] args) {
        UnsharedConcreteFlyweight unshared = new UnsharedConcreteFlyweight();
        unshared.setMonitorSite("0001");
        unshared.setDeviceNo("1234");
        unshared.setAlarmTime(new Date());

        // FlyweightFactory factory=new FlyweightFactory();
        FlyweightFactory.createFlyweightFactory();
        ConcreteFlyweight shared = FlyweightFactory.getFlyweight(0);

    }

}
