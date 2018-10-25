package com.ortsevlised.creditcardservice;

import java.time.LocalDate;
import java.util.UUID;

public class CreditCheckRequest {
    private final int citizenNumber;

    public String getUuid() {
        return uuid;
    }

    private final String uuid = UUID.randomUUID().toString();

    public CreditCheckRequest(int citizenNumber) {
        this.citizenNumber = citizenNumber;
    }

    public int getCitizenNumber() {
        return citizenNumber;
    }

    public String getRequestDate() {
        return requestDate;
    }

    private final String requestDate = LocalDate.now().toString();
}
