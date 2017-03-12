package ge.edu.geolab.gevents.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

import org.greenrobot.eventbus.Subscribe;

import java.util.List;

import ge.edu.geolab.gevents.R;
import ge.edu.geolab.gevents.adapter.EndlessRecyclerViewScrollListener;
import ge.edu.geolab.gevents.adapter.EventsFeedAdapter;
import ge.edu.geolab.gevents.event.EventBusProvider;
import ge.edu.geolab.gevents.helper.AppFont;
import ge.edu.geolab.gevents.helper.font.TypefaceHelper;
import ge.edu.geolab.gevents.model.EventCategory;
import ge.edu.geolab.gevents.model.EventModel;
import ge.edu.geolab.gevents.presenter.MainPresenter;
import ge.edu.geolab.gevents.presenter.impl.MainPresenterImpl;
import ge.edu.geolab.gevents.ui.base.SlidingActivity;
import ge.edu.geolab.gevents.ui.fragment.DrawerActionListener;
import ge.edu.geolab.gevents.ui.widgets.DividerItemDecoration;
import ge.edu.geolab.gevents.view.MainView;

public class HomeActivity extends SlidingActivity implements DrawerActionListener, MainView {

    private DrawerLayout mLeftDrawer;
    private MainPresenter mMainPresenter;
    private RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setHomeButtonEnabled(false);
            actionBar.setDisplayHomeAsUpEnabled(false);
            actionBar.setDisplayShowHomeEnabled(false);
        }

        mLeftDrawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, mLeftDrawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        mLeftDrawer.addDrawerListener(toggle);
        toggle.setDrawerIndicatorEnabled(false);
        toggle.syncState();

        findViewById(R.id.open_drawer_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mLeftDrawer.openDrawer(Gravity.LEFT);
            }
        });

        findViewById(R.id.search_event_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this, SearchActivity.class);
                startActivity(intent);
            }
        });

        mRecyclerView = (RecyclerView) findViewById(R.id.events_feed_recycler);
        final LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.addItemDecoration(
                new DividerItemDecoration(ContextCompat.getDrawable(this, R.drawable.line_divider), true, true));
        mRecyclerView.setAdapter(new EventsFeedAdapter(this));
        mRecyclerView.addOnScrollListener(new EndlessRecyclerViewScrollListener(layoutManager) {

            @Override
            public void onLoadMore(int page, int totalItemsCount) {
                mMainPresenter.loadFeedEvents(++page);
            }
        });

        initTypefaces();
        setTitle(R.string.app_name);

        mMainPresenter = new MainPresenterImpl(this);
        mMainPresenter.onCreate();

        mMainPresenter.loadFeedEvents(1);
    }

    private void initTypefaces() {
        TypefaceHelper.override(this, findViewById(R.id.title), AppFont.BPG_NINO_MTAVRULI_NORMAL);
        TypefaceHelper.override(this, findViewById(R.id.sub_title), AppFont.BPG_NINO_MTAVRULI_NORMAL);
    }

    @Override
    public void setTitle(int titleId) {
        final String title = getString(titleId);
        setTitle(title);
    }

    @Override
    public void setTitle(CharSequence title) {
        final TextView titleView = (TextView) findViewById(R.id.title);
        titleView.setText(title);
    }

    public void setSubtitle(CharSequence title) {
        final TextView subTitleView = (TextView) findViewById(R.id.sub_title);
        subTitleView.setText(title);
    }

    @Override
    protected void onDestroy() {
        mMainPresenter.onDestroy();
        super.onDestroy();
    }

    @Subscribe
    public void onEventSelected(EventModel event) {
        final Intent intent = new Intent(HomeActivity.this, DetailsPageActivity.class);
        intent.putExtra(EventModel.KEY, event);
        startActivity(intent);
    }

    @Override
    protected void onPause() {
        super.onPause();
        EventBusProvider.getInstance().unregister(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        EventBusProvider.getInstance().register(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            closeDrawer();
        } else {
            super.onBackPressed();
        }
    }

    @Override
    protected void onLeaveThisActivity() {

    }

    private void closeDrawer() {
        mLeftDrawer.closeDrawer(GravityCompat.START);
    }

    @Override
    public void onDrawerItemSelected(int id) {
        closeDrawer();
        setSubtitle(EventCategory.getNameFromId(id));
    }

    private EventsFeedAdapter getAdapter() {
        return (EventsFeedAdapter) mRecyclerView.getAdapter();
    }

    @Override
    public void onDrawerClose() {
        closeDrawer();
    }

    @Override
    public void showLoader() {
        findViewById(R.id.loader).setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoader() {
        findViewById(R.id.loader).setVisibility(View.INVISIBLE);
    }

    @Override
    public void setFeedItems(List<EventModel> items) {
        getAdapter().addItems(items);
    }

    @Override
    public void setError(String message) {

    }

    @Override
    public Context getViewContext() {
        return this;
    }
}
