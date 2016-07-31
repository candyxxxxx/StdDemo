package shushuxu.cityu.com.demo.UI.Fragment.FirstTab;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.ArrayList;

import shushuxu.cityu.com.demo.Adapter.ProbeAdapter;
import shushuxu.cityu.com.demo.Base.BaseFragment;
import shushuxu.cityu.com.demo.Entity.ProbeCategory;
import shushuxu.cityu.com.demo.Event.TabSelectedEvent;
import shushuxu.cityu.com.demo.R;
import shushuxu.cityu.com.demo.UI.Fragment.MainFragment;

/**
 * Created by shushu on 7/8/16.
 */
public class ProbePagerFragment extends BaseFragment {

    private ListView mListView;
    private ProbeAdapter mAdapter;
    private ArrayList<ProbeCategory> mItems;

    private boolean mInAtTop = true;

    public static ProbePagerFragment newInstance() {

        Bundle args = new Bundle();

        ProbePagerFragment fragment = new ProbePagerFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tab_first_pager_probe, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {

        EventBus.getDefault().register(this);

        mListView = (ListView) view.findViewById(R.id.probe_listView);

        initData();

        mAdapter = new ProbeAdapter(_mActivity, mItems);

        mListView.setAdapter(mAdapter);

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ProbeAdapter.ViewHolder viewHolder = (ProbeAdapter.ViewHolder) view.getTag();
                // 改变CheckBox的状态
                viewHolder.enabledProbeCheckbox.toggle();
                // 将CheckBox的选中状况记录下来
                ProbeAdapter.getIsSelected().put(position, viewHolder.enabledProbeCheckbox.isChecked());

                boolean isChecked = viewHolder.enabledProbeCheckbox.isChecked();
                if(isChecked){
                    viewHolder.probeEnabled.setText("Enabled");
                } else {
                    viewHolder.probeEnabled.setText("Disabled");
                }
                Log.d("MainActivity", "Click: --------------");
            }
        });

    }

    private void initData() {
        mItems = new ArrayList<>();
//        String[] data = {"WifiProbe", "LocationProbe","BatteryProbe","LightSensorProbe"};
//        for( int i = 0; i < data.length; i++){
//            mItems.add(data[i]);
//        }

        ProbeCategory categoryOne = new ProbeCategory("Studying");
        categoryOne.addItem("Lecture");
        categoryOne.addItem("Self-study");
        categoryOne.addItem("Studying App");

        ProbeCategory categoryTwo = new ProbeCategory("Social Activity");
        categoryTwo.addItem("Conversation");
        categoryTwo.addItem("Party time");

        ProbeCategory categoryThree = new ProbeCategory("Sports");
        categoryThree.addItem("Sports");

        ProbeCategory categoryFour = new ProbeCategory("Sleeping");
        categoryFour.addItem("Sleeping");

        mItems.add(categoryOne);
        mItems.add(categoryTwo);
        mItems.add(categoryThree);
        mItems.add(categoryFour);

    }

    /**
     * Reselected Tab
     */
    @Subscribe
    public void onTabSelectedEvent(TabSelectedEvent event) {
        if (event.position != MainFragment.FIRST) return;

//        if (mInAtTop) {
//            mRefreshLayout.setRefreshing(true);
//            onRefresh();
//        } else {
//            scrollToTop();
//        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mListView.setAdapter(null);
        EventBus.getDefault().unregister(this);
    }
}
