package shushuxu.cityu.com.demo;

import android.os.Bundle;

import me.yokeyword.fragmentation.anim.DefaultHorizontalAnimator;
import me.yokeyword.fragmentation.anim.FragmentAnimator;
import shushuxu.cityu.com.demo.Base.BaseActivity;
import shushuxu.cityu.com.demo.RecognitionAct.RecogActivity;
import shushuxu.cityu.com.demo.UI.Fragment.MainFragment;

public class MainActivity extends BaseActivity {

    private RecogActivity recogActivity = new RecogActivity(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            loadRootFragment(R.id.fl_container, MainFragment.newInstance());
        }

        recogActivity.startRecogAcitivity();
    }

    @Override
    public void onBackPressedSupport() {
        // 对于 3个类别的主Fragment内的回退back逻辑,已经在其onBackPressedSupport里各自处理了
        super.onBackPressedSupport();
    }

    @Override
    public FragmentAnimator onCreateFragmentAnimator() {
        // 设置横向(和安卓4.x动画相同)
        return new DefaultHorizontalAnimator();
    }
}
