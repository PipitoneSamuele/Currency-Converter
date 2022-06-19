package com.samu.utility;

import javafx.collections.FXCollections;
import javafx.scene.control.ComboBox;

public class ComboBoxUtility {

	public static ComboBox<String> createCurrencyCombo() {
		
		String[] currencies = {"", "EUR", "USD", "JPY", "GBP", "AUD", "CHF", "KRW"};
		ComboBox<String> comboBox = new ComboBox<String>(FXCollections.observableArrayList(currencies));
		
		return comboBox;
	}
	
}
