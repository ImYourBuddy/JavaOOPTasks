package com.mycompany.firsttask;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        boolean idEquals = (id == employee.id);
        boolean salaryEquals = (salary == employee.salary);
        boolean firstNameEquals = (firstName == null && employee.firstName == null)
                || (firstName != null && firstName.equals(employee.firstName));
        boolean lastNameEquals = (lastName == null && employee.lastName == null)
                || (lastName != null && lastName.equals(employee.lastName));
        return idEquals && salaryEquals && firstNameEquals && lastNameEquals;
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + id;
        result = 31 * result + salary;
        result = 31 * result + (firstName == null ? 0 : firstName.hashCode());
        result = 31 * result + (lastName == null ? 0 : lastName.hashCode());
        return result;
    }
}
