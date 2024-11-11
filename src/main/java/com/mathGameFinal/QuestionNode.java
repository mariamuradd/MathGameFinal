package com.mathGameFinal;
// NOT COMPLETE YET

import java.util.Random;

public class QuestionNode {
    private String question;
    private int answer;
    private int userResponse;
    private QuestionNode next;

    public QuestionNode(String question, int answer) {
        this.question = question;
        this.answer = answer;
        this.userResponse = -1;  // - 1 is user did not answer question yet
        this.next = null;
    }

    public String getQuestion() { return question; }
    public int getAnswer() { return answer; }
    public int getUserResponse() { return userResponse; }
    public QuestionNode getNext() { return next; }

    public void setQuestion(String q) { question = q; }
    public void setAnswer(int a) { answer = a; }
    public void setUserResponse(int ur) { userResponse = ur; }
    public void setNext(QuestionNode nextNode) { next = nextNode; }
   
}
