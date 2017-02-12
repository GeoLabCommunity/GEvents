package ge.edu.geolab.gevents.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ge.edu.geolab.gevents.R;

/**
 * Created by Vazha on 08.02.2017.
 */

public class EventsFeedAdapter extends RecyclerView.Adapter<EventsFeedAdapter.EventViewHolder> {

    private LayoutInflater mLayoutInflater;

    public EventsFeedAdapter(Context context) {
        mLayoutInflater = LayoutInflater.from(context);

    }

    @Override
    public EventViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View view = mLayoutInflater.inflate(R.layout.event_feed_item , parent, false);
        return new EventViewHolder(view);
    }

    @Override
    public void onBindViewHolder(EventViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 20;
    }

    static class EventViewHolder extends RecyclerView.ViewHolder {
        public EventViewHolder(View itemView) {
            super(itemView);
        }
    }

}
