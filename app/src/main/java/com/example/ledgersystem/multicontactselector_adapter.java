package com.example.ledgersystem;

import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class multicontactselector_adapter extends RecyclerView.Adapter<multicontactselector_adapter.ViewHolder> {

    List<listforadapter> data;
    public class ViewHolder extends RecyclerView.ViewHolder{

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
    @NonNull
    @Override
    public multicontactselector_adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull multicontactselector_adapter.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
