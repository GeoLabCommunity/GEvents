package ge.edu.geolab.gevents.presenter.impl;

import java.util.Collections;
import java.util.List;

import ge.edu.geolab.gevents.interactor.EventsInteractor;
import ge.edu.geolab.gevents.interactor.impl.EventsInteractorImpl;
import ge.edu.geolab.gevents.model.EventModel;
import ge.edu.geolab.gevents.presenter.SearchPresenter;
import ge.edu.geolab.gevents.presenter.base.BasePresenter;
import ge.edu.geolab.gevents.view.MainView;
import ge.edu.geolab.gevents.view.SearchView;

/**
 * Created by Vazha on 28.02.2017.
 */

public class SearchPresenterImpl extends BasePresenter implements SearchPresenter {

    private SearchView mView;
    private EventsInteractor mEventsInteractor;

    public SearchPresenterImpl(SearchView view) {
        mView = view;
        mEventsInteractor = new EventsInteractorImpl();
    }

    @Override
    public void performSearch(String keyWord, int page) {
        if (page == 1) {
            mView.showLoader();
        }

        mEventsInteractor.search(keyWord, page, new EventsInteractor.EventListCallback() {

            @Override
            public void onNothingFound() {
                if (mView != null) {
                    mView.hideLoader();
                    mView.setResult(Collections.<EventModel>emptyList());
                }
            }

            @Override
            public void onLoaded(List<EventModel> data) {
                if (mView != null) {
                    mView.hideLoader();
                    mView.setResult(data);
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
