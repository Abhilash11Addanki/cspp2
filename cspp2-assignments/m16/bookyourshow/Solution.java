import java.util.Scanner;
class Show {
	String movie_name;
	String datetime;
	String[] seats;
	Show(String name, String date, String[] seat) {
		movie_name = name;
		datetime = date;
		seats = seat;
	}
}
class Patron {
	String Patron_name;
	String Patron_number;
	Patron(String name, String number) {
		Patron_name = name;
		Patron_number = number;
	}
}
class BookYourShow {
	private String movie;
	private String timedate;
	private String[] seat_num;
	private String patron_name;
	private String patron_num;
	void addAShow(String name, String date, String[] seat) {
		movie = name;
		timedate = date;
		seat_num = seat;
	}
	void bookAShow(String name, String date, Patron p, String[] seat) {
		movie = name;
		timedate = date;
		seat_num = seat;
		patron_name = p.Patron_name;
		patron_num = p.Patron_number;
	}
	String getAShow(String name, String date) {
		if (movie == name && date == timedate) {
			return name + "," + date;
		}
		return null;
	}
	void printTicket(String name, String date, String num) {
		if (movie == name && date == timedate && num == patron_num) {
			System.out.println(name + "," + date + "," + num);
		}
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
				bys.addAShow(check[1], tokens[1], seats);
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
				String show = bys.getAShow(check[1], tokens[1]);
				if (show != null) {
					System.out.println(show);
				} else {
					System.out.println("No show");
				}
				break;

			case "print":
				bys.printTicket(check[1], tokens[1], tokens[2]);
				break;

			default:
				break;
			}
		}
	}
}
