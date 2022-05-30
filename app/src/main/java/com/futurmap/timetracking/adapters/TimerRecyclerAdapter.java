package com.futurmap.timetracking.adapters;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.futurmap.timetracking.R;
import com.futurmap.timetracking.model.TimerState;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Locale;

public class TimerRecyclerAdapter extends RecyclerView.Adapter<TimerRecyclerAdapter.ViewHolder> {
    private ArrayList<TimerState> list;

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
    public void onBindViewHolder(@NonNull TimerRecyclerAdapter.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        private final TextView lbl_count;
        private final Button btn_start;
        private final Button btn_pause;
        private final Button btn_stop;
        private  int seconds = 0;
        private boolean running;


        public ViewHolder(View view) {
            super(view);
            this.lbl_count = view.findViewById(R.id.lbl_count);
            this.btn_start = view.findViewById(R.id.btn_start);
            this.btn_pause = view.findViewById(R.id.btn_pause);
            this.btn_stop = view.findViewById(R.id.btn_stop);

        }

        private void runTimer() {
            final Handler handler
                    = new Handler();

            // Call the post() method,
            // passing in a new Runnable.
            // The post() method processes
            // code without a delay,
            // so the code in the Runnable
            // will run almost immediately.
            handler.post(new Runnable() {
                @Override

                public void run() {
                    int hours = seconds / 3600;
                    int minutes = (seconds % 3600) / 60;
                    int secs = seconds % 60;

                    // Format the seconds into hours, minutes,
                    // and seconds.
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
