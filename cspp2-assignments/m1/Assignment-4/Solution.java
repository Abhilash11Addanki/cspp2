import java.util.Scanner;
/**
   *This program converts celcius to fahrenheit.
*/
public final class Solution {
    /**
       *Solution constructor.
    */
    private Solution() {

    }
    /**
       *Do not modify this main function.
       @param args for command line arguments.
    */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        double degreesCelsius = scan.nextDouble();
        calculateFromDegreesToFarenheit(degreesCelsius);
    }
    /**
        * Need to fill the calculateFromDegreesToFarenheit function
        * and print the output
        * of fahrenheit.
        *@param d is celcius.
    */
    private static void calculateFromDegreesToFarenheit(final double d) {
        double f;
        final int nine = 9;
        final int five = 5;
        final int thirtytwo = 32;
        f = (nine * d / five) + thirtytwo;
        System.out.println(f);
    }
}
