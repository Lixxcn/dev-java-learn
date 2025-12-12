package cn.lixx.designpatterns;

import java.time.LocalDate;

class LocalDateFactory {
    static LocalDate fromInt(int yyyyMMdd) {
        int year = yyyyMMdd / 10000;
        int month = (yyyyMMdd % 10000) / 100;
        int day = yyyyMMdd % 100;

        return LocalDate.of(year, month, day);
    }
}

public class FactoryMethod {

    public static void main(String[] args) {
        LocalDate date1 = LocalDateFactory.fromInt(20200202);
        System.out.println("20200202 -> " + date1);

        LocalDate date2 = LocalDateFactory.fromInt(20231225);
        System.out.println("20231225 -> " + date2);

        LocalDate date3 = LocalDateFactory.fromInt(20240101);
        System.out.println("20240101 -> " + date3);
    }

}