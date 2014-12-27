package com.cards.cah.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.cards.cah.R;
import com.cards.cah.models.Game;


public class GameHomeActivity extends BaseGameActivity {

    @Override
    protected int getDrawerLayoutViewId() {
        return R.id.game_home_layout;
    }

    @Override
    public int getMenuItemArrayId() {
        return R.array.nav_items;
    }

    @Override
    protected int getActivityLayoutId() {
        return R.layout.activity_game_home;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Game game = getGame();
        TextView questionText = (TextView)findViewById(R.id.question_card_text);
        questionText.setText(game.getCurrentQuestion().getCardText());
    }

    public void onSelectAnswerClick(View view) {
        Intent intent = new Intent(this, CardSelectActivity.class);
        startActivity(intent);
    }
}
