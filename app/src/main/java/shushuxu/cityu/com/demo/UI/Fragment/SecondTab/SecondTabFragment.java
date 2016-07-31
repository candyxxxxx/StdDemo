package shushuxu.cityu.com.demo.UI.Fragment.SecondTab;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import shushuxu.cityu.com.demo.Base.BaseLazyMainFragment;
import shushuxu.cityu.com.demo.R;

/**
 * Created by shushu on 7/8/16.
 */
public class SecondTabFragment extends BaseLazyMainFragment {

    public static SecondTabFragment newInstance() {

        Bundle args = new Bundle();

        SecondTabFragment fragment = new SecondTabFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tab_second, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {
        TextView tv = (TextView) view.findViewById(R.id.second);
    }

    @Override
    protected void initLazyView(@Nullable Bundle savedInstanceState) {

    }
}
