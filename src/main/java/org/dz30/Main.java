package org.dz30;

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

        Homework homework = new Homework(
                "Work1",
                LocalDate.now(),
                1,
                student
        );

        student.addHomework(homework);
        studentRepository.update(student);
        System.out.println(homework.toString());
        student.removeHomework(homework);
        studentRepository.update(student);



//
//        System.out.println("Find Student By Email..");
//        student = studentRepository.findByEmail(students.getFirst().getEmail());
//        System.out.println(student);
//        System.out.println("Update Student..");
//        student.setFirstName("Dave");
//        studentRepository.update(student);
//        System.out.println("Delete Student..");
//        studentRepository.deleteById(student.getId());
//        System.out.println("Get All Students After Delete..");
//        students = studentRepository.findAll();
//        students.forEach(System.out::println);

    }
}
