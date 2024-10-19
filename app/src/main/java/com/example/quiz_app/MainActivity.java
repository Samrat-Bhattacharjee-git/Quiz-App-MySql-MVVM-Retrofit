package com.example.quiz_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.text.format.DateUtils;
import android.view.View;
import android.widget.RadioButton;
import android.widget.Toast;

import com.example.quiz_app.databinding.ActivityMainBinding;
import com.example.quiz_app.modelRetrofit.Question;
import com.example.quiz_app.modelRetrofit.QuestionList;
import com.example.quiz_app.viewmodel.QuizViewModel;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding activityMainBinding;
    QuizViewModel quizViewModel;
    List<Question> questionList;

    static int result=0;
    static int totalQuestions=0;
    int i=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        activityMainBinding= DataBindingUtil.setContentView(this,R.layout.activity_main);

        result=0;
        totalQuestions=0;
        //creating an instance of quizviewmodel
        quizViewModel=new ViewModelProvider(this).get(QuizViewModel.class);

        //display the first question
        displayFirstQuestion();

        activityMainBinding.btnnext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                displayNextQuestions();
            }
        });
    }
    public void displayFirstQuestion(){
        quizViewModel.getQuestionListLiveData().observe(this, new Observer<QuestionList>() {
            @Override
            public void onChanged(QuestionList questions) {
                //called when livedata changes
                questionList = questions;
                activityMainBinding.text2.setText("Question 1: "+questions.get(0).getQuestion());
                activityMainBinding.btn1.setText(questions.get(0).getOption1());
                activityMainBinding.btn2.setText(questions.get(0).getOption2());
                activityMainBinding.btn3.setText(questions.get(0).getOption3());
                activityMainBinding.btn4.setText(questions.get(0).getOption4());
            }
        });
    }
    public void displayNextQuestions(){

        if(activityMainBinding.btnnext.getText().equals("Finish")){
            Intent intent=new Intent(MainActivity.this, Result.class);
            startActivity(intent);
            finish();
        }
        int selectedOption=activityMainBinding.radiogroup.getCheckedRadioButtonId();
        if(selectedOption!=-1){
            RadioButton radioButton=findViewById(selectedOption);

            //more ques to display??
            if((questionList.size()-i)>0){
                totalQuestions=questionList.size();

                //checking if the option is correct or not
                if(radioButton.getText().toString().equals(questionList.get(i).getCorrectOption())){
                    result++;
                    activityMainBinding.text3.setText("correct answer: "+result);
                }
                if(i==0){
                    i++;
                }
                //displaying the next que
                activityMainBinding.text2.setText("Question "+(i+1)+": "+questionList.get(i).getQuestion());
                activityMainBinding.btn1.setText(questionList.get(i).getOption1());
                activityMainBinding.btn2.setText(questionList.get(i).getOption2());
                activityMainBinding.btn3.setText(questionList.get(i).getOption3());
                activityMainBinding.btn4.setText(questionList.get(i).getOption4());

                //check if it the last question or not
                if(i==questionList.size()-1){
                    activityMainBinding.btnnext.setText("Finish");
                }
                activityMainBinding.radiogroup.clearCheck();
                i++;
            }
            else {
                if(radioButton.getText().toString().equals(questionList.get(i-1).getCorrectOption())){
                    result++;
                    activityMainBinding.text3.setText("correct answer: "+result);
                }
            }
        }
        else {
            Toast.makeText(this, "You Need To Select An Option", Toast.LENGTH_SHORT).show();
        }
    }
}