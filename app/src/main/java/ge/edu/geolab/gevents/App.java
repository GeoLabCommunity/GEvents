package ge.edu.geolab.gevents;

import android.app.Application;
import android.support.v7.app.AppCompatDelegate;

/**
 * Created by akaki on 04.02.17.
 */

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
    }

    static {
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
    }
}
