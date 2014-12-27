package com.cards.qa.activities;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.cards.qa.R;
import com.cards.qa.fragments.AnswerCardListFragment;
import com.cards.qa.models.Game;
import com.cards.qa.models.AnswerCard;
import com.cards.qa.models.QuestionCard;

import java.util.ArrayList;
import java.util.List;


public class SelectedAnswerActivity extends BaseGameActivity implements AnswerCardListFragment.OnFragmentInteractionListener {

    private AnswerCardListFragment answerCardListFragment;

    @Override
    public int getDrawerLayoutViewId() {
        return R.id.selected_answer_layout;
    }

    @Override
    public int getMenuItemArrayId() {
        return R.array.nav_items;
    }

    @Override
    protected int getActivityLayoutId() {
        return R.layout.activity_selected_answer;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setupCards();
    }

    @Override
    public void onRestart() {
        super.onRestart();
        setupCards();
    }

    private void setupCards() {
        Game game = getGame();

        QuestionCard questionCard = game.getCurrentQuestion();

        short answerCount = questionCard.getAnswerCount();
        ArrayList<AnswerCard> selectedAnswers = game.getSelectedAnswerCards();

        TextView questionText = (TextView)findViewById(R.id.question_card_text);
        questionText.setText(questionCard.getCardText());

        FragmentManager fragmentManager = getFragmentManager();
        answerCardListFragment = AnswerCardListFragment.newInstance(selectedAnswers, true, false);
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.selected_white_cards, answerCardListFragment);
        fragmentTransaction.commit();
    }

    @Override
    public void onCardSelect(AnswerCard card) {
        Intent intent = new Intent(this, CardSelectActivity.class);
        short answerIndex = getGame().getSelectedAnswerLocation(card);
        intent.putExtra(CardSelectActivity.ARG_ANSWER_INDEX, answerIndex);
        startActivity(intent);
    }
}
