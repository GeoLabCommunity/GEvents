package ge.edu.geolab.gevents.interactor;

import java.util.List;

import ge.edu.geolab.gevents.interactor.base.BaseInteractor;
import ge.edu.geolab.gevents.model.DrawerItem;

/**
 * Created by akaki on 28.01.17.
 */

public interface DrawerInteractor extends BaseInteractor {

    interface DrawerItemsCallback extends BaseCallback<List<DrawerItem>> {
    }

    void loadDrawerItems(DrawerItemsCallback callback);
}