package com.cards.cah.models;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.UUID;

/**
 * Created by Chris on 12/24/2014.
 */
public class WhiteCard implements Parcelable {
    private UUID id;
    private String cardText;

    public WhiteCard(UUID id, String cardText) {
        this.id = id;
        this.cardText = cardText;
    }

    public WhiteCard(Parcel in) {
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
        public WhiteCard createFromParcel(Parcel in) {
            return new WhiteCard(in);
        }

        public WhiteCard[] newArray(int size) {
            return new WhiteCard[size];
        }
    };
}
