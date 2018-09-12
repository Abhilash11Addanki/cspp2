import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
class Show {
	String movie_name;
	String datetime;
	String[] seats;
	Show(String name, String date, String[] seat) {
		movie_name = name;
		datetime = date;
		seats = seat;
	}
	String getMovie() {
		return movie_name;
	}
	String getTime() {
		return datetime;
	}
	String[] getSeats() {
		return seats;
	}
	void setSeat(int index) {
		seats[index] = "N/A";
	}
	public String toString() {
		return movie_name + "," + datetime;
	}
}

class Patron {
	String Patron_name;
	String Patron_number;
	Patron(String name, String number) {
		Patron_name = name;
		Patron_number = number;
	}
	String getPatronName() {
		return Patron_name;
	}
	String getPatronNumber() {
		return Patron_number;
	}
	public String toString() {
		return Patron_name + "," + Patron_number;
	}
}
class BookYourShow {
	ArrayList<Show> showList = new ArrayList<Show>();
	ArrayList<String> bookList = new ArrayList<String>();
	void addAShow(Show show) {
		showList.add(show);
	}
	void bookAShow(String name, String date, Patron p, String[] seat) {
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
	Show getAShow(String name, String date) {
		for (Show s : showList) {
			if (s.getMovie().equals(name) && s.getTime().equals(date)) {
				return s;
			}
		}
		return null;
	}
	void printTicket(String name, String date, String num) {
		String s = num + " " + name + " " + date;
		if (bookList.contains(s))
			System.out.println(s);
		else
			System.out.println("Invalid");
	}
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
