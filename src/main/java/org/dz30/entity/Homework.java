package org.dz30.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "homeworks")
public class Homework {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private LocalDate deadline;

    @Column(nullable = false)
    private int mark;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    public Homework(
            final String description,
            final LocalDate deadline,
            final int mark,
            final Student student
    ) {
        this.description = description;
        this.deadline = deadline;
        this.mark = mark;
        this.student = student;
    }

    public Homework() {
    }

    public Long getId() {
        return id;
    }

    public Homework setId(Long id) {
        this.id = id;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Homework setDescription(String description) {
        this.description = description;
        return this;
    }

    public LocalDate getDeadline() {
        return deadline;
    }

    public Homework setDeadline(LocalDate deadline) {
        this.deadline = deadline;
        return this;
    }

    public int getMark() {
        return mark;
    }

    public Homework setMark(int mark) {
        this.mark = mark;
        return this;
    }

    public Student getStudent() {
        return student;
    }

    public Homework setStudent(Student student) {
        this.student = student;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Homework homework = (Homework) o;
        return Objects.equals(id, homework.id);
    }

    @Override
    public int hashCode() {
        return (id != null) ? id.hashCode() : System.identityHashCode(this);
    }

    @Override
    public String toString() {
        return "Homework{" +
                "id=" + this.id +
                ", description='" + this.description + '\'' +
                ", deadline=" + this.deadline +
                ", mark=" + this.mark +
                '}';
    }
}

