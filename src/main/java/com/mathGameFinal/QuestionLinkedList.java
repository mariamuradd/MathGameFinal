package com.mathGameFinal;
//NOT COMPLETE YET

public class QuestionLinkedList {
    private QuestionNode head;
    private QuestionNode tail;

    public QuestionLinkedList() {
        head = null;
        tail = null;
    }

    public void insertQuestion(QuestionNode newNode) {
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.setNext(newNode);
            tail = newNode;
        }
    }

    public void removeQuestion() {
        if (head != null) {
            head = head.getNext();
        }
    }

    public QuestionNode findQuestion(String question) {
        QuestionNode current = head;
        while (current != null) {
            if (current.getQuestion().equals(question)) {
                return current;
            }
            current = current.getNext();
        }
        return null;  // will return null if question is not located
    }

    public void printQuestions() {
        QuestionNode current = head;
        while (current != null) {
            System.out.println(current.getQuestion());
            current = current.getNext();
        }
    }
}
