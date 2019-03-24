package com.alumtest.activities;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.alumtest.R;
import com.bumptech.glide.Glide;

public class PhotoDetailsActivity extends AppCompatActivity {

    private ImageView itemPhotoDetails;
    private TextView titleDetailsTxtView;
    private TextView itemDescriptionDetails;
    private TextView itemDescriptionMoreDetails;
    private Button callButton;
    private Button messageButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo_details);


        itemPhotoDetails = findViewById(R.id.itemPhotoDetails);
        titleDetailsTxtView = findViewById(R.id.titleDetailsTxtView);
        itemDescriptionDetails = findViewById(R.id.itemDescriptionDetails);
        itemDescriptionMoreDetails = findViewById(R.id.itemDescriptionMoreDetails);
        callButton = findViewById(R.id.callButton);
        messageButton = findViewById(R.id.messageButton);

        setUp();
    }

    private void setUp() {
        String photoUrl = getIntent().getStringExtra("photoUrl");
        String title = getIntent().getStringExtra("title");

        if (photoUrl != null && !photoUrl.isEmpty()) {
            Glide.with(this).asBitmap().load(photoUrl).into(itemPhotoDetails);
        }

        titleDetailsTxtView.setText(title);
    }


}
