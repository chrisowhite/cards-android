package com.cards.cah.dummy;

import com.cards.cah.models.Hand;
import com.cards.cah.models.WhiteCard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 * <p/>
 * TODO: Replace all uses of this class before publishing your app.
 */
public class DummyContent {

    /**
     * An array of sample (dummy) items.
     */
    public static List<DummyItem> ITEMS = new ArrayList<DummyItem>();

    public static Hand DummyHand = new Hand();

    /**
     * A map of sample (dummy) items, by ID.
     */
    public static Map<String, DummyItem> ITEM_MAP = new HashMap<String, DummyItem>();

    static {
        // Add 3 sample items.
        addItem(new DummyItem("1", "Card 1"));
        addItem(new DummyItem("2", "Card 2"));
        addItem(new DummyItem("3", "Card 3"));

        DummyHand.addCard(new WhiteCard(UUID.randomUUID(), "Not giving a shit about the Third World."));
        DummyHand.addCard(new WhiteCard(UUID.randomUUID(), "Sexting."));
        DummyHand.addCard(new WhiteCard(UUID.randomUUID(), "Authentic Mexican cuisine."));
        DummyHand.addCard(new WhiteCard(UUID.randomUUID(), "Dropping a chandelier on your enemies and riding the rope up."));
        DummyHand.addCard(new WhiteCard(UUID.randomUUID(), "Eating all of the cookies before the AIDS bake-sale."));
        DummyHand.addCard(new WhiteCard(UUID.randomUUID(), "Michelle Obama's arms."));
        DummyHand.addCard(new WhiteCard(UUID.randomUUID(), "A middle-aged man on roller skates."));
        DummyHand.addCard(new WhiteCard(UUID.randomUUID(), "An erection that lasts longer than four hours."));
        DummyHand.addCard(new WhiteCard(UUID.randomUUID(), "Waterboarding."));
        DummyHand.addCard(new WhiteCard(UUID.randomUUID(), "Home video of Oprah sobbing into a Lean Cuisine."));
    }

    private static void addItem(DummyItem item) {
        ITEMS.add(item);
        ITEM_MAP.put(item.id, item);
    }

    /**
     * A dummy item representing a piece of content.
     */
    public static class DummyItem {
        public String id;
        public String content;

        public DummyItem(String id, String content) {
            this.id = id;
            this.content = content;
        }

        @Override
        public String toString() {
            return content;
        }
    }
}
