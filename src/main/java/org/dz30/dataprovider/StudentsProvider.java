package org.dz30.dataprovider;

import org.dz30.entity.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentsProvider {
    public static List<Student> get() {
        List<Student> students = new ArrayList<>();
        students.add(new Student("Igor", "Novikov", "mail@mail.com"));
        students.add(new Student("Vladimir", "Pupkin", "mail2@mail.com"));
        students.add(new Student("Vladislav", "Pupkin", "mail3@mail.com"));
        return students;
    }
}
