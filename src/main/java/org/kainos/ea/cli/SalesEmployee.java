package org.kainos.ea.cli;


public class SalesEmployee {
    private  int employeeId;
    private String name;
    private double salary;
    private double monthlySalary;
    private float commissionRate;

    public SalesEmployee(int employeeId, String name, double salary, double monthlySalary, float comissionRate) {
        setEmployeeId(employeeId);
        setName(name);
        setSalary(salary);
        setMonthlySalary(monthlySalary);
        setCommissionRate(comissionRate);
    }
    public int getEmployeeId() {
        return employeeId;
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

    public double getMonthlySalary() {
        return monthlySalary;
    }

    public void setMonthlySalary(double monthlySalary) {
        this.monthlySalary = monthlySalary;
    }

    public float getCommissionRate() {
        return commissionRate;
    }

    public void setCommissionRate(float commissionRate) {
        this.commissionRate = commissionRate;
    }




}