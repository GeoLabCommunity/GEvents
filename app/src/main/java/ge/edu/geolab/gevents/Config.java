package ge.edu.geolab.gevents;

/**
 * Created by akaki on 06.02.17.
 */

public final class Config {

    public interface API {
        String BASE_URL = "http://mvc.geolab.edu.ge/";
        String EVENTS_REQUEST_URL = BASE_URL + "api/contact";
    }

    public static final int LOAD_ITEM_COUNT_DEFAULT = 10;
}
