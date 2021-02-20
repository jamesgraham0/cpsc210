package model.quiz;

import model.question.QuestionList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UnlimitedTriesQuizTest extends QuizTest {
    private int numAttempts;

    @BeforeEach
    void runBefore() {
        QuestionList questionList = generateQuestionList();
        quiz = new UnlimitedTriesQuiz(questionList);
    }

    @Test
    void testConstructor() {
        super.testConstructor();
        assertEquals(6, quiz.getMaxMark());
        assertEquals(0, numAttempts);
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
            assertEquals("It took you 2 attempts to answer 2 questions correctly.", quiz.endQuiz());
        } catch (Exception e) {
            fail("Should not have thrown exception.");
        }
    }

    @Test
    void testSubmitAnswerAllIncorrect() {
        try {
            quiz.getNextQuestion();
            String feedback = quiz.submitAnswer("erth");
            assertEquals("Incorrect, try again", feedback);
            assertEquals(0, quiz.getMarkSoFar());
            feedback = quiz.submitAnswer("Earth");
            assertEquals("Correct!", feedback);
            assertEquals(4, quiz.getMarkSoFar());
//        } catch (Exception e) {
//            System.out.println("Incorrect, try again");
//        }


            quiz.getNextQuestion();
            feedback = quiz.submitAnswer("Cambodia");
            assertEquals("Incorrect, try again", feedback);
            assertEquals(4, quiz.getMarkSoFar());
            feedback = quiz.submitAnswer("Canada");
            assertEquals("Correct!", feedback);
            assertEquals(6, quiz.getMarkSoFar());
            assertFalse(quiz.hasMoreQuestions());
            assertEquals("It took you 4 attempts to answer 2 questions correctly.", quiz.endQuiz());
        } catch (Exception e) {
            System.out.println("Incorrect, try again");
        }
    }

    @Test
    void testSubmitAnswerPartiallyCorrect() {
        try {
            quiz.getNextQuestion();
            String feedback = quiz.submitAnswer("erth");
            assertEquals("Incorrect, try again", feedback);
            assertEquals(0, quiz.getMarkSoFar());
            feedback = quiz.submitAnswer("Earth");
            assertEquals("Correct!", feedback);
            assertEquals(4, quiz.getMarkSoFar());

            quiz.getNextQuestion();
            feedback = quiz.submitAnswer("Canada");
            assertEquals("Correct!", feedback);
            assertEquals(6, quiz.getMarkSoFar());
            assertFalse(quiz.hasMoreQuestions());
            assertEquals("It took you 3 attempts to answer 2 questions correctly.", quiz.endQuiz());
        } catch (Exception e) {
            System.out.println("Incorrect, try again");
        }
    }
}
