package com.ortsevlised.creditCheckService;

import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.Before;

import static com.ortsevlised.creditCheckService.CreditCheckResponse.Score.HIGH;
import static com.ortsevlised.creditCheckService.CreditCheckResponse.Score.LOW;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class BaseContractTest {

    @Before
    public void setup() {
        final CreditCheckService creditCheckService = mock(CreditCheckService.class);
        when(creditCheckService.doCreditCheck(1234)).thenReturn(new CreditCheckResponse(HIGH,"d1b8242f-f755-403d-9f36-f4d5fdb109b2"));
        when(creditCheckService.doCreditCheck(4444)).thenReturn(new CreditCheckResponse(LOW,"d1b8242f-f755-403d-9f36-f4d5fdb109b2"));

        RestAssuredMockMvc.standaloneSetup(new CreditCheckController(creditCheckService));
    }

}
