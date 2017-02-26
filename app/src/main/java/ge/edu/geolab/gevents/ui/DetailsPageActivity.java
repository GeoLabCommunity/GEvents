package ge.edu.geolab.gevents.ui;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;
import ge.edu.geolab.gevents.R;
import ge.edu.geolab.gevents.model.EventModel;
import ge.edu.geolab.gevents.presenter.DetailsPresenter;
import ge.edu.geolab.gevents.presenter.impl.DetailsPresenterImpl;
import ge.edu.geolab.gevents.ui.base.SlidingActivity;
import ge.edu.geolab.gevents.ui.widgets.DateView;
import ge.edu.geolab.gevents.utils.ViewUtils;
import ge.edu.geolab.gevents.view.DetailsView;

public class DetailsPageActivity extends SlidingActivity implements OnMapReadyCallback, DetailsView {

    private MapFragment mapFragment;

    @BindView(R.id.details_page_event_cover_img)
    AppCompatImageView mCoverImageView;
    @BindView(R.id.details_page_event_title)
    TextView mTitleView;
    @BindView(R.id.details_page_description)
    TextView mDescriptionView;
    @BindView(R.id.details_page_event_date_view)
    DateView mDateView;
    @BindView(R.id.details_page_event_organizer)
    TextView mOrganizerView;
    @BindView(R.id.details_page_attending_count)
    TextView mAttendingCountView;
    @BindView(R.id.details_page_start_end_time)
    TextView mStartEndTimeView;
    @BindView(R.id.details_page_event_address)
    TextView mAddressView;

    private DetailsPresenter mDetailsPresenter;
    private LatLng mLocation;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_page);

        ButterKnife.bind(this);

        final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setTitle("");

        findViewById(R.id.back_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        mDetailsPresenter = new DetailsPresenterImpl(this);
        EventModel model = (EventModel) getIntent().getSerializableExtra(EventModel.KEY);
        mDetailsPresenter.setModel(model);
        mDetailsPresenter.initDetails();

        mapFragment = (MapFragment) getFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        googleMap.addMarker(new MarkerOptions().position(mLocation));
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(mLocation, 14));
    }

    @Override
    public void setCoverImage(String url) {
        Picasso.with(this)
                .load(url)
                .placeholder(R.mipmap.ic_launcher)
                .error(R.mipmap.ic_launcher)
                .into(mCoverImageView);
    }

    @Override
    public void setEventName(String name) {
        mTitleView.setText(name);
    }

    @Override
    public void setDescription(String description) {
        mDescriptionView.setText(description);
    }

    @Override
    public void setLocation(LatLng latLng) {
        mLocation = latLng;
    }

    @Override
    public void setEventAddress(String address) {
        mAddressView.setText(address);
    }

    @Override
    public void setStartDate(long date) {
        mDateView.setDate(date);
    }

    @Override
    public void setStartEndTime(String time) {
        mStartEndTimeView.setText(time);
    }

    @Override
    public void setOrganizer(String organizer) {
        mOrganizerView.setText(organizer);
    }

    @Override
    public void setAttendingCount(int count) {
        mAttendingCountView.setText(String.valueOf(count));
    }

    @Override
    public void setInterestedCount(int count) {
    }
}
