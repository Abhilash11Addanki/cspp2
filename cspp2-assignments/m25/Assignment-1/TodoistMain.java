import java.util.Scanner;
import java.util.Arrays;
import java.util.ArrayList;

/**
  * write your code below this comment
  */

/**
 * Class for todoist main.
 */
public class TodoistMain {
	TodoistMain() {

	}
	/**
	 * Starts a test.
	 */
	public static void startTest() {
		Todoist todo = new Todoist();
		Scanner s = new Scanner(System.in);
		while (s.hasNext()) {
			String[] tokens = s.nextLine().split(",");
			switch (tokens[0]) {
			case "task":
				testTask(tokens);
				break;
			case "add-task":
				testAddTask(todo, tokens);
				break;
			case "print-todoist":
				System.out.println(todo);
				break;
			case "get-next":
				System.out.println(todo.getNextTask(tokens[1]));
				break;
			case "get-next-n":
				int n = Integer.parseInt(tokens[2]);
				Task[] tasks = todo.getNextTask(tokens[1], n);
				System.out.println(Arrays.deepToString(tasks));
				break;
			case "total-time":
				System.out.println(todo.totalTime4Completion());
				break;
			default:
				break;
			}
		}
	}

	/**
	 * method to test add task.
	 *
	 * @param      todo    The todo
	 * @param      tokens  The tokens
	 */
	public static void testAddTask(final Todoist todo, final String[] tokens) {
		try {
			todo.addTask(createTask(tokens));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	/**
	 * method to test the creation of task object.
	 *
	 * @param      tokens  The tokens
	 */
	public static void testTask(final String[] tokens) {
		try {
			System.out.println(createTask(tokens));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	/**
	 * Creates a task object.
	 *
	 * @param      tokens     The tokens
	 *
	 * @return     Task object
	 *
	 * @throws     Exception  if task inputs are invalid
	 */
	public static Task createTask(final String[] tokens) throws Exception {
		String title = tokens[1];
		String assignedTo = tokens[2];
		int timeToComplete = Integer.parseInt(tokens[3]);
		boolean important = tokens[4].equals("y");
		boolean urgent = tokens[5].equals("y");
		String status = tokens[6];
		return new Task(
		           title, assignedTo, timeToComplete, important, urgent, status);
	}

	/**
	 * main method.
	 *
	 * @param      args  The command line arguments
	 */
	public static void main(final String[] args) {
		startTest();
	}
}
class InvalidTitle extends Exception {
	InvalidTitle(String s) {
		super(s);
	}
}
class InvalidTime extends Exception {
	InvalidTime(String s) {
		super(s);
	}
}
class InvalidStatus extends Exception {
	InvalidStatus(String s) {
		super(s);
	}
}
class Task {
	private String title;
	private String assignedTo;
	private int timeToComplete;
	private boolean important;
	private boolean urgent;
	private String status;
	Task(String t, String a, int time, boolean i, boolean u, String s) throws Exception {
		title = t;
		assignedTo = a;
		timeToComplete = time;
		important = i;
		urgent = u;
		status = s;
		if (title.equals("")) {
			throw new InvalidTitle("Title not provided");
		}
		if (timeToComplete < 0) {
			throw new InvalidTime("Invalid timeToComplete "
			                      + Integer.toString(timeToComplete));
		}
		if (!(status.equals("todo") || status.equals("done"))) {
			throw new InvalidStatus("Invalid status " + status);
		}
	}
	String getTitle() {
		return title;
	}
	void setTitle(String t) {
		title = t;
	}
	String getassignedTo() {
		return assignedTo;
	}
	void setassignedTo(String a) {
		assignedTo = a;
	}
	int getTime() {
		return timeToComplete;
	}
	void setTime(int time) {
		timeToComplete = time;
	}
	boolean getimportant() {
		return important;
	}
	void setimportant(boolean imp) {
		important = imp;
	}
	boolean geturgent() {
		return urgent;
	}
	void seturgent(boolean u) {
		urgent = u;
	}
	String getstatus() {
		return status;
	}
	void setstatus(String s) {
		status = s;
	}
	public String toString() {
		String imp;
		if (important) {
			imp = "Important";
		} else {
			imp = "Not Important";
		}

		String urg;
		if (urgent) {
			urg = "Urgent";
		} else {
			urg = "Not Urgent";
		}
		return title + ", " + assignedTo + ", "
		       + Integer.toString(timeToComplete) + ", " + imp
		       + ", " + urg + ", " + status;
	}
}
class Todoist {
	private ArrayList<Task> array;
	Todoist() {
		array = new ArrayList<Task>();
	}
	public void addTask(final Task item) {
		array.add(item);
	}
	public String toString() {
		String s = "";
		for (Task t : array) {
			s += t.toString() + "\n";
		}
		return s;
	}
	public Task getNextTask(final String name) {
		for (Task task : array) {
			if (task.getassignedTo().equals(name)
			        && task.getimportant() == true && task.geturgent() == false
			        && task.getstatus().equals("todo")) {
				return task;
			}
			if (task.getassignedTo().equals(name)
			        && task.getimportant() == true && task.geturgent() == true
			        && task.getstatus().equals("todo")) {
				return task;
			}
		}
		return null;
	}
	public Task[] getNextTask(final String name, final int count) {
		Task[] arr = new Task[count];
		int i = 0;
		for (Task t : array) {
			if (t.getassignedTo().equals(name)
			        && t.getimportant() == true
			        && t.geturgent() == false
			        && t.getstatus().equals("todo")) {
				arr[i++] = t;
				if (i == count) {
					break;
				}
			} else if (t.getassignedTo().equals(name)
			           && t.getimportant() == true
			           && t.geturgent() == true
			           && t.getstatus().equals("todo")) {
				arr[i++] = t;
				if (i == count) {
					break;
				}
			}
		}
		return arr;
	}
	public int totalTime4Completion() {
		int total = 0;
		for (Task task : array) {
			if (task.getstatus().equals("todo")) {
				total += task.getTime();
			}
		}
		return total;
	}
}

