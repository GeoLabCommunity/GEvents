package ge.edu.geolab.gevents.model;


import java.util.Arrays;
import java.util.List;

import ge.edu.geolab.gevents.R;
import ge.edu.geolab.gevents.model.base.IEventCategory;

/**
 * Created by akaki on 31.01.17.
 */

public enum EventCategory implements IEventCategory {
    ALL_EVENTS(0, "ყველა", R.drawable.ic_select_all),
    HAPPENING_NOW(1, "დღეს", R.drawable.ic_today),
    POPULAR(2, "ტოპ", R.drawable.ic_popular),
    NEARBY(3, "ახლოს", R.drawable.ic_nearby);

    EventCategory(int id, String name, int icon) {
        this.id = id;
        this.name = name;
        this.icon = icon;
    }

    final String name;
    final int id;
    final int icon;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public int getIconResId() {
        return icon;
    }

    public static String getNameFromId(int id) {
        for (EventCategory cat : values()) {
            if (cat.id == id) {
                return cat.name;
            }
        }
        return "";
    }

    public static IEventCategory fromId(int id) {
        for (EventCategory cat : values()) {
            if (cat.id == id) {
                return cat;
            }
        }
        return ALL_EVENTS;
    }

    private static List<EventCategory> NOT_IMPLEMENTED_CAT = Arrays.asList(NEARBY);

    @Override
    public boolean isNotImplemented() {
        return NOT_IMPLEMENTED_CAT.contains(this);
    }
}
