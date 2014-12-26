package com.cards.cah;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.cards.cah.models.Game;
import com.cards.cah.models.WhiteCard;

import java.util.ArrayList;


public class MainActivity extends BaseDrawerActivity{

    private Game game;

    @Override
    protected int getDrawerLayoutViewId() {
        return R.id.main_layout;
    }

    @Override
    protected int getMenuItemArrayId() {
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
