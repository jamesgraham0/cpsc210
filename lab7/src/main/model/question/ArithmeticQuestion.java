package model.question;

import model.question.checker.AnswerChecker;
import model.question.checker.ArithmeticAnswerChecker;

public class ArithmeticQuestion extends Question {


    public enum Operation { ADDITION, SUBTRACTION, MULTIPLICATION }


    public ArithmeticQuestion(int maxMark, Operation operation, int firstOp, int secondOp) {
        super(maxMark, arithmeticQuestion(operation, firstOp, secondOp),
                new ArithmeticAnswerChecker(answer(operation, firstOp, secondOp)));
    }
    //(printOperation(operation) == "*")

    public static int answer(Operation operation, int firstOp, int secondOp) {
        int answer = 0;
        if (printOperation(operation) == "+") {
            answer = firstOp + secondOp;
        } else if (printOperation(operation) == "-") {
            answer = firstOp - secondOp;
        } else {
            answer = firstOp * secondOp;
        }
        return answer;
    }

    public static String arithmeticQuestion(ArithmeticQuestion.Operation operation, int firstOp, int secondOp) {
        return "What is " + firstOp + " " + printOperation(operation) + " " + secondOp + " ?";
    }

    private static String printOperation(Operation operation) {
        if (operation == ArithmeticQuestion.Operation.ADDITION) {
            return "+";
        } else if (operation == ArithmeticQuestion.Operation.SUBTRACTION) {
            return "-";
        } else {
            return "*";
        }
    }
}
