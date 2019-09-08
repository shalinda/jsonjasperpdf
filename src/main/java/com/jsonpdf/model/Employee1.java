package com.jsonpdf.model;

public class Employee1 {

    private String name;
    private int age;
    private double salary;
    private String food;
    private Employee1 child;

    public Employee1 getChild() {
        return child;
    }

    public void setChild(Employee1 child) {
        this.child = child;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getFood() {
        return food;
    }

    public void setFood(String food) {
        this.food = food;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                ", food='" + food + '\'' +
                ", child=" + child +
                '}';
    }
}
