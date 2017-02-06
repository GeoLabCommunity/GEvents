package ge.edu.geolab.gevents.interactor.base;

/**
 * Created by akaki on 04.02.17.
 */

public interface BaseInteractor {

    interface BaseCallback<T> {
        void onLoaded(T data);

        void onLoadFailed();
    }
}