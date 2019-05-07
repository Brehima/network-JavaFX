/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.redhats.network.networkClient.javafx.login;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author lenovo
 */
public class TwoFactorAuthenticationController implements Initializable {

    @FXML
    private JFXButton backButton;
    @FXML
    private JFXTextField codeTextField;
    @FXML
    private JFXButton validateButton;
    @FXML
    private AnchorPane anchorPaneID;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    	codeTextField.setStyle("-fx-text-inner-color: white;");
    }    

    @FXML
    private void clicBackButton(ActionEvent event) throws IOException {
    	FXMLLoader loader=new FXMLLoader(getClass().getResource("/fxml/signin.fxml")); 
        Parent root=loader.load();
        Scene s = anchorPaneID.getScene(); 
        s.setRoot(root);
    }

    @FXML
    private void clicValidate(ActionEvent event) throws IOException {
    	
    	if(SigninController.generatedCode.equals(codeTextField.getText())) {
    		FXMLLoader loader=new FXMLLoader(getClass().getResource("/fxml/accessEnterpriseProfile.fxml")); 
            Parent root=loader.load();
            Scene s = anchorPaneID.getScene(); 
            s.setRoot(root);
    	}else {
    		Alert alerte2 = new Alert(Alert.AlertType.WARNING);
            alerte2.setTitle("Warning dialog");
            alerte2.setHeaderText("Wrong code ! ");
            alerte2.setContentText("Please check the sent code ...");
            
            Optional<ButtonType> result2 = alerte2.showAndWait();
            if (result2.get() == ButtonType.OK){
            	
            }
    	}
    	
    }
    
}
