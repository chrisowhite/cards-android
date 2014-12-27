package com.cards.cah.models;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.UUID;

public class AnswerCard implements Parcelable {
    private UUID id;
    private String cardText;

    public AnswerCard(UUID id, String cardText) {
        this.id = id;
        this.cardText = cardText;
    }

    public AnswerCard(Parcel in) {
        String[] data = new String[2];

        in.readStringArray(data);
        this.id = UUID.fromString(data[0]);
        this.cardText = data[1];
    }

    public String getCardText() {
        return cardText;
    }

    public UUID getId() {
        return id;
    }

    public String toString() {
        return getCardText();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeStringArray(new String[] {
                this.id.toString(),
                this.cardText
        });
    }

    public static final Creator CREATOR = new Creator() {
        public AnswerCard createFromParcel(Parcel in) {
            return new AnswerCard(in);
        }

        public AnswerCard[] newArray(int size) {
            return new AnswerCard[size];
        }
    };
}
