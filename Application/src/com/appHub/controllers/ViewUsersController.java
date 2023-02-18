package com.appHub.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.appHub.ServiceImpl.UserServiceImpl;
import com.appHub.daoImpl.UserDAOImpl;
import com.appHub.entity.UserEntity;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ViewUsersController implements Initializable {

	private final static Logger logger = Logger.getLogger(ViewUsersController.class.getName());

	@FXML
    private Button backBtn;

	 @FXML
	    private AnchorPane anchorPane;
	  
	@FXML
    private Button newUserBtn;

	@FXML
    private TableView<?> tblView;
    
    @FXML
    private TableColumn<?, ?> tbEmail;

    @FXML
    private TableColumn<?, ?> tbId;

    @FXML
    private TableColumn<?, ?> tbMobile;

    @FXML
    private TableColumn<?, ?> tbRole;

    @FXML
    private TableColumn<?, ?> tbUserName;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		List<UserEntity> users = new ArrayList<>();
		
		UserServiceImpl us = new UserServiceImpl();
		
		users = us.getAllUsers();
		
		// New Table View
		 TableView tbv = new TableView();
		 // Create two columns 
		 TableColumn cl1 = new TableColumn<>("User Name");
		 cl1.setCellValueFactory(new PropertyValueFactory<>("username"));
		 TableColumn cl2 = new TableColumn<>("Email");
		 cl2.setCellValueFactory(new PropertyValueFactory<>("email"));
		 TableColumn cl3 = new TableColumn<>("Mobile");
		 cl3.setCellValueFactory(new PropertyValueFactory<>("mobile"));
		 TableColumn cl4 = new TableColumn<>("Role");
		 cl4.setCellValueFactory(new PropertyValueFactory<>("role"));
		 // Add two columns into TableView
		 tbv.getColumns().add(cl1);
		 tbv.getColumns().add(cl2);
		 tbv.getColumns().add(cl3);
		 tbv.getColumns().add(cl4);
		 
		 for(UserEntity ue:users) {
			 tbv.getItems().add(ue);
		 }
		 
		 tbv.setMinSize(500, 350);
		 anchorPane.getChildren().addAll(tbv);
		
	}
    
    @FXML
    public void createNewUserLoad() {
    	newUserBtn.getScene().getWindow().hide();
		Stage primaryStage = new Stage();
		Parent root;
		try {
			root = FXMLLoader.load(getClass().getResource("/com/appHub/views/CreateUser.fxml"));
			Scene scene = new Scene(root,700,500);		
			primaryStage.setScene(scene);
			primaryStage.show();
			primaryStage.setResizable(true);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			logger.log(Level.SEVERE, e.getMessage());
			e.printStackTrace();
		}
    }
    
    @FXML
    void redirectToMenu(ActionEvent event) {
    	newUserBtn.getScene().getWindow().hide();
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
			logger.log(Level.SEVERE, e.getMessage());
			e.printStackTrace();
		}
    }
}
