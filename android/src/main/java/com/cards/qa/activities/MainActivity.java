package com.cards.qa.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.cards.qa.CardsApplication;
import com.cards.qa.R;
import com.cards.qa.models.Game;


public class MainActivity extends BaseActivity {

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
        Game game = app.getCurrentGame();
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
