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
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.awt.Dimension;

import com.samu.utility.UtilityJavaFxElements;
import com.samu.objects.ApiConverter;
import com.samu.utility.FormatUtility;

public class CurrencyCore extends Application{

	public static void main(String[] args) {
		launch(args);
	}

	//TODO - learn how to style it
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		 //initialize the converter
		 ApiConverter converter = new ApiConverter();
		
		 //title
		 primaryStage.setTitle("Currrency converter");
		 
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
		 
		 //scene style
		 Scene scene = new Scene(grid, (width/4), (height/3));
		 scene.getStylesheets().add(getClass().getResource("styles/stylesheet.css").toExternalForm());
	     primaryStage.setScene(scene);
	     
	     //create input for inserting values
	     Label labelInput = new Label("Insert the value you want to convert:");
	     grid.add(labelInput, 0, 1);
	     
	     TextField inputTextField = new TextField();
	     grid.add(inputTextField, 1, 1);
	     
	     //create box with currencies -- FROM
	     Label labelCurrenciesFrom = new Label("Choose the currency you want to convert from:");
	     grid.add(labelCurrenciesFrom, 0, 2);
	     ComboBox<String> currenciesBoxFrom = UtilityJavaFxElements.createCurrencyCombo();
	     grid.add(currenciesBoxFrom, 1, 2);
	     
	     //create box with currencies 
	     Label labelCurrenciesTo = new Label("Choose the currency you want to convert to:");
	     grid.add(labelCurrenciesTo, 0, 3);
	     ComboBox<String> currenciesBoxTo = UtilityJavaFxElements.createCurrencyCombo();
	     grid.add(currenciesBoxTo, 1, 3);
	     
	     //create submit button
	     Button submit = new Button("convert");
	     grid.add(submit, 0, 4);
	     
	     //add event to submit button 
	     submit.setOnAction(e -> {
	    	 String textResult;
	    	 if(FormatUtility.isNumeric(inputTextField.getText())) { //check if the value is numeric
	    		if(currenciesBoxFrom.getValue().length() <= 1 || currenciesBoxTo.getValue().length() <= 1) { //check if the two input boxes are not empty
	    			textResult = "Please insert a currency";
	    		} else {
	    			textResult = 
		    				"The value you have inserted is: " + inputTextField.getText() + 
		    				"\n\nFrom currency " + currenciesBoxFrom.getValue() + " to currency " + currenciesBoxTo.getValue() + 
		    				"\n\nThe result is : " + 
		    				FormatUtility.round(converter.convert(currenciesBoxFrom.getValue(), currenciesBoxTo.getValue()) * Double.parseDouble(inputTextField.getText()), 2)
		    				+ " " + currenciesBoxTo.getValue();
	    		}
	    	 } else {
	    		 textResult = "You must insert a number in the form";
	    	 }
	    	 	//show results
	    	 	Text result = new Text(textResult);
	    	 	grid.getChildren().removeIf(node -> GridPane.getColumnIndex(node) == 0 && GridPane.getRowIndex(node) == 6); //remove redundant data
	    	 	grid.add(result, 0, 6);
	     });
	     
	     //show window
	     primaryStage.show();
	}

}
