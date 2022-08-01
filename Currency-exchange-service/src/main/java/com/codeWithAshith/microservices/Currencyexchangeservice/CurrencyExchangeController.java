package com.codeWithAshith.microservices.Currencyexchangeservice;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyExchangeController {

	@Autowired
	private Environment evironment;

	@Autowired
	private CurrencyExchangeRepository exchangeValueRepository;

	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public CurrencyExchange retrieveExchangeValue(@PathVariable String from, @PathVariable String to) {
		CurrencyExchange exchangeValue = exchangeValueRepository.findByFromAndTo(from, to);
		exchangeValue.setPort(evironment.getProperty("local.server.port"));
		return exchangeValue;
	}

	// Right click on project and choose run as -> run configuration
	// Rename the project by adding a suffix of 8000
	// Duplicate the configuration and rename with a suffix 8001
	// Switch to arguments tab and enter "-Dserver.port=8001" in VM arguments

}
