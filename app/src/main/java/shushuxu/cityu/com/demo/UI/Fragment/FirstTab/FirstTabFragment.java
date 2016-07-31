package shushuxu.cityu.com.demo.UI.Fragment.FirstTab;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import shushuxu.cityu.com.demo.Adapter.PagerFragmentAdapter;
import shushuxu.cityu.com.demo.Base.BaseLazyMainFragment;
import shushuxu.cityu.com.demo.R;

/**
 * Created by shushu on 7/8/16.
 */
public class FirstTabFragment extends BaseLazyMainFragment {

    private TabLayout mTab;
    private Toolbar mToolbar;
    private ViewPager mViewPager;

    public static FirstTabFragment newInstance() {

        Bundle args = new Bundle();

        FirstTabFragment fragment = new FirstTabFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tab_first, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {
        mToolbar = (Toolbar) view.findViewById(R.id.toolbar);
        mTab = (TabLayout) view.findViewById(R.id.tab);
        mViewPager = (ViewPager) view.findViewById(R.id.viewPager);

        mToolbar.setTitle("Data");
        initToolbarMenu(mToolbar);

        mTab.addTab(mTab.newTab().setText("Probe"));
        mTab.addTab(mTab.newTab().setText("Survey"));
    }

    @Override
    protected void initLazyView(@Nullable Bundle savedInstanceState) {
        mViewPager.setAdapter(new PagerFragmentAdapter(getChildFragmentManager()));
        mTab.setupWithViewPager(mViewPager);
    }
}
