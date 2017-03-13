package ge.edu.geolab.gevents.presenter.impl;

import java.util.Collections;
import java.util.List;

import ge.edu.geolab.gevents.interactor.EventsInteractor;
import ge.edu.geolab.gevents.interactor.impl.EventsInteractorImpl;
import ge.edu.geolab.gevents.model.EventModel;
import ge.edu.geolab.gevents.networking.VolleyManager;
import ge.edu.geolab.gevents.presenter.MainPresenter;
import ge.edu.geolab.gevents.presenter.base.BasePresenter;
import ge.edu.geolab.gevents.view.MainView;

/**
 * Created by akaki on 04.02.17.
 */

public class MainPresenterImpl extends BasePresenter implements MainPresenter {

    private MainView mView;
    private EventsInteractor mEventsInteractor;

    public MainPresenterImpl(MainView view) {
        mView = view;
        mEventsInteractor = new EventsInteractorImpl();
    }

    @Override
    public void onCreate() {
        VolleyManager.getInstance().init(mView.getViewContext());
    }

    @Override
    public void onDestroy() {
        mView = null;
        VolleyManager.getInstance().cancelAllRequests();
    }

    @Override
    public void loadFeedEvents(int page) {
        if (page == 1) {
            mView.showLoader();
        }

        mEventsInteractor.loadRecommended(page, new EventsInteractor.EventListCallback() {

            @Override
            public void onNothingFound() {
                if (mView != null) {
                    mView.hideLoader();
                    mView.setFeedItems(Collections.<EventModel>emptyList());
                }
            }

            @Override
            public void onLoaded(List<EventModel> data) {
                if (mView != null) {
                    mView.hideLoader();
                    mView.setFeedItems(data);
                }
            }

            @Override
            public void onLoadFailed() {
                if (mView != null) {
                    mView.hideLoader();
                }
            }
        });
    }
}
