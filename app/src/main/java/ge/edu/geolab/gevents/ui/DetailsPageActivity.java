package ge.edu.geolab.gevents.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatImageButton;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.Date;

import ge.edu.geolab.gevents.R;
import ge.edu.geolab.gevents.ui.widgets.DateView;

public class DetailsPageActivity extends AppCompatActivity implements OnMapReadyCallback {

    private MapFragment map;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_page);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final AppCompatImageButton backButton = (AppCompatImageButton) (findViewById(R.id.back_btn));
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View view){
                Intent intent = new Intent(DetailsPageActivity.this, HomeActivity.class);
                startActivity(intent);
            }
        });


            map = (MapFragment) getFragmentManager().findFragmentById(R.id.map);
            map.getMapAsync(this);

            DateView dateView = (DateView) findViewById(R.id.event_date);
            dateView.setDate(new Date());
        }

        @Override
        public void onMapReady (GoogleMap googleMap){
            googleMap.addMarker(new MarkerOptions()
                    .position(new LatLng(10, 10))
                    .title("Hello world"));
        }
    }
