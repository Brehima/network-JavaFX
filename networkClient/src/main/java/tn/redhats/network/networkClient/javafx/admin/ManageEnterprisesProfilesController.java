/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.redhats.network.networkClient.javafx.admin;

import com.jfoenix.controls.JFXButton;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

import javax.naming.NamingException;

import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import networkClient.main.main;
import tn.redhats.network.networkServer.entities.EnterpriseProfile;
import tn.redhats.network.networkServer.services_impl.EnterpriseService;

/**
 * FXML Controller class
 *
 * @author lenovo
 */
public class ManageEnterprisesProfilesController implements Initializable {
	
	
	
	
	
	
    @FXML
    private AnchorPane anchorPaneID;
    @FXML 
    private TableView<EnterpriseProfile> table;
    @FXML
    private TableColumn<EnterpriseProfile, String> nameColumn;
    @FXML
    private TableColumn<EnterpriseProfile, String> jobFieldColumn;
    @FXML
    private TableColumn<EnterpriseProfile, String> websiteColumn;
    @FXML
    private TableColumn<EnterpriseProfile, Integer> employeesNumberColumn;
    
    @FXML
    private JFXButton detailsButton;
    @FXML
    private JFXButton backButton;
    
    public static EnterpriseProfile staticEp;
    @FXML
    private JFXButton deleteButton;
	
	
	
	
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    	
    	
    	
    	ObservableList<EnterpriseProfile> profiles = FXCollections.observableArrayList();
    	
    		try {
				for(EnterpriseProfile ep : main.getEnterpriseProfileProxy().findAllEnterprises()) {
					profiles.add(ep);
					nameColumn.setCellValueFactory(new PropertyValueFactory<EnterpriseProfile, String>("enterpriseName"));
					jobFieldColumn.setCellValueFactory(new PropertyValueFactory<EnterpriseProfile, String>("JobField"));
					websiteColumn.setCellValueFactory(new PropertyValueFactory<EnterpriseProfile, String>("website"));
					employeesNumberColumn.setCellValueFactory(new PropertyValueFactory<EnterpriseProfile, Integer>("EmployeesNumber"));
					}
			} catch (NamingException e) {

				e.printStackTrace();
			}
		
    	
    	table.setItems(profiles);


    	
    }

    @FXML
    private void clicDetails(ActionEvent event) throws IOException {
    	
    	staticEp = table.getSelectionModel().getSelectedItem();
    	FXMLLoader loader=new FXMLLoader(getClass().getResource("/fxml/adminShowEnterpriseDetails.fxml")); 
        Parent root=loader.load();
        Scene s = anchorPaneID.getScene(); 
        s.setRoot(root);
    	
    }

    @FXML
    private void clicBack(ActionEvent event) throws IOException {
    	FXMLLoader loader=new FXMLLoader(getClass().getResource("/fxml/adminDashboard.fxml")); 
        Parent root=loader.load();
        Scene s = anchorPaneID.getScene(); 
        s.setRoot(root);
    	
    }

    @FXML
    private void clicDelete(ActionEvent event) throws NamingException, IOException {
    	
    	Alert alerte = new Alert(Alert.AlertType.CONFIRMATION);
        alerte.setTitle("Confirmation dialog");
        alerte.setHeaderText("Be careful ! ");
        alerte.setContentText("Do you really want to delete this profile ?");
        
        Optional<ButtonType> result = alerte.showAndWait();
        if (result.get() == ButtonType.OK)
        {
        	staticEp = table.getSelectionModel().getSelectedItem();
            main.getEnterpriseProfileProxy().removeEnterprise(staticEp);           
        }else{
            
        }
        
        FXMLLoader loader=new FXMLLoader(getClass().getResource("/fxml/ManageEnterprisesProfiles.fxml")); 
        Parent root=loader.load();
        Scene s = anchorPaneID.getScene(); 
        s.setRoot(root);
 
    }
    
    
    
}
