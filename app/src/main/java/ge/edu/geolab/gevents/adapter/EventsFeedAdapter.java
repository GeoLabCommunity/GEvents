package ge.edu.geolab.gevents.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.content.res.AppCompatResources;
import android.support.v7.widget.AppCompatImageView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

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

public class EventsFeedAdapter extends BaseRecyclerAdapter<EventModel> {

    private final Drawable mPlaceholder;

    public EventsFeedAdapter(Context context) {
        super(context);
        mPlaceholder = AppCompatResources.getDrawable(context, R.drawable.placeholder);
    }

    @Override
    protected View createView(LayoutInflater inflater, ViewGroup viewGroup, int viewType) {
        return inflater.inflate(R.layout.event_feed_item, viewGroup, false);
    }

    @Override
    protected void bindView(EventModel item, ViewHolder viewHolder) {
        if (item != null) {
            final AppCompatImageView coverView = (AppCompatImageView) viewHolder.getView(R.id.event_cover_img);
            final TextView titleView = (TextView) viewHolder.getView(R.id.event_title);
            final TextView organizer = (TextView) viewHolder.getView(R.id.event_organizer_title);
            final DateView dateView = (DateView) viewHolder.getView(R.id.event_date_view);

            Picasso.with(context)
                    .load(item.coverImgUrl)
                    .placeholder(mPlaceholder)
                    .error(mPlaceholder)
                    .into(coverView);

            titleView.setText(item.name);
            organizer.setText(item.organizer);
            dateView.setDate(DateUtils.getTime(item.startTime));
        }
    }

    @Override
    protected void onViewHolderCreated(ViewHolder holder) {
        TypefaceHelper.override(holder.getView(R.id.event_title), AppFont.BPG_NINO_MTAVRULI_NORMAL);
        TypefaceHelper.override(holder.getView(R.id.event_organizer_title), AppFont.BPG_NINO_MKHEDRULI_NORMAL);
        TypefaceHelper.overrideRootView(holder.getItemView().getContext(), holder.getView(R.id.event_date_view), AppFont.BPG_NINO_MTAVRULI_NORMAL);
    }

    @Override
    protected void onItemClick(EventModel item, int position) {
        EventBusProvider.getInstance().post(item);
    }
}
