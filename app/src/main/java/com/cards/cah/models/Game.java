package com.cards.cah.models;

import com.cards.cah.dummy.DummyContent;

import java.util.UUID;

/**
 * Created by Chris on 12/24/2014.
 */
public class Game {
    private Hand hand;
    private BlackCard currentQuestion;

    public Game() {
        hand = DummyContent.DummyHand; // replace this eventually
        currentQuestion = new BlackCard(UUID.randomUUID(), "Anthropologists have recently discovered a primitive tribe that worships __________.");
    }

    public Hand getCurrentHand() {
        return hand;
    }
    public BlackCard getCurrentQuestion() {
        return currentQuestion;
    }
}
