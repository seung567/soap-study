package com.prac.demo_soap.controller;

import com.prac.demo_soap.soapclient.CountryClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class SoapSendController {

    private final CountryClient countryClient;

    @PostMapping(value = "/post/call")
    public void call(){
        countryClient.getCountry("test");
    }

}
