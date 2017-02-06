package ge.edu.geolab.gevents.networking;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.Volley;

/**
 * Created by akaki on 17.12.16.
 */

public class VolleyManager {

    private static final String TAG_EVENTS_REQUEST = "events_request";
    private static final RequestQueue.RequestFilter CANCEL_ALL_FILTER = new RequestQueue.RequestFilter() {
        @Override
        public boolean apply(Request<?> request) {
            return true;
        }
    };

    private static VolleyManager sInstance;

    private RequestQueue mRequestQueue;
    private ImageLoader mImageLoader;

    public static VolleyManager getInstance() {
        if (sInstance == null) {
            synchronized (VolleyManager.class) {
                if (sInstance == null) {
                    sInstance = new VolleyManager();
                }
            }
        }
        return sInstance;
    }

    public void init(Context context) {
        mRequestQueue = Volley.newRequestQueue(context);
        mImageLoader = new ImageLoader(mRequestQueue, new LruBitmapCache(context));
    }

    public void addEventRequest(Request request) {
        mRequestQueue.cancelAll(TAG_EVENTS_REQUEST);
        mRequestQueue.add(request.setTag(TAG_EVENTS_REQUEST));
    }

    public void cancelAllRequests() {
        mRequestQueue.cancelAll(CANCEL_ALL_FILTER);
    }

    public ImageLoader getImageLoader() {
        return mImageLoader;
    }
}
