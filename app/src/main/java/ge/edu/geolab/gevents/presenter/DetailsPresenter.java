package ge.edu.geolab.gevents.presenter;

import com.google.android.gms.maps.model.LatLng;

import ge.edu.geolab.gevents.model.EventModel;

/**
 * Created by Vazha on 19.02.2017.
 */

public interface DetailsPresenter {
    void setModel(EventModel model);

    void initDetails();
}
