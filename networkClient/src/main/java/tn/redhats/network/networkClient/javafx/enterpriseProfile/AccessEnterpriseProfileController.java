/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.redhats.network.networkClient.javafx.enterpriseProfile;

import com.jfoenix.controls.JFXButton;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javax.naming.NamingException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import networkClient.main.main;
import tn.redhats.network.networkClient.javafx.admin.ManageEnterprisesProfilesController;
import tn.redhats.network.networkClient.javafx.login.SigninController;
import tn.redhats.network.networkServer.enumeration.Role;

/**
 * FXML Controller class
 *
 * @author lenovo
 */
public class AccessEnterpriseProfileController implements Initializable {

    @FXML
    private AnchorPane anchorPaneID;
    @FXML
    private ImageView logo;
    @FXML
    private Label EnterpriseName;
    @FXML
    private JFXButton ManageProfileButton;
    @FXML
    private JFXButton eventsButton;
    @FXML
    private JFXButton signoutButton;
    @FXML
    private ImageView manageImageView;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    	EnterpriseName.setText(SigninController.staticEP.getEnterpriseName());
    	
    	if(SigninController.connectedUser.getRole().equals(Role.EnterpriseAdministrator)) {
    		manageImageView.setOpacity(1);
    		ManageProfileButton.setOpacity(1);
    	}else {
    		manageImageView.setOpacity(0);
    		ManageProfileButton.setOpacity(0);
    	}
    	
    	try {
    		File image = new File(main.getEnterpriseProfileProxy().findEnterpriseById(SigninController.staticEP.getId()).getPhoto());
			logo.setImage(new Image(image.toURI().toString()));
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	
    }    

    @FXML
    private void clicManageProfile(ActionEvent event) throws IOException {
    	FXMLLoader loader=new FXMLLoader(getClass().getResource("/fxml/manageProfile.fxml")); 
        Parent root=loader.load();
        Scene s = anchorPaneID.getScene(); 
        s.setRoot(root);
    }

    private void clicJobOffers(ActionEvent event) throws IOException {
    	FXMLLoader loader=new FXMLLoader(getClass().getResource("/fxml/jobOffers.fxml")); 
        Parent root=loader.load();
        Scene s = anchorPaneID.getScene(); 
        s.setRoot(root);
    }

    @FXML
    private void clicEvents(ActionEvent event) throws IOException {
    	FXMLLoader loader=new FXMLLoader(getClass().getResource("/fxml/createEvent.fxml")); 
        Parent root=loader.load();
        Scene s = anchorPaneID.getScene(); 
        s.setRoot(root);
    }

    @FXML
    private void clicSignOut(ActionEvent event) throws IOException {
    	SigninController.connectedUser = null;
    	SigninController.staticEP = null;
    	FXMLLoader loader=new FXMLLoader(getClass().getResource("/fxml/signin.fxml")); 
        Parent root=loader.load();
        Scene s = anchorPaneID.getScene(); 
        s.setRoot(root);
    }
    
}
