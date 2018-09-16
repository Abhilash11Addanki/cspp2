import java.util.Scanner;
import java.util.ArrayList;

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
        /**
         * q of type Quiz class.
         */
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
     * @param      s              The scanner object for user input
     * @param      quiz           The quiz object
     * @param      questionCount  The question count
     */
    public static void loadQuestions(final Scanner s,
                                     final Quiz quiz, final int questionCount) {
        /**
         * questions list.
         */
        int cnt = 0;
        String[] field = new String[questionCount];
        if (questionCount < 1) {
            System.out.println("Quiz does not have questions");
            return;
        }
        for (int i = 0; i < questionCount; i++) {
            final int five = 5;
            String q = s.nextLine();
            field = q.split(":");
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
            quiz.setquestiontext(field[0]);
            quiz.setmarksawarded(Integer.parseInt(field[3]));
            for (int j = 0; j < choices.length; j++) {
                quiz.setchoices(choices[j]);
            }
        }
        System.out.println(questionCount + " " + "are added to the quiz");
    }

    /**
     * Starts a quiz.
     *
     * @param      s            The scanner object for user input
     * @param      quiz         The quiz object
     * @param      answerCount  The answer count
     */
    public static void startQuiz(final Scanner s,
                                 final Quiz quiz, final int answerCount) {
        quiz.displayquestiontext();
    }
    /**
     * Displays the score report.
     *
     * @param      quiz  The quiz
     */
    public static void displayScore(final Quiz quiz) {
        // write your code here to display the score report
    }
}
/**
 * Class for quiz.
 */
class Quiz {
    /**
     * questiontext.
     */
    private ArrayList<String> questiontext = new ArrayList<String>();
    /**
     * choices.
     */
    private ArrayList<String> choices = new ArrayList<String>();
    /**
     * correctanswer.
     */
    private ArrayList<Integer> correctanswer = new ArrayList<Integer>();
    /**
     * marksawarded.
     */
    private ArrayList<Integer> marksawarded = new ArrayList<Integer>();
    /**
     * penalty.
     */
    private ArrayList<Integer> penalty = new ArrayList<Integer>();
    /**
     * sets question text.
     *
     * @param      q     The quarter
     */
    void setquestiontext(final String q) {
        questiontext.add(q);
    }
    /**
     * sets choices.
     *
     * @param      ch     { parameter_description }
     */
    void setchoices(final String ch) {
        choices.add(ch);
    }
    /**
     * sets correct answer.
     *
     * @param      c     { parameter_description }
     */
    void setcorrectanswer(final int c) {
        correctanswer.add(c);
    }
    /**
     * sets marks awarded.
     *
     * @param      m     { parameter_description }
     */
    void setmarksawarded(final int m) {
        marksawarded.add(m);
    }
    /**
     * sets penalty.
     *
     * @param      p     { parameter_description }
     */
    void setpenalty(final int p) {
        penalty.add(p);
    }
    void displayquestiontext() {
        int i = 0;
        for (String quiz : questiontext) {
            System.out.println(quiz + "(" + marksawarded.get(i) + ")");
            for (int j = 0; j < choices.size(); j++) {
                System.out.print(choices.get(j) + "     ");
            }
            System.out.println();
            i++;
        }
    }
}






