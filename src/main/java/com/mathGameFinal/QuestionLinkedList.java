/*
 * Name: Maria Murad
 * Class Name: QuestionLinkedList
 * Date: November 26th, 2024
 * Description: This class manages a linked list of QuestionNode objects, providing methods for insertion, removal, searching, and displaying questions.
 */
package com.mathGameFinal;

public class QuestionLinkedList {
    
    private QuestionNode head;
    private QuestionNode tail;

    public QuestionLinkedList() {
        head = null;
        tail = null;
    }

    // insert a question at the end of the list
    public void insertQuestion(QuestionNode newNode) {
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.setNext(newNode);
            tail = newNode;
        }
    }



    // this will insert at the tail - same as insertQuestion
    public void insertAtTail(QuestionNode newNode) {
        insertQuestion(newNode);
    }

    // removes the first question in this list Remove the first question in the list
    public void removeQuestion() {
        if (head != null) {
            head = head.getNext();
            if (head == null) {  // will equal to null if the list becomes empty
                tail = null;
            }
        }
    }


    // this will find a question by its string representation
    public QuestionNode findQuestion(String question) {
        QuestionNode current = head;
        while (current != null) {
            if (current.getQuestion().equals(question)) {
                return current;
            }
            current = current.getNext();
        }
        return null;  // will return null if the question is not found
    }


    // this will print all the questions in the linked list
    public void printQuestions() {
        QuestionNode current = head;
        while (current != null) {
            System.out.println(current.getQuestion() + " = " + current.getExpectedAnswer());
            current = current.getNext();
        }
    }


    // gets the tail node
    public QuestionNode getTail() {
        return tail;
    }

    // checks if the list is empty
    public boolean isEmpty() {
        return head == null;
    }

}
