package shushuxu.cityu.com.demo.Base;

import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import me.yokeyword.fragmentation.SupportFragment;
import shushuxu.cityu.com.demo.R;

/**
 * Created by shushu on 7/7/16.
 */
public class BaseFragment extends SupportFragment {

    private static final String TAG = "Demo";

    protected void initToolbarMenu(Toolbar toolbar) {
        toolbar.inflateMenu(R.menu.hierarchy);
        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.action_hierarchy:
                        _mActivity.showFragmentStackHierarchyView();
                        _mActivity.logFragmentStackHierarchy(TAG);
                        break;
                }
                return true;
            }
        });
    }
}
