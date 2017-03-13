package ge.edu.geolab.gevents.utils;

import android.content.Intent;
import android.net.Uri;

import com.google.android.gms.maps.model.LatLng;

import static android.text.TextUtils.isEmpty;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * Created by akaki on 12.03.17.
 */

public class MapUtils {

    public static class LocationHolder {
        public LatLng latLng;
        public String address;
    }

    public static Intent navigateIntent(final LocationHolder location) {
        return new Intent(Intent.ACTION_VIEW, Uri.parse("google.navigation:q=" +
                buildQuery(location.latLng.latitude, location.latLng.longitude, location.address)));
    }

    public static Intent showOnMapIntent(final LocationHolder location) {
        return new Intent(Intent.ACTION_VIEW, Uri.parse("geo:0,0?q=" +
                buildQuery(location.latLng.latitude, location.latLng.longitude, location.address)));
    }

    private static String buildQuery(final double lat, final double lng, final String query) {
        String encodedQuery = "";
        try {
            encodedQuery = URLEncoder.encode(query, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return isEmpty(query) ? lat + "," + lng + "()" : encodedQuery;
    }
}