package com.cards.qa.activities;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.cards.qa.R;
import com.cards.qa.fragments.AnswerCardListFragment;
import com.cards.qa.models.QuestionCard;
import com.cards.qa.models.Game;
import com.cards.qa.models.AnswerCard;


public class CardSelectActivity extends BaseGameActivity implements AnswerCardListFragment.OnFragmentInteractionListener {

    public static final String ARG_ANSWER_INDEX = "ARG_ANSWER_INDEX";

    private AnswerCardListFragment answerCardListFragment;
    private short answerIndex = -1;

    @Override
    protected int getDrawerLayoutViewId() {
        return R.id.card_select_layout;
    }

    @Override
    public int getMenuItemArrayId() {
        return R.array.nav_items;
    }

    @Override
    protected int getActivityLayoutId() {
        return R.layout.activity_card_select;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = getIntent();
        if (intent.hasExtra(ARG_ANSWER_INDEX))
            answerIndex = intent.getShortExtra(ARG_ANSWER_INDEX, (short)-1);

        Game game = getGame();
        QuestionCard questionCard = game.getCurrentQuestion();
        TextView questionCardText = (TextView)findViewById(R.id.question_card_text);
        questionCardText.setText(questionCard.getCardText());

        FragmentManager fragmentManager = getFragmentManager();
        answerCardListFragment = AnswerCardListFragment.newInstance(game.getCurrentHand().getCards(), true, questionCard.getAnswerCount() > 1);
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.content_frame, answerCardListFragment);
        fragmentTransaction.commit();
    }

    @Override
    public void onCardSelect(AnswerCard card) {
        if (answerIndex >= 0)
            getGame().setSelectedAnswer(answerIndex, card);
        else
            getGame().addSelectedAnswer(card);

        Intent intent = new Intent(this, SelectedAnswerActivity.class);
        finish();
        startActivity(intent);
    }
}
