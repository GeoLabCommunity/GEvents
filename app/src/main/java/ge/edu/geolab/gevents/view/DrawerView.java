package ge.edu.geolab.gevents.view;

import java.util.List;

import ge.edu.geolab.gevents.model.DrawerItem;
import ge.edu.geolab.gevents.view.base.BaseView;
import ge.edu.geolab.gevents.view.base.ContextView;

/**
 * Created by akaki on 28.01.17.
 */

public interface DrawerView extends BaseView, ContextView {
    void setItems(List<DrawerItem> items);
}