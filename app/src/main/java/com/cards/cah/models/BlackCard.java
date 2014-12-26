package com.cards.cah.models;

import java.util.UUID;

/**
 * Created by Chris on 12/24/2014.
 */
public class BlackCard {
    private UUID id;
    private String cardText;

    public BlackCard(UUID id, String cardText) {
        this.id = id;
        this.cardText = cardText;
    }

    public String getCardText() {
        return cardText;
    }

    public UUID getId() {
        return id;
    }
}
