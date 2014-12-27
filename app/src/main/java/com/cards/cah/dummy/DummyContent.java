package com.cards.cah.dummy;

import com.cards.cah.models.AnswerCard;
import com.cards.cah.models.QuestionCard;
import com.cards.cah.models.Hand;

import java.util.UUID;

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 * <p/>
 * TODO: Replace all uses of this class before publishing your app.
 */
public class DummyContent {

    public static Hand DummyHand = new Hand();
    public static QuestionCard DummyQuestionCard;

    static {
        DummyHand.addCard(new AnswerCard(UUID.randomUUID(), "Not giving a shit about the Third World."));
        DummyHand.addCard(new AnswerCard(UUID.randomUUID(), "Sexting."));
        DummyHand.addCard(new AnswerCard(UUID.randomUUID(), "Authentic Mexican cuisine."));
        DummyHand.addCard(new AnswerCard(UUID.randomUUID(), "Dropping a chandelier on your enemies and riding the rope up."));
        DummyHand.addCard(new AnswerCard(UUID.randomUUID(), "Eating all of the cookies before the AIDS bake-sale."));
        DummyHand.addCard(new AnswerCard(UUID.randomUUID(), "Michelle Obama's arms."));
        DummyHand.addCard(new AnswerCard(UUID.randomUUID(), "A middle-aged man on roller skates."));
        DummyHand.addCard(new AnswerCard(UUID.randomUUID(), "An erection that lasts longer than four hours."));
        DummyHand.addCard(new AnswerCard(UUID.randomUUID(), "Waterboarding."));
        DummyHand.addCard(new AnswerCard(UUID.randomUUID(), "Home video of Oprah sobbing into a Lean Cuisine."));

        DummyQuestionCard = new QuestionCard(UUID.randomUUID(), "Anthropologists have recently discovered a primitive tribe that worships __________.", (short)1);
    }
}
