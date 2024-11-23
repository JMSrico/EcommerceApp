package com.example.gaterjv.Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.load.resource.bitmap.GranularRoundedCorners;
import com.example.gaterjv.Activity.DetailActivity2;
import com.example.gaterjv.Domain.PopularDomain;
import com.example.gaterjv.R;

import java.util.ArrayList;

public class PopularListAdapter extends RecyclerView.Adapter<PopularListAdapter.Viewholder> {
    ArrayList<PopularDomain> items;
    Context context;

    public PopularListAdapter(ArrayList<PopularDomain> items) {
        this.items = items;

    }

    @NonNull
    @Override
    public PopularListAdapter.Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate= LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_pop_list,parent,false);
        context = parent.getContext();
        return new Viewholder(inflate);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull Viewholder holder, int position) {
        holder.titleTxt.setText(items.get(position).getTitle());
        holder.feeTxt.setText("Kz"+items.get(position).getPrice());
        holder.ScoreTxt.setText(""+items.get(position).getScore());

        @SuppressLint("DiscouragedApi") int drawableResourceId=holder.itemView.getResources().getIdentifier(items.get(position).getPicUrl(),
                "drawable",holder.itemView.getContext().getPackageName());

        com.bumptech.glide.Glide.with(holder.itemView.getContext())
                .load(drawableResourceId)
                .transform(new GranularRoundedCorners(30,30,0,0))
                .into(holder.pic);

        holder.itemView.setOnClickListener(view -> {
            Intent intent = new Intent(holder.itemView.getContext(), DetailActivity2.class);
            intent.putExtra("object", items.get(position));
            holder.itemView.getContext().startActivity(intent);
        });

    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public static class Viewholder extends RecyclerView.ViewHolder {
        TextView titleTxt,feeTxt,ScoreTxt;
        ImageView pic;
        public Viewholder(@NonNull View itemView) {
            super(itemView);

            titleTxt=itemView.findViewById(R.id.titleTxt);
            feeTxt=itemView.findViewById(R.id.feeText);
            ScoreTxt=itemView.findViewById(R.id.scoreTxt);
            pic = itemView.findViewById(R.id.pic);
        }
    }

}
