package com.everis.eva.demoBanca.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.everis.eva.demoBanca.service.bank.IBankService;
import com.everis.eva.demoBanca.service.bank.IIbexService;

@RestController
@RequestMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
public class SaldoController {
    private static Logger LOGGER = LoggerFactory.getLogger(SaldoController.class);

    @Autowired
    private IBankService bankService;

    @Autowired
    private IIbexService ibexService;

    @RequestMapping(method = RequestMethod.GET, value = "/balance/account")
    public Float getBalanceAccount() {
        LOGGER.info("Getting Balance");
        return bankService.queryBalanceFromAccount();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/ibex/value/")
    public Float getIbex() {
        LOGGER.info("Getting Ibex35");
        return ibexService.queryBalanceFromAccount();
    }

}
