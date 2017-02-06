package ge.edu.geolab.gevents.ui.fragment;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ge.edu.geolab.gevents.R;
import ge.edu.geolab.gevents.helper.AppFont;
import ge.edu.geolab.gevents.helper.font.TypefaceHelper;
import ge.edu.geolab.gevents.model.DrawerItem;
import ge.edu.geolab.gevents.presenter.DrawerPresenter;
import ge.edu.geolab.gevents.presenter.impl.DrawerPresenterImpl;
import ge.edu.geolab.gevents.view.DrawerView;

public class CategoryListFragment extends ListFragment implements DrawerView {

    private static final String KEY_ID = "id";
    private static final String KEY_TITLE = "title";
    private static final String KEY_ICON = "icon";

    private Context mContext;

    private DrawerActionListener mDrawerCallback;
    private DrawerPresenter mPresenter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mPresenter = new DrawerPresenterImpl(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.category_list_fragment, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        final ListView listView = getListView();
        listView.addHeaderView(new View(mContext));
        listView.addFooterView(new View(mContext));
        listView.setDivider(new ColorDrawable(Color.parseColor("#2b2d44")));
        listView.setBackgroundColor(Color.parseColor("#33334b"));
        listView.setOverScrollMode(View.OVER_SCROLL_NEVER);
        listView.setDividerHeight(0);
        listView.setVerticalScrollBarEnabled(false);

        listView.setChoiceMode(ListView.CHOICE_MODE_SINGLE);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                if (mDrawerCallback != null) {
                    mDrawerCallback.onDrawerItemSelected((int) id);
                }
            }
        });

        view.findViewById(R.id.close_drawer_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mDrawerCallback != null) {
                    mDrawerCallback.onDrawerClose();
                }
            }
        });
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        mPresenter.onReady();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        mContext = context;

        if (context instanceof DrawerActionListener) {
            mDrawerCallback = (DrawerActionListener) context;
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();

        mDrawerCallback = null;
    }

    @Override
    public void setItems(List<DrawerItem> items) {
        final List<Map<String, ?>> adapterItems = new ArrayList<>();
        for (DrawerItem item : items) {
            final Map<String, Object> adapterItem = new HashMap<>();
            adapterItem.put(KEY_ID, item.getId());
            adapterItem.put(KEY_TITLE, item.getTitle());
            adapterItem.put(KEY_ICON, item.getIconDrawable());
            adapterItems.add(adapterItem);
        }
        final SimpleAdapter adapter = new SimpleAdapter(mContext, adapterItems, R.layout.category_item,
                new String[]{KEY_ICON, KEY_TITLE},
                new int[]{android.R.id.icon1, android.R.id.text1}) {

            @SuppressWarnings("unchecked")
            @Override
            public long getItemId(int position) {
                return (Integer) ((Map<String, ?>) getItem(position)).get(KEY_ID);
            }
        };
        adapter.setViewBinder(new SimpleAdapter.ViewBinder() {
            @Override
            public boolean setViewValue(View view, Object data, String textRepresentation) {
                switch (view.getId()) {
                    case android.R.id.icon1:
                        if (view instanceof ImageView && data instanceof Drawable) {
                            ((ImageView) view).setImageDrawable((Drawable) data);
                            return true;
                        }
                        break;
                    case android.R.id.text1:
                        if (view instanceof TextView) {
                            ((TextView) view).setText(String.valueOf(data));

                            TypefaceHelper.override(view, AppFont.BPG_NINO_MTAVRULI_NORMAL);

                            return true;
                        }
                        break;

                    default:
                        break;
                }
                return false;
            }
        });

        setListAdapter(adapter);
    }

    @Override
    public void setError(String message) {
        setEmptyText("laoad failed: " + message);
    }

    @Override
    public Context getViewContext() {
        return mContext;
    }
}