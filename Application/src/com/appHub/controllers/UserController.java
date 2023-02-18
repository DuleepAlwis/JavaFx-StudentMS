package com.appHub.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import com.appHub.ServiceImpl.UserServiceImpl;
import com.appHub.entity.UserEntity;
import com.appHub.enums.Role;
import com.appHub.util.ResponseMessage;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class UserController implements Initializable {

	@FXML
	private Button cancelBtn;

	@FXML
	private TextField emailTxt;

	@FXML
	private TextField mobileTxt;

	@FXML
    private PasswordField passwordTxt;

	@FXML
	private ComboBox<?> roleCombo;

	@FXML
	private Button saveBtn;

	@FXML
	private TextField usernameTxt;

	@FXML
	private Label responseLbl;
	
	 @FXML
	    private Button backBtn;

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		ArrayList roles = new ArrayList();
		roles.add(Role.ADMIN.getRole());
		roles.add(Role.STUDENT.getRole());
		roles.add(Role.TUTOR.getRole());
		roleCombo.getItems().addAll(roles);
	}

	@FXML
	public void saveInfo(ActionEvent event) {
		UserEntity ue = new UserEntity();
		UserServiceImpl userService = new UserServiceImpl();
		String username = usernameTxt.getText();
		String password = passwordTxt.getText();
		String email = emailTxt.getText();
		String mobile = mobileTxt.getText();
		String role = (String) roleCombo.getValue();
		
		//Email validation check
		int i = email.indexOf('@');
		int j = email.indexOf('.');
		if(i>=j) {
			responseLbl.setText("Email is not valid");
			return;
		}
		if(email.contains(",/.<>!#%^&()_-+?")) {
			responseLbl.setText("Email is not valid");
			return;
		}
		if(mobile.length()!=10) {
			responseLbl.setText("Mobile number is not valid");
			return;
		}
		
		if(role.equals(Role.ADMIN.getRole())) {
			ue.setRole(Role.ADMIN);
		}else if(role.equals(Role.STUDENT.getRole())){
			ue.setRole(Role.STUDENT);
		}else if(role.equals(Role.TUTOR.getRole())){
			ue.setRole(Role.TUTOR);
		}
		ue.setUsername(username);
		ue.setEmail(email);
		ue.setPassword(password);
		ue.setMobile(mobile);
		
		if(username.length()>0 && password.length()>0 && email.length()>0) {
			if(userService.save(ue)) {
				responseLbl.setText(ResponseMessage.USER_SAVE_SUCCESS);
			}else {
				responseLbl.setText(ResponseMessage.USER_EXISTS);
			}
		}else {
			responseLbl.setText(ResponseMessage.FIELDS_ARE_MANDATORY);
			return;
		}
		
	}
	
	 @FXML
	 public void clearAll(ActionEvent event) {
		 
		 usernameTxt.setText("");
		 passwordTxt.setText("");
		 emailTxt.setText("");
		 mobileTxt.setText("");
		 responseLbl.setText("");
	 }
	 
	 @FXML
	 public void backBtnClicked() {
		 backBtn.getScene().getWindow().hide();
			Stage primaryStage = new Stage();
			Parent root;
			try {
				root = FXMLLoader.load(getClass().getResource("/com/appHub/views/AdminPanel.fxml"));
				Scene scene = new Scene(root,700,400);		
				primaryStage.setScene(scene);
				primaryStage.show();
				primaryStage.setResizable(true);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
				e.printStackTrace();
			}
			
	 }

}
