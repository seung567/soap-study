package com.prac.demo_soap.endpoint;

import com.prac.demo_soap.wsdl.Country;
import com.prac.demo_soap.wsdl.Currency;
import com.prac.demo_soap.wsdl.GetCountryRequest;
import com.prac.demo_soap.wsdl.GetCountryResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Slf4j
@Endpoint
public class CountryEndpoint {

    private static final String NAMESPACE_URI = "http://example.com/soapdemo/country";

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getCountryRequest")
    @ResponsePayload
    public GetCountryResponse getCountryResponse(@RequestPayload GetCountryRequest request) {
        log.info(">> GET Country Response Service!");
        GetCountryResponse response = new GetCountryResponse();
        Country country = new Country();

        country.setName(request.getName() + "_Success_Process");
        country.setPopulation(51_780_000);
        country.setCapital("Seoul");
        country.setCurrency(Currency.KRW);

        response.setCountry(country);
        return response;
    }
}