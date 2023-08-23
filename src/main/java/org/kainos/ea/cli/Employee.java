package org.kainos.ea.cli;

public abstract class Employee {
    private  int employeeId;
    private String name;
    private double salary;


    public Employee(int employeeId, String name, double salary) {
        setEmployeeId(employeeId);
        setName(name);
        setSalary(salary);
    }


    public double calcPay() {

        return getSalary()/12;
    }


    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }


    public abstract double calcPay(String role);
}
