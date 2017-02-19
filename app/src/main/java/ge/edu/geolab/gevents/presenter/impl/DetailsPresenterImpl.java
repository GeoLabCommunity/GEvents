package ge.edu.geolab.gevents.presenter.impl;

import com.google.android.gms.maps.model.LatLng;

import ge.edu.geolab.gevents.interactor.DetailsInteractor;
import ge.edu.geolab.gevents.interactor.impl.DetailsInteractorImpl;
import ge.edu.geolab.gevents.model.EventModel;
import ge.edu.geolab.gevents.presenter.DetailsPresenter;
import ge.edu.geolab.gevents.presenter.base.BasePresenter;
import ge.edu.geolab.gevents.view.DetailsView;

/**
 * Created by Vazha on 19.02.2017.
 */

public class DetailsPresenterImpl extends BasePresenter implements DetailsPresenter {

    private DetailsInteractor mDetailsInteractor;
    private DetailsView mView;
    private EventModel mModel;

    public DetailsPresenterImpl(DetailsView view) {
        mView = view;
        mDetailsInteractor = new DetailsInteractorImpl();
    }

    @Override
    public void setModel(EventModel model) {
        mModel = model;
    }

    @Override
    public void initDetails() {
        if (mModel == null) {
            throw new IllegalStateException("Call setModel method first dumbass!!!");
        }

        final String url = mDetailsInteractor.getCoverImageUrl(mModel);
        mView.setCoverImage(url);

        final String name = mDetailsInteractor.getEventName(mModel);
        mView.setEventName(name);

        final String description = mDetailsInteractor.getDescription(mModel);
        mView.setDescription(description);

        final LatLng location = mDetailsInteractor.getLocation(mModel);
        mView.setLocation(location);

        final String address = mDetailsInteractor.getEventAddress(mModel);
        mView.setEventAddress(address);

        final long startDate = mDetailsInteractor.getStartDate(mModel);
        mView.setStartDate(startDate);

        final String startEndTima = mDetailsInteractor.getStartEndTime(mModel);
        mView.setStartEndTime(startEndTima);

        final String organizer = mDetailsInteractor.getOrganizer(mModel);
        mView.setOrganizer(organizer);

        final int attendingCount = mDetailsInteractor.getAttendingCount(mModel);
        mView.setAttendingCount(attendingCount);

        final int interestedCount = mDetailsInteractor.getInterestedCount(mModel);
        mView.setInterestedCount(interestedCount);
    }
}
