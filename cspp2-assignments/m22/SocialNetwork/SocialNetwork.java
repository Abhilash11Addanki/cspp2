import java.util.TreeMap;
import java.util.ArrayList;
import java.util.Scanner;
/**
 * Class for operations.
 */
class Operations {
    /**
     * map of type TreeMap to store the key-value pairs.
     */
    private TreeMap<String, ArrayList> map = new TreeMap<String, ArrayList>();
    /**
     * val of type ArrayList to store the values of a user.
     */
    private ArrayList<String> val;
    /**
     * user of type ArrayList to store the users.
     */
    private ArrayList<String> user;
    /**
     * Gets the connections.
     * @param      str   The string
     */
    void getConnections(final String str) {
        if (map.containsKey(str)) {
            val = map.get(str);
            System.out.println(val);
        } else {
            System.out.println("Not a user in Network");
        }
    }
    /**
     * Adds a connection.
     * @param      str   The string
     * @param      str1  The string 1
     */
    void addConnection(final String str, final String str1) {
        if (map.containsKey(str) && map.containsKey(str1)) {
            val = map.get(str);
            val.add(str1);
        } else {
            System.out.println("Not a user in Network");
        }
    }
    /**
     * Gets the common connections.
     * @param      str   The string
     * @param      str1  The string 1
     */
    void getCommonConnections(final String str, final String str1) {
        ArrayList<String> s1 = map.get(str);
        ArrayList<String> s2 = map.get(str1);
        ArrayList<String> res = new ArrayList<String>();
        for (String a : s1) {
            for (String b : s2) {
                if (a.equals(b)) {
                    res.add(a);
                }
            }
        }
        System.out.println(res);
    }
    /**
     * Gets the network.
     */
    void getNetwork() {
        System.out.println(map.toString().
            replace("=", ": ").replace("{", "").replace("}", ""));
    }
    /**
     * Adds to map.
     * @param      s1    The s 1
     * @param      s2    The s 2
     */
    void addToMap(final String s1, final ArrayList<String> s2) {
        map.put(s1, s2);
    }
}
/**
 * Class for social network.
 */
final class SocialNetwork {
    /**
     * Constructs the object.
     */
    private SocialNetwork() {

    }
    /**
     * main method.
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Operations o = new Operations();
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String line = sc.nextLine();
            String[] tokens = line.split(" ");
            switch (tokens[0]) {
            case "Create":
                String l;
                String[] c = new String[0];
                String[] v = new String[0];
                int num = Integer.parseInt(tokens[1]);
                while (num != 0) {
                    l = sc.nextLine();
                    c = l.split(" is connected to ");
                    v = c[1].split(",");
                    ArrayList<String> values = new ArrayList<String>();
                    for (int i = 0; i < v.length; i++) {
                        values.add(v[i].replace(".", "").replace(" ", ""));
                    }
                    o.addToMap(c[0], values);
                    num--;
                }
                break;
            case "getConnections":
                o.getConnections(tokens[1]);
                break;
            case "addConnections":
                o.addConnection(tokens[1], tokens[2]);
                break;
            case "CommonConnections":
                o.getCommonConnections(tokens[1], tokens[2]);
                break;
            case "Network":
                o.getNetwork();
                break;
            default:
                break;
            }
        }
    }
}
