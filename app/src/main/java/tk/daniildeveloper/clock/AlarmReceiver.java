package tk.daniildeveloper.clock;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * Recaiver
 * Created by daniildeveloper on 02.01.2018.
 */
public class AlarmReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d("TAG_LOG", "Receiver worked");
    }
}
