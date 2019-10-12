package com.example.recyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

//The definition of RecyclerView.Adapter requires a viewholder class
public class RecyclerAdapter extends RecyclerView.Adapter<viewholder> {
    private List<User> users;
    private Context context;

    public RecyclerAdapter(Context context, List<User> users) {
        this.users = users;
        this.context= context;
    }

    @NonNull
    @Override
    public viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_item,parent,false);
        return new viewholder(view);
    }
    // list initilization
    @Override
    public void onBindViewHolder(@NonNull viewholder holder, final int position)
    {
        User sampleuser = users.get(position);
        holder.name.setText(sampleuser.subjectname);
        holder.desc.setText(sampleuser.userdesc);
        //for use of glide library
        //holder.image.setImageResource(sampleuser.subimage);

        Glide.with(context).load(sampleuser.subimage).into(holder.image);

        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,"Item " + position + " Clicked",Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount()
    {
        return users.size();
    }
}
