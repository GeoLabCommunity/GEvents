package ge.edu.geolab.gevents.interactor.impl;

import java.util.ArrayList;
import java.util.List;

import ge.edu.geolab.gevents.model.DrawerItem;
import ge.edu.geolab.gevents.interactor.DrawerInteractor;

/**
 * Created by akaki on 28.01.17.
 */

public class NetworkDrawerInteractorImpl implements DrawerInteractor {

    @Override
    public void loadDrawerItems(DrawerItemsCallback callback) {
        final List<DrawerItem> items = new ArrayList<>();
        // TODO: 04.02.17
        callback.onLoaded(items);
    }
}
