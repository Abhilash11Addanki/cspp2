import java.util.Scanner;
/**
   *Program to swap two numbers.
*/
final class Swap {
/**
   *Swap Constructor.
*/
private Swap() {

}
/**
   *Main method to swap numbers.
   * @param args for command line arguments.
*/
public static void main(final String[] args) {
Scanner sc = new Scanner(System.in);
int a = sc.nextInt();
int b = sc.nextInt();
System.out.println("The numbers are:" + a + "," + b);
int temp;
temp = a;
a = b;
b = temp;
System.out.println("The swapped numbers are:" + a + "," + b);
}
}
