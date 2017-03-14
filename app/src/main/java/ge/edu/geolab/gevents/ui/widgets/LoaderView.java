package ge.edu.geolab.gevents.ui.widgets;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.FrameLayout;

import ge.edu.geolab.gevents.R;

/**
 * Created by akaki on 22.02.17.
 */

public class LoaderView extends FrameLayout {
    public LoaderView(Context context) {
        super(context);
        init();
    }

    public LoaderView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public LoaderView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public LoaderView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    private void init() {
        inflate(getContext(), R.layout.loader_view, this);
    }

    public void show() {
        setVisibility(VISIBLE);
    }

    public void hide() {
        setVisibility(INVISIBLE);
    }
}
