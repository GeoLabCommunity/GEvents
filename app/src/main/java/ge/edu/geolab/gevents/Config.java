package ge.edu.geolab.gevents;

import ge.edu.geolab.gevents.model.base.IEventCategory;

/**
 * Created by akaki on 06.02.17.
 */

public final class Config {

    public static abstract class API {
        private static String BASE_URL = "http://mvc.geolab.edu.ge/";
        private static String EVENTS_REQUEST_URL = BASE_URL + "api/filters/";
        private static String SEARCH_EVENTS_REQUEST_URL = BASE_URL + "api/Search/";

        public static String getEventsUrl(IEventCategory category, int page) {
            return EVENTS_REQUEST_URL + category.getId() + "/" + page;
        }

        public static String getSearchEventsUrl(String keyWord, int page) {
            return SEARCH_EVENTS_REQUEST_URL + keyWord + "/" + page;
        }
    }

    public static final int LOAD_ITEM_COUNT_DEFAULT = 10;
}
