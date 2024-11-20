package oop.lesson8;

import java.util.ArrayList;
import java.util.List;

public class StreamService {
    private StreamGroup streamGroup;

    public List<Stream> getSortedStream() {
        List<Stream> groupList = new ArrayList<>(streamGroup.getStudentGroupList());
        groupList.sort(new StreamComparator());
        return groupList;
    }

    public StreamGroup getStreamGroup() {
        return streamGroup;
    }

    public void setStreamGroup(StreamGroup streamGroup) {
        this.streamGroup = streamGroup;
    }
}
