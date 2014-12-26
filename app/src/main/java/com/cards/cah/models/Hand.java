package com.cards.cah.models;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * Created by Chris on 12/24/2014.
 */
public class Hand implements Parcelable {
    private static final String ARG_CARD_LIST = "CARD_LIST";

    private Map<UUID, WhiteCard> cards;

    public Hand() {
        cards = new HashMap<>();
    }

    public Hand(Parcel in) {
        this();
        List<WhiteCard> cardList = new ArrayList<>();
        in.readTypedList(cardList, WhiteCard.CREATOR);

        // Populate card collection
        for(Iterator<WhiteCard> i = cardList.iterator(); i.hasNext();) {
            addCard(i.next());
        }
    }

    public List<WhiteCard> getCards() {
        return new ArrayList(cards.values());
    }

    public void addCard(WhiteCard card) {
        cards.put(card.getId(), card);
    }

    public void removeCard(UUID id) {
        if (cards.containsKey(id)) {
            cards.remove(id);
        }
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        // Write list of WhiteCard to parcel
        dest.writeTypedList(getCards());
    }

    public static final Creator CREATOR = new Creator() {
        public Hand createFromParcel(Parcel in) {
            return new Hand(in);
        }

        public Hand[] newArray(int size) {
            return new Hand[size];
        }
    };
}
