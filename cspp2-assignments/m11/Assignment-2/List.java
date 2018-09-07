import java.util.Arrays;
/**
 * List class.
 * @param      <E>   { parameter_description }
 */
public class List<E> {
	/**
	 * { var_description }.
	 */
    private E[] list;
    /**
     * { var_description }.
     */
    private int size;
    /**
     * Constructs the object.
     */
    public List() {
        list = ((E[])new Object[10]);
        size = 0;
    }
    /**
     * Constructs the object.
     * @param      n     { parameter_description }
     */
    public List(final int n) {
        list = ((E[])new Object[n]);
        size = 0;
    }
    /**
     * { function_description }.
     * @param      item  The item
     */
    public void add(final E item) {
        //Inserts the specified element at the end of the list.
        //You can modify the code in this method.
        list[size++] = item;
    }
    /**
     * Adds all.
     * @param      items  The items
     */
    public void addAll(final E[] items) {
        //Write logic for addAll method
        int newsize = size;
        for (int i = newsize, j = 0; i < newsize + items.length; i++) {
            add(items[j]);
            j++;
        }
    }
    /**
     * { function_description }.
     */
    private void resize() {
    	int n = 2 * size;
        E[] newarr = java.util.Arrays.copyOf(list, n);
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
        //Write logic for remove method
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
    public E get(final int index) {
         //Write logic for get method
    	if (index < 0 || index >= size) {
    		return null;
    	}
    	return list[index];
    }
    /**
     * Returns a string representation of the object.
     *
     * @return     String representation of the object.
     */
    public String toString() {
    	E[] temparr = ((E[])new Object[size]);
        for (int i = 0; i < size; i++) {
        	temparr[i] = list[i];
        }
       return Arrays.toString(temparr).replace(" ", "");
    }
    /**
     * { function_description }.
     *
     * @param      item  The item
     *
     * @return     { description_of_the_return_value }
     */
    public boolean contains(final E item) {
		//Write logic for contains method
		for (int i = 0; i < size; i++) {
			if (list[i].equals(item)) {
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
    public int indexOf(final E item) {
       //Write logic for indexOf method
    	for (int i = 0; i < size; i++) {
    		if (list[i] == item) {
    			return i;
    		}
    	}
        return -1;
    }

    /**
     * Removes all.
     *
     * @param      items  The items
     */
    public void removeAll(final E[] items)
    {
        // write the logic
        for (int i = 0; i < items.length; i++) {
            for (int j = 0; j < size; j++) {
                if (list[j] == items[i]) {
                    remove(j);
                    j--;
                }
            }
        }
    }

    /**
     * { function_description }.
     *
     * @param      n     { parameter_description }
     * @param      n2    The n 2
     *
     * @return     { description_of_the_return_value }
     */
    public List subList(final int n, final int n2) {
    	List l = new List();
        if ((n < 0 || n2 < 0) || (n > n2) || size == 0) {
            System.out.println("Index Out of Bounds Exception");
            return null;
        } else {
            for (int i = n; i < n2; i++) {
                l.add(list[i]);
            }
        }
    return l;
    }
    /**
     * { function_description }.
     *
     * @param      listdata  The listdata
     *
     * @return     { description_of_the_return_value }
     */
    public boolean equals(final List<E> listdata) {
        if (size != listdata.size) {
            return false;
        }
        for (int i = 0; i < size; i++) {
            if (! list[i].equals(listdata.list[i])) {
                return false;
            }
        }
    return true;
    }
    /**
     * { function_description }.
     */
    public void clear()
    {
        // write the logic for clear.
    final int defaultsize = 10;
    list = ((E[])new Object[defaultsize]);
    size = 0;
    }
}
