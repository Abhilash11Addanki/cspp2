
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
     * main method.
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            String s = sc.next();
            String res = binaryToDecimal(s);
            System.out.println(res);
        }
    }
    /**
     * binaryToDecimal.
     * @param      s     { parameter_description }
     * @return     { description_of_the_return_value }
     */
    static String binaryToDecimal(final String s) {
        String[] s1 = s.split("");
        int cnt = s1.length - 1;
        int sum = 0;
        for (int i = 0; i < s1.length; i++) {
            if (Integer.parseInt(s1[i]) == 1) {
                sum += Math.pow(2, cnt);
                cnt -= 1;
            } else {
                cnt -= 1;
            }
        }
        return Integer.toString(sum);
    }
}
