package com.cards.qa.fragments;

import android.app.Activity;
import android.os.Bundle;
import android.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.cards.qa.R;
import com.cards.qa.adapters.RecyclerListAdapter;
import com.cards.qa.models.AnswerCard;

import java.util.ArrayList;
import java.util.List;

/**
 * A fragment representing a list of Items.
 * <p/>
 * Large screen devices (such as tablets) are supported by replacing the ListView
 * with a GridView.
 * <p/>
 * Activities containing this fragment MUST implement the {@link OnFragmentInteractionListener}
 * interface.
 */
public class AnswerCardListFragment extends Fragment {

    public static final String ARG_CARDS = "ARG_CARDS";
    public static final String ARG_MULTI_SELECT = "ARG_MULTI_SELECT";
    public static final String ARG_ALLOW_CLICK = "ARG_ALLOW_CLICK";

    private OnFragmentInteractionListener fragmentListener;

    /**
     * The fragment's ListView/GridView.
     */
    private RecyclerView recyclerView;
    private RecyclerListAdapter recyclerAdapter;
    private LinearLayoutManager layoutManager;
    private boolean allowClick;
    private boolean multiSelect;

    /**
     * The Adapter which will be used to populate the ListView/GridView with
     * Views.
     */
    private List<AnswerCard> cards;

    public static AnswerCardListFragment newInstance(List<AnswerCard> cards, boolean allowClick, boolean multiSelect) {
        AnswerCardListFragment fragment = new AnswerCardListFragment();
        Bundle args = new Bundle();
        args.putParcelableArrayList(ARG_CARDS, new ArrayList<>(cards));
        args.putBoolean(ARG_ALLOW_CLICK, allowClick);
        args.putBoolean(ARG_MULTI_SELECT, allowClick && multiSelect);
        fragment.setArguments(args);
        return fragment;
    }

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public AnswerCardListFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle args = getArguments();
        if (args != null) {
            cards = args.getParcelableArrayList(ARG_CARDS);
            allowClick = args.getBoolean(ARG_ALLOW_CLICK);
            multiSelect = args.getBoolean(ARG_MULTI_SELECT);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_whitecardlist, container, false);

        CardClickListener cardClickListener = new CardClickListener();
        recyclerAdapter = allowClick
                ? new RecyclerListAdapter<>(cards, cardClickListener)
                : new RecyclerListAdapter<>(cards);

        layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView = (RecyclerView) view.findViewById(R.id.white_card_list);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(layoutManager);

        recyclerView.setAdapter(recyclerAdapter);

        return view;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            fragmentListener = (OnFragmentInteractionListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        fragmentListener = null;
    }

    public interface OnFragmentInteractionListener {
        void onCardSelect(AnswerCard card);
    }

    public class CardClickListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            RecyclerListAdapter.CardViewHolder<AnswerCard> viewHolder =
                    (RecyclerListAdapter.CardViewHolder<AnswerCard>) recyclerView.getChildViewHolder(v);

            AnswerCard card = viewHolder.getCard();
            fragmentListener.onCardSelect(card);
        }
    }
}
