package shushuxu.cityu.com.demo.Base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.Window;

import me.yokeyword.fragmentation.SupportActivity;

/**
 * Created by shushu on 7/7/16.
 */
public class BaseActivity extends SupportActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
    }
}
