package com.alumtest.holder;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.alumtest.R;

public class PhotoViewHolder extends RecyclerView.ViewHolder {

    public ImageView itemPhoto;
    public TextView itemTitle;
    public TextView itemDescription;

    public PhotoViewHolder(@NonNull View itemView) {
        super(itemView);

        itemPhoto = itemView.findViewById(R.id.itemPhoto);
        itemTitle = itemView.findViewById(R.id.itemTitle);
        itemDescription = itemView.findViewById(R.id.itemDescription);
    }
}
