package ge.edu.geolab.gevents.presenter;

import ge.edu.geolab.gevents.model.base.IEventCategory;

/**
 * Created by akaki on 04.02.17.
 */

public interface MainPresenter {
    void onCreate();

    void onDestroy();

    void loadFeedEvents(int page);

    void setCategory(IEventCategory category);
}
