package com.cards.qa.activities;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.BackgroundColorSpan;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.TextView;

import com.cards.qa.R;
import com.cards.qa.fragments.AnswerCardListFragment;
import com.cards.qa.models.Game;
import com.cards.qa.models.AnswerCard;
import com.cards.qa.models.QuestionCard;
import com.cards.qa.text.style.ClickableAnswerSpan;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


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
        ArrayList<AnswerCard> selectedAnswers = game.getSelectedAnswerCards();

        TextView questionTextView = (TextView) findViewById(R.id.question_card_text);

        String questionText = questionCard.getCardText();

        // See if we can fill in blanks in the question from selected answers.
        if (questionCard.getIsFillInTheBlank() && selectedAnswers.size() > 0) {

            SpannableStringBuilder stringBuilder = new SpannableStringBuilder();
            stringBuilder.append(questionText);

            // Regex match blanks in question
            Pattern pattern = Pattern.compile("_+");
            Matcher matcher = pattern.matcher(questionText);
            int blanksFilled = 0;

            // Replace blanks for as many currently selected answers
            while (matcher.find() && blanksFilled < selectedAnswers.size()) {
                MatchResult result = matcher.toMatchResult();

                AnswerCard answerCard = selectedAnswers.get(blanksFilled);
                String answerText = answerCard.getCardText();

                // Trim trailing period from answer, we'll use the question's punctuation.
                if (answerText.lastIndexOf(".") == answerText.length() - 1) {
                    answerText = answerText.substring(0, answerText.length() - 1);
                }

                // Replace blank with answer.
                stringBuilder.replace(result.start(), result.end(), answerText);

                // Apply contrasting text color and background for answer text.
                int spanEnd = result.start() + answerText.length();
                stringBuilder.setSpan(new BackgroundColorSpan(Color.WHITE), result.start(), spanEnd, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                stringBuilder.setSpan(new ForegroundColorSpan(Color.BLACK), result.start(), spanEnd, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

                // Keep track of blanks filled
                blanksFilled++;

                // Create a new matcher with the modified string to look for more blanks.
                matcher = pattern.matcher(stringBuilder.toString());
            }

            questionTextView.setText(stringBuilder);
        } else {
            questionTextView.setText(questionText);
        }

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
