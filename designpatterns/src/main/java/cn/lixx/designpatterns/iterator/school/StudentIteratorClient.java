package cn.lixx.designpatterns.iterator.school;

import java.util.Iterator;

public class StudentIteratorClient {
    public static void main(String[] args) {
        SchoolClass schoolClass = new SchoolClass();
        schoolClass.addStudent(new Student("Alice", 20));
        schoolClass.addStudent(new Student("Bob", 22));
        schoolClass.addStudent(new Student("Charlie", 19));
        schoolClass.addStudent(new Student("David", 25));
        schoolClass.addStudent(new Student("Eve", 22));

        System.out.println("按年龄降序遍历学生：");
        Iterator<Student> iterator = schoolClass.getStudentsByAgeDescIterator();
        
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}