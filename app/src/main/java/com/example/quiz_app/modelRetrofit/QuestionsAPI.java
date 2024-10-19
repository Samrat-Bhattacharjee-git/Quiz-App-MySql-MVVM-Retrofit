package com.example.quiz_app.modelRetrofit;

import retrofit2.Call;
import retrofit2.http.GET;

public interface QuestionsAPI {
    @GET("myquizapi.php") //end point
    Call<QuestionList> getQuestions();

}
