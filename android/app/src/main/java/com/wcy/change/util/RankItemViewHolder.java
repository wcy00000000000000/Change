package com.wcy.change.util;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.wcy.change.R;

public class RankItemViewHolder extends RecyclerView.ViewHolder {
    private TextView rank, name, day;
    private ImageView avatar;
    private Context context;

    public RankItemViewHolder(@NonNull View view, Context context) {
        super(view);
        this.context = context;
        name = view.findViewById(R.id.item_user);
        day = view.findViewById(R.id.item_check_day);
        avatar = view.findViewById(R.id.item_avatar);
        rank = view.findViewById(R.id.item_rank);
    }

    public void setDay(String day) {
        this.day.setText(day);
    }

    public String getDay() {
        return this.day.getText().toString();
    }

    public String getRank() {
        return rank.getText().toString();
    }

    public void setRank(String rank) {
        this.rank.setText(rank);
    }

    public String getName() {
        return name.getText().toString();
    }

    public void setName(String name) {
        this.name.setText(name);
    }

    public void setAvatar(String imageUrl) {
        Glide.with(context).load(imageUrl)
                .apply(RequestOptions.circleCropTransform())
                .into(avatar);
    }
}
