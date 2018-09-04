import java.io.BufferedInputStream;
import java.util.Scanner;
import java.util.Arrays;
/**
 * List class.
 */
public class List {
/**
 * Integer array.
 */
    private int[] arr;
/**
 * size of type int.
 */
    private int size;
/**
 * Constructs the object.
 */
    public List() {
        final int ten = 10;
        arr = new int[ten];
        size = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                size += 1;
            }
        }
    }
    /**
     * add method.
     * @param      item  The item
     */
    public void add(final int item) {
        //Inserts the specified element at the end of the list.
            arr[size] = item;
            size++;
    }
    /**
     * size method.
     * @return     { description_of_the_return_value }
     */
    public int size() {
        // replace the code below to implement the size method
        if (size < 0) {
            return 0;
        }
        return size;
    }
    /**
     * remove method.
     * @param      index  The index
     */
    public void remove(final int index) {
        // write the logic for remove here.
        // Think about what to do to the size variable.
        if (index > size) {
            System.out.println("Invalid Position Exception");
        } else {
            for (int i = 0; i < arr.length; i++) {
            if (arr[i] == arr[index]) {
                for (int j = i; j < arr.length - 1; j++) {
                    arr[j] = arr[j + 1];
                }
            break;
        }
    }
    size -= 1;
    }
}
/**
 * get method.
 * @param      index  The index
 * @return     { description_of_the_return_value }
 */
    public int get(final int index) {
        // Replace the code below to write the code for get
        if (index > size) {
            return -1;
        }
        return arr[index];
    }
    /**
     * Returns a string representation of the object.
     * @return     String representation of the object.
     */
    public String toString() {
        // Replace the code below
        int[] newarr = new int[size];
        for (int i = 0; i < size; i++) {
            newarr[i] = arr[i];
        }
        return Arrays.toString(newarr).replace(" ", "");
    }
    /**
     * contains method.
     * @param      item  The item
     * @return     { description_of_the_return_value }
     */
    public boolean contains(final int item) {
        // Replace the code below
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == item) {
                return true;
            }
        }
        return false;
    }
    /**
     * Searches for the first match.
     * @param      item  The item
     * @return     { description_of_the_return_value }
     */
    public int indexOf(final int item) {
        // Replace the code below
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == item) {
                return i;
            }
        }
        return -1;
    }
    /**
     * main method.
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        // create an object of the list to invoke methods on it
        List l = new List();
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
                case "add":
                l.add(Integer.parseInt(tokens[1]));
                break;
                case "size":
                // invoke size method and print the list size
                // BTW, list size is not the array size
                // it is the number of items in the list
                System.out.println(l.size());
                break;
                case "print":
                // print the list (implement toString for this to work)
                // expected format is [item-1,item-2,...,item-n]
                // review the output testcase file
                System.out.println(l);
                break;
                case "remove":
                l.remove(Integer.parseInt(tokens[1]));
                break;
                case "indexOf":
                System.out.println(l.indexOf(Integer.parseInt(tokens[1])));
                break;
                case "get":
                int temp = l.get(Integer.parseInt(tokens[1]));
                if (temp != -1) {
                    System.out.println(temp);
                }
                break;
                case "contains":
                System.out.println(l.contains(Integer.parseInt(tokens[1])));
                break;
                default:
                break;
            }
        }
    }
}


