package com.androidapps.robertsteele.geoquiz;

public class Question {

    private int mtextResId;
    private boolean mTrueAnswer;

    public boolean ismTrueAnswer() {
        return mTrueAnswer;
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

    public Question(int textResId, boolean TrueAnswer) {
        mtextResId = textResId;
        mTrueAnswer = TrueAnswer;
    }

}
