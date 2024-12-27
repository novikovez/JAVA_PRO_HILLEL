package org.dz30;

import org.dz30.dataprovider.HomeworkProvider;
import org.dz30.dataprovider.StudentsProvider;
import org.dz30.entity.Homework;
import org.dz30.entity.Student;
import org.dz30.dao.HomeworkDao;
import org.dz30.dao.StudentDao;

import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        StudentDao studentRepository = new StudentDao();

        for (Student student : StudentsProvider.get()) {
            System.out.println("Add Student..");
            studentRepository.save(student);
        }
        System.out.println("Get All Students..");
        List<Student> students = studentRepository.findAll();
        students.forEach(System.out::println);
        System.out.println("Find Student By ID..");
        Student student = studentRepository.findById(students.getFirst().getId());
        System.out.println(student);

        for(Homework homeworkItem : HomeworkProvider.get()) {
            student.addHomework(homeworkItem);
        }
        studentRepository.update(student);
        System.out.println(student.getHomeworks());

        student.removeHomework(student.getHomeworks().iterator().next());
        studentRepository.update(student);
        System.out.println(student.getHomeworks());
    }
}
