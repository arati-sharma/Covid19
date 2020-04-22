package com.example.covid19;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    @NonNull

    private List<ListItem> listItems;
    private Context context;

    public MyAdapter(@NonNull List<ListItem> listItems, Context context) {
        this.listItems = listItems;
        this.context = context;
    }

    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item,viewGroup,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        ListItem listItem=listItems.get(i);
        viewHolder.TextviewHead.setText(listItem.getHead());
        viewHolder.TextViewDescription.setText(listItem.getDercrip());
    }

    @Override
    public int getItemCount() {
        return listItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        public TextView TextviewHead;
        public TextView TextViewDescription;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            TextviewHead=(TextView) itemView.findViewById(R.id.TextViewHead);
            TextViewDescription=(TextView) itemView.findViewById(R.id.TextViewDescription);
        }
    }
}
