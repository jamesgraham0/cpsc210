package model.quiz;

import model.exceptions.AnswerIncorrectException;
import model.exceptions.OutOfTriesException;
import model.question.QuestionList;

public class UnlimitedTriesQuiz extends Quiz {
    public int numAttempts;

    // REQUIRES: questions cannot be an empty list
    // EFFECTS: constructs quiz with given list of questions
    public UnlimitedTriesQuiz(QuestionList questions) {
        super(questions);
        numAttempts = 0;
    }

    // EFFECTS: submit an answer to the current question and return feedback string;
    // does not modify max mark of current question;
    // throws AnswerIncorrectException if the user should re-try the question;
    @Override
    public String submitAnswer(String answer) throws AnswerIncorrectException {
        boolean correct = super.checkAnswer(answer);
        numAttempts++;
        if (!correct) {
            throw new AnswerIncorrectException("Incorrect, try again");
        } else {
            return "Correct!";
        }
    }

    // EFFECTS: returns number of attempts taken to answer questions so far
    public int getNumAttempts() {
        return numAttempts;
    }

    @Override
    // MODIFIES: this
    // EFFECTS: returns a string providing feedback to the user on their performance in the quiz
    public String endQuiz() {
        int length = questions.length();
        return "It took you " + getNumAttempts() + " attempts to answer " + length + " questions correctly.";
    }

}
