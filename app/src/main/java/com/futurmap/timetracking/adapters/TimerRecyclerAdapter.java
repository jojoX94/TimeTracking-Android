package com.futurmap.timetracking.adapters;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.futurmap.timetracking.R;
import com.futurmap.timetracking.model.TimerState;

import java.util.ArrayList;
import java.util.Locale;

public class TimerRecyclerAdapter extends RecyclerView.Adapter<TimerRecyclerAdapter.ViewHolder> {
    private final ArrayList<TimerState> list;

    public TimerRecyclerAdapter(ArrayList<TimerState> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public TimerRecyclerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.lbl_project.setText(this.list.get(position).getProject());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView lbl_count;
        private final TextView lbl_project;
        private final ImageButton btn_start;
        private final ImageButton btn_pause;
        private final ImageButton btn_stop;
        private int seconds = 0;
        private boolean running;


        public ViewHolder(View view) {
            super(view);
            this.lbl_count = view.findViewById(R.id.lbl_count);
            this.lbl_project = view.findViewById(R.id.lbl_project);
            this.btn_start = view.findViewById(R.id.btn_start);
            this.btn_pause = view.findViewById(R.id.btn_pause);
            this.btn_stop = view.findViewById(R.id.btn_stop);


            runTimer();
            view.setOnClickListener(view12 -> running = !running);
            this.btn_start.setOnClickListener(view1 -> running = true);
            this.btn_pause.setOnClickListener(view1 -> running = false);
            this.btn_stop.setOnClickListener(view1 -> {
                running = false;
                seconds = 0;
            });
        }


        private void runTimer() {
            final Handler handler
                    = new Handler();

            handler.post(new Runnable() {

                @Override
                public void run() {
                    int hours = seconds / 3600;
                    int minutes = (seconds % 3600) / 60;
                    int secs = seconds % 60;

                    String time
                            = String
                            .format(Locale.getDefault(),
                                    "%d:%02d:%02d", hours,
                                    minutes, secs);
                    lbl_count.setText(time);
                    if (running) {
                        seconds++;
                    }
                    handler.postDelayed(this, 1000);
                }
            });
        }
    }
}
