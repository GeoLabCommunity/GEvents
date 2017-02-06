package ge.edu.geolab.gevents.model;

import android.graphics.drawable.Drawable;

/**
 * Created by akaki on 31.01.17.
 */

public class DrawerItem {

    private int mId;
    private String mTitle;
    private Drawable mIconDrawable;

    private DrawerItem() {
    }

    public static DrawerItem create(int id, String title, Drawable icon) {
        final DrawerItem item = new DrawerItem();
        item.mId = id;
        item.mTitle = title;
        item.mIconDrawable = icon;
        return item;
    }

    public int getId() {
        return mId;
    }

    public String getTitle() {
        return mTitle;
    }

    public Drawable getIconDrawable() {
        return mIconDrawable;
    }
}
