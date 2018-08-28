import java.util.Scanner;
/**
   *This program converts celcius to fahrenheit.
*/
final class DegreesToFahrenheit {
/**
   *degreestofahrenheit constructor.
*/
private DegreesToFahrenheit() {

    }
/**
   *main method.
   *@param args are command line arguments.
*/
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        float cel = sc.nextInt();
        float fah;
        final int nine = 9;
        final int five = 5;
        final int thirtytwo = 32;
        fah = (nine * cel / five) + thirtytwo;
        System.out.println(fah);
    }
}
