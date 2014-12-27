package com.cards.qa.adapters;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.cards.qa.R;

import java.util.List;

public class RecyclerListAdapter<TDataItem> extends RecyclerView.Adapter<RecyclerListAdapter.CardViewHolder<TDataItem>> {
    private List<TDataItem> dataSet;
    private View.OnClickListener clickListener;

    public RecyclerListAdapter(List<TDataItem> dataSet) {
        this.dataSet = dataSet;
    }

    public RecyclerListAdapter(List<TDataItem> dataSet, View.OnClickListener clickListener) {
        this(dataSet);
        this.clickListener = clickListener;
    }

    @Override
    public CardViewHolder<TDataItem> onCreateViewHolder(ViewGroup parent,
                                             int viewType) {
        // Get Card
        CardView cardView = (CardView) LayoutInflater.from(parent.getContext())
                                .inflate(R.layout.answer_card, parent, false);

        // Hook up card selection handler
        cardView.setOnClickListener(clickListener);

        return new CardViewHolder<>(cardView);
    }

    @Override
    public void onBindViewHolder(CardViewHolder<TDataItem> holder, int position) {
        View view = holder.cardView;
        TextView cardText = (TextView)view.findViewById(R.id.card_text);

        TDataItem dataItem = dataSet.get(position);
        holder.setCard(dataItem);
        cardText.setText(dataItem.toString());
    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }

    public static class CardViewHolder<TCard> extends RecyclerView.ViewHolder {
        public CardView cardView;
        private TCard card;

        public CardViewHolder(CardView v) {
            super(v);
            cardView = v;
        }

        public void setCard(TCard card) {
            this.card = card;
        }

        public TCard getCard() {
            return card;
        }
    }
}
