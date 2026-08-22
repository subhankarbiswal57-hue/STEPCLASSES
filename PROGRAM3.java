import java.util.Scanner;
public class PROGRAM3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int number = sc.nextInt();
        int origNumber = number;

        int reversedNumber = 0;

        while (number != 0) {
            int digit = number % 10;
            reversedNumber = reversedNumber * 10 + digit;
            number = number / 10;
        }

        if (reversedNumber == origNumber) {
            System.out.println("Is the number " + origNumber + " a Palindrome? Yes");
        } else {
            System.out.println("Is the number " + origNumber + " a Palindrome? No");
        }

        sc.close();
    }
}
    
