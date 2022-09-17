package com.sudhirtheindian4.mywallpaperapp;

import java.util.ArrayList;

public class SearchModel {

    // api me  photos ke andar imagemodel ka src hai isliye imagemodel ko photos array list me rakhenge
    private ArrayList<ImageModel> photos;

    public SearchModel(ArrayList<ImageModel> photos) {
        this.photos = photos;
    }

    public ArrayList<ImageModel> getPhotos() {
        return photos;
    }

    public void setPhotos(ArrayList<ImageModel> photos) {
        this.photos = photos;
    }
}
