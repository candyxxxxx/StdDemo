package shushuxu.cityu.com.demo.Base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.Toast;

import shushuxu.cityu.com.demo.R;

/**
 * Double-click exit project
 * Created by shushu on 7/8/16.
 */
public abstract class BaseLazyMainFragment extends BaseFragment {

    private static final long WAIT_TIME = 2000L;
    private long TOUCH_TIME = 0;

    private boolean mInited = false;
    private Bundle mSavedInstanceState;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mSavedInstanceState = savedInstanceState;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        if (savedInstanceState == null) {
            if (!isHidden()) {
                mInited = true;
                initLazyView(null);
            }
        } else {
            // isSupportHidden()仅在saveIns tanceState!=null时有意义,是库帮助记录Fragment状态的方法
            if (!isSupportHidden()) {
                mInited = true;
                initLazyView(savedInstanceState);
            }
        }
    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        if (!mInited && !hidden) {
            mInited = true;
            initLazyView(mSavedInstanceState);
        }
    }

    /**
     * 懒加载
     */
    protected abstract void initLazyView(@Nullable Bundle savedInstanceState);

    /**
     * 处理回退事件
     *
     * @return
     */
    @Override
    public boolean onBackPressedSupport() {
        if (System.currentTimeMillis() - TOUCH_TIME < WAIT_TIME) {
            _mActivity.finish();
        } else {
            TOUCH_TIME = System.currentTimeMillis();
            Toast.makeText(_mActivity, R.string.press_again_exit, Toast.LENGTH_SHORT).show();
        }
        return true;
    }
}
