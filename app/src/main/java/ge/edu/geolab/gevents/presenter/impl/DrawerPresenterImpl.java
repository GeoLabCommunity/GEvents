package ge.edu.geolab.gevents.presenter.impl;

import java.util.List;

import ge.edu.geolab.gevents.model.DrawerItem;
import ge.edu.geolab.gevents.interactor.DrawerInteractor;
import ge.edu.geolab.gevents.interactor.impl.LocalDrawerInteractorImpl;
import ge.edu.geolab.gevents.presenter.DrawerPresenter;
import ge.edu.geolab.gevents.presenter.base.BasePresenter;
import ge.edu.geolab.gevents.view.DrawerView;

/**
 * Created by akaki on 28.01.17.
 */

public class DrawerPresenterImpl extends BasePresenter implements DrawerPresenter {

    private DrawerView mView;
    private DrawerInteractor mDrawerInteractor;

    public DrawerPresenterImpl(DrawerView view) {
        mView = view;
        mDrawerInteractor = new LocalDrawerInteractorImpl(mView.getViewContext());
    }

    @Override
    public void onReady() {
        mDrawerInteractor.loadDrawerItems(new DrawerInteractor.DrawerItemsCallback() {
            @Override
            public void onLoaded(List<DrawerItem> data) {
                mView.setItems(data);
            }

            @Override
            public void onLoadFailed() {
                mView.setError("");
            }
        });
    }
}
