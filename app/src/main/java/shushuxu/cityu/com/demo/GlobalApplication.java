package shushuxu.cityu.com.demo;

import android.app.Application;

/**
 * Created by shushu on 7/31/16.
 */
public class GlobalApplication extends Application {

    private static GlobalApplication instance;

    public GlobalApplication()
    {
        super();
        instance = this;
    }

    public static Application getContext()
    {
        return instance;
    }
}
