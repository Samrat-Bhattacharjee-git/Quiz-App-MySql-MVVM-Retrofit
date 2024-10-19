package com.example.quiz_app.respository;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.quiz_app.modelRetrofit.QuestionList;
import com.example.quiz_app.modelRetrofit.QuestionsAPI;
import com.example.quiz_app.modelRetrofit.RetrofitInstance;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class QuizRespository {

    QuestionsAPI questionsAPI;
    public QuizRespository(){
        this.questionsAPI=new RetrofitInstance()
                .getRetrofitInstance()
                .create(QuestionsAPI.class);
    }
    public LiveData<QuestionList> getQuestionsFromAPI(){
        MutableLiveData<QuestionList> data=new MutableLiveData<>();
        Call<QuestionList> response= questionsAPI.getQuestions();
        response.enqueue(new Callback<QuestionList>() {
            @Override
            public void onResponse(Call<QuestionList> call, Response<QuestionList> response) {
                //saving the data to the list
                QuestionList list= response.body();
                data.setValue(list);
            }

            @Override
            public void onFailure(Call<QuestionList> call, Throwable t) {

            }
        });
        return data;
    }
}
