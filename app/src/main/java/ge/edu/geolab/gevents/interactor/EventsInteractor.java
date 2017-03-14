package ge.edu.geolab.gevents.interactor;

import java.util.List;

import ge.edu.geolab.gevents.interactor.base.BaseInteractor;
import ge.edu.geolab.gevents.model.EventModel;
import ge.edu.geolab.gevents.model.base.IEventCategory;

/**
 * Created by akaki on 04.02.17.
 */

public interface EventsInteractor extends BaseInteractor {

    interface EventListCallback extends BaseCallback<List<EventModel>> {
        void onNothingFound();
    }

    interface EventCallback extends BaseCallback<EventModel> {
    }

    void loadByCategory(IEventCategory cat, int page, EventListCallback listener);

    void loadDetails(int id, EventCallback listener);

    void search(String keyword, int page, EventListCallback listener);

}