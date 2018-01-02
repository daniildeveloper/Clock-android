package tk.daniildeveloper.clock;

import android.annotation.TargetApi;
import android.app.AlarmManager;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    Button alarmOn, alarmOff;
    TextView updateText;
    TimePicker timePicker;
    AlarmManager alarmManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

//        initialize created components
        alarmOn = (Button) findViewById(R.id.alarm_on);
        alarmOff = (Button) findViewById(R.id.alarm_off);
        updateText = (TextView) findViewById(R.id.updateText);
        timePicker = (TimePicker) findViewById(R.id.timePicker);
        alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);

        final Calendar calendar = Calendar.getInstance();

//        add listeners for buttons
        alarmOn.setOnClickListener(new View.OnClickListener() {

            @TargetApi(Build.VERSION_CODES.M)
            @Override
            public void onClick(View view) {
                calendar.set(Calendar.HOUR_OF_DAY, timePicker.getHour());
                calendar.set(Calendar.MINUTE, timePicker.getMinute());

//
                int hour = timePicker.getHour();
                int minute = timePicker.getMinute();

//                convert to string
                String hourString = String.valueOf(hour);
                String minuteString = String.valueOf(minute);

                if (hour > 12) {
                    hourString = String.valueOf(hour - 12);
                }

                if (minute < 10) {
//                    12:5 -> 12:05
                    minuteString = "0" + String.valueOf(minute);
                }

                setTimeText("Будильник поставлен на " + hourString + " : " + minuteString);
            }
        });
        alarmOff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setTimeText("Будильник выключен");
            }
        });
    }

    private void setTimeText(String s) {
        updateText.setText(s);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
