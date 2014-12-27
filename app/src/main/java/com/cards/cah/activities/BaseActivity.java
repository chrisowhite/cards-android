package com.cards.cah.activities;

import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.cards.cah.R;

public abstract class BaseActivity extends ActionBarActivity {

    private DrawerLayout.DrawerListener drawerListener;
    private DrawerLayout drawerLayout;
    private Toolbar toolbar;

    protected abstract int getDrawerLayoutViewId();
    public abstract int getMenuItemArrayId();
    protected abstract int getActivityLayoutId();

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(getActivityLayoutId());
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        setupNavDrawer();
    }

    @Override
    public void setContentView(int layoutId) {
        super.setContentView(layoutId);
        getActionBarToolbar();
    }

    private void setupNavDrawer() {
        drawerLayout = (DrawerLayout)findViewById(getDrawerLayoutViewId());
        drawerListener = new DrawerLayout.DrawerListener() {
            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {
            }

            public void onDrawerOpened(View view) {
            }

            public void onDrawerClosed(View drawerView) {
            }

            @Override
            public void onDrawerStateChanged(int newState) {
            }
        };

        if (toolbar != null) {
            toolbar.setNavigationIcon(R.drawable.ic_drawer);
            toolbar.setNavigationOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    drawerLayout.openDrawer(Gravity.START);
                }
            });
            toolbar.setTitle(getTitle());
        }

        drawerLayout.setDrawerListener(drawerListener);
        drawerLayout.setDrawerShadow(R.drawable.drawer_shadow, Gravity.START);

        populateNavDrawer();
    }

    private void populateNavDrawer() {
        createNavDrawerItems();
    }

    private void createNavDrawerItems() {
        ViewGroup navDrawerItemsContainer = (ViewGroup) findViewById(R.id.navdrawer_items_list);
        if (navDrawerItemsContainer == null) {
            return;
        }

        String[] navItems = getResources().getStringArray(R.array.nav_items);

        navDrawerItemsContainer.removeAllViews();
        for (String itemText : navItems) {
            View navDrawerItemView = makeNavDrawerItem(itemText, navDrawerItemsContainer);
            navDrawerItemsContainer.addView(navDrawerItemView);
        }
    }

    private View makeNavDrawerItem(final String itemText, ViewGroup container) {
        TextView view = (TextView)getLayoutInflater().inflate(R.layout.drawer_list_item, container, false);

        view.setText(itemText);

        return view;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

    protected Toolbar getActionBarToolbar() {
        if (toolbar == null) {
            toolbar = (Toolbar) findViewById(R.id.nav_toolbar);
            if (toolbar != null) {
                setSupportActionBar(toolbar);
            }
        }
        return toolbar;
    }
}
