package ge.edu.geolab.gevents.ui;

import android.os.Bundle;
import android.support.v7.widget.AppCompatEditText;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import ge.edu.geolab.gevents.R;
import ge.edu.geolab.gevents.helper.AppFont;
import ge.edu.geolab.gevents.helper.font.TypefaceHelper;
import ge.edu.geolab.gevents.ui.base.SlidingActivity;

public class SearchActivity extends SlidingActivity {

    @BindView(R.id.search_input)
    AppCompatEditText mSearchInput;

    @BindView(R.id.clear_text_btn)
    View mClearTextBtn;

    @BindView(R.id.back_btn)
    View mBackBtn;

    private interface MyListener extends View.OnClickListener, TextWatcher, TextView.OnEditorActionListener {

    }

    private MyListener mListener = new MyListener() {
        @Override
        public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
            if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                performSearch();
                return true;
            }
            return false;
        }


        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            mClearTextBtn.setVisibility(TextUtils.isEmpty(s) ? View.INVISIBLE : View.VISIBLE);
        }

        @Override
        public void afterTextChanged(Editable s) {

        }

        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.back_btn:
                    finish();
                    break;
                case R.id.clear_text_btn:
                    mSearchInput.setText("");
                    break;
            }
        }
    };

    private void performSearch() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        ButterKnife.bind(this);

        mBackBtn.setOnClickListener(mListener);
        mClearTextBtn.setOnClickListener(mListener);
        mSearchInput.addTextChangedListener(mListener);
        mSearchInput.setOnEditorActionListener(mListener);
        overrideTypefaces();


    }

    private void overrideTypefaces() {
        TypefaceHelper.override(mSearchInput, AppFont.BPG_NINO_MTAVRULI_NORMAL);
    }
}
