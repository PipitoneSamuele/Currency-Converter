package com.samu.myObjects;

import com.posadskiy.currencyconverter.CurrencyConverter;
import com.posadskiy.currencyconverter.config.ConfigBuilder;

public class ApiConverter {

	private final String CURRENCY_CONVERTER_API_KEY = "4b4d041fe8b176abf639";
	private CurrencyConverter converter;
	
	public ApiConverter() {
		this.converter = new CurrencyConverter(new ConfigBuilder()
				.currencyConverterApiApiKey(CURRENCY_CONVERTER_API_KEY)
				.build());
	}
	
	public Double convert(String from, String to) {
		return converter.rate(from, to);
	}
	
}
