package com.cards.qa.models;

import java.util.UUID;
import java.util.regex.Pattern;

public class QuestionCard {
    private UUID id;
    private String cardText;
    private short answerCount;

    public QuestionCard(UUID id, String cardText, short answerCount) {
        this.id = id;
        this.cardText = cardText;
        this.answerCount = answerCount;
    }

    public String getCardText() {
        return cardText;
    }

    public short getAnswerCount() {
        return answerCount;
    }

    public UUID getId() {
        return id;
    }

    public boolean getIsFillInTheBlank() {
        return Pattern.compile("_+").matcher(cardText).find();
    }
}
