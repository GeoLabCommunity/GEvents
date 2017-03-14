package ge.edu.geolab.gevents.ui;

import android.os.Bundle;
import android.support.v7.content.res.AppCompatResources;
import android.support.v7.widget.AppCompatEditText;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import ge.edu.geolab.gevents.R;
import ge.edu.geolab.gevents.adapter.EndlessRecyclerViewScrollListener;
import ge.edu.geolab.gevents.adapter.EventsFeedAdapter;
import ge.edu.geolab.gevents.adapter.SearchAdapter;
import ge.edu.geolab.gevents.helper.AppFont;
import ge.edu.geolab.gevents.helper.font.TypefaceHelper;
import ge.edu.geolab.gevents.model.EventModel;
import ge.edu.geolab.gevents.presenter.SearchPresenter;
import ge.edu.geolab.gevents.presenter.impl.SearchPresenterImpl;
import ge.edu.geolab.gevents.ui.base.BaseActivity;
import ge.edu.geolab.gevents.ui.widgets.DividerItemDecoration;
import ge.edu.geolab.gevents.ui.widgets.LoaderView;
import ge.edu.geolab.gevents.view.SearchView;

public class SearchActivity extends BaseActivity implements SearchView {

    @BindView(R.id.search_input)
    AppCompatEditText mSearchInput;
    @BindView(R.id.clear_text_btn)
    View mClearTextBtn;
    @BindView(R.id.back_btn)
    View mBackBtn;
    @BindView(R.id.loader)
    LoaderView mLoaderView;

    private RecyclerView mRecyclerView;
    private SearchPresenter mSearchPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        ButterKnife.bind(this);

        mBackBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        mClearTextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mSearchInput.setText("");
            }
        });
        mSearchInput.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                mClearTextBtn.setVisibility(TextUtils.isEmpty(charSequence) ? View.INVISIBLE : View.VISIBLE);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        mSearchInput.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int actionId, KeyEvent keyEvent) {
                if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                    hideKeypad();
                    performSearch();
                    return true;
                }
                return false;
            }
        });

        mRecyclerView = (RecyclerView) findViewById(R.id.events_feed_recycler);
        final LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.addItemDecoration(
                new DividerItemDecoration(AppCompatResources.getDrawable(this, R.drawable.line_divider), true, true));
        mRecyclerView.setAdapter(new SearchAdapter(this));
        mRecyclerView.addOnScrollListener(new EndlessRecyclerViewScrollListener(layoutManager) {

            @Override
            public void onLoadMore(int page, int totalItemsCount) {
                mSearchPresenter.performSearch(getSearchInput(), ++page);
            }
        });

        mSearchPresenter = new SearchPresenterImpl(this);
        overrideTypefaces();
    }

    private String getSearchInput(){
        return mSearchInput.getText().toString();
    }

    private void overrideTypefaces() {
        TypefaceHelper.override(mSearchInput, AppFont.ARIAL);
    }

    private void performSearch() {
        getAdapter().clear();
        mSearchPresenter.performSearch(getSearchInput(), 1);
    }

    private SearchAdapter getAdapter() {
        return (SearchAdapter) mRecyclerView.getAdapter();
    }

    @Override
    public void setResult(List<EventModel> result) {
        getAdapter().addItems(result);
    }

    @Override
    public void showLoader() {
        mLoaderView.show();
    }

    @Override
    public void hideLoader() {
        mLoaderView.hide();
    }

    @Override
    public void setError(String message) {

    }
}
