package com.futurmap.timetracking;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.futurmap.timetracking.adapters.TimerListAdapter;
import com.futurmap.timetracking.adapters.TimerRecyclerAdapter;
import com.futurmap.timetracking.model.TimerState;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private final ArrayList<TimerState> list = new ArrayList<>();
    private RecyclerView rc_timer;

    private boolean wasRunning;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Recycler
        rc_timer = findViewById(R.id.rc_timer);
        list.add(new TimerState());
        list.add(new TimerState());
        list.add(new TimerState());
        TimerRecyclerAdapter timerRecyclerAdapter = new TimerRecyclerAdapter(list);
        rc_timer.setAdapter(timerRecyclerAdapter);



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

}