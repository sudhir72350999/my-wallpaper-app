package com.sudhirtheindian4.mywallpaperapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {


   private  ArrayList<ImageModel> modelClassList;
   private RecyclerView recyclerView;
   Adapter adapter;
   CardView nature, bus, train, trending,car;
   EditText editText ;
   ImageButton search;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().hide();

        recyclerView = findViewById(R.id.recyclerView);
        nature = findViewById(R.id.nature);
        bus = findViewById(R.id.bus);
        train = findViewById(R.id.train);
        trending = findViewById(R.id.trending);
        car = findViewById(R.id.car);
        editText = findViewById(R.id.edittetxt);
        search = findViewById(R.id.search);


        modelClassList = new ArrayList<>();
        recyclerView.setLayoutManager(new GridLayoutManager(this,2));
        recyclerView.setHasFixedSize(true);
        adapter = new Adapter(getApplicationContext(),modelClassList);
        recyclerView.setAdapter(adapter);

        findPhotos();

        nature.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String query = "nature";
                getSearchImage(query);

            }
        });

        car.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String query = "car";
                getSearchImage(query);

            }
        });

        train.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String query = "train";
                getSearchImage(query);

            }
        });


        bus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String query = "bus";
                getSearchImage(query);

            }
        });



        trending.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String query = "trending";
                 findPhotos();
            }
        });


        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String query = editText.getText().toString().trim().toLowerCase();
                if(query.isEmpty()){
                    Toast.makeText(MainActivity.this, "Enter Something ", Toast.LENGTH_SHORT).show();
                    //or
//                    Toast.makeText(getApplicationContext(), "Enter Something ", Toast.LENGTH_SHORT).show();

                }
                else {
                    getSearchImage(query);
                    
                }
            }
        });














    }

    private void getSearchImage(String query) {

        ApiUtilities.getApiInterface().getSearchImage(query,1,80).enqueue(new Callback<SearchModel>() {
            @Override
            public void onResponse(Call<SearchModel> call, Response<SearchModel> response) {
                modelClassList.clear();
                if(response.isSuccessful()){
                    modelClassList.addAll(response.body().getPhotos());
                    adapter.notifyDataSetChanged();
                }
                else {
                    Toast.makeText(MainActivity.this, "Not Able to get", Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(Call<SearchModel> call, Throwable t) {

            }
        });
    }

    private void findPhotos() {
        modelClassList.clear();


        ApiUtilities.getApiInterface().getImage(1,80).enqueue(new Callback<SearchModel>() {
            @Override
            public void onResponse(Call<SearchModel> call, Response<SearchModel> response) {



                if(response.isSuccessful()){
                    modelClassList.addAll(response.body().getPhotos());
                    adapter.notifyDataSetChanged();
                }
                else {
                    Toast.makeText(MainActivity.this, "Not Able to get", Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(Call<SearchModel> call, Throwable t) {

            }
        });
    }
}