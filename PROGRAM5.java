import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Week 8 Assignment - Problem 5: The Streaming Plan Renewal Reminder
 * Category C
 * 
 * Demonstrates polymorphism:
 * Base class SubscriptionPlan with subclasses BasicPlan, StandardPlan, PremiumPlan.
 */
public class PROGRAM5 {

    abstract static class SubscriptionPlan {
        protected String subscriberName;
        protected LocalDate startDate;

        public SubscriptionPlan(String subscriberName, LocalDate startDate) {
            this.subscriberName = subscriberName;
            this.startDate = startDate;
        }

        public String getSubscriberName() {
            return subscriberName;
        }

        public abstract LocalDate calculateRenewalDate();
    }

    static class BasicPlan extends SubscriptionPlan {
        public BasicPlan(String subscriberName, LocalDate startDate) {
            super(subscriberName, startDate);
        }

        @Override
        public LocalDate calculateRenewalDate() {
            // Basic plan: valid for 30 days
            return startDate.plusDays(30);
        }
    }

    static class StandardPlan extends SubscriptionPlan {
        public StandardPlan(String subscriberName, LocalDate startDate) {
            super(subscriberName, startDate);
        }

        @Override
        public LocalDate calculateRenewalDate() {
            // Standard plan: valid for 90 days
            return startDate.plusDays(90);
        }
    }

    static class PremiumPlan extends SubscriptionPlan {
        public PremiumPlan(String subscriberName, LocalDate startDate) {
            super(subscriberName, startDate);
        }

        @Override
        public LocalDate calculateRenewalDate() {
            // Premium plan: valid for 365 days
            return startDate.plusDays(365);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) {
            return;
        }
        int n = scanner.nextInt();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        List<SubscriptionPlan> subscriptions = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String planType = scanner.next();
            String name = scanner.next();
            String dateStr = scanner.next();
            LocalDate startDate = LocalDate.parse(dateStr, formatter);

            if ("BASIC".equalsIgnoreCase(planType)) {
                subscriptions.add(new BasicPlan(name, startDate));
            } else if ("STANDARD".equalsIgnoreCase(planType)) {
                subscriptions.add(new StandardPlan(name, startDate));
            } else if ("PREMIUM".equalsIgnoreCase(planType)) {
                subscriptions.add(new PremiumPlan(name, startDate));
            }
        }

        for (SubscriptionPlan plan : subscriptions) {
            LocalDate renewalDate = plan.calculateRenewalDate();
            System.out.printf("%s: %s\n", plan.getSubscriberName(), renewalDate.format(formatter));
        }

        scanner.close();
    }
}