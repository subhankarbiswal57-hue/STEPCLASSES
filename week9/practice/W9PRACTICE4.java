import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

/**
 * Week 9 Practice - Problem 4: Employee Bonus Distributor
 *
 * Demonstrates inheritance and polymorphism:
 * Base class Employee with subclasses Manager, Developer, Intern.
 * Each role receives a different bonus percentage on their salary.
 */
public class W9PRACTICE4 {

    abstract static class Employee {
        protected String name;
        protected double salary;

        public Employee(String name, double salary) {
            this.name = name;
            this.salary = salary;
        }

        public String getName() {
            return name;
        }

        public abstract double getBonusPercentage();
        public abstract String getRole();

        public double calculateBonus() {
            return salary * getBonusPercentage() / 100.0;
        }
    }

    static class Manager extends Employee {
        public Manager(String name, double salary) {
            super(name, salary);
        }

        @Override
        public double getBonusPercentage() {
            return 20.0;
        }

        @Override
        public String getRole() {
            return "MANAGER";
        }
    }

    static class Developer extends Employee {
        public Developer(String name, double salary) {
            super(name, salary);
        }

        @Override
        public double getBonusPercentage() {
            return 15.0;
        }

        @Override
        public String getRole() {
            return "DEVELOPER";
        }
    }

    static class Intern extends Employee {
        public Intern(String name, double salary) {
            super(name, salary);
        }

        @Override
        public double getBonusPercentage() {
            return 5.0;
        }

        @Override
        public String getRole() {
            return "INTERN";
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) {
            return;
        }
        int n = scanner.nextInt();
        scanner.nextLine();
        List<Employee> employees = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine().trim();
            String[] parts = line.split(" ");
            String role = parts[0];
            String name = parts[1];
            double salary = Double.parseDouble(parts[2]);

            if ("MANAGER".equalsIgnoreCase(role)) {
                employees.add(new Manager(name, salary));
            } else if ("DEVELOPER".equalsIgnoreCase(role)) {
                employees.add(new Developer(name, salary));
            } else if ("INTERN".equalsIgnoreCase(role)) {
                employees.add(new Intern(name, salary));
            }
        }

        double totalBonus = 0.0;
        for (Employee emp : employees) {
            double bonus = emp.calculateBonus();
            System.out.printf("%s (%s): %.2f%n", emp.getName(), emp.getRole(), bonus);
            totalBonus += bonus;
        }
        System.out.printf("Total Bonus: %.2f%n", totalBonus);
        scanner.close();
    }
}
