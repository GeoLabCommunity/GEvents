package ge.edu.geolab.gevents.helper.font;

import android.content.Context;
import android.graphics.Typeface;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by akaki on 05.02.17.
 */

public class TypefaceHelper {

    public static void override(View view, IFont font) {
        override(view.getContext(), view, font);
    }

    public static void override(Context context, View view, IFont font) {
        if (view instanceof TextView) {
            final TextView textView = (TextView) view;
            final int style = textView.getTypeface() != null ?
                    textView.getTypeface().getStyle() : Typeface.NORMAL;
            textView.setTypeface(TypefaceProvider.getTypeface(context, font), style);
        }
    }

    public static void overrideRootView(Context context, View root, IFont font) {
        if (root instanceof ViewGroup) {
            final ViewGroup parent = (ViewGroup) root;
            for (int i = parent.getChildCount() - 1; i >= 0; i--) {
                final View child = parent.getChildAt(i);
                if (child instanceof ViewGroup) {
                    overrideRootView(context, child, font);
                } else {
                    override(context, child, font);
                }
            }
        }
    }
}
