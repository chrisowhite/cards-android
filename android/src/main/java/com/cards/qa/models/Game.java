package com.cards.qa.models;

import com.cards.qa.dummy.DummyContent;

import java.util.ArrayList;

public class Game {
    private static final short MAX_ANSWER_COUNT = 2;

    private Hand hand;
    private QuestionCard currentQuestion;
    private ArrayList<AnswerCard> selectedCards;

    public Game() {
        hand = DummyContent.DummyHand; // replace this eventually
        currentQuestion = DummyContent.DummyQuestionCard;
        selectedCards = new ArrayList<>(MAX_ANSWER_COUNT);
    }

    public Hand getCurrentHand() {
        return hand;
    }
    public ArrayList<AnswerCard> getSelectedAnswerCards() {
        return selectedCards;
    }

    public void removeSelectedAnswer(AnswerCard card) {
        selectedCards.remove(card);
    }

    public void removeSelectedAnswer(int index) {
        selectedCards.remove(index);
    }

    public void addSelectedAnswer(AnswerCard card) {
        if (selectedCards.size() < MAX_ANSWER_COUNT) {
            if (currentQuestion.getAnswerCount() == 1 && selectedCards.size() > 0) {
                selectedCards.clear();
            }
            selectedCards.add(card);
        }
    }

    public boolean getAdditionalAnswersAllowed() {
        return !(selectedCards.size() == currentQuestion.getAnswerCount());
    }

    public short getSelectedAnswerLocation(AnswerCard card) {
        return (short)selectedCards.indexOf(card);
    }

    public void setSelectedAnswer(short answerIndex, AnswerCard card) {
        selectedCards.set(answerIndex, card);
    }

    public int getSelectedAnswerCount() {
        return selectedCards.size();
    }
    public QuestionCard getCurrentQuestion() {
        return currentQuestion;
    }
}
