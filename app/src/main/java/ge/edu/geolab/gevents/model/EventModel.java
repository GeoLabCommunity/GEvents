package ge.edu.geolab.gevents.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class EventModel implements Serializable {

    public static final String KEY = "event_model";

    @SerializedName("eventId")
    public String id;

    @SerializedName("name")
    public String name;

    @SerializedName("description")
    public String description;

    @SerializedName("startTime")
    public String startTime;

    @SerializedName("endTime")
    public String endTime;

    @SerializedName("organizer")
    public String organizer;

    @SerializedName("category")
    public String category;

    @SerializedName("coverImgUrl")
    public String coverImgUrl;

    @SerializedName("TicketUrl")
    public String ticketUrl;

    @SerializedName("Place")
    public PlaceModel place;

    @SerializedName("interested_count")
    public int interestedCount;

    @SerializedName("attending_count")
    public int attendingCount;
}


