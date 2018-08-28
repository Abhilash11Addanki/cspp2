
import java.util.Scanner;
/**
 * Class for solution.
 */
public final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {

    }
    /**
    *Do not modify this main function.
     *@param args for arguments.
    */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        int a = scan.nextInt();
        int b = scan.nextInt();
        int c = scan.nextInt();
        rootsOfQuadraticEquation(a, b, c);
    }
    /**
       *Need to write the rootsOfQuadraticEquation
      *function and print the output.
      *@param x argument.
      *@param y argument.
      *@param z argument.
    */
    static void rootsOfQuadraticEquation(final int x, final int y,
        final int z) {
        final int four = 4;
        final int two = 2;
        double root1 = (-y + Math.sqrt(y * y - four * x * z)) / (two * x);
        double root2 = (-y - Math.sqrt(y * y - four * x * z)) / (two * x);
        System.out.println(root1 + " " + root2);
    }
}



