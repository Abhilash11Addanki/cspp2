import java.util.Scanner;
import java.io.FileReader;
import java.util.Map;
import java.util.HashMap;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;
/**this class is to maintain.
*complete details of two files.
*/
class Data {
    /** this is an empty constructor.
    */
    Data() {
    }
    /**this method is to convert the.
    *file document text to string
    *@param file File
    *@return str returns string of that text.
    */
    public static String toText(final File file) {
        String str = "";
        try {
            Scanner input = new Scanner(new FileReader(file));
            StringBuilder text = new StringBuilder();
            while (input.hasNext()) {
                text.append(input.next());
                text.append(" ");
            }
            input.close();
            str = text.toString();
        } catch (FileNotFoundException e) {
            System.out.println("No file");
        }
        return str;
    }
    /**
     * to remove the unwanted characters.
     *
     * @param      text  The text
     *
     * @return map which contains
     * frequency of words.
     */
    public Map remove(final String text) {
        text.toLowerCase();
        text.replaceAll("[0-9_]", "");
        String[] words = text.split(" ");
        Map<String, Integer> map = new HashMap<>();
        for (String element : words) {
         if (element.length() > 0) {
            if (!(map.containsKey(element))) {
                map.put(element, 1);
            } else {
                map.put(element, map.get(element) + 1);
            }
        }
    }
        return map;
    }
    /**this method is to give the.
     *document distance.
     *@param textOne first file string
     *@param textTwo second file string
     *@return document distance
     */

    public int similarity(final String textOne, final String textTwo) {
        double numerator = 0;
        double denominator = 1;
        double sumOne = 0;
        double sumTwo = 0;
        final int hundred = 100;
        Map<String, Integer> mapOne = remove(textOne);
        Map<String, Integer> mapTwo = remove(textTwo);
        for (String element: mapOne.keySet()) {
            for (String item: mapTwo.keySet()) {
                if (element.equals(item)) {
                    numerator += mapOne.get(element) * mapTwo.get(item);
                }
            }
        }

        for (String word: mapOne.keySet()) {
            sumOne += mapOne.get(word) * mapOne.get(word);
        }
        for (String word: mapTwo.keySet()) {
            sumTwo += mapTwo.get(word) * mapTwo.get(word);
        }
        denominator = Math.sqrt(sumOne) * Math.sqrt(sumTwo);
        double documentDistance = (
            (numerator / denominator) * hundred);
        return (int) (documentDistance);
    }
}
/** this is the solution class.
*/
public final class Solution {
    /** an empty constructor.
    */
    private Solution() {

    }
    /**
     * this is main method.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        try  {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        File files = new File(input);
        Data obj = new Data();
        File[] fileList = files.listFiles();
        int length = fileList.length;
        int maxValue = 0;
        final int hundred = 100;
        String result = "";
        int[][] fileMatrix = new int[length][length];
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if (i == j) {
                    fileMatrix[i][j] = hundred;
                } else {
                    fileMatrix[i][j] = obj.similarity(
                        obj.toText(fileList[i]), obj.toText(fileList[j]));
                    if (maxValue < fileMatrix[i][j]) {
                        maxValue = fileMatrix[i][j];
                        result = "Maximum similarity is between "
                        + fileList[i].getName() + " and "
                        + fileList[j].getName();
                    }
                }
            }
        }
        System.out.print("      \t");
        for (int i = 0; i < length - 1; i++) {
            System.out.print("\t" + fileList[i].getName());
        }
        System.out.println("\t" + fileList[length - 1].getName());
        for (int i = 0; i < length; i++) {
            System.out.print(fileList[i].getName() + "\t");
            for (int j = 0; j < length; j++) {
                    System.out.print(fileMatrix[i][j] + "\t\t");
            }
            System.out.println();
        }
     System.out.println(result);
    } catch (NoSuchElementException e) {
        System.out.println("empty directory");
    }
    }
}

