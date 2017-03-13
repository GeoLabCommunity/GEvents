package ge.edu.geolab.gevents.interactor.impl;

import com.google.android.gms.maps.model.LatLng;

import java.text.SimpleDateFormat;
import java.util.Date;

import ge.edu.geolab.gevents.interactor.DetailsInteractor;
import ge.edu.geolab.gevents.model.EventModel;
import ge.edu.geolab.gevents.utils.DateUtils;

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
        return new LatLng(model.place.latitude, model.place.longitude);
    }

    @Override
    public String getEventAddress(EventModel model) {
        return checkNull(model.place.city) +
                " , " +
                checkNull(model.place.street) +
                " , " +
                checkNull(model.place.name);
    }

    @Override
    public long getStartDate(EventModel model) {
        return DateUtils.getTime(model.startTime);
    }

    @Override
    public String getStartEndTime(EventModel model) {
        String time = getTime(DateUtils.getTime(model.startTime));
        if (model.endTime != null && !model.endTime.isEmpty()) {
            time += " - " + getTime(DateUtils.getTime(model.endTime));
        }
        return time;
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

    private String checkNull(String value) {
        return value == null ? "" : value;
    }
}