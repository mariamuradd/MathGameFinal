package com.mathGameFinal;
// NOT COMPLETE YET BUT controls all abstraction and need to make sure that math questions asked include subtraction, division & multiplication
// want a timer as well

public class GameController {
    protected int score;
    protected QuestionLinkedList questionList;
    protected QuestionNode currentQuestion;

    public GameController() {
        this.score = 0;
        this.questionList = new QuestionLinkedList();
        this.currentQuestion = null;
    }

   // public abstract void askQuestion();
    //public abstract void evaluateAnswer(int userAnswer);
    //public abstract void generateQuestion();

    public void startGame() {
        score = 0;
        questionList = new QuestionLinkedList();
        // have to write more of the initialization code
    }

    public void nextQuestion() {
        currentQuestion = currentQuestion.getNext();
    }

    public void endGame() {
        System.out.println("Game Over! Your final score is: " + score);
    }
}
