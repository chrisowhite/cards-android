package com.cards.cah;

import android.app.Application;

import com.cards.cah.models.Game;

/**
 * Created by Chris on 12/25/2014.
 */
public class CardsApplication extends Application {
    private Game game;
    public Game getCurrentGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }
}
