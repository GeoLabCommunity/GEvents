package ge.edu.geolab.gevents.utils;


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
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
}
