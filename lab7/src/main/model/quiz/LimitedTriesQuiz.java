package model.quiz;

import model.exceptions.AnswerIncorrectException;
import model.exceptions.OutOfTriesException;
import model.question.QuestionList;

public class LimitedTriesQuiz extends Quiz {

    // REQUIRES: questions cannot be an empty list
    // EFFECTS: constructs quiz with given list of questions
    public LimitedTriesQuiz(QuestionList questions) {
        super(questions);
    }

    // MODIFIES: this
    // EFFECTS: submit an answer to the current question and return feedback string;
    // if the answer is incorrect, decrements the max mark of the current question by one;
    // throws AnswerIncorrectException if the user should re-try the question
    // throws an OutOfTriesException if the answer is incorrect and no more
    // attempts are allowed
    @Override
    public String submitAnswer(String answer) throws AnswerIncorrectException, OutOfTriesException {
        boolean correct = super.checkAnswer(answer);
        int maxMark = curQuestion.getMaxMark();
        int triesLeft = curQuestion.getMaxMark();

        for (int i = 0; i < maxMark; i++) {
            if (!correct) {
                triesLeft--;
                curQuestion.setMaxMark(triesLeft);
                if (triesLeft > 0) {
                    throw new AnswerIncorrectException("Incorrect, try again");
                } else {
                    throw new OutOfTriesException("Out of tries");
                }
            }
        }
        return "Correct!";
    }

}


