/**
 * Week 6 Assignment - Problem 5: Employee and Company Information Management
 * Demonstrates static fields, static methods, and instance variables.
 */
public class PROGRAM5 {

    static class Employee {
        private String empName;
        private double salary;

        private static String companyName = "Bright Horizon Technologies";
        private static int employeeCount = 0;

        public Employee(String empName, double salary) {
            this.empName = empName;
            this.salary = salary;
            employeeCount++;
        }

        public static void printCompanyInfo() {
            System.out.println(companyName);
            System.out.println("Employees on record: " + employeeCount);
        }
    }

    public static void main(String[] args) {
        new Employee("Amit", 50000);
        new Employee("Sneha", 60000);
        new Employee("Rahul", 55000);

        Employee.printCompanyInfo();
    }
}