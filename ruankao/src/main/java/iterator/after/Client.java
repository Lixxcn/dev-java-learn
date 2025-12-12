package iterator.after;

public class Client {
    static void main(String[] args) {
        Float[] valueList = { 0.22f, 4.5f, 55.77f };

        ConcreteAggregrate aggregrate = new ConcreteAggregrate();
        for (int i = 0; i < valueList.length; i++) {
            aggregrate.add(valueList[i]);// 装箱
        }

        Iterator iterator = aggregrate.getIterator();
        Float value = (Float) iterator.first();
        Boolean state = iterator.next();

    }

}
