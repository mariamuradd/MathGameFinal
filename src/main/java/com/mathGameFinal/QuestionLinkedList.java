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

    // Insert a question at the end of the list
    public void insertQuestion(QuestionNode newNode) {
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.setNext(newNode);
            tail = newNode;
        }
    }

    // Insert at the tail (same as insertQuestion, but separated for clarity)
    public void insertAtTail(QuestionNode newNode) {
        insertQuestion(newNode);
    }

    // Remove the first question in the list
    public void removeQuestion() {
        if (head != null) {
            head = head.getNext();
            if (head == null) {  // If the list becomes empty
                tail = null;
            }
        }
    }

    // Find a question by its string representation
    public QuestionNode findQuestion(String question) {
        QuestionNode current = head;
        while (current != null) {
            if (current.getQuestion().equals(question)) {
                return current;
            }
            current = current.getNext();
        }
        return null;  // Returns null if question is not found
    }

    // Print all questions in the linked list
    public void printQuestions() {
        QuestionNode current = head;
        while (current != null) {
            System.out.println(current.getQuestion() + " = " + current.getExpectedAnswer());
            current = current.getNext();
        }
    }

    // Get the tail node
    public QuestionNode getTail() {
        return tail;
    }

    // Check if the list is empty
    public boolean isEmpty() {
        return head == null;
    }
}
