package ge.edu.geolab.gevents.ui.base;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import org.greenrobot.eventbus.Subscribe;

import ge.edu.geolab.gevents.event.EventBusProvider;
import ge.edu.geolab.gevents.model.EventModel;
import ge.edu.geolab.gevents.ui.DetailsPageActivity;

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

    protected void showKeypad() {
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.toggleSoftInput(InputMethodManager.SHOW_IMPLICIT, 0);
    }

    protected void hideKeypad() {
        InputMethodManager inputMethodManager = (InputMethodManager) this
                .getSystemService(Context.INPUT_METHOD_SERVICE);
        View focus = getCurrentFocus();
        if (focus != null)
            inputMethodManager.hideSoftInputFromWindow(focus.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
    }
}
