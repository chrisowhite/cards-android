package com.cards.cah;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.cards.cah.models.Game;


public class GameHomeActivity extends BaseDrawerActivity {

    @Override
    protected int getDrawerLayoutViewId() {
        return R.id.game_home_layout;
    }

    @Override
    protected int getMenuItemArrayId() {
        return R.array.nav_items;
    }

    @Override
    protected int getActivityLayoutId() {
        return R.layout.activity_game_home;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        CardsApplication app = (CardsApplication)getApplicationContext();
        Game game = app.getCurrentGame();

        TextView questionText = (TextView)findViewById(R.id.question_card_text);
        questionText.setText(game.getCurrentQuestion().getCardText());
    }

    public void onSelectAnswerClick(View view) {
        Intent intent = new Intent(this, CardSelectActivity.class);
        startActivity(intent);
    }
}
