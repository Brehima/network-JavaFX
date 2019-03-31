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

import org.mindrot.jbcrypt.BCrypt;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import networkClient.main.candidateFXMain;
import networkClient.main.main;
import tn.redhats.network.networkServer.entities.Code2FACandidate;
import tn.redhats.network.networkServer.entities.User;
import tn.redhats.network.networkServer.services.CandidatProfilServiceRemote;

/**
 * FXML Controller class
 *
 * @author Coulibaly
 */
public class SignIn_fxmlController implements Initializable {

    /**
     * Initializes the controller class.
     */
	@FXML
	private JFXTextField userID;
	@FXML
	private JFXPasswordField userpass;
	public static User userConnected;
	public static String generatedCode;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    	userConnected = new User();
    	
        // TODO
    }    
    
    public void login()
    {
    	String id = userID.getText();
 
		  String jndiName1="networkServer-ear/networkServer-ejb/CandidatProfilService!tn.redhats.network.networkServer.services.CandidatProfilServiceRemote";
			Context context;
			try {
				context = new InitialContext();
				CandidatProfilServiceRemote proxy = (CandidatProfilServiceRemote) context.lookup(jndiName1);
				User user =  proxy.signInStepOne(id);
				System.out.println("userConnectedLog1:"+user);
				if(user!=null)
				{
					if(user.getLoginAttempts() <= 3)
					{
						
						if(BCrypt.checkpw(userpass.getText(), user.getPassword()))
							{
								userConnected = user;
								
								generatedCode = SignUp_fxmlController.generateCode();
								//Code2FACandidate code = new Code2FACandidate();
								//code.setIdUser(userConnected.getId());
								//code.setCode(generatedCode);
								//proxy.addCode(code);
								SignUp_fxmlController.sendEmailBySSl(generatedCode, user.getEmail());
								
								loadStep2Code();
							}
						else
						{
							user.setLoginAttempts(user.getLoginAttempts()+1);
							proxy.updateUser(user);
							Alert alert = new Alert(AlertType.ERROR);
							alert.setTitle("Account ");
							alert.setHeaderText("Wrong username or password");
							alert.showAndWait();	
						
						}
					}
					else
					{
						if(BCrypt.checkpw(userpass.getText(), user.getPassword()))
						{
							userConnected = user;
							Alert alert = new Alert(AlertType.ERROR);
							alert.setTitle("Account ");
							alert.setHeaderText("Your account is blocked");
							alert.setContentText("please check your email to proceed your account activation!");
							alert.showAndWait();
							generatedCode = SignUp_fxmlController.generateCode();
							SignUp_fxmlController.sendEmailBySSl(generatedCode, user.getEmail());
							loadStep2Code();	
						}
						else
						{
							Alert alert = new Alert(AlertType.ERROR);
							alert.setTitle("Account ");
							alert.setHeaderText("Wrong username or password");
							alert.showAndWait();	
						}
						
					}
				}
				System.out.println(user);
			} catch (NamingException e) {
				
				e.printStackTrace();
			}
   
    }
    
@FXML	
    private void loadSignUp() {
    	 Parent root;
		try {
			root = FXMLLoader.load(getClass().getResource("/tn/redhats/network/networkClient/javafx/candidateProfile/signUp_fxml.fxml"));
			 Scene scene = new Scene(root);
		      
		        candidateFXMain.stage.setScene(scene);
		        candidateFXMain.stage.setIconified(false);
		       
		       candidateFXMain.stage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    
                 	
    }
    @FXML
    private void loadStep2Code()
    {
    	 Parent root;
 		try {
 			root = FXMLLoader.load(getClass().getResource("/tn/redhats/network/networkClient/javafx/candidateProfile/SignIn_2_fxml.fxml"));
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
