package ge.edu.geolab.gevents.interactor.impl;

import com.android.volley.Response;
import com.android.volley.VolleyError;

import java.util.Arrays;

import ge.edu.geolab.gevents.Config;
import ge.edu.geolab.gevents.interactor.EventsInteractor;
import ge.edu.geolab.gevents.model.EventModel;
import ge.edu.geolab.gevents.model.base.IEventCategory;
import ge.edu.geolab.gevents.networking.VolleyManager;
import ge.edu.geolab.gevents.requests.GsonRequest;

import static com.android.volley.Request.Method;

/**
 * Created by akaki on 04.02.17.
 */

public class EventsInteractorImpl implements EventsInteractor {

    @Override
    public void loadByCategory(IEventCategory category, int page, final EventListCallback callback) {
        VolleyManager.getInstance().addEventRequest(
                new GsonRequest<>(
                        Method.GET,
                        Config.API.getEventsUrl(category, page),
                        EventModel[].class,
                        new Response.Listener<EventModel[]>() {
                            @Override
                            public void onResponse(EventModel[] response) {
                                callback.onLoaded(Arrays.asList(response));
                            }
                        },
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                callback.onLoadFailed();
                            }
                        }
                )
        );
    }

    @Override
    public void loadDetails(int id, EventCallback listener) {
        // TODO: 04.02.17
    }

    @Override
    public void search(String keyword, int page, final EventListCallback callback) {
        VolleyManager.getInstance().addEventRequest(
                new GsonRequest<>(
                        Method.GET,
                        Config.API.getSearchEventsUrl(keyword, page),
                        EventModel[].class,
                        new Response.Listener<EventModel[]>() {
                            @Override
                            public void onResponse(EventModel[] response) {
                                callback.onLoaded(Arrays.asList(response));
                            }
                        },
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                callback.onLoadFailed();
                            }
                        }
                )
        );
    }
}
