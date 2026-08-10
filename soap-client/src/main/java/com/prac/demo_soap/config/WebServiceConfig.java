package com.prac.demo_soap.config;

import com.prac.demo_soap.soapclient.CountryClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Slf4j
@Configuration
public class WebServiceConfig {

    @Bean
    public Jaxb2Marshaller marshaller(){
        log.info(">> Jaxb2Marshaller Config Success!!");
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setContextPath("com.example.soapclient.wsdl");
        return marshaller;
    }

    @Bean
    public CountryClient countryClient(Jaxb2Marshaller marshaller){
        CountryClient client = new CountryClient();
        client.setDefaultUri("http://127.0.0.1:8080/ws");
        client.setMarshaller(marshaller);
        client.setUnmarshaller(marshaller);
        return client;
    }
}
