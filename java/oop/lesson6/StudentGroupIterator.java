package oop.lesson6;

import java.util.Iterator;
import java.util.List;

public class StudentGroupIterator implements Iterator<Student> {

    private int count;
    private List<Student> studentList;

    public StudentGroupIterator(StudentGroup studentGroup) {
        this.count = 0;
        this.studentList = studentGroup.getStudentList();
    }

    @Override
    public boolean hasNext() {
        return count < studentList.size() - 1;
    }

    @Override
    public Student next() {
        if (!hasNext()) { return null; }
        return studentList.get(count++);
    }

    @Override
    public void remove() {
        studentList.remove(count);
    }
}
