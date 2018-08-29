/**
 * Class for convert to while loop.
 */
final class ConvertToWhileLoop {
    /**
     * Constructs the object.
     */
    private ConvertToWhileLoop() {

    }
    /**
     * main method.
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        int i = 2;
        final int c = 10;
        while (i <= c) {
            System.out.println(i);
            i += 2;
        }
        System.out.println("GoodBye!");
    }
}
