import java.util.*;
import java.io.*;
import java.nio.file.*;
class BagOfWords {
    String[] doc1, doc2, combined;
    BagOfWords(String[] d1, String[] d2) {
        doc1 = d1;
        doc2 = d2;
        combined = new String[doc1.length + doc2.length];
        int size = 0;
        for (String i : doc1) {
            combined[size++] = i;
        }
        for (String i : doc2) {
            combined[size++] = i;
        }
    }
    int freqcount(String[] doc, String word) {
        int count = 0;
        for (String i : doc) {
            if (i.equals(word)) {
                count++;
            }
        }
        return count;
    }
    HashMap<String, Integer> checkfreq(String[] doc1, String[] doc2) {
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        for (String i : doc2) {
            int c = freqcount(doc1, i);
            if (!map.containsKey(i)) {
                map.put(i, c);
            }
        }
        return map;
    }
    double euclidean(HashMap<String, Integer> map) {
        double e = 0;
        for (int i : map.values()) {
            e += Math.pow(i, 2);
        }
        return Math.sqrt(e);
    }
    double dotProduct(HashMap<String, Integer> map1, HashMap<String, Integer> map2) {
        double result = 0;
        for (String key : map1.keySet()) {
            result += map1.get(key) * map2.get(key);
        }
        return result;
    }
    double computeFreq() {
        HashMap<String, Integer> s1 = checkfreq(doc1, combined);
        HashMap<String, Integer> s2 = checkfreq(doc2, combined);
        return dotProduct(s1, s2) / (euclidean(s1) * euclidean(s2));
    }
}
class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String text = sc.next();
            File file = new File(text);
            File[] filelist = file.listFiles();
            if (filelist.length == 0) {
                System.out.println("empty directory");
                return;
            }
            String[] docs = new String[filelist.length];
            int i = 0;
            try {
                for (File f : filelist) {
                    docs[i++] = new String(Files.readAllBytes(Paths.get(f.toString()))).toLowerCase();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            for (String inp : docs) {
                String[] s1 = inp.split(" ");
                for (String j : docs) {
                    String[] s2 = j.split(" ");
                    BagOfWords bag = new BagOfWords(s1, s2);
                    double result = bag.computeFreq();
                    System.out.print(Math.round(result * 100));
                    System.out.print(" " + "\t");
                }
                System.out.println();
            }
            return;
        }
        System.out.println("empty directory");
    }
}
