package shushuxu.cityu.com.demo.Event;

import me.yokeyword.fragmentation.SupportFragment;

/**
 * Created by shushu on 7/8/16.
 */

// EventBus
public class StartBrotherEvent {
    public SupportFragment targetFragment;

    public StartBrotherEvent(SupportFragment targetFragment) {
        this.targetFragment = targetFragment;
    }
}
