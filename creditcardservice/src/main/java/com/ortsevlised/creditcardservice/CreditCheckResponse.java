package com.ortsevlised.creditcardservice;

public class CreditCheckResponse {

    public Score getScore() {
        return score;
    }

    private Score score;

    public enum Score {
        HIGH
    }
}
