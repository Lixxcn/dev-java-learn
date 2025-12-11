package cn.lixx.designpatterns.flyweight;

/**
 * Learn Java from https://www.liaoxuefeng.com/
 * 
 * @author liaoxuefeng
 */
public class Main {

    public static void main(String[] args) {
        test1();
        test2();

        Student s1 = Student.create(1, "小明");
        Student s2 = Student.create(2, "小红");
        Student s3 = Student.create(1, "小明");
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);
        System.out.println(s1 == s3); // true
    }

    private static void test1() {
        Integer n1 = Integer.valueOf(100);
        Integer n2 = Integer.valueOf(100);
        System.out.println(n1 == n2); // true
    }

    private static void test2() {
        Integer n1 = Integer.valueOf(200);
        Integer n2 = Integer.valueOf(200);
        System.out.println(n1 == n2); // false
    }
}
