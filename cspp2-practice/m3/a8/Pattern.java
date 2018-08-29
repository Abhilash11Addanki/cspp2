/**
 * Class for pattern.
 */
final class Pattern {
    /**
     * Pattern constructor.
     */
    private Pattern() {

    }
    /**
     * main method.
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        final int c = 5;
        for (int i = 1; i <= c; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }
}
