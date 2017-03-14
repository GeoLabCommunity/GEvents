package ge.edu.geolab.gevents.interactor.impl;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.support.v7.content.res.AppCompatResources;

import java.util.ArrayList;
import java.util.List;

import ge.edu.geolab.gevents.interactor.DrawerInteractor;
import ge.edu.geolab.gevents.model.DrawerItem;
import ge.edu.geolab.gevents.model.EventCategory;

/**
 * Created by akaki on 28.01.17.
 */

public class LocalDrawerInteractorImpl implements DrawerInteractor {

    private Context mContext;

    public LocalDrawerInteractorImpl(Context context) {
        mContext = context;
    }

    @Override
    public void loadDrawerItems(DrawerItemsCallback callback) {
        final List<DrawerItem> items = new ArrayList<>();

        for (EventCategory cat : EventCategory.values()) {
            final DrawerItem item = DrawerItem.create(
                    cat.getId(),
                    cat.getName(),
                    AppCompatResources.getDrawable(mContext, cat.getIconResId())
            );
            items.add(item);
        }

        callback.onLoaded(items);
    }
}