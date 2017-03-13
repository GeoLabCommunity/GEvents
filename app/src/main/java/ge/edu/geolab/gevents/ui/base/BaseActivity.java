package ge.edu.geolab.gevents.ui.base;

import android.content.Intent;

import org.greenrobot.eventbus.Subscribe;

import ge.edu.geolab.gevents.event.EventBusProvider;
import ge.edu.geolab.gevents.model.EventModel;
import ge.edu.geolab.gevents.ui.DetailsPageActivity;
import ge.edu.geolab.gevents.ui.HomeActivity;

/**
 * Created by akaki on 13.03.17.
 */

public class BaseActivity extends SlidingActivity {

    @Override
    protected void onPause() {
        super.onPause();
        EventBusProvider.getInstance().unregister(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        EventBusProvider.getInstance().register(this);
    }

    @Subscribe
    public void onEventSelected(EventModel event) {
        final Intent intent = new Intent(this, DetailsPageActivity.class);
        intent.putExtra(EventModel.KEY, event);
        startActivity(intent);
    }
}
