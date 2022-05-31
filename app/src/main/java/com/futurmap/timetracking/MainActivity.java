package com.futurmap.timetracking;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.futurmap.timetracking.adapters.TimerRecyclerAdapter;
import com.futurmap.timetracking.model.TimerState;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private final ArrayList<TimerState> list = new ArrayList<>();
    private RecyclerView rc_timer;
    private Button btn_create;
    private EditText txt_project;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rc_timer = findViewById(R.id.rc_timer);
        TimerRecyclerAdapter timerRecyclerAdapter = getTimerRecyclerAdapter();

        // Add new Timer
        addTimer(timerRecyclerAdapter);
    }

    @NonNull
    private TimerRecyclerAdapter getTimerRecyclerAdapter() {
        list.add(new TimerState());
        rc_timer.setLayoutManager(new LinearLayoutManager(this));
        TimerRecyclerAdapter timerRecyclerAdapter = new TimerRecyclerAdapter(list);
        rc_timer.setAdapter(timerRecyclerAdapter);
        return timerRecyclerAdapter;
    }

    private void addTimer(TimerRecyclerAdapter timerRecyclerAdapter) {
        btn_create = findViewById(R.id.btn_create);
        btn_create.setOnClickListener(view -> {
            txt_project = findViewById(R.id.txt_project);
            if (txt_project.getText().toString().equals("")) {
                Log.d("String", txt_project.getText().toString());
                Toast.makeText(this, "Empty field", Toast.LENGTH_SHORT).show();
            } else {
                list.add(new TimerState());
                timerRecyclerAdapter.notifyItemChanged(0);
            }
        });
    }

    private void initRecyclerView(RecyclerView rc_timer) {

    }
}