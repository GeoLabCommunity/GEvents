package ge.edu.geolab.gevents.ui.widgets;

import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.view.Gravity;
import android.widget.FrameLayout;
import android.widget.TextView;

import java.util.Calendar;
import java.util.Date;

import ge.edu.geolab.gevents.R;

/**
 * Created by akaki on 25.01.17.
 */

public class DateView extends FrameLayout {

    private static final String[] MONTH_NAMES_GEO = new String[]{
            "იანვარი",
            "თებერვალი",
            "მარტი",
            "აპრილი",
            "მაისი",
            "ივნისი",
            "ივლისი",
            "აგვისტო",
            "სექტემბერი",
            "ოქტომბერი",
            "ნოემბერი",
            "დეკემბერი"
    };

    private static Calendar sCalendar;

    static {
        sCalendar = Calendar.getInstance();
    }

    private TextView mDayView, mMonthView;
    private Drawable mDrawable;

    public DateView(Context context) {
        this(context, null);
    }

    public DateView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public DateView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        inflate(context, R.layout.date_view, this);

        mDayView = (TextView) findViewById(R.id.day);
        mMonthView = (TextView) findViewById(R.id.month);

        final Drawable drawable1 = ContextCompat.getDrawable(context, R.drawable.dateview_cirle_bg);
        mDrawable = new ClipDrawable(drawable1, Gravity.BOTTOM, ClipDrawable.VERTICAL);
        final Drawable drawable2 = drawable1.getConstantState().newDrawable();
        drawable2.setColorFilter(Color.WHITE, PorterDuff.Mode.SRC_IN);

        setBackground(new LayerDrawable(new Drawable[]{drawable2, mDrawable}));
    }

    private String getMonth(int month) {
        return MONTH_NAMES_GEO[month].substring(0, 3);
    }

    public void setDate(long time) {
        setDate(new Date(time));
    }

    public void setDate(Date date) {
        sCalendar.setTime(date);

        final int day = sCalendar.get(Calendar.DAY_OF_MONTH);
        final int month = sCalendar.get(Calendar.MONTH);

        mDayView.setText(String.valueOf(day));
        mMonthView.setText(getMonth(month));
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        int width = getMeasuredWidth();
        int height = getMeasuredHeight();
        if (width != height) {
            int dimension = Math.max(width, height);
            setMeasuredDimension(dimension, dimension);
        }

        int level = (int) (10_000 * (0.5 * (mDayView.getTop() + mMonthView.getBottom()) / getBottom()));
        mDrawable.setLevel(level);
    }
}
