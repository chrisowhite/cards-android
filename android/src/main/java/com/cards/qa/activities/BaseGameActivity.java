package com.cards.qa.activities;

import android.os.Bundle;

import com.cards.qa.CardsApplication;
import com.cards.qa.models.Game;

public abstract class BaseGameActivity extends BaseActivity {
    private CardsApplication app;
    private Game game;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setGameState();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }

    private void setGameState() {
        app = (CardsApplication)getApplicationContext();
        game = app.getCurrentGame();
    }

    protected Game getGame() {
        return game;
    }

    protected CardsApplication getCardApplication() {
        return app;
    }
}
