import java.util.Scanner;

public class PROGRAM5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int number = sc.nextInt();
        int origNumber = number;

        int sum = 0;

        while (number != 0) {
            int digit = number % 10;
            sum = sum + (digit * digit * digit);
            number = number / 10;
        }

        if (sum == origNumber) {
            System.out.println("Is the number " + origNumber + " an Armstrong number? Yes");
        } else {
            System.out.println("Is the number " + origNumber + " an Armstrong number? No");
        }

        sc.close();
    }
}