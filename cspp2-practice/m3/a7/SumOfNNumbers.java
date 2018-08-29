import java.util.Scanner;
/**
 * Class for sum of n numbers.
 */
final class SumOfNNumbers {
    /**
     * Constructs the object.
     */
    private SumOfNNumbers() {

    }
    /**
     * main method.
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        int sum = 0;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the value of n:");
        int n = sc.nextInt();
        for (int i = 1; i <= n; i++) {
            sum = sum + i;
        }
        System.out.println("The sum of" + " " + n
            + " " + "natural numbers is:" + sum);
    }
}
