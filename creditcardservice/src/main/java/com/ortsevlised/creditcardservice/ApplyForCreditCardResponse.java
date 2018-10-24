package com.ortsevlised.creditcardservice;

public class ApplyForCreditCardResponse {
    public ApplyForCreditCardResponse(Status status) {
        this.status = status;
    }
    private final Status status;
    public Status getStatus() {
        return status;
    }

    public enum Status {
        GRANTED
    }
}
