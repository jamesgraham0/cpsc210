package model.question.checker;

import model.question.ArithmeticQuestion;

public class ArithmeticAnswerChecker extends AnswerChecker {
    public int answer;

    // EFFECTS: constructs checker for given answer
    public ArithmeticAnswerChecker(int answer) {
        this.answer = answer;
    }

    /**
     *
     * Indicate the answer is incorrect if the user enters a non-integer value (e.g. 6.0, 5.2, -3.6).
     * In particular, note that 6 and 6.0 are interpreted differently in Java - 6 is considered to
     * be a value of type int whereas 6.0 is a value of type double
     *
     * Indicate the answer is incorrect if the user enters an integer that cannot be represented as an
     * int.  Keep in mind that the int type can represent only those values in the range -2147483648 to 2147483647.
     *
     * Indicate the answer is incorrect if the user enters a sequence of characters that cannot be interpreted
     * as an int. For example, if the user enters "four" instead of "4", the answer is incorrect.
     */

    @Override
    public boolean checkAnswer(String userResponse) {
        try {
            return Integer.parseInt(userResponse) == answer;
        } catch (NumberFormatException e) {
            return false;
        }
    }

}
