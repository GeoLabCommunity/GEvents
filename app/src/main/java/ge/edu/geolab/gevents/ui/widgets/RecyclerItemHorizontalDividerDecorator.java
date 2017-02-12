package ge.edu.geolab.gevents.ui.widgets;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by Vazha on 08.02.2017.
 */

public class RecyclerItemHorizontalDividerDecorator extends RecyclerView.ItemDecoration {

    private final int verticalSpaceHeight;

    public RecyclerItemHorizontalDividerDecorator(int verticalSpaceHeight) {
        this.verticalSpaceHeight = verticalSpaceHeight;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        outRect.bottom = verticalSpaceHeight;
    }

}


