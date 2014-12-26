package com.cards.cah;

import android.app.Activity;
import android.os.Bundle;
import android.app.Fragment;
import android.os.Parcelable;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;


import com.cards.cah.dummy.DummyContent;
import com.cards.cah.models.Hand;
import com.cards.cah.models.WhiteCard;

import java.util.ArrayList;
import java.util.Arrays;
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
public class WhiteCardListFragment extends Fragment {

    public static final String ARG_CARDS = "ARG_CARDS";

    private OnFragmentInteractionListener fragmentListener;

    /**
     * The fragment's ListView/GridView.
     */
    private RecyclerView recyclerView;
    private RecyclerListAdapter recyclerAdapter;
    private LinearLayoutManager layoutManager;

    /**
     * The Adapter which will be used to populate the ListView/GridView with
     * Views.
     */
    private List<WhiteCard> cards;

    public static WhiteCardListFragment newInstance(List<WhiteCard> cards) {
        WhiteCardListFragment fragment = new WhiteCardListFragment();
        Bundle args = new Bundle();
        args.putParcelableArrayList(ARG_CARDS, new ArrayList<>(cards));
        fragment.setArguments(args);
        return fragment;
    }

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public WhiteCardListFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            cards = getArguments().getParcelableArrayList(ARG_CARDS);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_whitecardlist, container, false);

        CardClickListener cardClickListener = new CardClickListener();
        recyclerAdapter = new RecyclerListAdapter<>(cards, cardClickListener);

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

    /**
     * The default content for this Fragment has a TextView that is shown when
     * the list is empty. If you would like to change the text, call this method
     * to supply the text it should use.
     */
//    public void setEmptyText(CharSequence emptyText) {
//        View emptyView = recyclerView.getEmptyView();
//
//        if (emptyView instanceof TextView) {
//            ((TextView) emptyView).setText(emptyText);
//        }
//    }

    public interface OnFragmentInteractionListener {
        void onCardSelect(ArrayList<WhiteCard> card);
    }

    public class CardClickListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            RecyclerListAdapter.CardViewHolder<WhiteCard> viewHolder =
                    (RecyclerListAdapter.CardViewHolder<WhiteCard>) recyclerView.getChildViewHolder(v);

            WhiteCard card = viewHolder.getCard();
            fragmentListener.onCardSelect(new ArrayList<>(Arrays.asList(card)));
        }
    }
}
