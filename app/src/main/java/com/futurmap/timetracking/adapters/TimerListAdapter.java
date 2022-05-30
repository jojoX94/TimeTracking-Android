package com.futurmap.timetracking.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.futurmap.timetracking.R;
import com.futurmap.timetracking.model.TimerState;

import java.util.ArrayList;

public class TimerListAdapter extends BaseAdapter {
    private final Context context;
    private final ArrayList<TimerState> cardList;

    public TimerListAdapter(Context context, ArrayList<TimerState> cardList) {
        this.context = context;
        this.cardList = cardList;
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

    @Override
    public long getItemId(int position) {
        return position;
    }

    @NonNull
    public View getView(int position, View convertView, ViewGroup container) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.card_item, container, false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        TimerState model = getItem(position);
        holder.lbl_count.setText(String.valueOf("00:00:00"));
        return convertView;
    }

    static class ViewHolder {
        TextView lbl_count;

        ViewHolder(View view) {
            lbl_count = (TextView) view.findViewById(R.id.lbl_count);
        }
    }
}
