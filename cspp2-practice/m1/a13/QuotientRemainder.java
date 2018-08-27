import java.util.Scanner;
/**
   *This program displays quotient and remainder of two numbers.
*/
final class QuotientRemainder {
/**
   *quotient_remainder constructor.
*/
    private QuotientRemainder() {

    }
/**
   *Main method.
   *@param args are command line arguments.
*/
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        System.out.println("The numbers are:" + a + "," + b);
        int quotient = a / b;
        int remainder = a % b;
        System.out.println("The quotient is:" + quotient);
        System.out.println("The remainder is:" + remainder);
    }
}
