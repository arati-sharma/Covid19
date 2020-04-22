package com.example.covid19;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class MyAdapter_date_wise extends RecyclerView.Adapter<MyAdapter_date_wise.ViewHolder> {
    @NonNull

    private List<date_wise> listItems;
    private Context context;

    public MyAdapter_date_wise(@NonNull List<date_wise> listItems, Context context) {
        this.listItems = listItems;
        this.context = context;
    }

    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.activity_date_wise,viewGroup,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        date_wise listItem=listItems.get(i);
        viewHolder.date.setText(listItem.getDate());
        viewHolder.dailyconfirm.setText(listItem.getDailyconfirmed());
        viewHolder.dailydecease.setText(listItem.getDailydeceased());
        viewHolder.dailyrecover.setText(listItem.getDailyrecovered());
        viewHolder.totalconfirm.setText(listItem.getTotalconfirmed());
        viewHolder.totaldecease.setText(listItem.getTotaldeceased());
        viewHolder.totalrecover.setText(listItem.getTotalrecovered());
    }

    @Override
    public int getItemCount() {
        return listItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        public TextView date;
        public TextView dailyconfirm;
        public TextView dailydecease;
        public TextView dailyrecover;
        public TextView totalconfirm;
        public TextView totaldecease;
        public TextView totalrecover;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            date=(TextView) itemView.findViewById(R.id.Date_wise);
            dailyconfirm=(TextView) itemView.findViewById(R.id.DailyConfirmed);
            dailydecease=(TextView) itemView.findViewById(R.id.DailyDeceased);
            dailyrecover=(TextView) itemView.findViewById(R.id.DailyRecovered);
            totalconfirm=(TextView) itemView.findViewById(R.id.TotalConfirmed);
            totaldecease=(TextView) itemView.findViewById(R.id.TotalDeceased);
            totalrecover=(TextView) itemView.findViewById(R.id.TotalRecovered);
        }
    }
}
