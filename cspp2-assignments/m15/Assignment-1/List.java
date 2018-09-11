import java.io.BufferedInputStream;
import java.util.Scanner;
import java.util.Arrays;
/**
 * List class.
 */
class InvalidPositionException extends Exception {
	InvalidPositionException(String s) {
		super(s);
	}
}
class IndexOutOfBoundsException extends Exception {
	IndexOutOfBoundsException(String s) {
		super(s);
	}
}
public class List {
	/**
	 * { var_description }.
	 */
	private int[] arr;
	/**
	 * { var_description }.
	 */
	private int size;
	/**
	 * Constructs the object.
	 */
	public List() {
		final int ten = 10;
		arr = new int[ten];
		size = 0;
	}
	/**
	 * Constructs the object.
	 * @param      n     { parameter_description }
	 */
	public List(final int n) {
		size = 0;
		arr = new int[n];
	}
	/**
	 * add method.
	 * @param      item  The item
	 */
	public void add(final int item) {
		//Inserts the specified element at the end of the list.
		if (size == arr.length) {
			arr = resize();
		}
		arr[size++] = item;
	}
	/**
	 * resize method.
	 * @return     { description_of_the_return_value }
	 */
	public int[] resize() {
		int n = 2 * size;
		int[] newarr = java.util.Arrays.copyOf(arr, n);
		return newarr;
	}
	/**
	 * size method.
	 * @return     { description_of_the_return_value }
	 */
	public int size() {
		// replace the code below to implement the size method
		return size;
	}
	/**
	 * remove method.
	 * @param      index  The index
	 */
	public void remove(final int index) throws InvalidPositionException {
		if (index >= 0 && index < size) {
			for (int i = index; i < size - 1; i++) {
				arr[i] = arr[i + 1];
			}
			size--;
		} else {
			throw new InvalidPositionException("Invalid Position Exception");
		}
	}
	/**
	 * get method.
	 *
	 * @param      index  The index
	 *
	 * @return     { description_of_the_return_value }
	 */
	public int get(final int index) {
		// Replace the code below to write the code for get
		if (index >= size) {
			return -1;
		}
		return arr[index];
	}

	/**
	 * Returns a string representation of the object.
	 *
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
	 *
	 * @param      item  The item
	 *
	 * @return     { description_of_the_return_value }
	 */
	public boolean contains(final int item) {
		// Replace the code below
		for (int i = 0; i < size; i++) {
			if (arr[i] == item) {
				return true;
			}
		}
		return false;
	}
	/**
	 * Searches for the first match.
	 *
	 * @param      item  The item
	 *
	 * @return     { description_of_the_return_value }
	 */
	public int indexOf(final int item) {
		// Replace the code below
		for (int i = 0; i < size; i++) {
			if (item == arr[i]) {
				return i;
			}
		}
		return -1;
	}
	/**
	 * Adds all.
	 *
	 * @param      newArray  The new array
	 */
	public void addAll(final int[] newArray) {
		// write the logic
		int[] resArray = Arrays.copyOf(newArray, newArray.length);
		if (size == newArray.length) {
			resArray = resize();
		}
		int newsize = size;
		for (int i = newsize, j = 0; i < newsize + resArray.length; i++) {
			add(resArray[j]);
			j++;
		}
	}
	/**
	 * Removes all.
	 *
	 * @param      newArray  The new array
	 */
	public void removeAll(final int[] newArray) throws InvalidPositionException {
		// write the logic
		for (int i = 0; i < newArray.length; i++) {
			for (int j = 0; j < size; j++) {
				if (arr[j] == newArray[i]) {
					remove(j);
					j--;
				}
			}
		}
	}
	/**
	 * subList method.
	 *
	 * @param      start  The start
	 * @param      end    The end
	 *
	 * @return     { description_of_the_return_value }
	 */
	public List subList(final int start, final int end) throws IndexOutOfBoundsException {
		// write the logic for subList
		List l = new List();
		if ((start <= 0 || end <= 0) || (start > end) || size == 0) {
			throw new IndexOutOfBoundsException("Index Out of Bounds Exception");
		} else {
			for (int i = start; i < end; i++) {
				l.add(arr[i]);
			}
		}
		return l;
	}
	/**
	 * equals method.
	 *
	 * @param      list  The list
	 *
	 * @return     { description_of_the_return_value }
	 */
	public boolean equals(final List list) {
		if (size != list.size) {
			return false;
		}
		for (int i = 0; i < size; i++) {
			if (arr[i] != list.arr[i]) {
				return false;
			}
		}
		return true;
	}
	/**
	 * clear method.
	 */
	public void clear() {
		// write the logic for clear.
		final int defaultsize = 10;
		arr = new int[defaultsize];
		size = 0;
	}
	/**
	 * { function_description }.
	 *
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
				if (tokens.length == 2) {
					String[] t = tokens[1].split(",");
					if (t.length == 1) {
						l.add(Integer.parseInt(tokens[1]));
					}
				}
				break;
			case "size":
				System.out.println(l.size());
				break;
			case "print":
				System.out.println(l);
				break;
			case "remove":
				try {
					if (tokens.length == 2) {
						l.remove(Integer.parseInt(tokens[1]));
					}
				} catch (Exception e) {
					System.out.println(e);
				}
				break;
			case "indexOf":
				if (tokens.length == 2) {
					System.out.println(l.indexOf(
					                       Integer.parseInt(tokens[1])));
				}
				break;
			case "get":
				if (tokens.length == 2) {
					System.out.println(l.get(
					                       Integer.parseInt(tokens[1])));
				}
				break;
			case "contains":
				if (tokens.length == 2) {
					System.out.println(l.contains(
					                       Integer.parseInt(tokens[1])));
				}
				break;
			case "addAll":
				if (tokens.length == 2) {
					String[] t1 = tokens[1].split(",");
					int[] temp = new int[t1.length];
					for (int i = 0; i < temp.length; i++) {
						temp[i] = Integer.parseInt(t1[i]);
					}
					l.addAll(temp);
				}
				break;
			case "removeAll":
				try {
					if (tokens.length == 2) {
						String[] t2 = tokens[1].split(",");
						int[] a = new int[t2.length];
						for (int i = 0; i < t2.length; i++) {
							a[i] = Integer.parseInt(t2[i]);
						}
						l.removeAll(a);
					}
				} catch (Exception e) {
					System.out.println(e);
				}
				break;
			case "subList":
				try {
					if (tokens.length != 2) {
						break;
					}
					String[] arrstring3 = tokens[1].split(",");
					List object = l.subList(Integer.parseInt(arrstring3[0]),
					                        Integer.parseInt(arrstring3[1]));
					if (object != null) {
						System.out.println(object);
					}
				} catch (Exception e) {
					System.out.println(e);
				}
				break;
			case "equals":
				if (tokens.length == 2) {
					String[] lt = tokens[1].split(",");
					List l2 = new List();
					for (int k = 0; k < lt.length; k++) {
						l2.add(Integer.parseInt(lt[k]));
					}
					System.out.println(l.equals(l2));
				}
				break;
			case "clear":
				l.clear();
				break;
			default:
				break;
			}
		}
	}
}


