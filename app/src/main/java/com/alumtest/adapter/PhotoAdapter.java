package com.alumtest.adapter;


import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alumtest.R;
import com.alumtest.holder.PhotoViewHolder;
import com.alumtest.listener.PhotoListener;
import com.alumtest.model.Photo;
import com.bumptech.glide.Glide;

import java.util.List;

public class PhotoAdapter extends RecyclerView.Adapter<PhotoViewHolder> {

    private List<Photo> photoList;
    private Context context;
    private PhotoListener photoListener;


    public PhotoAdapter(List<Photo> photoList, Context context, PhotoListener photoListener) {
        this.photoList = photoList;
        this.context = context;
        this.photoListener = photoListener;
    }

    @NonNull
    @Override
    public PhotoViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).
                inflate(R.layout.photo_list_view, viewGroup, false);
        return new PhotoViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull PhotoViewHolder holder, int position) {
        Photo photo = photoList.get(position);
        holder.itemTitle.setText(photo.getTitle());
        holder.itemDescription.setText(photo.getUrl());
        if (!photo.getUrl().isEmpty()) {
            Glide.with(context).asBitmap().load(photo.getUrl()).into(holder.itemPhoto);
        } else {
            Glide.with(context).asBitmap().load(R.drawable.ic_launcher_background).into(holder.itemPhoto);
        }

        holder.itemView.setOnClickListener(v -> {
            this.photoListener.onItemClick(photo, position);
        });
    }

    @Override
    public int getItemCount() {
        return photoList.size();
    }
}
