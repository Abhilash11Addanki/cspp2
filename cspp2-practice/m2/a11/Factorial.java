import java.util.Scanner;
/**
 * Class for factorial.
 */
final class Factorial {
    /**
     * Constructs the object.
     */
    private Factorial() {

    }
    /**
     * main function.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number:");
        int n = sc.nextInt();
        System.out.println("The factorial is:" + factorial(n));
    }
    /**
     * function for calculating factorial.
     *
     * @param      n     { parameter_description }
     *
     * @return     { description_of_the_return_value }
     */
    static int factorial(final int n) {
        if (n == 0) {
            return 1;
        }
        int fact = n * factorial(n - 1);
        return fact;
    }
}
