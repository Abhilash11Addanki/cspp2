import java.util.Scanner;
/**
 * Class for fibonacci.
 */
public class Fibonacci {
    /**
     * fib method.
     * @param      n     { parameter_description }
     * @return     { description_of_the_return_value }
     */
    public static List fib(int n) {
        // todo - complete this method
        List l = new List(n);
        int a = 0, b = 1, c;
        while (n > 0) {
        	l.add(a);
        	c = a + b;
        	a = b;
        	b = c;
        	n--;
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