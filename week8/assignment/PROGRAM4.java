import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

/**
 * Week 8 Assignment - Problem 4: The Festival Bonus Calculator
 * Category C
 * 
 * Demonstrates polymorphism:
 * Base class Employee with subclasses FullTimeEmployee, PartTimeEmployee, InternEmployee.
 */
public class PROGRAM4 {

    abstract static class Employee {
        protected String name;
        protected double monthlySalary;

        public Employee(String name, double monthlySalary) {
            this.name = name;
            this.monthlySalary = monthlySalary;
        }

        public String getName() {
            return name;
        }

        public abstract double calculateBonus();
    }

    static class FullTimeEmployee extends Employee {
        public FullTimeEmployee(String name, double monthlySalary) {
            super(name, monthlySalary);
        }

        @Override
        public double calculateBonus() {
            // Full-time employees get 10% of monthly salary
            return monthlySalary * 0.10;
        }
    }

    static class PartTimeEmployee extends Employee {
        public PartTimeEmployee(String name, double monthlySalary) {
            super(name, monthlySalary);
        }

        @Override
        public double calculateBonus() {
            // Part-time employees get 5% of monthly salary
            return monthlySalary * 0.05;
        }
    }

    static class InternEmployee extends Employee {
        public InternEmployee(String name, double monthlySalary) {
            super(name, monthlySalary);
        }

        @Override
        public double calculateBonus() {
            // Interns get a fixed bonus of 2000
            return 2000.0;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) {
            return;
        }
        int n = scanner.nextInt();
        List<Employee> employees = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            String name = scanner.next();
            double salary = scanner.nextDouble();

            if ("FULLTIME".equalsIgnoreCase(type)) {
                employees.add(new FullTimeEmployee(name, salary));
            } else if ("PARTTIME".equalsIgnoreCase(type)) {
                employees.add(new PartTimeEmployee(name, salary));
            } else if ("INTERN".equalsIgnoreCase(type)) {
                employees.add(new InternEmployee(name, salary));
            }
        }

        double totalBonus = 0.0;
        for (Employee emp : employees) {
            double bonus = emp.calculateBonus();
            System.out.printf("%s: %.2f\n", emp.getName(), bonus);
            totalBonus += bonus;
        }

        System.out.printf("Total Bonus: %.2f\n", totalBonus);
        scanner.close();
    }
}
