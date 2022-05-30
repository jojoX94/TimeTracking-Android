package com.futurmap.timetracking.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.futurmap.timetracking.R;
import com.futurmap.timetracking.model.TimerState;

import java.util.ArrayList;
import java.util.List;

public class CardTimerAdapter extends ArrayAdapter<TimerState> {
    private static final String TAG = "CardArrayAdapter";
    private final List<TimerState> cardList = new ArrayList<TimerState>();

    public CardTimerAdapter(@NonNull Context context, int resource) {
        super(context, resource);
    }

    @Override
    public void add(@Nullable TimerState object) {
        cardList.add(object);
        super.add(object);
    }

    @Override
    public int getCount() {
        return this.cardList.size();
    }

    @Nullable
    @Override
    public TimerState getItem(int position) {
        return this.cardList.get(position);
    }

    @NonNull
    public View getView(int position, View convertView, ViewGroup container) {
        ViewHolder holder;
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            convertView = inflater.inflate(R.layout.card_item, container, false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        TimerState model = getItem(position);


        holder.lbl_count.setText(String.valueOf(model.getCurrentTime()));
        return convertView;
    }

    static class ViewHolder {
        TextView lbl_count;

        ViewHolder(View view) {
            lbl_count = (TextView) view.findViewById(R.id.lbl_count);
        }
    }
}
