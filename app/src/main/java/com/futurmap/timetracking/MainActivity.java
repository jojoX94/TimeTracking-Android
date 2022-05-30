package com.futurmap.timetracking;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.futurmap.timetracking.adapters.TimerRecyclerAdapter;
import com.futurmap.timetracking.model.TimerState;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private final ArrayList<TimerState> list = new ArrayList<>();
    private RecyclerView rc_timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Recycler
        initRecyclerView();

    }

    private void initRecyclerView() {
        rc_timer = findViewById(R.id.rc_timer);
        list.add(new TimerState());
        list.add(new TimerState());
        list.add(new TimerState());
        list.add(new TimerState());
        list.add(new TimerState());
        list.add(new TimerState());
        rc_timer.setLayoutManager(new LinearLayoutManager(this));
        TimerRecyclerAdapter timerRecyclerAdapter = new TimerRecyclerAdapter(list);
        rc_timer.setAdapter(timerRecyclerAdapter);
    }
}