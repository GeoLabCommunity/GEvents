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
            "იან",
            "თებ",
            "მარ",
            "აპრ",
            "მაი",
            "ივნ",
            "ივლ",
            "აგვ",
            "სექ",
            "ოქტ",
            "ნოე",
            "დეკ"
    };

    private static Calendar sCalendar;

    static {
        sCalendar = Calendar.getInstance();
    }

    private TextView mDayView, mMonthView;

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

    }

    private String getMonth(int month) {
        return MONTH_NAMES_GEO[month];
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

//    @Override
//    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
//        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
//        int width = getMeasuredWidth();
//        int height = getMeasuredHeight();
//        if (width != height) {
//            int dimension = Math.max(width, height);
//            setMeasuredDimension(dimension, dimension);
//        }
//    }
}
