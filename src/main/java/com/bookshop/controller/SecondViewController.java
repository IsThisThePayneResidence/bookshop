package com.bookshop.controller;

import com.bookshop.domain.MessageModel;
import com.bookshop.gui.ViewConfig;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import org.springframework.beans.factory.annotation.Autowired;

public class SecondViewController extends ViewController {

	public SecondViewController(ViewConfig config) {
		super(config);
	}
	
	@Autowired
	private MessageModel model;
	
	@FXML
	TextField messageTf;
	
	@FXML
	void initialize() {
		messageTf.setText(model.getMessage());
		
		model.addObserver((o, arg) -> messageTf.setText(model.getMessage()));
	}
	
	@FXML 
	void onApply(ActionEvent event){
		model.setMessage(messageTf.getText());
	}
	
	@FXML
	void prevView(ActionEvent event){
		config.loadMain();
	}
	
	@FXML 
	void openPopup(ActionEvent event){
		config.loadPopup();
	}
	

}
