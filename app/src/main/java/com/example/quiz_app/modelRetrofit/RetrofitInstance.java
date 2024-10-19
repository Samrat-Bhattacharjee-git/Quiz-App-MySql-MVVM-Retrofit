package com.example.quiz_app.modelRetrofit;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitInstance {

    String BaseUrl= "http://10.0.2.2/quiz/";

    public Retrofit getRetrofitInstance(){
        return new Retrofit.Builder()
                .baseUrl(BaseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
}
