package com.androidapps.robertsteele.geoquiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class GeoQuizActivity extends AppCompatActivity {

    private Button mTrueButton;
    private Button mFalseButton;
    private TextView mQuestionTextView;

    private Question[] mQuestions = new Question[] {
        new Question(R.string.question_australia, true),
                new Question(R.string.question_oceans, true),
                new Question(R.string.question_mideast, false),
                new Question(R.string.question_africa, false),
                new Question(R.string.question_americas, true),
                new Question(R.string.question_asia, true),
    };

    private int mQuestionIndex = 0;


    private void updateQuestion() {
        mQuestionIndex = (mQuestionIndex + 1) % mQuestions.length;
        mQuestionTextView.setText(mQuestions[mQuestionIndex].getMtextResId());
    }

    private void checkAnswer(boolean userPressedTrue){
        boolean answerIsTrue = mQuestions[mQuestionIndex].ismTrueAnswer();
        int resId = 0;
        if(userPressedTrue == answerIsTrue){
            resId = R.string.correct_toast;
        }
        else{
            resId = R.string.incorrect_toast;
        }
        Toast.makeText(this, resId, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_geo_quiz);
        mTrueButton = (Button) findViewById(R.id.true_button);
        mFalseButton = (Button) findViewById(R.id.false_buttton);
        mQuestionTextView = (TextView) findViewById(R.id.question_text_view);
        updateQuestion();
        mTrueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkAnswer(true);

            }
        });

        mFalseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkAnswer(false);
            }
        });
        mQuestionTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mQuestionTextView.setText(mQuestions[mQuestionIndex].getMtextResId());
                updateQuestion();
            }
        });
    }
}


