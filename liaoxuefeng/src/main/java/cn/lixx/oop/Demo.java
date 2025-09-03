package cn.lixx.oop;

public class Demo {
    public static void main(String[] args) {
        // 向上转型为Number:
        Number num = Integer.valueOf(999);
        // 获取byte, int, long, float, double:
        byte b = num.byteValue();
        int n = num.intValue();
        long ln = num.longValue();
        float f = num.floatValue();
        double d = num.doubleValue();

        System.out.println(b);
        System.out.println(n);
        System.out.println(ln);
        System.out.println(f);
        System.out.println(d);

    }

}
