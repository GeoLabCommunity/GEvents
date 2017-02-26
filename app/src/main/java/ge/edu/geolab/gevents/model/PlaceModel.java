package ge.edu.geolab.gevents.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by Vazha on 18.02.2017.
 */
public class PlaceModel implements Serializable {

    @SerializedName("name")
    public String name;

    @SerializedName("city")
    public String city;

    @SerializedName("country")
    public String country;

    @SerializedName("latitude")
    public float latitude;

    @SerializedName("longitude")
    public float longitude;

    @SerializedName("street")
    public String street;

    @SerializedName("placeId")
    public String placeId;

}
