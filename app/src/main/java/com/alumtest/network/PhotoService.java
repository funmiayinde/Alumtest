package com.alumtest.network;


import com.alumtest.model.Photo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface PhotoService {

    @GET("/photos")
    Call<List<Photo>> getAllPhotos();
}
