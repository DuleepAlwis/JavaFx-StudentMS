package com.appHub.controllers;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class AdminPanelController {

	
	@FXML
    private Label createPropLbl;

    @FXML
    private Label viewUserLbl;

    @FXML
    public void loadViewUser(MouseEvent event) {
    	createPropLbl.getScene().getWindow().hide();
		Stage primaryStage = new Stage();
		Parent root;
		try {
			root = FXMLLoader.load(getClass().getResource("/com/appHub/views/ViewUsers.fxml"));
			Scene scene = new Scene(root,700,600);		
			primaryStage.setScene(scene);
			primaryStage.show();
			primaryStage.setResizable(true);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

    }
    
    @FXML
    public void loadViewSubject(MouseEvent event) {
    	createPropLbl.getScene().getWindow().hide();
		Stage primaryStage = new Stage();
		Parent root;
		try {
			root = FXMLLoader.load(getClass().getResource("/com/appHub/views/ViewSubject.fxml"));
			Scene scene = new Scene(root,700,600);		
			primaryStage.setScene(scene);
			primaryStage.show();
			primaryStage.setResizable(true);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

    }
}
