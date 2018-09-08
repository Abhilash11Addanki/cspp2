import java.io.BufferedInputStream;
import java.util.Scanner;
import java.util.Arrays;

/**
 * Class for set.
 * @author :
 */
class Set {
    /**
     * set arr.
     */
    private int[] arr;
    /**
     * size of arr.
     */
    private int size;
    /**
     * Constructs the object.
     */
    Set() {
        final int ten = 10;
        arr = new int[ten];
        size = 0;
    }
    /**
     * Constructs the object.
     * @param      n     { parameter_description }
     */
    Set(final int n) {
        size = 0;
        arr = new int[n];
    }
    /**
     * resize method.
     * @return     { description_of_the_return_value }
     */
    public int[] resize() {
        int n = 2 * size;
        int[] newarr = Arrays.copyOf(arr, n);
        return newarr;
    }
    /**
     * size method.
     * @return     { description_of_the_return_value }
     */
    public int size() {
        return size;
    }
    /**
     * contains method.
     * @param      item  The item
     * @return     { description_of_the_return_value }
     */
    public boolean contains(final int item) {
        for (int i = 0; i < size; i++) {
            if (arr[i] == item) {
                return true;
            }
        }
        return false;
    }
    /**
     * Returns a string representation of the object.
     * @return     String representation of the object.
     */
    public String toString() {
        if (size == 0) {
            return "{}";
        }
        String str = "{";
        int i = 0;
        for (i = 0; i < size - 1; i++) {
            str = str + arr[i] + ", ";
        }
        str = str + arr[i] + "}";
        return str;
    }
    /**
     * add method.
     * @param      item  The item
     */
    public void add(final int item) {
        if (size == arr.length) {
            arr = resize();
        }
        if (!contains(item)) {
            arr[size++] = item;
        }
    }
    /**
     * add method for n number of elements.
     * @param      newArray  The new array
     */
    public void add(final int[] newArray) {
        int[] resArray = Arrays.copyOf(newArray, newArray.length);
        if (size == newArray.length) {
            resArray = resize();
        }
        int newsize = size;
        for (int i = newsize, j = 0; i < newsize + resArray.length; i++) {
            if (!contains(resArray[j])) {
                add(resArray[j]);
            }
            j++;
        }
    }
    /**
     * intersection method.
     * @param      set   The set
     * @return     { description_of_the_return_value }
     */
    public Set intersection(final Set set) {
        Set resArray = new Set();
        for (int i = 0; i < size; i++) {
            if (set.contains(arr[i])) {
                resArray.add(arr[i]);
            }
        }
        return resArray;
    }
    /**
     * retainAll method.
     * @param      newArray  The new array
     * @return     { description_of_the_return_value }
     */
    public Set retainAll(final int[] newArray) {
        Set resArray = new Set();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < newArray.length; j++) {
                if (arr[i] == newArray[j]) {
                    resArray.add(arr[i]);
                }
            }
        }
        return resArray;
    }
    /**
     * cartesianProduct method.
     * @param      set   The set
     * @return     { description_of_the_return_value }
     */
    public int[][] cartesianProduct(final Set set) {
        if (size == 0 || set.size == 0) {
            return null;
        }
        int i = 0, k = 0;
        int rows = size * set.size;
        int[][] resArray = new int[rows][2];
        for (int j = 0; j < rows; j++) {
            resArray[j][0] = arr[i];
            resArray[j][1] = set.arr[k++];
            if (k == set.size) {
                k = 0;
                i++;
            }
        }
        return resArray;
    }
}
/**
 * Solution class for code-eval.
 */
public final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {

    }
    /**
     * helper function to convert string input to int array.
     *
     * @param      s     { string input from test case file }
     *
     * @return     { int array from the given string }
     */
    public static int[] intArray(final String s) {
        String input = s;
        if (input.equals("[]")) {
            return new int[0];
        }
        if (s.contains("[")) {
            input = s.substring(1, s.length() - 1);
        }
        return Arrays.stream(input.split(","))
               .mapToInt(Integer::parseInt)
               .toArray();
    }
    /**
     * main function to execute test cases.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        // instantiate this set
        Set s = new Set();
        // code to read the test cases input file
        Scanner stdin = new Scanner(new BufferedInputStream(System.in));
        // check if there is one more line to process
        while (stdin.hasNext()) {
            // read the line
            String line = stdin.nextLine();
            // split the line using space
            String[] tokens = line.split(" ");
            // based on the list operation invoke the corresponding method
            switch (tokens[0]) {
            case "size":
                System.out.println(s.size());
                break;
            case "contains":
                System.out.println(s.contains(Integer.parseInt(tokens[1])));
                break;
            case "print":
                System.out.println(s);
                break;
            case "add":
                int[] intArray = intArray(tokens[1]);
                if (intArray.length == 1) {
                    s.add(intArray[0]);
                } else {
                    s.add(intArray);
                }
                break;
            case "intersection":
                s = new Set();
                Set t = new Set();
                intArray = intArray(tokens[1]);
                s.add(intArray);
                intArray = intArray(tokens[2]);
                t.add(intArray);
                System.out.println(s.intersection(t));
                break;
            case "retainAll":
                s = new Set();
                intArray = intArray(tokens[1]);
                s.add(intArray);
                intArray = intArray(tokens[2]);
                System.out.println(s.retainAll(intArray));
                break;
            case "cartesianProduct":
                s = new Set();
                t = new Set();
                intArray = intArray(tokens[1]);
                s.add(intArray);
                intArray = intArray(tokens[2]);
                t.add(intArray);
                System.out.println(Arrays.deepToString(s.cartesianProduct(t)));
                break;
            default:
                break;
            }
        }
    }
}


