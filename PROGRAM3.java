/**
 * Week 6 Assignment - Problem 3: Employee Profile Creation
 * Constructor chaining with this(...) for Employee class supporting interns & permanent staff.
 */
public class PROGRAM3 {

    static class Employee {
        private String empId;
        private String empName;
        private double salary;
        private boolean isIntern;

        public Employee(String empId, String empName, double salary) {
            this.empId = empId;
            this.empName = empName;
            this.salary = salary;
            this.isIntern = false;
        }

        public Employee(String empId, String empName) {
            this(empId, empName, 0.0);
            this.isIntern = true;
        }

        public void printProfile() {
            System.out.println(empId + " | " + empName + " | Rs " + salary + " | Intern: " + isIntern);
        }
    }

    public static void main(String[] args) {
        Employee permanent = new Employee("E-101", "Divya", 65000.0);
        Employee intern = new Employee("E-102", "Arjun");

        permanent.printProfile();
        intern.printProfile();
    }
}
