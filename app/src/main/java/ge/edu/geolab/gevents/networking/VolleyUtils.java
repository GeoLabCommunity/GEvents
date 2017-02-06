package ge.edu.geolab.gevents.networking;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkError;
import com.android.volley.NoConnectionError;
import com.android.volley.ParseError;
import com.android.volley.ServerError;
import com.android.volley.TimeoutError;
import com.android.volley.VolleyError;

/**
 * Created by akaki on 08.01.17.
 */

public class VolleyUtils {

    public static String handleError(VolleyError volleyError) {
        String message = null;
        if (volleyError instanceof NetworkError) {
            message = "Cannot connect to Internet... Please check your connection.";
        } else if (volleyError instanceof ServerError) {
            message = "The server could not be found. Please try again later.";
        } else if (volleyError instanceof AuthFailureError) {
            message = "Cannot connect to Internet... Please check your connection.";
        } else if (volleyError instanceof ParseError) {
            message = "Parsing error! Please try again later";
        } else if (volleyError instanceof NoConnectionError) {
            message = "Cannot connect to Internet... Please check your connection.";
        } else if (volleyError instanceof TimeoutError) {
            message = "Connection TimeOut! Please check your internet connection.";
        }
        return message;
    }
}
