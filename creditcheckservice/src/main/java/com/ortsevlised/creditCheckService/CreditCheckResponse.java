package com.ortsevlised.creditCheckService;

import java.util.UUID;

public class CreditCheckResponse {

    private Score score;
    private final String uuid;

    public CreditCheckResponse(Score score, String uuid) {
        this.score = score;
        this.uuid = uuid;
    }

    public String getUuid() {
        return uuid;
    }


    public Score getScore() {
        return score;
    }

    public void setScore(Score score) {
        this.score = score;
    }

    public enum Score {
        HIGH,
        LOW
    }
}
