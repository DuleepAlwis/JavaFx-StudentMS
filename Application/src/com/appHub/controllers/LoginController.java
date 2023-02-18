package com.appHub.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import com.appHub.ServiceImpl.UserServiceImpl;
import com.appHub.entity.UserEntity;
import com.appHub.enums.Role;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.Window;

public class LoginController implements Initializable {

	@FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button cancelBtn;

    @FXML
    private TextField emailTxt;

    @FXML
    private Button loginBtn;

    @FXML
    private PasswordField passwordTxt;
    
    @FXML
    private Hyperlink forgotPasswordLink;
    
    @FXML
    private Label errorLbl;
    
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
	
	@FXML
	public void loginBtnClicked(ActionEvent e) {
		UserServiceImpl us = new UserServiceImpl();
		/*
		 * UserEntity demo = new UserEntity(); demo.setEmail("user1@gmail.com");
		 * demo.setUsername("user1"); demo.setMobile("0712365478");
		 * demo.setPassword("user1"); demo.setRole(Role.ADMIN); us.save(demo);
		 */
		UserEntity ue = us.login(emailTxt.getText(), passwordTxt.getText());
		if(ue!=null) {
			if(ue.getRole()==Role.ADMIN) {
				try {
					loginBtn.getScene().getWindow().hide();
					Stage primaryStage = new Stage();
					Parent root = FXMLLoader.load(getClass().getResource("/com/appHub/views/AdminPanel.fxml"));
					Scene scene = new Scene(root,700,400);		
					primaryStage.setScene(scene);
					primaryStage.show();
					primaryStage.setResizable(true);

				} catch(Exception ex) {
					System.out.println(ex.getMessage());
					
				}
			}
		}else {
			errorLbl.setText("Wrong credentials, please check them");
		}
		
	}
	
	@FXML
	public void cancelBtnClicked(ActionEvent e) {
		emailTxt.setText("");
		passwordTxt.setText("");
		errorLbl.setText("");
		
	}

}
