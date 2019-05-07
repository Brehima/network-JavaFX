/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.redhats.network.networkClient.javafx.admin;

import com.jfoenix.controls.JFXButton;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javax.naming.NamingException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import networkClient.main.main;
import tn.redhats.network.networkServer.entities.EnterpriseProfile;
import tn.redhats.network.networkServer.entities.User;

/**
 * FXML Controller class
 *
 * @author lenovo
 */
public class AdminShowEnterpriseDetailsController implements Initializable {

    @FXML
    private AnchorPane anchorPaneID;
    @FXML
    private JFXButton backButton;
    @FXML
    private Label introductionValue;
    @FXML
    private Label jobFieldValue;
    @FXML
    private Label websiteValue;
    @FXML
    private Label employeesNumberValue;
    @FXML
    private ImageView logoImageView;
    @FXML
    private TableView<User> table;
    @FXML
    private TableColumn<User, String> firstNameColumn;
    @FXML
    private TableColumn<User, String> lastNameColumn;
    @FXML
    private TableColumn<User, String> emailColumn;
    @FXML
    private TableColumn<User, String> usernameColumn;
    @FXML
    private TableColumn<User, String> roleColumn;
    @FXML
    private Label enterpriseNameValue;
    @FXML
    private ListView<String> locationsListView;

    /**
     * Initializes the controller class.
     */
    private List<String> locations = new ArrayList<String>();
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    	
    	
    	for (String location : ManageEnterprisesProfilesController.staticEp.getLocations()) {
    		locations.add(location);
    	}
    	ObservableList<String> cl = FXCollections.observableArrayList(locations);
    	locationsListView.setItems(cl);
    	
    	
    	
    	enterpriseNameValue.setText(ManageEnterprisesProfilesController.staticEp.getEnterpriseName());
    	introductionValue.setText(ManageEnterprisesProfilesController.staticEp.getIntroduction());
    	jobFieldValue.setText(ManageEnterprisesProfilesController.staticEp.getJobField());
    	websiteValue.setText(ManageEnterprisesProfilesController.staticEp.getWebsite());
    	employeesNumberValue.setText(ManageEnterprisesProfilesController.staticEp.getEmployeesNumber());
    	try {
    		File image = new File(main.getEnterpriseProfileProxy().findEnterpriseById(ManageEnterprisesProfilesController.staticEp.getId()).getPhoto());
			logoImageView.setImage(new Image(image.toURI().toString()));
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	

    	
    	ObservableList<User> users = FXCollections.observableArrayList();
    	
		try {
			for(User user : main.getEnterpriseProfileProxy().EnterpriseProfileUsers(ManageEnterprisesProfilesController.staticEp.getId())) {
				users.add(user);
				firstNameColumn.setCellValueFactory(new PropertyValueFactory<User, String>("firstName"));
				lastNameColumn.setCellValueFactory(new PropertyValueFactory<User, String>("lastName"));
				emailColumn.setCellValueFactory(new PropertyValueFactory<User, String>("email"));
				usernameColumn.setCellValueFactory(new PropertyValueFactory<User, String>("username"));
				roleColumn.setCellValueFactory(new PropertyValueFactory<User, String>("role"));
				}
		} catch (NamingException e) {

			e.printStackTrace();
		}
	
	
	table.setItems(users);
    	
 
    	
    }    

    @FXML
    private void clicBack(ActionEvent event) throws IOException {
    	FXMLLoader loader=new FXMLLoader(getClass().getResource("/fxml/ManageEnterprisesProfiles.fxml")); 
        Parent root=loader.load();
        Scene s = anchorPaneID.getScene(); 
        s.setRoot(root);
    }
    
}
