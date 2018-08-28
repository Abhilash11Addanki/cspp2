import java.util.Scanner;
/**
    *This program prints the Name and Roll no.
*/
public final class Solution {
    /**
        *Solution constructor.
    */
        private Solution() {

        }
    /**
        *Main method.
        *@param args for command line arguments.
    */
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        String name = sc.next();
        int rollno = sc.nextInt();
        System.out.println("Name : " + name + ","
        + " Roll Number : " + rollno);
    }
}
