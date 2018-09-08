import java.io.BufferedInputStream;
import java.util.Scanner;
import java.util.Arrays;

/**
 * Class for set.
 * @author :
 */
class Set {
	//your code goes here...
	//Good luck :-)
	private int[] arr;
	private int size;

	public Set() {
		final int ten = 10;
		arr = new int[ten];
		size = 0;
	}
	public Set(final int n) {
		size = 0;
		arr = new int[n];
	}
	public int[] resize() {
		int n = 2 * size;
		int[] newarr = Arrays.copyOf(arr, n);
		return newarr;
	}
	public int size() {
		return size;
	}
	public boolean contains(final int item) {
		for (int i = 0; i < size; i++) {
			if (arr[i] == item) {
				return true;
			}
		}
		return false;
	}
	public String toString() {
		int[] newarr = new int[size];
		for (int i = 0; i < size; i++) {
			newarr[i] = arr[i];
		}
		return Arrays.toString(newarr).replace(" ", "");
	}
	public void add(final int item) {
		if (size == arr.length) {
			arr = resize();
		}
		if (contains(item) == false) {
			arr[size++] = item;
		}
	}
	public void add(final int[] newArray) {
		int[] resArray = Arrays.copyOf(newArray, newArray.length);
		if (size == newArray.length) {
			resArray = resize();
		}
		int newsize = size;
		for (int i = newsize, j = 0; i < newsize + resArray.length; i++) {
			if (contains(resArray[j]) == false) {
				add(resArray[j]);
			}
			j++;
		}
	}
	public int[] intersection(final Set set) {
		int[] newarr = new int[size];
		int i = 0, j = 0;
		int m = size, n = size;;
		while (i < m && j < n) {
			if (arr[i] < set.arr[j]) {
				i++;
			} else if (set.arr[j] < arr[i]) {
				j++;
			} else {
				for (i = 0; i < newarr.length; i++) {
					newarr[i] = set.arr[j++];
					i++;
				}
			}
		}
		return newarr;
	}
	public int[] retainAll(final int[] newArray) {
		int[] resArray = new int[newArray.length];
		for (int i = 0; i < newArray.length; i++) {
			for (int j = 0; j < size; j++) {
				if (arr[j] == newArray[i]) {
					resArray[i] = arr[j];
				}
			}
		}
		return resArray;
	}
	public int[][] cartesianProduct(final Set set) {
		if (arr.length == 0 || set.arr.length == 0) {
			return null;
		}
		int rows = this.size()*set.size();
		int[][] resArray = new int[rows][2];
		for (int i = 0; i < this.size(); i++) {
			int k = 0;
			for (int j = 0; j < rows; j++) {
				resArray[i][0] = this.arr[i];
				resArray[i][1] = set.arr[k++];
				if (k == set.size()) {
					k = 0;
					i++;
				}
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
