package com.sudhirtheindian4.mywallpaperapp;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiUtilities {
    private  static  Retrofit retrofit = null;
    public  static  final String API = "563492ad6f917000010000014ab0d03a7ba24d4d9e8a4e0f97aebffe";

    public  static  ApiInterface getApiInterface(){
        if(retrofit==null){
            retrofit = new Retrofit.Builder().baseUrl(ApiInterface.BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
        }
        return retrofit.create(ApiInterface.class);


    }


}
