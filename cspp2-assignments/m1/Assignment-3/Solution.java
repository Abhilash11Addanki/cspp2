import java.util.Scanner;
/**
   *This program displays the area of triangle.
*/
public final class Solution {
/**
   *Solution constructor.
*/
    private Solution() {

    }
    /**
       *Do not modify this main function.
       *@param args for command line arguments.
    */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        int base = scan.nextInt();
        int height = scan.nextInt();
        areaOfTriangle(base, height);
    }
    /**
        *Need to fill the areaOfTriangle function and print the output
         of fahrenheit.
        *@param b for breadth.
        *@param h for height.
    */
    private static void areaOfTriangle(final int b, final int h) {
        double area;
        final double val = 0.5;
        area = val * b * h;
        System.out.println(area);
    }
}
