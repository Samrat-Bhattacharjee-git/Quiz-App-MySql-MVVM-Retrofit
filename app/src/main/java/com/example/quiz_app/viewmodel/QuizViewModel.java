package com.example.quiz_app.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.quiz_app.modelRetrofit.QuestionList;
import com.example.quiz_app.respository.QuizRespository;

public class QuizViewModel extends ViewModel {
    QuizRespository respository=new QuizRespository();

    LiveData<QuestionList> questionListLiveData;

    public QuizViewModel() {
        questionListLiveData= respository.getQuestionsFromAPI();
    }

    public LiveData<QuestionList> getQuestionListLiveData() {
        return questionListLiveData;
    }
}
