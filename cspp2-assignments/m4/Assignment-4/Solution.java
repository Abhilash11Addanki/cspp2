/**
 * author : @abhilash
 * Date 30 Aug 2018
 */
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
        String s = sc.nextLine();
        String reverse = reverseString(s);
        System.out.println(reverse);
    }
    /**
     * reverseString method.
     * @param      str   The string.
     * @return     { description_of_the_return_value }
     */
    static String reverseString(final String str) {
        String[] s = str.split("");
        String res = "";
        for (int i = s.length - 1; i >= 0; i--) {
            res += s[i];
        }
        return res;
    }
}
