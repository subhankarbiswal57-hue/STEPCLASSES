import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

/**
 * Week 9 Assignment - Problem 4: The Student Scholarship Eligibility Checker
 *
 * Demonstrates inheritance and polymorphism:
 * Base class Student with subclasses MeritStudent, NeedBasedStudent, SportsStudent.
 * Each type has different eligibility criteria and scholarship amounts.
 */
public class W9ASSIGNMENT4 {

    abstract static class Student {
        protected String studentName;
        protected double cgpa;
        protected double familyIncome;

        public Student(String studentName, double cgpa, double familyIncome) {
            this.studentName = studentName;
            this.cgpa = cgpa;
            this.familyIncome = familyIncome;
        }

        public String getStudentName() {
            return studentName;
        }

        public abstract boolean isEligible();
        public abstract double getScholarshipAmount();
        public abstract String getScholarshipType();
    }

    static class MeritStudent extends Student {
        public MeritStudent(String studentName, double cgpa, double familyIncome) {
            super(studentName, cgpa, familyIncome);
        }

        @Override
        public boolean isEligible() {
            return cgpa >= 8.5; // Merit: CGPA >= 8.5
        }

        @Override
        public double getScholarshipAmount() {
            return isEligible() ? 50000.0 : 0.0;
        }

        @Override
        public String getScholarshipType() {
            return "MERIT";
        }
    }

    static class NeedBasedStudent extends Student {
        public NeedBasedStudent(String studentName, double cgpa, double familyIncome) {
            super(studentName, cgpa, familyIncome);
        }

        @Override
        public boolean isEligible() {
            return familyIncome <= 300000.0 && cgpa >= 6.0; // Need-based: income <= 3L and CGPA >= 6
        }

        @Override
        public double getScholarshipAmount() {
            return isEligible() ? 30000.0 : 0.0;
        }

        @Override
        public String getScholarshipType() {
            return "NEED_BASED";
        }
    }

    static class SportsStudent extends Student {
        private String sportsLevel; // STATE, NATIONAL, INTERNATIONAL

        public SportsStudent(String studentName, double cgpa, double familyIncome, String sportsLevel) {
            super(studentName, cgpa, familyIncome);
            this.sportsLevel = sportsLevel;
        }

        @Override
        public boolean isEligible() {
            return cgpa >= 5.0 && (sportsLevel.equalsIgnoreCase("STATE")
                    || sportsLevel.equalsIgnoreCase("NATIONAL")
                    || sportsLevel.equalsIgnoreCase("INTERNATIONAL"));
        }

        @Override
        public double getScholarshipAmount() {
            if (!isEligible()) return 0.0;
            if (sportsLevel.equalsIgnoreCase("INTERNATIONAL")) return 75000.0;
            if (sportsLevel.equalsIgnoreCase("NATIONAL")) return 50000.0;
            return 25000.0; // STATE
        }

        @Override
        public String getScholarshipType() {
            return "SPORTS";
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) {
            return;
        }
        int n = scanner.nextInt();
        scanner.nextLine();
        List<Student> students = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine().trim();
            String[] parts = line.split(" ");
            String type = parts[0];
            String name = parts[1];
            double cgpa = Double.parseDouble(parts[2]);
            double income = Double.parseDouble(parts[3]);

            if ("MERIT".equalsIgnoreCase(type)) {
                students.add(new MeritStudent(name, cgpa, income));
            } else if ("NEED_BASED".equalsIgnoreCase(type)) {
                students.add(new NeedBasedStudent(name, cgpa, income));
            } else if ("SPORTS".equalsIgnoreCase(type)) {
                String level = parts[4];
                students.add(new SportsStudent(name, cgpa, income, level));
            }
        }

        for (Student s : students) {
            String status = s.isEligible() ? "Eligible" : "Not Eligible";
            System.out.printf("%s (%s): %s, Amount: %.2f%n",
                    s.getStudentName(), s.getScholarshipType(), status, s.getScholarshipAmount());
        }
        scanner.close();
    }
}
