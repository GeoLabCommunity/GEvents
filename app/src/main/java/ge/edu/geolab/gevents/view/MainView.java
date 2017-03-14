package ge.edu.geolab.gevents.view;

import java.util.List;

import ge.edu.geolab.gevents.model.EventModel;
import ge.edu.geolab.gevents.view.base.BaseView;
import ge.edu.geolab.gevents.view.base.ContextView;

/**
 * Created by akaki on 04.02.17.
 */

public interface MainView extends BaseView, ContextView {
    void showLoader();

    void hideLoader();

    void addFeedItems(List<EventModel> items);

    void setSubtitle(String subtitle);
}
