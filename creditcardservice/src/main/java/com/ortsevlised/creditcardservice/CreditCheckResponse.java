package com.ortsevlised.creditcardservice;

public class CreditCheckResponse {

    public String getUuid() {
        return uuid;
    }

    private String uuid;

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public Score getScore() {
        return score;
    }

    private Score score;

    public enum Score {
        HIGH,
        LOW
    }
}
