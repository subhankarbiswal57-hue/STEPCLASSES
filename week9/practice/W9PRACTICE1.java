import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

/**
 * Week 9 Practice - Problem 1: Online Course Fee Calculator
 *
 * Demonstrates polymorphism:
 * Base class Course with specialized subclasses LiveCourse, RecordedCourse, HybridCourse.
 * Each type applies a different discount policy.
 */
public class W9PRACTICE1 {

    abstract static class Course {
        protected String name;
        protected double baseFee;

        public Course(String name, double baseFee) {
            this.name = name;
            this.baseFee = baseFee;
        }

        public String getName() {
            return name;
        }

        public abstract double calculateFee();
        public abstract String getCourseType();
    }

    static class LiveCourse extends Course {
        public LiveCourse(String name, double baseFee) {
            super(name, baseFee);
        }

        @Override
        public double calculateFee() {
            return baseFee; // No discount for live courses
        }

        @Override
        public String getCourseType() {
            return "LIVE";
        }
    }

    static class RecordedCourse extends Course {
        public RecordedCourse(String name, double baseFee) {
            super(name, baseFee);
        }

        @Override
        public double calculateFee() {
            return baseFee * 0.80; // 20% discount for recorded courses
        }

        @Override
        public String getCourseType() {
            return "RECORDED";
        }
    }

    static class HybridCourse extends Course {
        public HybridCourse(String name, double baseFee) {
            super(name, baseFee);
        }

        @Override
        public double calculateFee() {
            return baseFee * 0.90; // 10% discount for hybrid courses
        }

        @Override
        public String getCourseType() {
            return "HYBRID";
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) {
            return;
        }
        int n = scanner.nextInt();
        scanner.nextLine();
        List<Course> courses = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine().trim();
            String[] parts = line.split(" ");
            String type = parts[0];
            double fee = Double.parseDouble(parts[parts.length - 1]);
            StringBuilder nameBuild = new StringBuilder();
            for (int j = 1; j < parts.length - 1; j++) {
                if (j > 1) nameBuild.append(" ");
                nameBuild.append(parts[j]);
            }
            String courseName = nameBuild.toString();

            if ("LIVE".equalsIgnoreCase(type)) {
                courses.add(new LiveCourse(courseName, fee));
            } else if ("RECORDED".equalsIgnoreCase(type)) {
                courses.add(new RecordedCourse(courseName, fee));
            } else if ("HYBRID".equalsIgnoreCase(type)) {
                courses.add(new HybridCourse(courseName, fee));
            }
        }

        double total = 0.0;
        for (Course course : courses) {
            double finalFee = course.calculateFee();
            System.out.printf("%s (%s): %.2f%n", course.getName(), course.getCourseType(), finalFee);
            total += finalFee;
        }
        System.out.printf("Total Fee: %.2f%n", total);
        scanner.close();
    }
}
