import java.util.Scanner;
/**
 * Class for bigger equal smaller.
 */
final class BiggerEqualSmaller {
    /**
     * Constructs the object.
     */
    private BiggerEqualSmaller() {

    }
    /**
     * main method.
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the value of varA:");
        int varA = sc.nextInt();
        System.out.println("Enter the value of varB:");
        int varB = sc.nextInt();
        if (varA > varB) {
            System.out.println("Bigger");
        } else if (varA == varB) {
            System.out.println("Equal");
        } else {
            System.out.println("Smaller");
        }
    }
}
