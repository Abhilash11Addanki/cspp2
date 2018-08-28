
import java.util.Scanner;
/**
 * class Solution.
 */
public final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {

    }
    /**
       *Do not modify this main function.
      *@param args argument.
    */
    public static void main(final String[] args) {
        Scanner s = new Scanner(System.in);
        int base = s.nextInt();
        int exponent = s.nextInt();
        long result = power(base, exponent);
        System.out.println(result);
    }
    /**
       *Need to write the power function and print the output.
      *@param b argument.
      *@param e argument.
      *@return power.
    */
    static long power(final int b, final int e) {
        if (e == 0) {
            return 1;
        } else {
            long pow = b * power(b, e - 1);
            return pow;
        }
    }
}


