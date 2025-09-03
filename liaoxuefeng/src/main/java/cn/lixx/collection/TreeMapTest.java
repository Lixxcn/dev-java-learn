package cn.lixx.collection;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class TreeMapTest {
    public static void main(String[] args) {
        Map<String, Integer> map = new TreeMap<>();
        map.put("orange", 1);
        map.put("apple", 2);
        map.put("pear", 3);
        for (String key : map.keySet()) {
            System.out.println(key);
        }
        System.out.println("==================");
        // apple, orange, pear
        Map<Person, Integer> personMap = new TreeMap<>(new Comparator<Person>() {
            public int compare(Person p1, Person p2) {
                return p1.name.compareTo(p2.name);
            }
        });
        personMap.put(new Person("Tom"), 1);
        personMap.put(new Person("Bob"), 2);
        personMap.put(new Person("Lily"), 3);
        for (Person key : personMap.keySet()) {
            System.out.println(key);
        }
        // {Person: Bob}, {Person: Lily}, {Person: Tom}
        System.out.println(personMap.get(new Person("Bob"))); // 2

        System.out.println("==================");

        Map<Student, Integer> studentMap = new TreeMap<>(new Comparator<Student>() {
            public int compare(Student p1, Student p2) {
                // if (p1.score == p2.score) {
                // return 0;
                // }
                // return p1.score > p2.score ? -1 : 1;
                return Integer.compare(p1.score, p2.score);

            }
        });
        studentMap.put(new Student("Tom", 77), 1);
        studentMap.put(new Student("Bob", 66), 2);
        studentMap.put(new Student("Lily", 99), 3);
        for (Student key : studentMap.keySet()) {
            System.out.println(key);
        }
        System.out.println(studentMap.get(new Student("Bob", 66))); // null?
    }

}

class Person {
    public String name;

    Person(String name) {
        this.name = name;
    }

    public String toString() {
        return "{Person: " + name + "}";
    }
}

class Student {
    public String name;
    public int score;

    Student(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public String toString() {
        return String.format("{%s: score=%d}", name, score);
    }
}