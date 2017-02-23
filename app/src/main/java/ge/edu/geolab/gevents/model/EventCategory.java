package ge.edu.geolab.gevents.model;


import ge.edu.geolab.gevents.R;
import ge.edu.geolab.gevents.model.base.IEventCategory;

/**
 * Created by akaki on 31.01.17.
 */

public enum EventCategory implements IEventCategory {
    HAPPENING_NOW(0, "დღეს", R.mipmap.ic_launcher),
    ALL_EVENTS(1, "ყველა", R.mipmap.ic_launcher);

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
}
