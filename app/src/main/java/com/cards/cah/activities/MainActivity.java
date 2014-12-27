package com.cards.cah.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.cards.cah.CardsApplication;
import com.cards.cah.R;
import com.cards.cah.models.Game;


public class MainActivity extends BaseActivity {

    private Game game;

    @Override
    protected int getDrawerLayoutViewId() {
        return R.id.main_layout;
    }

    @Override
    public int getMenuItemArrayId() {
        return R.array.nav_items;
    }

    @Override
    protected int getActivityLayoutId() {
        return R.layout.activity_main;
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        CardsApplication app = (CardsApplication)getApplicationContext();
        game = app.getCurrentGame();
        if (game == null) {
            game = new Game();
            app.setGame(game);
        }
    }

    public void onGoToGameClick(View view) {
        Intent intent = new Intent(this, GameHomeActivity.class);
        startActivity(intent);
    }
}
