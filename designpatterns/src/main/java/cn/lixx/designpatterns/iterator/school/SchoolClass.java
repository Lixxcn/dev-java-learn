package cn.lixx.designpatterns.iterator.school;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class SchoolClass {
    private List<Student> students = new ArrayList<>();

    public void addStudent(Student student) {
        students.add(student);
    }

    /**
     * 返回按年龄降序排列的学生迭代器。
     * 我们不修改原始列表的顺序以保留插入顺序，
     * 因此我们对副本进行排序。
     */
    public Iterator<Student> getStudentsByAgeDescIterator() {
        List<Student> sortedList = new ArrayList<>(students);
        Collections.sort(sortedList, new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {
                return s2.getAge() - s1.getAge(); // 降序
            }
        });
        return sortedList.iterator();
    }
}