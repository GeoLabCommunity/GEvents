package ge.edu.geolab.gevents;

/**
 * Created by akaki on 06.02.17.
 */

public final class Config {

    public static abstract class API {
        private static String BASE_URL = "http://mvc.geolab.edu.ge/";
        private static String EVENTS_REQUEST_URL = BASE_URL + "api/allevents/";
        private static String SEARCH_EVENTS_REQUEST_URL = BASE_URL + "api/search/";

        public static String getEventsUrl(int page) {
            return EVENTS_REQUEST_URL + page;
        }

        public static String getSearchEventsUrl(String keyWord, int page) {
            return SEARCH_EVENTS_REQUEST_URL + keyWord + "/" + page;
        }

    }

    public static final int LOAD_ITEM_COUNT_DEFAULT = 10;
}
