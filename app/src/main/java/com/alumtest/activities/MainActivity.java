package com.alumtest.activities;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.alumtest.R;
import com.alumtest.adapter.PhotoAdapter;
import com.alumtest.listener.PhotoListener;
import com.alumtest.model.Photo;
import com.alumtest.network.PhotoService;
import com.alumtest.network.RetrofitInstance;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements PhotoListener {
    private PhotoAdapter adapter;
    private ProgressDialog dialog;
    private RecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dialog = new ProgressDialog(this);
        dialog.setMessage("loading....");
        dialog.show();

        setUp();
    }

    private void setUp() {
        PhotoService photoService = RetrofitInstance.getRetrofitInstance().create(PhotoService.class);
        Call<List<Photo>> listCall = photoService.getAllPhotos();
        listCall.enqueue(new Callback<List<Photo>>() {
            @Override
            public void onResponse(Call<List<Photo>> call, Response<List<Photo>> response) {
                dialog.dismiss();
                generatedList(response.body());
            }

            @Override
            public void onFailure(Call<List<Photo>> call, Throwable t) {
                dialog.dismiss();
                Toast.makeText(MainActivity.this, "Oop! an error occur, please try again", Toast.LENGTH_LONG).show();
            }
        });
    }

    private void generatedList(List<Photo> photoList) {
        recyclerView = findViewById(R.id.recyclerView);
        adapter = new PhotoAdapter(photoList, MainActivity.this, this);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onItemClick(Photo photo, int position) {
        if (photo != null && position != -1) {
            Intent intent = new Intent(MainActivity.this, PhotoDetailsActivity.class);
            intent.putExtra("photoUrl", photo.getUrl());
            intent.putExtra("title", photo.getTitle());
            startActivity(intent);
        }
    }
}
