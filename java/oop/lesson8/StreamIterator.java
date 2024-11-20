package oop.lesson8;

import java.util.Iterator;
import java.util.List;

public class StreamIterator implements Iterator<StudentGroup>{

    private int count;
    private List<StudentGroup> studentGroupList;

    public StreamIterator(Stream stream) {
        this.count = 0;
        this.studentGroupList = stream.getStudentGroupList();
    }

    @Override
    public boolean hasNext() {
        return count < studentGroupList.size() - 1;
    }

    @Override
    public StudentGroup next() {
        if (!hasNext()) { return null; }
        return studentGroupList.get(count++);
    }

    @Override
    public void remove() {
        studentGroupList.remove(count);
    }

}

