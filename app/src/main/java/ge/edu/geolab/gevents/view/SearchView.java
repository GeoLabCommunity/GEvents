package ge.edu.geolab.gevents.view;

import java.util.List;

import ge.edu.geolab.gevents.model.EventModel;
import ge.edu.geolab.gevents.view.base.BaseView;

/**
 * Created by Vazha on 28.02.2017.
 */

public interface SearchView extends BaseView{

    void setResult(List<EventModel> result);
    void showLoader();
    void hideLoader();

}
