import java.util.Scanner;
/**
 * Class for student.
 */
class Student {
    /**
     * string name.
     */
    private String name;
    /**
     * string rollNumber.
     */
    private String rollNumber;
    /**
     * double m1.
     */
    private double m1;
    /**
     * double m2.
     */
    private double m2;
    /**
     * double m3.
     */
    private double m3;
    /**
     * Constructs the object.
     *
     * @param      n       { parameter_description }
     * @param      r       { parameter_description }
     * @param      marks1  The marks 1
     * @param      marks2  The marks 2
     * @param      marks3  The marks 3
     */
    Student(final String n, final String r,
        final double marks1, final double marks2, final double marks3) {
        name = n;
        rollNumber = r;
        m1 = marks1;
        m2 = marks2;
        m3 = marks3;
    }
    /**
     * { function_description }.
     * @return     { description_of_the_return_value }.
     */
    double gpa() {
        final int three = 3;
        return (m1 + m2 + m3) / three;
    }
}
/**
 * Class for student details.
 */
public final class StudentDetails {
    /**
     * Constructs the object.
     */
    private StudentDetails() {

    }
    /**
     * { function_description }.
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        String name = sc.next();
        String rollNumber = sc.next();
        double m1 = sc.nextDouble();
        double m2 = sc.nextDouble();
        double m3 = sc.nextDouble();
        Student s = new Student(name, rollNumber, m1, m2, m3);
        System.out.println(s.gpa());
    }
}
