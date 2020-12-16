package com.mycompany.firsttask;

public class Employee {
    private int id;
    private String firstName;
    private String lastName;
    private int salary;

    public Employee(int id, String firstName, String lastName, int salary) {
        if (id <= 0) {
            throw new IllegalArgumentException("Id should be > 0");
        } else if (salary < 0) {
            throw new IllegalArgumentException("Salary should be >= 0");
        } else {
            this.id = id;
            this.firstName = firstName;
            this.lastName = lastName;
            this.salary = salary;
        }
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getName() {
        return firstName + ' ' + lastName;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        if (salary < 0) {
            throw new IllegalArgumentException("salary should be >= 0");
        } else {
            this.salary = salary;
        }
    }

    public int getAnnualSalary() {
        return salary * 12;
    }

    public int raiseSalary(int percent) {
        int increasedSalary = (100 + percent) * salary / 100;
        return increasedSalary;
    }

    @Override
    public String toString() {
        return "Employee[" +
                "id=" + id +
                ", name=" + firstName + ' ' + lastName +
                ", salary=" + salary +
                ']';
    }
}
