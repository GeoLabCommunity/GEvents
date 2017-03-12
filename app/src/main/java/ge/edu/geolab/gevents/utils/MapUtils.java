package ge.edu.geolab.gevents.utils;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * Created by akaki on 12.03.17.
 */

public class MapUtils {
    public static Intent navigate(final Context context, final double lat, final double lng) {
        return new Intent(Intent.ACTION_VIEW, Uri.parse("google.navigation:q=" + lat + "," + lng));
    }

    public static Intent showOnMap(final Context context, final double lat, final double lng, final String label) {
        try {
            return new Intent(Intent.ACTION_VIEW, Uri.parse("geo:0,0?q=" + lat + "," + lng + "(" + URLEncoder.encode(label, "UTF-8") + ")"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }
}