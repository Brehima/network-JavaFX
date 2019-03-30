/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.redhats.network.networkClient.javafx.candidateProfile;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.jfoenix.controls.JFXTextField;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import networkClient.main.candidateFXMain;
import tn.redhats.network.networkServer.entities.Code2FACandidate;
import tn.redhats.network.networkServer.enumeration.AccountStatus;
import tn.redhats.network.networkServer.services.CandidatProfilServiceRemote;

/**
 * FXML Controller class
 *
 * @author Coulibaly
 */
public class SignIn_2_fxmlController implements Initializable {

    /**
     * Initializes the controller class.
     */
	@FXML
	JFXTextField signUpCode;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    
    public void goToSignIn1()
    {
   	 Parent root;
   		try {
   			root = FXMLLoader.load(getClass().getResource("/tn/redhats/network/networkClient/javafx/candidateProfile/signIN_fxml.fxml"));
   			 Scene scene = new Scene(root);
   		      
   		        candidateFXMain.stage.setScene(scene);
   		        candidateFXMain.stage.setIconified(false);
   		       
   		       candidateFXMain.stage.show();
   		} catch (IOException e) {
   			// TODO Auto-generated catch block
   			e.printStackTrace();
   		}
       
    }
    public void verifyUserCode()
    {
    	 String jndiName1="networkServer-ear/networkServer-ejb/CandidatProfilService!tn.redhats.network.networkServer.services.CandidatProfilServiceRemote";
			Context context;
			try {
				context = new InitialContext();
				CandidatProfilServiceRemote proxy = (CandidatProfilServiceRemote) context.lookup(jndiName1);
				//Code2FACandidate code = proxy.findCode(SignIn_fxmlController.userConnected.getId());
			    if(SignIn_fxmlController.generatedCode.equals(signUpCode.getText()))
			      {
			    	SignIn_fxmlController.userConnected.setLoginAttempts(0);
			    	proxy.updateUser(SignIn_fxmlController.userConnected);
			    	System.out.println("you are logged in");
			    	goToProfilePage();
			      }
				
			} catch (NamingException e) {
				
				e.printStackTrace();
			}
    }
    public void goToProfilePage()
    {
   	 Parent root;
   		try {
   			root = FXMLLoader.load(getClass().getResource("/tn/redhats/network/networkClient/javafx/candidateProfile/profilePage.fxml"));
   			 Scene scene = new Scene(root);
   		      
   		        candidateFXMain.stage.setScene(scene);
   		        candidateFXMain.stage.setIconified(false);
   		       
   		       candidateFXMain.stage.show();
   		} catch (IOException e) {
   			// TODO Auto-generated catch block
   			e.printStackTrace();
   		}
       
    }
}
