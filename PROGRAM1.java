/**
 * Week 6 Practice - Problem 1: Employee Payroll System (Inheritance + Polymorphism)
 * Base class Employee with subclasses FullTimeEmployee and PartTimeEmployee.
 */
public class PROGRAM1 {

    static abstract class Employee {
        private String name;
        private int id;

        public Employee(String name, int id) {
            this.name = name;
            this.id = id;
        }

        public String getName() { return name; }
        public int getId() { return id; }

        public abstract double calculateSalary();

        @Override
        public String toString() {
            return "ID: " + id + " | Name: " + name + " | Salary: " + String.format("%.2f", calculateSalary());
        }
    }

    static class FullTimeEmployee extends Employee {
        private double monthlySalary;

        public FullTimeEmployee(String name, int id, double monthlySalary) {
            super(name, id);
            this.monthlySalary = monthlySalary;
        }

        @Override
        public double calculateSalary() {
            return monthlySalary;
        }
    }

    static class PartTimeEmployee extends Employee {
        private double hourlyRate;
        private int hoursWorked;

        public PartTimeEmployee(String name, int id, double hourlyRate, int hoursWorked) {
            super(name, id);
            this.hourlyRate = hourlyRate;
            this.hoursWorked = hoursWorked;
        }

        @Override
        public double calculateSalary() {
            return hourlyRate * hoursWorked;
        }
    }

    public static void printPayroll(Employee[] employees) {
        double totalPayroll = 0;
        System.out.println("--- Payroll Report ---");
        for (Employee emp : employees) {
            System.out.println(emp);
            totalPayroll += emp.calculateSalary();
        }
        System.out.println("Total Payroll: " + String.format("%.2f", totalPayroll));
    }

    public static void main(String[] args) {
        Employee[] team = {
            new FullTimeEmployee("Alice", 101, 50000),
            new PartTimeEmployee("Bob", 102, 250, 80),
            new FullTimeEmployee("Charlie", 103, 60000),
            new PartTimeEmployee("Diana", 104, 300, 60)
        };
        printPayroll(team);
    }
}