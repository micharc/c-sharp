package oop.lesson8;

import java.util.Iterator;
import java.util.List;

public class StreamGroup implements Iterator<Stream> {

    private int count;
    private List<Stream> streamList;

    public StreamGroup(StreamGroup streamGroup) {
        this.count = 0;
        this.streamList = streamGroup.getStudentGroupList();
    }

    @Override
    public boolean hasNext() {
        return count < streamList.size() - 1;
    }

    @Override
    public Stream next() {
        if (hasNext()) {
            return streamList.get(count++);
        } else {
            return null;
        }
    }

    @Override
    public void remove() {
        streamList.remove(count);
    }

    public List<Stream> getStudentGroupList() {
        return streamList;
    }

    public List<Stream> getStreamList() {
        return streamList;
    }

    public void setStreamList(List<Stream> streamList) {
        this.streamList = streamList;
    }

}
