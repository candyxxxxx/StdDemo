package shushuxu.cityu.com.demo.RecognitionAct;

import android.app.IntentService;
import android.content.Intent;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;

import com.google.android.gms.location.ActivityRecognitionResult;
import com.google.android.gms.location.DetectedActivity;

/**
 * Created by shushu on 7/31/16.
 */
public class DetectedActivitiesIntentService extends IntentService {

    protected static final String TAG = "DetectedActivitiesIS";

    /**
     * This constructor is required, and calls the super IntentService(String)
     * constructor with the name for a worker thread.
     */

    public DetectedActivitiesIntentService() {
        super(TAG);
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }

    /**
     * Handles incoming intents.
     * @param intent The Intent is provided (inside a PendingIntent) when requestActivityUpdates()
     *               is called.
     */

    @Override
    protected void onHandleIntent(Intent intent) {

        ActivityRecognitionResult result = ActivityRecognitionResult.extractResult(intent);
        Intent localIntent = new Intent(Constants.BROADCAST_ACTION);

        DetectedActivity probActivity = result.getMostProbableActivity();

        // Log each activity.
        Log.i(TAG, "activity detected");
        Log.i(TAG, Constants.getActivityString(getApplicationContext(), probActivity.getType()) + " " + probActivity.getConfidence() + "%");

//        }

        // Broadcast the list of detected activities.
        localIntent.putExtra(Constants.ACTIVITY_EXTRA, probActivity);
        LocalBroadcastManager.getInstance(this).sendBroadcast(localIntent);
    }
}
