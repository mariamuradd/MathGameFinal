/*
 * Name: Maria Murad
 * Class Name: QuestionNode
 * Date: November 26th, 2024
 * Description: This class represents a single math question with operators, operands, and the expected answer, and links to the next question in the sequence.
 */
package com.mathGameFinal;

import java.util.Random;

public class QuestionNode {
    
    private int operator1;
    private int operator2;
    private char operator;
    private int expectedAnswer;
    private int userResponse;
    private QuestionNode next;

    // this is the possible array of operators I will be using
    private static final char[] OPERATORS = {'+', '-', '*', '/'};

    public QuestionNode() {
        Random random = new Random();


        // this will assign random values to operator1 and operator2
        this.operator1 =  random.nextInt(20);
        this.operator2 = random.nextInt(20);


        // this randomly choose an operator from the array
        this.operator = OPERATORS[random.nextInt(OPERATORS.length)];

        // calculates the expected answer based on the chosen operator
        switch (operator) {
            case '+':
                this.expectedAnswer = operator1 + operator2;
                break;
            case '-':
                this.expectedAnswer = operator1 - operator2;
                break;
            case '*':
                this.expectedAnswer = operator1 * operator2;
                break;
            case '/':
                // handles multiplication & division
                this.expectedAnswer = operator2 != 0 ? operator1 /operator2 : 0;
                break;
        }

        // initializes user response to -1 to indicate no answer yet
        this.userResponse = -1;
        this.next = null;
    }


    // getters
    public int getOperator1() { return operator1; }
    public int getOperator2() { return operator2; }
    public char getOperator() { return operator; }
    public int getExpectedAnswer() { return expectedAnswer; }
    public int getUserResponse() { return userResponse; }
    public QuestionNode getNext() { return next; }



    // setters
    public void setOperator1(int operator1) { this.operator1 = operator1; }
    public void setOperator2(int operator2) { this.operator2 = operator2; }
    public void setOperator(char operator) { this.operator = operator; }
    public void setExpectedAnswer(int expectedAnswer) { this.expectedAnswer = expectedAnswer; }
    public void setUserResponse(int userResponse) { this.userResponse = userResponse; }
    public void setNext(QuestionNode next) { this.next = next; }


    // generates a string representation of the question
    public String getQuestion() {
        return "What is " + operator1 + " " + operator + " " + operator2 + "?";
    }

}
