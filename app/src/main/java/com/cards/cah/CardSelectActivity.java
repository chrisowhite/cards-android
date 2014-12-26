package com.cards.cah;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.cards.cah.models.Game;
import com.cards.cah.models.WhiteCard;

import java.util.ArrayList;


public class CardSelectActivity extends BaseDrawerActivity implements WhiteCardListFragment.OnFragmentInteractionListener {

    private WhiteCardListFragment whiteCardListFragment;

    @Override
    protected int getDrawerLayoutViewId() {
        return R.id.card_select_layout;
    }

    @Override
    protected int getMenuItemArrayId() {
        return R.array.nav_items;
    }

    @Override
    protected int getActivityLayoutId() {
        return R.layout.activity_card_select;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        CardsApplication app = (CardsApplication)getApplicationContext();
        Game game = app.getCurrentGame();

        TextView questionCardText = (TextView)findViewById(R.id.question_card_text);
        questionCardText.setText(game.getCurrentQuestion().getCardText());

        FragmentManager fragmentManager = getFragmentManager();
        whiteCardListFragment = (WhiteCardListFragment) fragmentManager.findFragmentById(R.id.content_frame);

        if (whiteCardListFragment == null) {
            whiteCardListFragment = WhiteCardListFragment.newInstance(game.getCurrentHand().getCards());
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.content_frame, whiteCardListFragment);
            fragmentTransaction.commit();
        }
    }

    @Override
    public void onCardSelect(ArrayList<WhiteCard> cards) {
        Intent intent = new Intent(this, SelectedAnswerActivity.class);
        intent.putParcelableArrayListExtra(WhiteCardListFragment.ARG_CARDS, cards);
        finish();
        startActivity(intent);
    }
}
