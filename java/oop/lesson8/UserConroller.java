package oop.lesson8;

public interface UserController<T extends User> {
    void create(String firstName, String lastName, String middleName);
}
