package model.question;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArithmeticTest extends QuestionTest {
    private ArithmeticQuestion additionQuestion;
    private ArithmeticQuestion subtractionQuestion;
    private ArithmeticQuestion multiplicationQuestion;

    @BeforeEach
    void runBefore() {
        additionQuestion = new ArithmeticQuestion(3, ArithmeticQuestion.Operation.ADDITION,
                2, 1);
        subtractionQuestion = new ArithmeticQuestion(3, ArithmeticQuestion.Operation.SUBTRACTION,
                2, 1);
        multiplicationQuestion = new ArithmeticQuestion(3, ArithmeticQuestion.Operation.MULTIPLICATION,
                2, 1);

    }

    @Test
    void testConstructor() {
        assertEquals(3, additionQuestion.getMaxMark());
    }

    @Test
    void testQuestionString() {
        assertEquals("What is 2 + 1 ? [3 points]", additionQuestion.getQuestionString());
        assertEquals("What is 2 - 1 ? [3 points]", subtractionQuestion.getQuestionString());
        assertEquals("What is 2 * 1 ? [3 points]", multiplicationQuestion.getQuestionString());
    }

    @Test
    void testCheckAnswerCorrect() {
        assertTrue(additionQuestion.isCorrect("3"));
        assertTrue(subtractionQuestion.isCorrect("1"));
        assertTrue(multiplicationQuestion.isCorrect("2"));
    }

    @Test
    void testCheckAnswerIncorrect() {
        assertFalse(additionQuestion.isCorrect("2"));
        assertFalse(subtractionQuestion.isCorrect("5"));
        assertFalse(multiplicationQuestion.isCorrect("5"));
    }
}