package oop.lesson8;

import java.util.Comparator;

public class UserComparator<T extends User> implements Comparator<T> {

    @Override
    public int compare(T o1, T o2) {
        int result = o1.getFirstName().compareTo(o2.getFirstName());
        if (result == 0) {
            result = o1.getLastName().compareTo(o2.getLastName());
            if (result == 0) {
                result = o1.getMiddleName().compareTo(o2.getMiddleName());
            }
        }
        return result;
    }
}
