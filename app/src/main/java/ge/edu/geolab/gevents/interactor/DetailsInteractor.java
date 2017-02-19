package ge.edu.geolab.gevents.interactor;

import com.google.android.gms.maps.model.LatLng;

import ge.edu.geolab.gevents.interactor.base.BaseInteractor;
import ge.edu.geolab.gevents.model.EventModel;

/**
 * Created by Vazha on 19.02.2017.
 */

public interface DetailsInteractor extends BaseInteractor {
    String getCoverImageUrl(EventModel model);
    String getEventName(EventModel model);
    String getDescription(EventModel model);
    LatLng getLocation(EventModel model);
    String getEventAddress(EventModel model);
    long getStartDate(EventModel model);
    String getStartEndTime(EventModel model);
    String getOrganizer(EventModel model);
    int getAttendingCount(EventModel model);
    int getInterestedCount(EventModel model);
}
