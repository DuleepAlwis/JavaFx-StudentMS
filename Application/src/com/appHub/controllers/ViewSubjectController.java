package com.appHub.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.appHub.ServiceImpl.SubjectServiceImpl;
import com.appHub.ServiceImpl.UserServiceImpl;
import com.appHub.entity.SubjectEntity;
import com.appHub.entity.UserEntity;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class ViewSubjectController implements Initializable{

	private final static Logger logger = Logger.getLogger(ViewSubjectController.class.getName());

	@FXML
    private Button backBtn;

    @FXML
    private Button newSubjectBtn;
    
    @FXML
    private AnchorPane anchorPane;

    @FXML
    void backAdminPanel(ActionEvent event) {
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
			logger.log(Level.SEVERE, e.getMessage());
			e.printStackTrace();
		}
    }

    @FXML
    void createNewSubject(ActionEvent event) {

    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
        List<SubjectEntity> subjects = new ArrayList<>();
		
		SubjectServiceImpl ss = new SubjectServiceImpl();
		
		subjects = ss.getAll();
		
		// New Table View
		 TableView tbv = new TableView();
		 // Create two columns 
		 TableColumn cl1 = new TableColumn<>("Subject Name");
		 cl1.setCellValueFactory(new PropertyValueFactory<>("name"));
		 TableColumn cl2 = new TableColumn<>("Credits");
		 cl2.setCellValueFactory(new PropertyValueFactory<>("credits"));
		 TableColumn cl3 = new TableColumn<>("Academic Year");
		 cl3.setCellValueFactory(new PropertyValueFactory<>("academicYear"));
		 TableColumn cl4 = new TableColumn<>("Semester");
		 cl4.setCellValueFactory(new PropertyValueFactory<>("semester"));
		 TableColumn cl5 = new TableColumn<>("Degree");
		 cl5.setCellValueFactory(new PropertyValueFactory<>("degree"));
		 // Add two columns into TableView
		 tbv.getColumns().add(cl1);
		 tbv.getColumns().add(cl2);
		 tbv.getColumns().add(cl3);
		 tbv.getColumns().add(cl4);
		 tbv.getColumns().add(cl5);

		 for(SubjectEntity se:subjects) {
			 tbv.getItems().add(se);
		 }
		 
		 tbv.setMinSize(500, 350);
		 anchorPane.getChildren().addAll(tbv);
		
	}

}
