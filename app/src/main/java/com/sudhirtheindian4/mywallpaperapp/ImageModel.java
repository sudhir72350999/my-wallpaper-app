package com.sudhirtheindian4.mywallpaperapp;

public class ImageModel {

    // api me  imagemodel ke andar uriemodel ka src hai isliye urimodel ko imagemodel  me rakhenge

    private  UrlModel src;

    public ImageModel(UrlModel src) {
        this.src = src;
    }


    public UrlModel getSrc() {
        return src;
    }

    public void setSrc(UrlModel src) {
        this.src = src;
    }
}
