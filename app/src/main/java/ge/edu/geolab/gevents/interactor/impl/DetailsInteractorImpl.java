package ge.edu.geolab.gevents.interactor.impl;

import com.google.android.gms.maps.model.LatLng;

import java.text.SimpleDateFormat;
import java.util.Date;

import ge.edu.geolab.gevent.utils.DateUtils;
import ge.edu.geolab.gevents.interactor.DetailsInteractor;
import ge.edu.geolab.gevents.model.EventModel;

/**
 * Created by Vazha on 19.02.2017.
 */
public class DetailsInteractorImpl implements DetailsInteractor {
    //todo defaulti da shemtxvevebi gasaweri gvaqvs yvelastvis
    @Override
    public String getCoverImageUrl(EventModel model) {
        return model.coverImgUrl;
    }

    @Override
    public String getEventName(EventModel model) {
        return model.name;
    }

    @Override
    public String getDescription(EventModel model) {
        return model.description;
    }

    @Override
    public LatLng getLocation(EventModel model) {
        return new LatLng(model.place.lattitude, model.place.longitude);
    }

    @Override
    public String getEventAddress(EventModel model) {
        return new StringBuilder()
                .append(model.place.city)
                .append(", ")
                .append(model.place.street)
                .append(", ")
                .append(model.place.name)
                .toString();
    }

    @Override
    public long getStartDate(EventModel model) {
        return DateUtils.getTime(model.startTime);
    }

    @Override
    public String getStartEndTime(EventModel model) {
        return getTime(DateUtils.getTime(model.startTime)) + " - " + getTime(DateUtils.getTime(model.endTime));
    }

    @Override
    public String getOrganizer(EventModel model) {
        return model.organizer;
    }

    @Override
    public int getAttendingCount(EventModel model) {
        return model.attendingCount;
    }

    @Override
    public int getInterestedCount(EventModel model) {
        return model.interestedCount;
    }

    private String getTime(long time) {
        return new SimpleDateFormat("HH:mm").format(new Date(time));
    }
}
