import java.util.Scanner;
/**
 * Class for area of circle.
 */
final class AreaOfCircle {
    /**
     * AreaOfCircle constructor.
     */
    private AreaOfCircle() {

    }
    /**
     * main method.
     * @param      args  The arguments.
     */
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        int r = sc.nextInt();
        System.out.println(area(r));
    }
    /**
     * pi method.
     * @return     { description_of_the_return_value }.
     */
    static double pi() {
        final double pi = 3.14;
        return pi;
    }
    /**
     * area method.
     * @param      radius  The radius.
     * @return     { description_of_the_return_value }.
     */
    static double area(final int radius) {
        return pi() * radius * radius;
    }
}
