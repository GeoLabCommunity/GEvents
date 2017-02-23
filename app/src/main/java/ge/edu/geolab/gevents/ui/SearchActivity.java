package ge.edu.geolab.gevents.ui;

import android.os.Bundle;
import android.support.v7.widget.AppCompatEditText;
import android.view.View;

import butterknife.BindView;
import butterknife.ButterKnife;
import ge.edu.geolab.gevents.R;
import ge.edu.geolab.gevents.helper.AppFont;
import ge.edu.geolab.gevents.helper.font.TypefaceHelper;
import ge.edu.geolab.gevents.ui.base.SlidingActivity;

public class SearchActivity extends SlidingActivity {

    @BindView(R.id.search_input)
    AppCompatEditText mSearchInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        ButterKnife.bind(this);

        findViewById(R.id.back_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        overrideTypefaces();
    }

    private void overrideTypefaces() {
        TypefaceHelper.override(mSearchInput, AppFont.BPG_NINO_MTAVRULI_NORMAL);
    }
}
