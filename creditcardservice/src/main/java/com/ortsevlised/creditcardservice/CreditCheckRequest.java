package com.ortsevlised.creditcardservice;

import java.time.LocalDate;

public class CreditCheckRequest {
    private final int citizenNumber;

    public CreditCheckRequest(int citizenNumber) {
        this.citizenNumber = citizenNumber;
    }

    public int getCitizenNumber() {
        return citizenNumber;
    }
    public String getRequestDate() {
        return requestDate;
    }

    private final String requestDate= LocalDate.now().toString();

}
