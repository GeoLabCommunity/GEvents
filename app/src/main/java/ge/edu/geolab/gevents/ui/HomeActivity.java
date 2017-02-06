package ge.edu.geolab.gevents.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

import java.util.List;

import ge.edu.geolab.gevents.R;
import ge.edu.geolab.gevents.helper.AppFont;
import ge.edu.geolab.gevents.helper.font.TypefaceHelper;
import ge.edu.geolab.gevents.model.EventCategory;
import ge.edu.geolab.gevents.model.EventModel;
import ge.edu.geolab.gevents.presenter.MainPresenter;
import ge.edu.geolab.gevents.presenter.impl.MainPresenterImpl;
import ge.edu.geolab.gevents.ui.fragment.DrawerActionListener;
import ge.edu.geolab.gevents.view.MainView;

public class HomeActivity extends AppCompatActivity implements DrawerActionListener, MainView {

    private DrawerLayout mLeftDrawer;
    private MainPresenter mMainPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Intent intent = new Intent(this, DetailsPageActivity.class);
        startActivity(intent);

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

        initTypefaces();
        setTitle(R.string.app_name);

        mMainPresenter = new MainPresenterImpl(this);
        mMainPresenter.onCreate();
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

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    private void closeDrawer() {
        mLeftDrawer.closeDrawer(GravityCompat.START);
    }

    @Override
    public void onDrawerItemSelected(int id) {
        closeDrawer();
        setSubtitle(EventCategory.getNameFromId(id));

        // mMainPresenter.loadFeedEvents();
    }

    @Override
    public void onDrawerClose() {
        closeDrawer();
    }

    @Override
    public void showLoader() {

    }

    @Override
    public void hideLoader() {

    }

    @Override
    public void setFeedItems(List<EventModel> items) {

    }

    @Override
    public void setError(String message) {

    }

    @Override
    public Context getViewContext() {
        return this;
    }
}
