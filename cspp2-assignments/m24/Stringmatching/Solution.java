import java.io.*;
import java.util.*;
import java.lang.Math;
class Substring {
    Substring() {

    }
    public String toString(File givenFile) {
        String result = "";
        try {
            Scanner s = new Scanner(new FileReader(givenFile));
            StringBuilder sb = new StringBuilder();
            while (s.hasNext()) {
                sb.append(s.next());
                sb.append(" ");
            }
            s.close();
            result = sb.toString();
        } catch(FileNotFoundException e) {
            System.out.println("no file");
        }
        return result;
    }
    public double findLCS(String firstString, String secondString) {
    int lengthOne = firstString.length();
    int lengthTwo = secondString.length();
    double totalLength = lengthOne + lengthTwo;
    int[][] tempMatrix = new int[lengthOne+1][lengthTwo+1];
    double result = 0;
    double lcsValue = 0;
    for (int i = 0; i <= lengthOne; i++) {
        for (int j = 0; j <= lengthTwo; j++) {
            if (i == 0 || j == 0) {
                tempMatrix[i][j] = 0;
            } else if (firstString.charAt(i-1) == secondString.charAt(j-1)) {
                tempMatrix[i][j] = tempMatrix[i-1][j-1]+1;
            } else {
                tempMatrix[i][j] = 0;
            }
            if (result < tempMatrix[i][j]) {
                result = tempMatrix[i][j];
            }
        }
    }
    lcsValue = ((result*2)/totalLength)*100;
    // System.out.println((int)lcsValue);
    return Math.round(lcsValue * 100D) / 100;
    }
}


class Solution{
    Solution() {

    }
    public static void main(String[] args) {
        try {
        Substring s = new Substring();
        String path;
        Scanner scan = new Scanner(System.in);
        path = scan.nextLine();
        File folder = new File(path);
        File[] filesList = folder.listFiles();
        int length = filesList.length;
        double[][] matrix = new double[length][length];
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                matrix[i][j] = s.findLCS(s.toString(filesList[i]),s.toString(filesList[j]));
            }
        }
        for (int i = 0; i < filesList.length - 1; i++) {
            System.out.print("\t       " + filesList[i].getName());
        }
        System.out.println("\t" + filesList[length - 1].getName());
        for (int i = 0; i < length; i++) {
            System.out.print(filesList[i].getName() + "\t");
            for (int j = 0; j < length; j++) {
                System.out.print(matrix[i][j] + "        ");
            }
            System.out.println();
        }
    } catch (NoSuchElementException e) {
        System.out.println("Empty Directory");
    }

    }
}   