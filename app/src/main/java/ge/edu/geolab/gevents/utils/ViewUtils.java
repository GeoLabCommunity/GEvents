package ge.edu.geolab.gevents.utils;

import android.annotation.TargetApi;
import android.os.Build;
import android.view.View;
import android.view.animation.AlphaAnimation;

/**
 * Created by akaki on 23.02.17.
 */

public class ViewUtils {

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static void setOpacity(View view, float alpha) {
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.HONEYCOMB) {
            view.setAlpha(alpha);
        } else {
            AlphaAnimation alphaAnim = new AlphaAnimation(alpha, alpha);
            alphaAnim.setDuration(0);
            alphaAnim.setFillAfter(true);
            view.startAnimation(alphaAnim);
        }
    }
}
