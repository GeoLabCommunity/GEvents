package ge.edu.geolab.gevent.utils;


import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * Created by akaki on 23.02.17.
 */

public class DateUtils {

    private static final SimpleDateFormat FORMATTER = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");

    public static long getTime(String date) {
        try {
            return FORMATTER.parse(date).getTime();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
