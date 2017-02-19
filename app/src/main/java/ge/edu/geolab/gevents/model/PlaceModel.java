package ge.edu.geolab.gevents.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Vazha on 18.02.2017.
 */
public class PlaceModel {

    @SerializedName("name")
    String name;

    @SerializedName("city")
    String city;

    @SerializedName("country")
    String country;

    @SerializedName("lattitude")
    String lattitude;

    @SerializedName("longitude")
    String longitude;

    @SerializedName("street")
    String street;

}
