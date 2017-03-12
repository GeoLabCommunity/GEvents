package ge.edu.geolab.gevents.ui.base;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AppCompatDelegate;

import ge.edu.geolab.gevents.R;

/**
 * Created by akaki on 19.02.17.
 */

public class SlidingActivity extends AppCompatActivity {

    protected void onLeaveThisActivity() {
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
    }

    protected void onStartNewActivity() {
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
    }

    @Override
    public void startActivity(Intent intent) {
        super.startActivity(intent);
        onStartNewActivity();
    }

    @Override
    public void startActivity(Intent intent, Bundle options) {
        super.startActivity(intent, options);
        onStartNewActivity();
    }

    @Override
    public void startActivityForResult(Intent intent, int requestCode) {
        super.startActivityForResult(intent, requestCode);
        onStartNewActivity();
    }

    @Override
    public void startActivityFromChild(Activity child, Intent intent, int requestCode) {
        super.startActivityFromChild(child, intent, requestCode);
        onStartNewActivity();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        onLeaveThisActivity();
    }

    @Override
    public void finish() {
        super.finish();
        onLeaveThisActivity();
    }

    public void finishNoAnimation() {
        super.finish();
    }

    @Override
    public void finishActivity(int requestCode) {
        super.finishActivity(requestCode);
        onLeaveThisActivity();
    }

    @Override
    public void finishFromChild(Activity child) {
        super.finishFromChild(child);
        onLeaveThisActivity();
    }

    @Override
    public void finishActivityFromChild(Activity child, int requestCode) {
        super.finishActivityFromChild(child, requestCode);
        onLeaveThisActivity();
    }
}
