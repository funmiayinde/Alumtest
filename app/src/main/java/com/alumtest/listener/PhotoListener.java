package com.alumtest.listener;

import com.alumtest.model.Photo;


public interface PhotoListener {
    void onItemClick(Photo photo, int position);
}
