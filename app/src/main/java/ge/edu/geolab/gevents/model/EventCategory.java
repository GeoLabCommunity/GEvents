package ge.edu.geolab.gevents.model;

import ge.edu.geolab.gevents.R;

/**
 * Created by akaki on 31.01.17.
 */

public enum EventCategory {
    ART_EVENT(0, "Art", R.mipmap.ic_launcher),
    BOOK_EVENT(1, "Book", R.mipmap.ic_launcher),
    MOVIE_EVENT(2, "Movie", R.mipmap.ic_launcher),
    FUNDRAISER(3, "Fundraiser", R.mipmap.ic_launcher),
    VOLUNTEERING(4, "Volunteering", R.mipmap.ic_launcher),
    FAMILY_EVENT(5, "Family", R.mipmap.ic_launcher),
    FESTIVAL_EVENT(6, "Festival", R.mipmap.ic_launcher),
    NEIGHBORHOOD(7, "Neighborhood", R.mipmap.ic_launcher),
    RELIGIOUS_EVENT(8, "Religious", R.mipmap.ic_launcher),
    SHOPPING(9, "Shopping", R.mipmap.ic_launcher);
//    COMEDY_EVENT,
//    MUSIC_EVENT,
//    DANCE_EVENT,
//    NIGHTLIFE,
//    THEATER_EVENT,
//    DINING_EVENT,
//    FOOD_TASTING,
//    CONFERENCE_EVENT,
//    MEETUP,
//    CLASS_EVENT,
//    LECTURE,
//    WORKSHOP,
//    FITNESS,
//    SPORTS_EVENT,
//    OTHER;

    private EventCategory(int id, String name, int iconResId) {
        this.id = id;
        this.name = name;
        this.iconResId = iconResId;
    }

    public static String getNameFromId(int id) {
        for (EventCategory cat : values()) {
            if (cat.id == id) {
                return cat.name;
            }
        }
        return "";
    }

    public final int id;
    public final String name;
    public final int iconResId;
}
