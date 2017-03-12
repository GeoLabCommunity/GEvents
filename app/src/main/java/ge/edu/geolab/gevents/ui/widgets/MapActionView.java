package ge.edu.geolab.gevents.ui.widgets;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.widget.RelativeLayout;

import ge.edu.geolab.gevents.R;

/**
 * Created by Vazha on 08.03.2017.
 */

public class MapActionView extends RelativeLayout implements View.OnClickListener {

    public interface OnMapActionListener {
        void onNavigateOnMap();

        void onShowOnMap();
    }

    private OnMapActionListener mMapActionCallback;
    private View mContentView;

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
        mContentView = inflate(context, R.layout.map_toolbar, null);
        mContentView.findViewById(R.id.show_on_map_btn).setOnClickListener(this);
        mContentView.findViewById(R.id.navigate_on_map_btn).setOnClickListener(this);
        mContentView.setVisibility(INVISIBLE);

        addView(mContentView,
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT
        );

        setOnClickListener(this);
    }

    public void setMapActionListener(OnMapActionListener listener) {
        mMapActionCallback = listener;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.navigate_on_map_btn:
                if (mMapActionCallback != null) {
                    mMapActionCallback.onNavigateOnMap();
                }
                break;
            case R.id.show_on_map_btn:
                if (mMapActionCallback != null) {
                    mMapActionCallback.onShowOnMap();
                }
                break;
            default:
                toggleVisibility();
        }
    }

    private void toggleVisibility() {
        final ViewPropertyAnimator animator = mContentView.animate().setDuration(200);
        if (mContentView.getVisibility() == INVISIBLE) {
            animator.alpha(1).setListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationStart(Animator animation) {
                    mContentView.setVisibility(VISIBLE);
                }
            });
        } else {
            animator.alpha(0).setListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    mContentView.setVisibility(INVISIBLE);
                }
            });
        }
        animator.start();
    }
}
