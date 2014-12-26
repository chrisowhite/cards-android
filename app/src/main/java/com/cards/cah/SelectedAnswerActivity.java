package com.cards.cah;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.cards.cah.models.Game;
import com.cards.cah.models.WhiteCard;

import java.util.ArrayList;


public class SelectedAnswerActivity extends BaseDrawerActivity implements WhiteCardListFragment.OnFragmentInteractionListener {

    private WhiteCardListFragment whiteCardListFragment;

    @Override
    public int getDrawerLayoutViewId() {
        return R.id.selected_answer_layout;
    }

    @Override
    protected int getMenuItemArrayId() {
        return R.array.nav_items;
    }

    @Override
    protected int getActivityLayoutId() {
        return R.layout.activity_selected_answer;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = getIntent();
        ArrayList<WhiteCard> selectedAnswers = intent.getParcelableArrayListExtra(WhiteCardListFragment.ARG_CARDS);

        CardsApplication app = (CardsApplication)getApplicationContext();
        Game game = app.getCurrentGame();

        TextView questionText = (TextView)findViewById(R.id.question_card_text);
        questionText.setText(game.getCurrentQuestion().getCardText());

        FragmentManager fragmentManager = getFragmentManager();
        whiteCardListFragment = WhiteCardListFragment.newInstance(selectedAnswers);
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.selected_white_cards, whiteCardListFragment);
        fragmentTransaction.commit();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_selected_answer, menu);
        return true;
    }

    @Override
    public void onCardSelect(ArrayList<WhiteCard> cards) {

    }

    public void onShowWhiteCardListClick(View view) {
        Intent intent = new Intent(this, CardSelectActivity.class);
        startActivity(intent);
    }
}
