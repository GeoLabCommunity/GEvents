package ge.edu.geolab.gevents.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class EventModel {
    @SerializedName("id")
    String id;

    @SerializedName("name")
    String name;

    @SerializedName("desc")
    String description;

    @SerializedName("start_date")
    long startDate;

    @SerializedName("end_date")
    long endDate;

    @SerializedName("organizer")
    String organizer;

    @SerializedName("category")
    String category;

    @SerializedName("location")
    ArrayList<Double> location;

    @SerializedName("cover")
    String coverImgUrl;
}
