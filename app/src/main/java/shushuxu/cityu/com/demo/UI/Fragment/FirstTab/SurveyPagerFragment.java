package shushuxu.cityu.com.demo.UI.Fragment.FirstTab;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import shushuxu.cityu.com.demo.Base.BaseFragment;
import shushuxu.cityu.com.demo.R;

/**
 * Created by shushu on 7/8/16.
 */
public class SurveyPagerFragment extends BaseFragment {

    public static SurveyPagerFragment newInstance() {

        Bundle args = new Bundle();
        SurveyPagerFragment fragment = new SurveyPagerFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tab_first_pager_survey, container, false);
        return view;
    }
}
