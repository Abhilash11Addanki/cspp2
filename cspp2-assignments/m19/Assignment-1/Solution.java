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
        ArrayList<Quiz> questions = new ArrayList<Quiz>();
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
            questions.add(quiz);
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
    private String questiontext;
    /**
     * choices.
     */
    private String[] choices;
    /**
     * correctanswer.
     */
    private int correctanswer;
    /**
     * marksawarded.
     */
    private int marksawarded;
    /**
     * penalty.
     */
    private int penalty;
    /**
     * Constructs the object.
     */
    Quiz() {

    }
    /**
     * Constructs the object.
     * @param      q     The quarter
     * @param      ch    { parameter_description }
     * @param      c     { parameter_description }
     * @param      m     { parameter_description }
     * @param      p     { parameter_description }
     */
    Quiz(final String q, final String[] ch,
        final int c, final int m, final int p) {
        questiontext = q;
        choices = ch;
        correctanswer = c;
        marksawarded = m;
        penalty = p;
    }
    /**
     * gets question text.
     *
     * @return     { description_of_the_return_value }
     */
    String getquestiontext() {
        return questiontext;
    }
    /**
     * sets question text.
     *
     * @param      q     The quarter
     */
    void setquestiontext(final String q) {
        questiontext = q;
    }
    /**
     * gets choices.
     *
     * @return     { description_of_the_return_value }
     */
    String[] getchoices() {
        return choices;
    }
    /**
     * sets choices.
     *
     * @param      c     { parameter_description }
     */
    void setchoices(final String[] c) {
        choices = c;
    }
    /**
     * gets correct answer.
     *
     * @return     { description_of_the_return_value }
     */
    int getcorrectanswer() {
        return correctanswer;
    }
    /**
     * sets correct answer.
     *
     * @param      c     { parameter_description }
     */
    void setcorrectanswer(final int c) {
        correctanswer = c;
    }
    /**
     * gets marks awarded.
     *
     * @return     { description_of_the_return_value }
     */
    int getmarksawarded() {
        return marksawarded;
    }
    /**
     * sets marks awarded.
     *
     * @param      m     { parameter_description }
     */
    void setmarksawarded(final int m) {
        marksawarded = m;
    }
    /**
     * gets penalty.
     *
     * @return     { description_of_the_return_value }
     */
    int getpenalty() {
        return penalty;
    }
    /**
     * sets penalty.
     *
     * @param      p     { parameter_description }
     */
    void setpenalty(final int p) {
        penalty = p;
    }
}






