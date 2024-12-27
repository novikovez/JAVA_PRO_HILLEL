package org.dz30.dataprovider;

import org.dz30.entity.Homework;
import org.dz30.entity.Student;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class HomeworkProvider {
    public static List<Homework> get() {
        List<Homework> homework = new ArrayList<>();
        homework.add(new Homework().setDescription("Work 1").setDeadline(LocalDate.now()).setMark(2));
        homework.add(new Homework().setDescription("Work 2").setDeadline(LocalDate.now()).setMark(44));
        homework.add(new Homework().setDescription("Work 3").setDeadline(LocalDate.now()).setMark(11));
        return homework;
    }
}
