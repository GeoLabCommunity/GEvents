package ge.edu.geolab.gevents.helper.font;

import android.content.Context;
import android.graphics.Typeface;

import java.lang.ref.SoftReference;
import java.util.Hashtable;

/**
 * Created by akaki on 05.02.17.
 */

public class TypefaceProvider {

    private static final Hashtable<IFont, SoftReference<Typeface>> CACHE = new Hashtable<>();

    public static Typeface getTypeface(Context context, IFont font) {
        synchronized (CACHE) {
            final SoftReference<Typeface> ref = CACHE.get(font);
            if (ref != null) {
                Typeface refObj = ref.get();
                if (refObj != null) {
                    return refObj;
                }
            }
            final Typeface typeface = createFromAsset(context, font);
            CACHE.put(font, new SoftReference<>(typeface));
            return typeface;
        }
    }

    private static Typeface createFromAsset(Context context, IFont file) {
        return Typeface.createFromAsset(context.getAssets(), file.getFilePath());
    }
}
