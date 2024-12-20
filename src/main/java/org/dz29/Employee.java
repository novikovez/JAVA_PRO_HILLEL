package org.dz29;

public class Employee {
    private int id;
    private String name;
    private int age;
    private String position;
    private float salary;

    public int getId() {
        return id;
    }

    public Employee setId(int id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Employee setName(String name) {
        this.name = name;
        return this;
    }

    public int getAge() {
        return age;
    }

    public Employee setAge(int age) {
        this.age = age;
        return this;
    }

    public String getPosition() {
        return position;
    }

    public Employee setPosition(String position) {
        this.position = position;
        return this;
    }

    public float getSalary() {
        return salary;
    }

    public Employee setSalary(float salary) {
        this.salary = salary;
        return this;
    }

    public String toString() {
        return "Employee{" +
                "id=" + this.id +
                ", name='" + this.name + '\'' +
                ", age=" + this.age +
                ", position='" + this.position + '\'' +
                ", salary=" + this.salary +
                '}';
    }
}
