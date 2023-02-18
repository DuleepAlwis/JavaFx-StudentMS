package com.appHub.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import com.appHub.enums.Degree;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class SubjectController implements Initializable {

	  @FXML
	    private TextField academicYTxt;

	    @FXML
	    private Button backBtn;

	    @FXML
	    private Button cancelBtn;

	    @FXML
	    private Spinner<?> creditsSpinner;

	    @FXML
	    private ComboBox<?> degreeCombo;

	    @FXML
	    private Label responseLbl;

	    @FXML
	    private Button saveBtn;

	    @FXML
	    private Spinner<?> semesterSpinner;

	    @FXML
	    private TextField subNameTxt;
	    
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		ArrayList degrees = new ArrayList<>();
		degrees.add(Degree.COMPUTER_SCIENCE.getDegree());
		degrees.add(Degree.INFORMATION_SYSTEMS.getDegree());
		degreeCombo.getItems().addAll(degrees);
		
		SpinnerValueFactory spinnerCreVals = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 10,3);
		creditsSpinner.setValueFactory(spinnerCreVals);
		
		SpinnerValueFactory spinnerSemVals = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 3,1);
		semesterSpinner.setValueFactory(spinnerSemVals);
		
	}
	
	@FXML
    void backBtnClicked(ActionEvent event) {
		backBtn.getScene().getWindow().hide();
		Stage primaryStage = new Stage();
		Parent root;
		try {
			root = FXMLLoader.load(getClass().getResource("/com/appHub/views/AdminPanel.fxml"));
			Scene scene = new Scene(root,700,500);		
			primaryStage.setScene(scene);
			primaryStage.show();
			primaryStage.setResizable(true);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
    }

    @FXML
    void clearAll(ActionEvent event) {

    }

   
    void saveInfo(ActionEvent event) {
    	
    	
    }

}
