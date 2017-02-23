package ge.edu.geolab.gevents.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Vazha on 18.02.2017.
 */
public class PlaceModel {

    @SerializedName("name")
    public String name;

    @SerializedName("city")
    public String city;

    @SerializedName("country")
    public String country;

    @SerializedName("lattitude")
    public float lattitude;

    @SerializedName("longitude")
    public float longitude;

    @SerializedName("street")
    public String street;

    @SerializedName("placeId")
    public String placeId;
}
