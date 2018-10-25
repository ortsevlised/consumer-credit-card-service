package com.ortsevlised.creditCheckService;

import java.util.UUID;

public class CreditCheckResponse {

    private Score score;
    public CreditCheckResponse(Score score) {
        this.score=score;
    }

    public String getUuid() {
        return uuid;
    }

    private final String uuid = UUID.randomUUID().toString();

    public Score getScore() {
        return score;
    }

    public void setScore(Score score) {
        this.score = score;
    }

    public enum  Score {
        HIGH,
        LOW
    }
}
