package com.androidapps.robertsteele.geoquiz;

public class Question {

    private int mtextResId;
    private boolean mTrueAnswer;
    private boolean mHasBeenAnswered;

    public boolean ismTrueAnswer() {
        return mTrueAnswer;
    }

    public boolean ismHasBeenAnswered() {
        return mHasBeenAnswered;
    }

    public void setmHasBeenAnswered(boolean mHasBeenAnswered) {
        this.mHasBeenAnswered = mHasBeenAnswered;
    }

    public void setmTrueAnswer(boolean mTrueAnswer) {
        this.mTrueAnswer = mTrueAnswer;
    }

    public int getMtextResId() {

        return mtextResId;
    }

    public void setMtextResId(int mtextResId) {
        this.mtextResId = mtextResId;
    }

    public Question(int textResId, boolean TrueAnswer, boolean hasBeenAnswered) {
        mtextResId = textResId;
        mTrueAnswer = TrueAnswer;
        mHasBeenAnswered = hasBeenAnswered;
    }

}
