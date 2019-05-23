/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.redhats.network.networkClient.javafx.admin;

import com.jfoenix.controls.JFXButton;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import tn.redhats.network.networkClient.javafx.login.SigninController;

/**
 * FXML Controller class
 *
 * @author lenovo
 */
public class AdminDashboardController implements Initializable {

    @FXML
    private AnchorPane anchorPaneID;
    @FXML
    private JFXButton buttonManageEnterprises;
    @FXML
    private JFXButton signOutButton;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void clicManageEnterprises(ActionEvent event) throws IOException {
    	FXMLLoader loader=new FXMLLoader(getClass().getResource("/fxml/ManageEnterprisesProfiles.fxml")); 
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
