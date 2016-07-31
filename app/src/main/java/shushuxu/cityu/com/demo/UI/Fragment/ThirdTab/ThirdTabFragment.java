package shushuxu.cityu.com.demo.UI.Fragment.ThirdTab;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import shushuxu.cityu.com.demo.Base.BaseLazyMainFragment;
import shushuxu.cityu.com.demo.R;

/**
 * Created by shushu on 7/8/16.
 */
public class ThirdTabFragment extends BaseLazyMainFragment implements SwipeRefreshLayout.OnRefreshListener{

    private SwipeRefreshLayout mRefreshLayout;

    public static ThirdTabFragment newInstance() {

        Bundle args = new Bundle();

        ThirdTabFragment fragment = new ThirdTabFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tab_third, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {
        mRefreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.refresh_layout);
    }

    @Override
    protected void initLazyView(@Nullable Bundle savedInstanceState) {
        mRefreshLayout.setOnRefreshListener(this);
    }

    @Override
    public void onRefresh() {
        mRefreshLayout.postDelayed(new Runnable() {
            @Override
            public void run() {
                mRefreshLayout.setRefreshing(false);
            }
        }, 2500);
    }
}
