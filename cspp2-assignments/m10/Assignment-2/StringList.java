//An interface for ListADT of strings
import java.util.Arrays;
/**
 * Interface for string list interface.
 */
interface StringListInterface
{
     public void add(String item);
     public void addAll(String items[]);
     public String get(int index);
     public int size();
     public void remove(int index);
     public boolean contains(String item);
     public int indexOf(String item);
}
/**
 * List of strings.
 */
public class StringList implements StringListInterface{
    /**
     * { var_description }.
     */
    private String[] list;
    /**
     * { var_description }.
     */
    private int size;
    /**
     * Constructs the object.
     */
    public StringList() {
        list = new String[10];
        size = 0;
    }
    /**
     * Constructs the object.
     * @param      n     { parameter_description }
     */
    public StringList(final int n) {
        size = 0;
        list = new String[n];
    }
    /**
     * { function_description }.
     * @param      item  The item
     */
    public void add(final String item) {
        //Inserts the specified element at the end of the list.
        list[size++] = item;
       
    }
    /**
     * Adds all.
     * @param      items  The items
     */
    public void addAll(String[] items) {
        if (size == list.length || list.length - size < items.length) {
            String[] temp = new String[2 * list.length];
            for (int i = 0; i < size; i++) {
                temp[i] = list[i];
            }
            for (int i = 0; i < items.length; i++) {
                temp[i + size] = items[i];
            }
            list = temp;
        } else {
            for (int i = 0; i < items.length; i++) {
                list[i + size] = items[i];
            }
        }
        size += items.length;
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
        if (index >= 0 && index < size) {
            for (int i = index; i < size - 1; i++) {
                list[i] = list[i + 1];
            }
            size--;
        } else {
            System.out.println("Invalid Position Exception");
        }
    }
    /**
     * { function_description }.
     *
     * @param      index  The index
     *
     * @return     { description_of_the_return_value }
     */
    public String get(final int index) {
        if (index < 0 || index >= size) {
            return null;
        } else {
            return list[index];
        }
    }
    /**
     * Returns a string representation of the object.
     *
     * @return     String representation of the object.
     */
    public String toString() {
       if (size == 0) {
            return "[]";
        }
        String str = "[";
        int i = 0;
        for (i = 0; i < size - 1; i++) {
            str = str + list[i] + ",";
        }
        str = str + list[i] + "]";
        return str;
    }
    /**
     * { function_description }.
     * @param      item  The item
     * @return     { description_of_the_return_value }
     */
    public boolean contains(final String item) {
        return indexOf(item) == -1;
    }
    /**
     * Searches for the first match.
     *
     * @param      item  The item
     *
     * @return     { description_of_the_return_value }
     */
    public int indexOf(final String item) {
        for (int i = 0; i < size; i++) {
            if (item == list[i]) {
                return i;
            }
        }
        return -1;
    }
}
