import java.util.Scanner;

public class PROGRAM1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int number = sc.nextInt();

        boolean isPrime = true;

        for (int i = 2; i < number; i++) {
            if (number % i == 0) {
                isPrime = false;
                break;
            }
        }

        if (number < 2) {
            isPrime = false;
        }

        if (isPrime) {
            System.out.println("Is the number " + number + " a Prime number? Yes");
        } else {
            System.out.println("Is the number " + number + " a Prime number? No");
        }

        sc.close();
    }
}