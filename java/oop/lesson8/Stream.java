package oop.lesson8;

import java.util.Iterator;
import java.util.List;

public class Stream implements Iterable<StudentGroup> {

    private int numberOfGroups;

    private List<StudentGroup> studentGroupList;

    public List<StudentGroup> getStudentGroupList() {
        return studentGroupList;
    }

    @Override
    public Iterator<StudentGroup> iterator() {
        return new StreamIterator(this);
    }

    public Stream(List<StudentGroup> studentGroupList) {
        this.studentGroupList = studentGroupList;
        this.numberOfGroups = studentGroupList.size();
    }

    public int getNumberOfGroups() {
        return numberOfGroups;
    }

}
