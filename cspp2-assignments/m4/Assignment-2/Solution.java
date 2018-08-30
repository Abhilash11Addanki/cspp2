import java.util.Scanner;
/**
 * Class for solution.
 */
public final class Solution {
    /**
     * { var_description }
     */
    private static Scanner sc = new Scanner(System.in);
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
        String[] a = rowcolumn();
        int m = Integer.parseInt(a[0]);
        int n = Integer.parseInt(a[1]);
        int[][] mat1 = matrix(m, n);
        String[] b = rowcolumn();
        int p = Integer.parseInt(b[0]);
        int q = Integer.parseInt(b[1]);
        int[][] mat2 = matrix(p, q);
        if (m == p && n == q) {
            for (int i = 0; i < p; i++){
                for (int j = 0; j < q; j++){
                    String s = (j != q -1) ? " " : "";
                    System.out.print(mat1[i][j] + mat2[i][j] + s);
                }
                System.out.println();
            }
        } else {
            System.out.println("not possible");
        }
    }
    /**
     * rowcolumn method.
     * @return     { description_of_the_return_value }
     */
    static String[] rowcolumn() {
        String str = sc.nextLine();
        String[] a = str.split(" ");
        return a;
    }
    /**
     * matrix method.
     * @param      a     { parameter_description }
     * @param      b     { parameter_description }
     * @return     { description_of_the_return_value }
     */
    static int[][] matrix(int a, int b) {
        int[][] mat = new int[a][b];
        for (int i = 0; i < a; i++) {
            String str1 = sc.nextLine();
            String[] s1 = str1.split(" ");
            for (int j = 0; j < b; j++) {
                mat[i][j] = Integer.parseInt(s1[j]);
            }
        }
        return mat;
    }
}
