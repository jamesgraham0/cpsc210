package model.quiz;

import model.question.QuestionList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LimitedTriesQuizTest extends QuizTest {

    @BeforeEach
    void runBefore() {
        QuestionList questionList = generateQuestionList();
        quiz = new LimitedTriesQuiz(questionList);
    }

    @Test
    void testConstructor() {
        super.testConstructor();
        assertEquals(6, quiz.getMaxMark());
    }

    @Test
    void testOutOfTries() {

    }


    @Test
    void testIncorrectForEveryAttempt() {
        try {
            quiz.getNextQuestion();
            String feedback = quiz.submitAnswer("erth");
            assertEquals("Incorrect, try again", feedback);
            assertEquals(0, quiz.getMarkSoFar());
            assertEquals(3, quiz.curQuestion.getMaxMark());

            feedback = quiz.submitAnswer("erth");
            assertEquals("Incorrect, try again", feedback);
            assertEquals(0, quiz.getMarkSoFar());
            assertEquals(2, quiz.curQuestion.getMaxMark());

            feedback = quiz.submitAnswer("erth");
            assertEquals("Incorrect, try again", feedback);
            assertEquals(0, quiz.getMarkSoFar());
            assertEquals(1, quiz.curQuestion.getMaxMark());

            feedback = quiz.submitAnswer("erth");
            assertEquals("Out of tries", feedback);
            assertEquals(0, quiz.getMarkSoFar());
            assertEquals(0, quiz.curQuestion.getMaxMark());

            quiz.getNextQuestion();
            feedback = quiz.submitAnswer("cambodia");
            assertEquals("Incorrect, try again", feedback);
            assertEquals(0, quiz.getMarkSoFar());
            assertEquals(1, quiz.curQuestion.getMaxMark());

            feedback = quiz.submitAnswer("Canada");
            assertEquals("Out of tries", feedback);
            assertEquals(0, quiz.getMarkSoFar());
            assertEquals(0, quiz.curQuestion.getMaxMark());
            assertFalse(quiz.hasMoreQuestions());
            assertEquals("Your final mark is: 0 out of 6", quiz.endQuiz());
        } catch (Exception e) {
            System.out.println("Either incorrect answer or out of tries.");
        }
    }


    @Test
    void testIncorrectUntilLastAttempt() {
        try {
            quiz.getNextQuestion();
            assertEquals(4, quiz.curQuestion.getMaxMark());
            String feedback = quiz.submitAnswer("erth");
            assertEquals("Incorrect, try again", feedback);
            assertEquals(0, quiz.getMarkSoFar());
            assertEquals(3, quiz.curQuestion.getMaxMark());

            feedback = quiz.submitAnswer("erth");
            assertEquals("Incorrect, try again", feedback);
            assertEquals(0, quiz.getMarkSoFar());
            assertEquals(2, quiz.curQuestion.getMaxMark());

            feedback = quiz.submitAnswer("erth");
            assertEquals("Incorrect, try again", feedback);
            assertEquals(0, quiz.getMarkSoFar());
            assertEquals(1, quiz.curQuestion.getMaxMark());

            feedback = quiz.submitAnswer("Earth");
            assertEquals("Correct!", feedback);
            assertEquals(1, quiz.getMarkSoFar());
            assertEquals(1, quiz.curQuestion.getMaxMark());

            quiz.getNextQuestion();
            assertEquals(2, quiz.curQuestion.getMaxMark());
            feedback = quiz.submitAnswer("cambodia");
            assertEquals("Incorrect, try again", feedback);
            assertEquals(1, quiz.getMarkSoFar());
            assertEquals(1, quiz.curQuestion.getMaxMark());

            feedback = quiz.submitAnswer("Canada");
            assertEquals("Correct!", feedback);
            assertEquals(2, quiz.getMarkSoFar());
            assertEquals(1, quiz.curQuestion.getMaxMark());

            assertFalse(quiz.hasMoreQuestions());
            assertEquals("Your final mark is: 2 out of 6", quiz.endQuiz());
        } catch (Exception e) {
            System.out.println("Either incorrect answer or out of tries.");
        }
    }

    @Test
    void testSubmitAnswerAllCorrect() {
        try {
            quiz.getNextQuestion();
            String feedback = quiz.submitAnswer("Earth");
            assertEquals("Correct!", feedback);
            assertEquals(4, quiz.getMarkSoFar());

            quiz.getNextQuestion();
            feedback = quiz.submitAnswer("Canada");
            assertEquals("Correct!", feedback);
            assertEquals(6, quiz.getMarkSoFar());
            assertFalse(quiz.hasMoreQuestions());
            assertEquals("Your final mark is: 6 out of 6", quiz.endQuiz());
        } catch (Exception e) {
            System.out.println("Either incorrect answer or out of tries.");
        }
    }

    @Test
    void testSubmitAnswerAllIncorrect() {
        try {
            quiz.getNextQuestion();
            String feedback = quiz.submitAnswer("erth");
            assertEquals("Incorrect, try again", feedback);
            assertEquals(0, quiz.getMarkSoFar());
            assertEquals(3, quiz.curQuestion.getMaxMark());
            feedback = quiz.submitAnswer("Earth");
            assertEquals("Correct!", feedback);
            assertEquals(3, quiz.getMarkSoFar());

            quiz.getNextQuestion();
            feedback = quiz.submitAnswer("Cambodia");
            assertEquals("Incorrect, try again", feedback);
            assertEquals(3, quiz.getMarkSoFar());
            assertEquals(1, quiz.curQuestion.getMaxMark());
            feedback = quiz.submitAnswer("Canada");
            assertEquals("Correct!", feedback);
            assertEquals(4, quiz.getMarkSoFar());
            assertFalse(quiz.hasMoreQuestions());
            assertEquals("Your final mark is: 4 out of 6", quiz.endQuiz());
        } catch (Exception e) {
            System.out.println("Either incorrect answer or out of tries.");
        }
    }

    @Test
    void testSubmitAnswerOutOfTries() {
        try {
            quiz.getNextQuestion();
            String feedback = quiz.submitAnswer("erth");
        } catch (Exception e) {
            assertEquals(0, quiz.getMarkSoFar());
            assertEquals(3, quiz.curQuestion.getMaxMark());
            System.out.println(quiz.curQuestion.getMaxMark());
        }

        try {
            String feedback = quiz.submitAnswer("erth");
            assertEquals("Incorrect, try again", feedback);
            assertEquals(0, quiz.getMarkSoFar());
            assertEquals(2, quiz.curQuestion.getMaxMark());

        } catch (Exception e) {
            System.out.println(quiz.curQuestion.getMaxMark());
        }

        try {
            String feedback = quiz.submitAnswer("erth");

        } catch (Exception e) {
            assertEquals(0, quiz.getMarkSoFar());
            assertEquals(1, quiz.curQuestion.getMaxMark());
            System.out.println(quiz.curQuestion.getMaxMark());
        }

        try {

            String feedback = quiz.submitAnswer("erth");
            assertEquals("Incorrect, try again", feedback);
            assertEquals(0, quiz.getMarkSoFar());
            assertEquals(0, quiz.curQuestion.getMaxMark());

        } catch (Exception e) {
            System.out.println(quiz.curQuestion.getMaxMark());
        }
        try {

            String feedback = quiz.submitAnswer("erth");
            assertEquals(0, quiz.getMarkSoFar());
            assertEquals(0, quiz.curQuestion.getMaxMark());

        } catch (Exception e) {
            System.out.println(quiz.curQuestion.getMaxMark());
        }
        try {

            String feedback = quiz.submitAnswer("erth");
            assertEquals(0, quiz.getMarkSoFar());
            assertEquals(0, quiz.curQuestion.getMaxMark());

        } catch (Exception e) {
            System.out.println(quiz.curQuestion.getMaxMark());
        }
    }
}
