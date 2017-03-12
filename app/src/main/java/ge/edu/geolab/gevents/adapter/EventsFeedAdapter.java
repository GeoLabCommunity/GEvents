package ge.edu.geolab.gevents.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.content.res.AppCompatResources;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import ge.edu.geolab.gevents.R;
import ge.edu.geolab.gevents.event.EventBusProvider;
import ge.edu.geolab.gevents.helper.AppFont;
import ge.edu.geolab.gevents.helper.font.TypefaceHelper;
import ge.edu.geolab.gevents.model.EventModel;
import ge.edu.geolab.gevents.ui.widgets.DateView;
import ge.edu.geolab.gevents.utils.DateUtils;

/**
 * Created by Vazha on 08.02.2017.
 */

public class EventsFeedAdapter extends RecyclerView.Adapter<EventsFeedAdapter.EventViewHolder> {

    private final LayoutInflater mLayoutInflater;
    private List<EventModel> mItems = new ArrayList<>();
    private final Context mContext;
    private final Drawable mPlaceholder;

    public EventsFeedAdapter(Context context) {
        mContext = context;
        mLayoutInflater = LayoutInflater.from(context);
        mPlaceholder = AppCompatResources.getDrawable(mContext, R.drawable.placeholder);
    }

    public void setItems(List<EventModel> items) {
        mItems.clear();
        mItems = items;
        notifyDataSetChanged();
    }

    public void addItems(List<EventModel> items) {
        mItems.addAll(items);
        notifyDataSetChanged();
    }

    @Override
    public EventViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View view = mLayoutInflater.inflate(R.layout.event_feed_item, parent, false);
        return new EventViewHolder(view);
    }

    @Override
    public void onBindViewHolder(EventViewHolder holder, int position) {
        final EventModel model = mItems.get(position);
        Picasso.with(mContext)
                .load(model.coverImgUrl)
                .placeholder(mPlaceholder)
                .error(mPlaceholder)
                .into(holder.coverView);
        holder.titleView.setText(model.name);
        holder.organizer.setText(model.organizer);
        holder.dateView.setDate(DateUtils.getTime(model.startTime));
        holder.setModel(model);
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    static class EventViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        @BindView(R.id.event_cover_img)
        AppCompatImageView coverView;
        @BindView(R.id.event_title)
        TextView titleView;
        @BindView(R.id.event_organizer_title)
        TextView organizer;
        @BindView(R.id.event_date_view)
        DateView dateView;

        EventViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

            TypefaceHelper.override(titleView, AppFont.BPG_NINO_MTAVRULI_NORMAL);
            TypefaceHelper.override(organizer, AppFont.BPG_NINO_MTAVRULI_NORMAL);
            TypefaceHelper.overrideRootView(dateView.getContext(), dateView, AppFont.BPG_NINO_MTAVRULI_NORMAL);

            itemView.setOnClickListener(this);
        }

        private EventModel mModel;

        void setModel(EventModel model) {
            this.mModel = model;
        }

        @Override
        public void onClick(View view) {
            EventBusProvider.getInstance().post(mModel);
        }
    }
}
