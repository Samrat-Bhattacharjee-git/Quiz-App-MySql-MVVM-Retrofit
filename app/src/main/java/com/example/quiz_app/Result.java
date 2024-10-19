package com.example.quiz_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.quiz_app.databinding.ActivityMainBinding;
import com.example.quiz_app.databinding.ActivityResultBinding;

public class Result extends AppCompatActivity {

    ActivityResultBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        binding = DataBindingUtil.setContentView(this, R.layout.activity_result);

        binding.txtAnswer.setText(
                "Your score is: "
                        +MainActivity.result
                        +"/" +MainActivity.totalQuestions);

        binding.btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Result.this
                        , MainActivity.class);
                startActivity(intent);
            }
        });


    }
}