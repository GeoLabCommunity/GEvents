package ge.edu.geolab.gevents.ui.widgets;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;

import ge.edu.geolab.gevents.R;

/**
 * Created by Vazha on 08.03.2017.
 */

public class MapActionView extends FrameLayout implements View.OnClickListener {

    private View mContent;

    public MapActionView(Context context) {
        super(context);
        init(context);
    }

    public MapActionView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public MapActionView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
        mContent = inflate(context, R.layout.map_toolbar, this);
        mContent.setVisibility(VISIBLE);
        setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        mContent.setVisibility(mContent.getVisibility() == INVISIBLE ? VISIBLE : INVISIBLE);
    }
}
