package ge.edu.geolab.gevents.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;

public class EventModel implements Serializable {

    public static String KEY = "event_model";

    @SerializedName("id")
    public String id;

    @SerializedName("name")
    public String name;

    @SerializedName("description")
    public String description;

    @SerializedName("start_time")
    public long startTime;

    @SerializedName("end_time")
    public long endTime;

    @SerializedName("organizer")
    public String organizer;

    @SerializedName("category")
    public String category;

    @SerializedName("cover")
    public String coverImgUrl;

    @SerializedName("ticket_url")
    public String ticketUrl;

    @SerializedName("place")
    public PlaceModel place;

    @SerializedName("interested_count")
    public int interestedCount;

    @SerializedName("attending_count")
    public int attendingCount;
}


