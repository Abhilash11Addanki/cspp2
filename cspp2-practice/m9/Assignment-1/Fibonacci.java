import java.util.Scanner;
/**
 * Class for fibonacci.
 */
public final class Fibonacci {
    /**
     * Constructs the object.
     */
    private Fibonacci() {

    }
    /**
     * fib method.
     * @param      n     { parameter_description }
     * @return     { description_of_the_return_value }
     */
    public static List fib(final int n) {
        // todo - complete this method
        List l = new List(n);
        int a = 0, b = 1, c, m = n;
        while (m > 0) {
            l.add(a);
            c = a + b;
            a = b;
            b = c;
            m--;
        }
        return l;
    }
    /**
     * main method.
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        System.out.println(fib(n));
    }
}
