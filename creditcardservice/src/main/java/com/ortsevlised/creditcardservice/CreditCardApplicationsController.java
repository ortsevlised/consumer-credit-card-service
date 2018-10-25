package com.ortsevlised.creditcardservice;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import static com.ortsevlised.creditcardservice.ApplyForCreditCardRequest.CardType.GOLD;
import static com.ortsevlised.creditcardservice.ApplyForCreditCardResponse.Status.DENIED;
import static com.ortsevlised.creditcardservice.ApplyForCreditCardResponse.Status.GRANTED;
import static com.ortsevlised.creditcardservice.CreditCheckResponse.Score.HIGH;
import static com.ortsevlised.creditcardservice.CreditCheckResponse.Score.LOW;

@RestController
public class CreditCardApplicationsController {

    private final RestTemplate restTemplate;
    private final String creditCheckServiceBaseUrl;

    public CreditCardApplicationsController(RestTemplate restTemplate, @Value("${creditcheckservice.baseurl}") String creditCheckServiceBaseUrl) {
        this.restTemplate = restTemplate;
        this.creditCheckServiceBaseUrl = creditCheckServiceBaseUrl;
    }

    @PostMapping("/credit-card-applications")
    public ApplyForCreditCardResponse applyForCreditCard(@RequestBody final ApplyForCreditCardRequest applyForCreditCardRequest) {
        final int citizenNumber = applyForCreditCardRequest.getCitizenNumber();
        String uri = UriComponentsBuilder.fromHttpUrl(creditCheckServiceBaseUrl).path("credit-scores").toUriString();
        CreditCheckResponse creditCheckResponse = restTemplate.postForObject(uri, new CreditCheckRequest(citizenNumber), CreditCheckResponse.class);
        final CreditCheckResponse.Score score = creditCheckResponse.getScore();
        final String uuid = creditCheckResponse.getUuid();

        if (score == HIGH && applyForCreditCardRequest.getCardType() == GOLD) {
            return new ApplyForCreditCardResponse(GRANTED,uuid);

        } else if (score == LOW && applyForCreditCardRequest.getCardType() == GOLD) {
            return new ApplyForCreditCardResponse(DENIED,uuid);
        }
        throw new RuntimeException("Card and score not yet implemented");
    }
}
