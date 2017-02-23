package ge.edu.geolab.gevents.event;

import org.greenrobot.eventbus.EventBus;

/**
 * Created by akaki on 22.02.17.
 */

public class EventBusProvider {
    private static EventBus sInstance;

    public static synchronized EventBus getInstance() {
        if (sInstance == null) {
            sInstance = new EventBus();
        }
        return sInstance;
    }
}
