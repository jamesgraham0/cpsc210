package model.question.checker;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ArithmeticAnswerCheckerTest {
    private ArithmeticAnswerChecker arithmeticAnswerChecker;

    @BeforeEach
    void runBefore() {
        arithmeticAnswerChecker = new ArithmeticAnswerChecker(5);
    }

    @Test
    void testMatch() {
        assertTrue(arithmeticAnswerChecker.checkAnswer("5"));
    }

    @Test
    void testDouble() {
        arithmeticAnswerChecker.checkAnswer("5.0");
        assertFalse(arithmeticAnswerChecker.checkAnswer("5.0"));
    }

    @Test
    void testIntTooLarge() {
        arithmeticAnswerChecker.checkAnswer("333333333333");
        assertFalse(arithmeticAnswerChecker.checkAnswer("333333333333"));
    }

    @Test
    void testIntTooSmall() {
        arithmeticAnswerChecker.checkAnswer("-333333333333");
        assertFalse(arithmeticAnswerChecker.checkAnswer("-333333333333"));
    }

    @Test
    void testNotInteger() {
        arithmeticAnswerChecker.checkAnswer("james");
        assertFalse(arithmeticAnswerChecker.checkAnswer("james"));
    }
}
