package com.ortsevlised.creditcardservice;

public class ApplyForCreditCardResponse {
    private final String uuid;

    public String getUuid() {
        return uuid;
    }

    public ApplyForCreditCardResponse(Status status, String uuid) {
        this.status = status;
        this.uuid= uuid;
    }
    private final Status status;
    public Status getStatus() {
        return status;
    }

    public enum Status {
        GRANTED,
        DENIED
    }
}
