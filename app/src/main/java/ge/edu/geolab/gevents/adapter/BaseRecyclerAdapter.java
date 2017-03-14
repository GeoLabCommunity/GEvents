package ge.edu.geolab.gevents.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by akaki on 13.03.17.
 */

public abstract class BaseRecyclerAdapter<T> extends RecyclerView.Adapter {

    private final LayoutInflater mLayoutInflater;
    protected final Context context;

    private List<T> mItems = new ArrayList<>();
    private final OnItemClick mListener = new OnItemClick() {
        @Override
        public void onClick(View view, int position) {
            onItemClick(getItem(position), position);
        }
    };

    protected abstract View createView(LayoutInflater inflater, ViewGroup viewGroup, int viewType);

    protected abstract void bindView(T item, ViewHolder viewHolder);

    protected abstract void onItemClick(T item, int position);

    protected void onViewHolderCreated(ViewHolder holder){

    }

    public BaseRecyclerAdapter(Context context) {
        super();
        this.context = context;
        mLayoutInflater = LayoutInflater.from(context);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        final ViewHolder holder = new ViewHolder(
                createView(mLayoutInflater, viewGroup, viewType), mListener);
        onViewHolderCreated(holder);
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int position) {
        bindView(getItem(position), (ViewHolder) viewHolder);
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    public T getItem(int index) {
        return mItems != null && index < mItems.size() ? mItems.get(index) : null;
    }

    public void setItems(List<T> items) {
        mItems = items;
        notifyDataSetChanged();
    }

    public void addItems(List<T> items) {
        mItems.addAll(items);
        notifyDataSetChanged();
    }

    public void clear() {
        mItems.clear();
        notifyDataSetChanged();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private SparseArray<View> mViewCache;
        private OnItemClick mListener;

        public ViewHolder(View view, OnItemClick listener) {
            super(view);
            mViewCache = new SparseArray<>();
            mViewCache.put(0, view);
            mListener = listener;
            if (mListener != null) {
                view.setOnClickListener(this);
            }
        }

        @Override
        public void onClick(View view) {
            if (mListener != null) {
                mListener.onClick(view, getAdapterPosition());
            }
        }

        public void initViews(int[] ids) {
            for (int id : ids) {
                initViewById(id);
            }
        }

        public View initViewById(int id) {
            final View view = getItemView() != null ? getItemView().findViewById(id) : null;
            if (view != null) {
                mViewCache.put(id, view);
            }
            return view;
        }

        public View getItemView() {
            return getView(0);
        }

        public View getView(int id) {
            View view = mViewCache.get(id);
            if (view == null) {
                view = initViewById(id);
            }
            return view;
        }
    }

    public interface OnItemClick {
        void onClick(View view, int position);
    }
}
