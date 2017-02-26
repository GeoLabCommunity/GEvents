package ge.edu.geolab.gevents;

/**
 * Created by akaki on 06.02.17.
 */

public final class Config {

    public static abstract class API {
        private static String BASE_URL = "http://mvc.geolab.edu.ge/";
        private static String EVENTS_REQUEST_URL = BASE_URL + "api/allevents/";

        public static String getEventsUrl(int page) {
            return EVENTS_REQUEST_URL + page;
        }
    }

    public static final int LOAD_ITEM_COUNT_DEFAULT = 10;
}
