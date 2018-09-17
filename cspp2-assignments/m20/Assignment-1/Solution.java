import java.util.Scanner;
/**
 * Class for question.
 */
class Question {
	/**
	 * { var_description }.
	 */
	private String questiontext;
	/**
	 * { var_description }.
	 */
	private String[] choices;
	/**
	 * { var_description }.
	 */
	private int correctAnswer;
	/**
	 * { var_description }.
	 */
	private int maxMarks;
	/**
	 * { var_description }.
	 */
	private int penalty;
	/**
	 * { var_description }.
	 */
	private String response;
	/**
	 * Constructs the object.
	 */
	Question() {

	}
	/**
	 * Constructs the object.
	 *
	 * @param      question1       The question 1
	 * @param      choices1        The choices 1
	 * @param      correctAnswer1  The correct answer 1
	 * @param      maxMarks1       The maximum marks 1
	 * @param      penalty1        The penalty 1
	 */
	Question(final String question1, final String[] choices1,
	         final int correctAnswer1, final int maxMarks1, final int penalty1) {
		questiontext = question1;
		choices = choices1;
		correctAnswer = correctAnswer1;
		maxMarks = maxMarks1;
		penalty = penalty1;
	}
	/**
	 * { function_description }.
	 *
	 * @param      choice  The choice
	 *
	 * @return     { description_of_the_return_value }
	 */
	public boolean evaluateResponse(final String choice) {
		return false;
	}
	/**
	 * Gets the correct answer.
	 *
	 * @return     The correct answer.
	 */
	public String getCorrectAnswer() {
		return Integer.toString(correctAnswer);
	}
	/**
	 * Gets the question text.
	 *
	 * @return     The question text.
	 */
	public String getQuestionText() {
		return questiontext;
	}
	/**
	 * Gets the choice.
	 *
	 * @return     The choice.
	 */
	public String[] getChoice() {
		return choices;
	}
	/**
	 * Gets the maximum marks.
	 *
	 * @return     The maximum marks.
	 */
	public int getMaxMarks() {
		return maxMarks;
	}
	/**
	 * Gets the penalty.
	 *
	 * @return     The penalty.
	 */
	public int getPenalty() {
		return penalty;
	}
	/**
	 * Sets the response.
	 *
	 * @param      answer  The answer
	 */
	public void setResponse(final String answer) {
		response = answer;
	}
	/**
	 * Gets the response.
	 *
	 * @return     The response.
	 */
	public String getResponse() {
		return response;
	}
	/**
	 * Returns a string representation of the object.
	 *
	 * @return     String representation of the object.
	 */
	public String toString() {
		String s = "";
		return s;
	}
}
/**
 * Class for quiz.
 */
class Quiz {
	/**
	 * { var_description }.
	 */
	private final int onehundred = 100;
	/**
	 * { var_description }.
	 */
	private Question[] questions;
	/**
	 * { var_description }.
	 */
	private int size;
	/**
	 * Constructs the object.
	 */
	Quiz() {
		questions = new Question[onehundred];
		size = 0;
	}
	/**
	 * Adds a question.
	 *
	 * @param      q     The question
	 */
	public void addQuestion(final Question q) {
		questions[size++] = q;
	}
	/**
	 * Gets the question.
	 *
	 * @param      index  The index
	 *
	 * @return     The question.
	 */
	public Question getQuestion(final int index) {
		return questions[index];
	}
	/**
	 * Shows the report.
	 *
	 * @return     { description_of_the_return_value }
	 */
	public String showReport() {
		String s = "";
		return s;
	}

}
/**
 * Solution class for code-eval.
 */
public final class Solution {
	/**
	* Constructs the object.
	*/
	private Solution() {
		// leave this blank
	}
	/**
	 * main function to execute test cases.
	 *
	 * @param      args  The arguments
	 */
	public static void main(final String[] args) {
		// instantiate this Quiz
		Quiz q = new Quiz();
		// code to read the test cases input file
		Scanner s = new Scanner(System.in);
		// check if there is one more line to process
		while (s.hasNext()) {
			// read the line
			String line = s.nextLine();
			// split the line using space
			String[] tokens = line.split(" ");
			// based on the list operation invoke the corresponding method
			switch (tokens[0]) {
			case "LOAD_QUESTIONS":
				System.out.println("|----------------|");
				System.out.println("| Load Questions |");
				System.out.println("|----------------|");
				loadQuestions(s, q, Integer.parseInt(tokens[1]));
				break;
			case "START_QUIZ":
				System.out.println("|------------|");
				System.out.println("| Start Quiz |");
				System.out.println("|------------|");
				startQuiz(s, q, Integer.parseInt(tokens[1]));
				break;
			case "SCORE_REPORT":
				System.out.println("|--------------|");
				System.out.println("| Score Report |");
				System.out.println("|--------------|");
				displayScore(q);
				break;
			default:
				break;
			}
		}
	}
	/**
	 * Loads questions.
	 *
	 * @param      scan       The scan
	 * @param      quiz       The quiz
	 * @param      q          The question count
	 *
	 */
	public static void loadQuestions(final Scanner scan,
	                                 final Quiz quiz, final int q) {
		int cnt = 0, j = 0;
		String[] field = new String[q];
		if (q < 1) {
			System.out.println("Quiz does not have questions");
			return;
		}
		for (int i = 0; i < q; i++) {
			final int five = 5;
			String s = scan.nextLine();
			field = s.split(":");
			if (field.length != five || field[0].equals("")) {
				System.out.println("Error! Malformed question");
				return;
			}
			String[] choices = field[1].split(",");
			if (choices.length < 2) {
				System.out.println(field[0] + " "
				                   + "does not have enough answer choices");
				return;
			}
			if (Integer.parseInt(field[2]) < 1
			        || Integer.parseInt(field[2]) > choices.length) {
				System.out.println("Error! Correct answer choice number"
				                   + " " + "is out of range for" + " " + field[0]);
				return;
			}
			final int three = 3;
			if (Integer.parseInt(field[three]) <= 0) {
				System.out.println("Invalid max marks for" + " " + field[0]);
				return;
			}
			final int four = 4;
			if (Integer.parseInt(field[four]) > 0) {
				System.out.println("Invalid penalty for" + " " + field[0]);
				return;
			}
			quiz.addQuestion(quiz.getQuestion(i));
		}
		System.out.println(q + " " + "are added to the quiz");
	}
	/**
	 * Starts a quiz.
	 *
	 * @param      scan  The scan
	 * @param      quiz  The quiz
	 * @param      q     The answer count
	 */
	public static void startQuiz(final Scanner scan,
	                             final Quiz quiz, final int q) {
		for (int i = 0; i < q; i++) {
			Question ques = quiz.getQuestion(i);
			System.out.println(ques);
		}
	}
	/**
	 * Displays the score report.
	 *
	 * @param      quiz     The quiz object
	 */
	public static void displayScore(final Quiz quiz) {
		// write your code here to display the score report using quiz object.
	}
}
