package com.example.recycleview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Myadapter extends RecyclerView.Adapter<Myviewholder> {
    Context context;
    List<users_cls> users;

    public Myadapter(Context context,List<users_cls> users) {

        this.context = context;
        this.users = users;
    }

    @NonNull
    @Override
    public Myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_view,parent,false);
        return new Myviewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Myviewholder holder, int position) {
        holder.name_view.setText(users.get(position).getName());
        holder.pwd_view.setText(users.get(position).getPassword());
        holder.fn_view.setText(users.get(position).getFn());
        holder.dob_view.setText(users.get(position).getDob());
        holder.hobby_view.setText(users.get(position).getInteres());




    }


    @Override
    public int getItemCount() {
        return users.size();
    }
}
