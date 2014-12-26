package com.cards.cah;

import android.app.Activity;
import android.os.Bundle;
import android.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link NavDrawerFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link NavDrawerFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class NavDrawerFragment extends Fragment {
    private OnFragmentInteractionListener listener;

    private String[] menuItems;
    private ListView drawerList;

    public static NavDrawerFragment newInstance() {
        NavDrawerFragment fragment = new NavDrawerFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    public NavDrawerFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_nav_drawer, container, false);

        BaseDrawerActivity activity = (BaseDrawerActivity)getActivity();
        menuItems = getResources().getStringArray(activity.getMenuItemArrayId());
        drawerList = (ListView)view.findViewById((R.id.left_drawer));

        drawerList.setAdapter(new ArrayAdapter<>(getActivity(), R.layout.drawer_list_item, menuItems));
        drawerList.setOnItemClickListener(new DrawerItemClickListener());

        return view;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            //mListener = (OnFragmentInteractionListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        listener = null;
    }

    private class DrawerItemClickListener implements ListView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView parent, View view, int position, long id) {
            //selectItem(position);
        }
    }

    public interface OnFragmentInteractionListener {
    }

}
