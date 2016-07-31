package shushuxu.cityu.com.demo.Adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import shushuxu.cityu.com.demo.UI.Fragment.FirstTab.ProbePagerFragment;
import shushuxu.cityu.com.demo.UI.Fragment.FirstTab.SurveyPagerFragment;

/**
 * Created by shushu on 7/8/16.
 */
public class PagerFragmentAdapter extends FragmentPagerAdapter {
    private String[] mTab = new String[]{"Probe", "Survey"};

    public PagerFragmentAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return ProbePagerFragment.newInstance();
        } else {
            return SurveyPagerFragment.newInstance();
        }
    }

    @Override
    public int getCount() {
        return mTab.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mTab[position];
    }
}
