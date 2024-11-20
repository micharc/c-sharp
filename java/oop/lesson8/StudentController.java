package oop.lesson8;

import java.util.List;

public class StudentController implements UserController<Student>{

    @Override
    public void create(String firstName, String lastName, String middleName) {
        studentGroupService.create(firstName, lastName, middleName);
    }

    private final StudentGroupService studentGroupService = new StudentGroupService();

    public void removeStudentByFIO (String lastName, String firstName, String middleName) {
        studentGroupService.removeStudentByFIO(lastName, firstName, middleName);
    }

    public List<Student> getSortedStudentList() {
        return studentGroupService.getSortedStudentList();
    }

    public List<Student> getSortedStudentByFIO() {
        return studentGroupService.getSortedStudentByFIO();
    }

    private final StreamService streamService = new StreamService();

    public List<Stream> getSortedStream() {
        return streamService.getSortedStream();
    }

}
