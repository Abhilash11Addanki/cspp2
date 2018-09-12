import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
/**
 * Class for show.
 */
class Show {
    /**
     * moviename.
     */
    private String moviename;
    /**
     * date and time of the movie.
     */
    private String datetime;
    /**
     * seat numbers.
     */
    private String[] seats;
    /**
     * Constructs the object.
     * @param      name  The name
     * @param      date  The date
     * @param      seat  The seat
     */
    Show(final String name, final String date, final String[] seat) {
        moviename = name;
        datetime = date;
        seats = seat;
    }
    /**
     * Gets the movie.
     * @return     The movie.
     */
    String getMovie() {
        return moviename;
    }
    /**
     * Gets the time.
     * @return     The time.
     */
    String getTime() {
        return datetime;
    }
    /**
     * Gets the seats.
     * @return     The seats.
     */
    String[] getSeats() {
        return seats;
    }
    /**
     * Sets the seat.
     * @param      index  The index
     */
    void setSeat(final int index) {
        seats[index] = "N/A";
    }
    /**
     * Returns a string representation of the object.
     * @return     String representation of the object.
     */
    public String toString() {
        return moviename + "," + datetime;
    }
}
/**
 * Class for patron.
 */
class Patron {
    /**
     * patron name.
     */
    private String patronname;
    /**
     * patron mobile number.
     */
    private String patronnumber;
    /**
     * Constructs the object.
     * @param      name    The name
     * @param      number  The number
     */
    Patron(final String name, final String number) {
        patronname = name;
        patronnumber = number;
    }
    /**
     * Gets the patron name.
     * @return     The patron name.
     */
    String getPatronName() {
        return patronname;
    }
    /**
     * Gets the patron number.
     * @return     The patron number.
     */
    String getPatronNumber() {
        return patronnumber;
    }
    /**
     * Returns a string representation of the object.
     * @return     String representation of the object.
     */
    public String toString() {
        return patronname + "," + patronnumber;
    }
}
/**
 * Class for book your show.
 */
class BookYourShow {
    /**
     * showList.
     */
    private ArrayList<Show> showList = new ArrayList<Show>();
    /**
     * bookList.
     */
    private ArrayList<String> bookList = new ArrayList<String>();
    /**
     * Adds a show.
     * @param      show  The show
     */
    void addAShow(final Show show) {
        showList.add(show);
    }
    /**
     * books a show.
     * @param      name  The name
     * @param      date  The date
     * @param      p     { parameter_description }
     * @param      seat  The seat
     */
    void bookAShow(final String name, final String date, final Patron p, final String[] seat) {
        Show show = getAShow(name, date);
        if (show == null) {
            System.out.println("No show");
            return;
        }
        boolean flag = false;
        String[] seats = show.getSeats();
        for (int i = 0; i < seat.length; i++)
            for (int j = 0; j < seats.length; j++)
                if (seat[i].equals(seats[j])) {
                    show.setSeat(j);
                    flag = true;
                }

        if (flag) {
            bookList.add(p.getPatronNumber() + " " + name + " " + date);
        }
    }
    /**
     * Gets a show.
     * @param      name  The name
     * @param      date  The date
     * @return     A show.
     */
    Show getAShow(final String name, final String date) {
        for (Show s : showList) {
            if (s.getMovie().equals(name) && s.getTime().equals(date)) {
                return s;
            }
        }
        return null;
    }
    /**
     * print the Ticket.
     * @param      name  The name
     * @param      date  The date
     * @param      num   The number
     */
    void printTicket(final String name, final String date, final String num) {
        String s = num + " " + name + " " + date;
        if (bookList.contains(s))
            System.out.println(s);
        else
            System.out.println("Invalid");
    }
    /**
     * Shows all.
     */
    void showAll() {
        for (Show show : showList)
            System.out.println(show.toString() + "," + Arrays.toString(show.getSeats()).replace(" ", ""));
    }
}
/**
 * Class for solution.
 */
public final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {

    }
    /**
     * main method to drive program.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        BookYourShow bys = new BookYourShow();
        Scanner scan = new Scanner(System.in);
        int testCases = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < testCases; i++) {
            String[] tokens = scan.nextLine().
                              replace("[", "").replace("]", "").split(",");
            String[] check = tokens[0].split(" ");
            switch (check[0]) {
            case "add":
                int k = 2;
                String[] seats = new String[tokens.length - 2];
                for (int j = 0; j < seats.length; j++) {
                    seats[j] = tokens[k++];
                }
                bys.addAShow(new Show(check[1], tokens[1], seats));
                break;

            case "book":
                k = 2 + 2;
                seats = new String[tokens.length - 2 - 2];
                for (int j = 0; j < seats.length; j++) {
                    seats[j] = tokens[k++];
                }
                bys.bookAShow(check[1], tokens[1],
                              new Patron(tokens[2], tokens[2 + 1]), seats);
                break;

            case "get":
                Show show = bys.getAShow(check[1], tokens[1]);
                if (show != null) {
                    System.out.println(show);
                } else {
                    System.out.println("No show");
                }
                break;

            case "print":
                bys.printTicket(check[1], tokens[1], tokens[2]);
                break;
            case "showAll":
                bys.showAll();
                break;

            default:
                break;
            }
        }
    }
}
