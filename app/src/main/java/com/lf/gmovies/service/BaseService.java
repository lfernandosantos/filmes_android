package com.lf.gmovies.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class BaseService<T> {

    final Class<T> type;

    private String baseUrl;

    public BaseService(String url, Class<T> type){
        this.baseUrl = url;
        this.type = type;
    }
     public T createRetrofit() {

         Gson gson = new GsonBuilder()
                 .setLenient()
                 .create();

         Retrofit retrofit = new Retrofit.Builder()
                 .baseUrl(baseUrl)
                 .addConverterFactory(GsonConverterFactory.create(gson))
                 .build();

         T api = retrofit.create(type);

         return api;

     }

}
