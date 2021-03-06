package com.everis.eva.demoBanca.service.bank;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.everis.eva.demoBanca.service.bank.model.RandomNumber;

@Service
public class BankService implements IBankService {
    private static Logger LOGGER = LoggerFactory.getLogger(BankService.class);

    @Value("${bankservice.balance.url}")
    private String balanceUrl;

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public Float queryBalanceFromAccount() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<String> requestEntity = new HttpEntity<>(null, headers);

        ResponseEntity<List<RandomNumber>> result = restTemplate.exchange(balanceUrl, HttpMethod.GET, requestEntity,
                new ParameterizedTypeReference<List<RandomNumber>>() {
                });

        LOGGER.debug("Getting result for Random service from BALANCE: " + result.getBody());

        return result.getBody().get(0).getRandom().floatValue();
    }
}
