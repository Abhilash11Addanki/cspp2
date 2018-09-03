import java.util.Scanner;
/**
 * Class for input validator.
 */
class InputValidator {
    /**
     * String data.
     */
    private String data;
    /**
     * int length.
     */
    private final int length = 6;
    /**
     * Constructs the object.
     * @param      d     { parameter_description }
     */
    InputValidator(final String d) {
        data = d;
    }
    /**
     * validateData method.
     * @return     { description_of_the_return_value }
     */
    boolean validateData() {
        if (data.length() >= length) {
            return true;
        }
        return false;
    }
}
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
        Scanner s = new Scanner(System.in);
        String input = s.next();
        InputValidator i = new InputValidator(input);   
        System.out.println(i.validateData());

    }
}
