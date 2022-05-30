package com.futurmap.timetracking;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.futurmap.timetracking.adapters.CardTimerAdapter;
import com.futurmap.timetracking.model.TimerState;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private final int seconds = 0;
    private final ArrayList<TimerState> list = new ArrayList<>();

    // Is the stopwatch running?
    private boolean running;

    private boolean wasRunning;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView lvCards = (ListView) findViewById(R.id.list_cards);
        CardTimerAdapter adapter = new CardTimerAdapter(this, list);
        list.add(new TimerState());
        list.add(new TimerState());
        lvCards.setAdapter(adapter);
//        if (savedInstanceState != null) {
//
//            // Get the previous state of the stopwatch
//            // if the activity has been
//            // destroyed and recreated.
//            seconds
//                    = savedInstanceState
//                    .getInt("seconds");
//            running
//                    = savedInstanceState
//                    .getBoolean("running");
//            wasRunning
//                    = savedInstanceState
//                    .getBoolean("wasRunning");
//        }
//        runTimer();
    }

    // Save the state of the stopwatch
    // if it's about to be destroyed.
//    @Override
//    public void onSaveInstanceState(
//            Bundle savedInstanceState)
//    {
//        savedInstanceState
//                .putInt("seconds", seconds);
//        savedInstanceState
//                .putBoolean("running", running);
//        savedInstanceState
//                .putBoolean("wasRunning", wasRunning);
//    }

    // If the activity is paused,
    // stop the stopwatch.
//    @Override
//    protected void onPause() {
//        super.onPause();
//        wasRunning = running;
//        running = false;
//    }
//
//    // If the activity is resumed,
//    // start the stopwatch
//    // again if it was running previously.
//    @Override
//    protected void onResume() {
//        super.onResume();
//        if (wasRunning) {
//            running = true;
//        }
//    }
//
//
//    public void onClickStart(View view) {
//        running = true;
//    }
//
//    public void onClickStop(View view) {
//        running = false;
//        seconds = 0;
//    }
//
//    public void onClickPause(View view) {
//        running = false;
//    }
//
//    private void runTimer() {
//        final TextView timeView
//                = (TextView) findViewById(
//                R.id.lbl_count);
//        final Handler handler
//                = new Handler();
//
//        // Call the post() method,
//        // passing in a new Runnable.
//        // The post() method processes
//        // code without a delay,
//        // so the code in the Runnable
//        // will run almost immediately.
//        handler.post(new Runnable() {
//            @Override
//
//            public void run() {
//                int hours = seconds / 3600;
//                int minutes = (seconds % 3600) / 60;
//                int secs = seconds % 60;
//
//                // Format the seconds into hours, minutes,
//                // and seconds.
//                String time
//                        = String
//                        .format(Locale.getDefault(),
//                                "%d:%02d:%02d", hours,
//                                minutes, secs);
//                timeView.setText(time);
//
//                if (running) {
//                    seconds++;
//                }
//                handler.postDelayed(this, 1000);
//            }
//        });
//    }
}