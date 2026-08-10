package com.prac.demo_soap.soapclient;

import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

@Slf4j
public class CountryClient extends WebServiceGatewaySupport {

    public com.example.soapclient.wsdl.Country getCountry(String name){
        com.example.soapclient.wsdl.GetCountryRequest request = new com.example.soapclient.wsdl.GetCountryRequest();
        request.setName(name);

        log.info(">> SOAP 요청 전송 : name={}", name);
        com.example.soapclient.wsdl.GetCountryResponse response = (com.example.soapclient.wsdl.GetCountryResponse) getWebServiceTemplate()
                .marshalSendAndReceive(request);

        log.info(">> SOAP 응답 수신 : {}", response.getCountry().toString());
        return response.getCountry();
    }
}
