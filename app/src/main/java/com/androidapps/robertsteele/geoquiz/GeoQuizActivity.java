package com.androidapps.robertsteele.geoquiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.util.Log;

public class GeoQuizActivity extends AppCompatActivity {

    private Button mTrueButton;
    private Button mFalseButton;
    private TextView mQuestionTextView;
    private static final String TAG = "GeoQuizActivity";
    private static final String KEY_INDEX = "index";

    private Question[] mQuestions = new Question[]{
            new Question(R.string.question_australia, true, false),
            new Question(R.string.question_oceans, true, false),
            new Question(R.string.question_mideast, false, false),
            new Question(R.string.question_africa, false, false),
            new Question(R.string.question_americas, true, false),
            new Question(R.string.question_asia, true, false),
    };

    private int mQuestionIndex = 0;

    private void updateQuestion() {
        mQuestionIndex = (mQuestionIndex + 1) % mQuestions.length;
        mQuestionTextView.setText(mQuestions[mQuestionIndex].getMtextResId());
    }

    private void checkAnswer(boolean userPressedTrue) {
        boolean answerIsTrue = mQuestions[mQuestionIndex].ismTrueAnswer();
        int resId = 0;
        if (userPressedTrue == answerIsTrue) {
            resId = R.string.correct_toast;
        } else {
            resId = R.string.incorrect_toast;
        }
        Toast.makeText(this, resId, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        Log.d(TAG, "onSavedInstanceState Called");
        savedInstanceState.putInt(KEY_INDEX, mQuestionIndex);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "The OnCreate callback function!");
        setContentView(R.layout.activity_geo_quiz);
        if (savedInstanceState != null) {
            savedInstanceState.getInt(KEY_INDEX, 0);
        }
        mTrueButton = (Button) findViewById(R.id.true_button);
        mFalseButton = (Button) findViewById(R.id.false_buttton);
        mQuestionTextView = (TextView) findViewById(R.id.question_text_view);
        updateQuestion();
        mTrueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!mQuestions[mQuestionIndex].ismHasBeenAnswered()) {
                    checkAnswer(true);
                    mQuestions[mQuestionIndex].setmHasBeenAnswered(true);
                }

            }
        });

        mFalseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!mQuestions[mQuestionIndex].ismHasBeenAnswered()) {
                    checkAnswer(false);
                    mQuestions[mQuestionIndex].setmHasBeenAnswered(true);
                }
            }
        });

        mQuestionTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateQuestion();
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart callback function");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume callback function");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "OnStop callback function");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "OnPause callback function");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy() called");
    }


}


