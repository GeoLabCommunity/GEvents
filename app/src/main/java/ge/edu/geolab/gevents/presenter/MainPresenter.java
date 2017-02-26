package ge.edu.geolab.gevents.presenter;

/**
 * Created by akaki on 04.02.17.
 */

public interface MainPresenter {
    void onCreate();

    void onDestroy();

    void loadFeedEvents(int page);
}
