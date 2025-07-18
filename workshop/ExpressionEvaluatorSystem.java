package workshop;

//File: ExpressionEvaluatorSystem.java

import java.util.*;

//Interface for different evaluator strategies
interface ExpressionEvaluator {
 double evaluate(String expression);
}

//Infix to Postfix converter and evaluator
class PostfixEvaluator implements ExpressionEvaluator {

 private int precedence(char operator) {
     return switch (operator) {
         case '+', '-' -> 1;
         case '*', '/' -> 2;
         default -> -1;
     };
 }

 private String infixToPostfix(String infix) {
     StringBuilder postfix = new StringBuilder();
     Stack<Character> stack = new Stack<>();
     for (char ch : infix.toCharArray()) {
         if (Character.isDigit(ch)) {
             postfix.append(ch);
         } else if (ch == '(') {
             stack.push(ch);
         } else if (ch == ')') {
             while (!stack.isEmpty() && stack.peek() != '(') {
                 postfix.append(stack.pop());
             }
             stack.pop(); // remove '('
         } else {
             while (!stack.isEmpty() && precedence(ch) <= precedence(stack.peek())) {
                 postfix.append(stack.pop());
             }
             stack.push(ch);
         }
     }
     while (!stack.isEmpty()) {
         postfix.append(stack.pop());
     }
     return postfix.toString();
 }

 private double evaluatePostfix(String postfix) {
     Stack<Double> stack = new Stack<>();
     for (char ch : postfix.toCharArray()) {
         if (Character.isDigit(ch)) {
             stack.push((double)(ch - '0'));
         } else {
             double b = stack.pop();
             double a = stack.pop();
             switch (ch) {
                 case '+' -> stack.push(a + b);
                 case '-' -> stack.push(a - b);
                 case '*' -> stack.push(a * b);
                 case '/' -> stack.push(a / b);
             }
         }
     }
     return stack.pop();
 }

 @Override
 public double evaluate(String expression) {
     String postfix = infixToPostfix(expression.replaceAll("\\s+", ""));
     return evaluatePostfix(postfix);
 }
}

//Main class for testing
public class ExpressionEvaluatorSystem {
 public static void main(String[] args) {
     ExpressionEvaluator evaluator = new PostfixEvaluator();
     String infixExpr = "3 + (2 * 4) - 5";
     double result = evaluator.evaluate(infixExpr);
     System.out.println("Evaluated Result: " + result);
 }
}
