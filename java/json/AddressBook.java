package json;

import java.util.ArrayList;
import java.util.List;

public class AddressBook {
    List<Record> book = new ArrayList<>();

    public AddressBook addRecord(Record r) {
        book.add(r);
        return this;
    }
}
