package com.samu.utility;

import javafx.collections.FXCollections;
import javafx.scene.control.ComboBox;

import java.util.ArrayList;
import java.util.List;

import com.posadskiy.currencyconverter.enums.Currency;

public class ComboBoxUtility {
	
	public ComboBoxUtility() {}

	public static ComboBox<String> createCurrencyCombo() {
		
		Currency[] currenciesList = Currency.values();
		
		List<String> currencies = new ArrayList<String>(); 
		
		for(Currency c : currenciesList) {
			currencies.add(c.toString());
		}
		
		ComboBox<String> comboBox = new ComboBox<String>(FXCollections.observableArrayList(currencies));
		
		return comboBox;
	}
	
}
