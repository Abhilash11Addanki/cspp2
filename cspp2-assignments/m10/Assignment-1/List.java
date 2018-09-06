import java.io.BufferedInputStream;
import java.util.Scanner;
/**
 * List class.
 */
public class List {
    /**
     * { var_description }.
     */
    private int[] list;
    /**
     * { var_description }.
     */
    private int size;
    /**
     * Constructs the object.
     */
    public List() {
        list = new int[10];
        size = 0;
    }
    /**
     * Constructs the object.
     * @param      capacity  The capacity
     */
    public List(final int capacity) {
        size = 0;
        list = new int[capacity];
    }
    /**
     * { function_description }.
     * @param      item  The item
     */
    public void add(final int item) {
        //Inserts the specified element at the end of the zelist.
        list[size++] = item;  
    }
    /**
     * { function_description }.
     * @return     { description_of_the_return_value }
     */
    public int[] resize() {
        int n = 2 * size;
        int[] newarr = java.util.Arrays.copyOf(list, n);
        return newarr;
    }
    /**
     * { function_description }.
     * @return     { description_of_the_return_value }
     */
    public int size() {
        return size;
    }
    /**
     * { function_description }.
     * @param      index  The index
     */
    public void remove(final int index) {
        // write the logic for remove here.
        // Think about what to do to the size variable.
        if(index >= 0 && index < size) {
            for(int i = index; i < size - 1; i++) {
                list[i] = list[i + 1];
            }
            size--;
        } else {
            System.out.println("Invalid Position Exception");
        }
    }
    /**
     * { function_description }.
     * @param      index  The index
     * @return     { description_of_the_return_value }
     */
    public int get(final int index) {
        if(index < 0 || index >= size) {
            return -1;
        } else {
            return list[index];
        }
    }
    /**
     * Returns a string representation of the object.
     * @return     String representation of the object.
     */
    public String toString() {
        if(size == 0)
            return "[]";
        String str = "[";
        int i = 0;
        for(i = 0; i < size - 1; i++) {
            str = str + list[i] + ",";
        }
        str = str + list[i] + "]";
        return str;
    }
    /**
     * { function_description }
     * @param      item  The item
     * @return     { description_of_the_return_value }
     */
    public boolean contains(final int item) {
        return indexOf(item) == -1;
    }
    /**
     * Searches for the first match.
     * @param      item  The item
     * @return     { description_of_the_return_value }
     */
    public int indexOf(final int item) {
        for(int i = 0; i < size; i++) {
            if(item == list[i])
                return i;
        }
        return -1;
    }
    /**
     * { item_description }.
     */
    public void addAll(int items[])
    {
        // write the logic
        int newsize = size;
        for (int i = newsize, j = 0; i < newsize + items.length; i++) {
            add(items[j]);
            j++;
        }
    }
    /**
     * { function_description }.
     * @param      index  The index
     * @param      item   The item
     */
    public void add(final int index,final int item) {
        // write the logic
        if (index >= 0) {
            int temp = list[index];
            for (int i = index; i < size + 1; i++) {
                int temp1 = list[i + 1];
                list[i + 1] = temp;
                temp = temp1;
            }
            list[index] = item;
            size++;
        }
    }
    /**
     * { function_description }.
     * @param      item  The item
     * @return     { description_of_the_return_value }
     */
    public int count(final int item)
    {
         // write the logic
        int count = 0;
        for (int i = 0; i < size; i++) {
            if (item == list[i]) {
                count++;
            }
        }
        return count;
    }
    /**
     * { function_description }.
     * @param      args  The arguments
     */
    public static void main(String[] args) {
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
                if((tokens.length)==2){
                String[] t = tokens[1].split(",");
                if(t.length==1){
                    l.add(Integer.parseInt(tokens[1]));
                }
                else{
                    if(t.length>1)
                        l.add(Integer.parseInt(t[0]),Integer.parseInt(t[1]));
                    }
                }
                break;
                case "count":
                System.out.println(l.count(Integer.parseInt(tokens[1])));
                break;
                case "addAll":
                if(tokens.length==2){
                String[] t1 = tokens[1].split(",");
                int temp[]=new int[t1.length];
                for(int i=0;i<temp.length;i++)
                    temp[i]=Integer.parseInt(t1[i]);
                l.addAll(temp);
                }
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
                System.out.println(l.get(Integer.parseInt(tokens[1])));
                break;
                case "contains":
                System.out.println(l.contains(Integer.parseInt(tokens[1])));
                break;
            }
        }
    }
}
