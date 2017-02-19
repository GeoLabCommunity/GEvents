package ge.edu.geolab.gevents.view;

import com.google.android.gms.maps.model.LatLng;

/**
 * Created by Vazha on 19.02.2017.
 */

public interface DetailsView {
    void setCoverImage(String url);

    void setEventName(String name);

    void setDescription(String description);

    void setLocation(LatLng latLng);

    void setEventAddress(String address);

    void setStartDate(long date);

    void setStartEndTime(String time);

    void setOrganizer(String oeganizer);

    void setAttendingCount(int count);

    void setInterestedCount(int count);
}
