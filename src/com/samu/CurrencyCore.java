package com.samu;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.awt.Dimension;

import com.samu.myObjects.ApiConverter;
import com.samu.utility.ComboBoxUtility;

public class CurrencyCore extends Application{

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		 //initialize the converter
		 ApiConverter converter = new ApiConverter();
		
		 //title
		 primaryStage.setTitle("Currrency converter!");
		 
		 //setting window dimensions
		 Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		 double width = screenSize.getWidth();
		 double height = screenSize.getHeight();
		 
		 //create window
		 GridPane grid = new GridPane();
		 grid.setAlignment(Pos.TOP_CENTER);
		 grid.setHgap(width/80);
		 grid.setVgap(width/100);
		 double paddingDimension = height/45;
		 grid.setPadding(new Insets(paddingDimension,paddingDimension,paddingDimension,paddingDimension));
	     primaryStage.setScene(new Scene(grid, (width/4), (height/2.2)));
	     
	     //create input for inserting values
	     Label labelInput = new Label("Insert the value you want to convert:");
	     grid.add(labelInput, 0, 1);
	     
	     TextField inputTextfield = new TextField();
	     grid.add(inputTextfield, 1, 1);
	     
	     //create box with currencies -- FROM
	     Label labelCurrenciesFrom = new Label("Choose the currency you want to convert from:");
	     grid.add(labelCurrenciesFrom, 0, 2);
	     ComboBox<String> currenciesBoxFrom = ComboBoxUtility.createCurrencyCombo();
	     grid.add(currenciesBoxFrom, 1, 2);
	     
	     //create box with currencies -- TO
	     Label labelCurrenciesTo = new Label("Choose the currency you want to convert to:");
	     grid.add(labelCurrenciesTo, 0, 3);
	     ComboBox<String> currenciesBoxTo = ComboBoxUtility.createCurrencyCombo();
	     grid.add(currenciesBoxTo, 1, 3);
	     
	     //create submit button
	     Button submit = new Button("convert !");
	     grid.add(submit, 0, 4);
	     
	     //show results
	     
	     //show window
	     primaryStage.show();
	}

}
