/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.redhats.network.networkClient.javafx.login;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Optional;
import java.util.Properties;
import java.util.Random;
import java.util.ResourceBundle;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.naming.NamingException;
import javax.xml.bind.DatatypeConverter;

import org.mindrot.jbcrypt.BCrypt;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.AnchorPane;
import networkClient.main.main;
import tn.redhats.network.networkServer.entities.EnterpriseProfile;
import tn.redhats.network.networkServer.entities.User;
import tn.redhats.network.networkServer.enumeration.Role;

/**
 * FXML Controller class
 *
 * @author lenovo
 */
public class SigninController implements Initializable {

    @FXML
    private JFXButton signUpButton;
    @FXML
    private JFXPasswordField passwordField;
    @FXML
    private JFXCheckBox rememberMeCheckBox;
    @FXML
    private JFXButton loginButton;
    @FXML
    private JFXButton forgetPasswordButton;
    @FXML
    private JFXTextField EmailTextField;
    @FXML
    private AnchorPane anchorPaneID;
    
    public static User connectedUser;
    public static EnterpriseProfile staticEP;
    public static String generatedCode="";
    public static String recoveryCode="";
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    	EmailTextField.setStyle("-fx-text-inner-color: white;");
    	passwordField.setStyle("-fx-text-inner-color: white;");
    }    

    @FXML
    private void ClicSignUp(ActionEvent event) throws IOException {
    	
    	
    	FXMLLoader loader=new FXMLLoader(getClass().getResource("/fxml/ProfileType.fxml")); 
        Parent root=loader.load();
        Scene s = anchorPaneID.getScene(); 
        s.setRoot(root);
    	
    }
    
    
    public static String generateCode()
    {
    	  String alphabet= "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ123456789&é(-_@=)}{$*%^!:+~";
          String s = "";
          Random random = new Random();
       
          
          for (int i = 0; i < 10; i++) {
              char c = alphabet.charAt(random.nextInt(alphabet.length()));
              s+=c;
          }
           
         return s;
    }
    
    public static Boolean sendEmailBySSl(String code,String userEmail){
    	Properties properties = new Properties();
    	properties.put("mail.smtp.host","smtp.gmail.com");
    	properties.put("mail.smtp.socketFactory.port","465");
    	properties.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
    	properties.put("mail.smtp.auth","true");
    	properties.put("mail.smtp.port","465");
    	Session session = Session.getDefaultInstance(properties,new javax.mail.Authenticator() {
    		protected PasswordAuthentication getPasswordAuthentication() {
			  return new PasswordAuthentication("projectnetwork87@gmail.com", "netw@rKPr0jec7");	
			}
    	});
    	try {
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("projectnetwork87@gmail.com"));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(userEmail));
			message.setSubject("Network account Validation");
			message.setText(" your account validation code is:"+code+"\n\n\n\n Best regards, Network project");
			Transport.send(message);
			System.out.println(" code send is:"+code);
			return true;
		} catch (MessagingException e) {
			System.out.println("Can't send codes");
		}
    	return false;
    }
    
    public static String hashPassword(String pass){

    	String chaineHasher=BCrypt.hashpw(pass, BCrypt.gensalt());   	
    	return chaineHasher;
    }

    @FXML
    private void clicLogin(ActionEvent event) throws IOException, NamingException {
    	
    	connectedUser = main.getEnterpriseProfileProxy().signInStepOne(EmailTextField.getText());
    	
    	
    	if (connectedUser==null) {
    		Alert alerte = new Alert(Alert.AlertType.WARNING);
            alerte.setTitle("Warning dialog");
            alerte.setHeaderText("Sorry ! ");
            alerte.setContentText("Check username and password ...");
            alerte.showAndWait();
    	}else if(BCrypt.checkpw(passwordField.getText(), connectedUser.getPassword())==false) {
    		connectedUser.setLoginAttempts(connectedUser.getLoginAttempts()+1);
    		main.getEnterpriseProfileProxy().updateLoginAttempts(connectedUser.getId(), connectedUser.getLoginAttempts()) ;
    		if (connectedUser.getLoginAttempts() > 3) {
    			
    			main.getEnterpriseProfileProxy().updateAccountStatusToDisabled(connectedUser.getId());


    			Alert alerte = new Alert(Alert.AlertType.ERROR);
                alerte.setTitle("Error dialog");
                alerte.setHeaderText("Sorry ! ");
                alerte.setContentText("Your account has been disabled, do you want to reactivate it ?");
                Optional<ButtonType> result = alerte.showAndWait();
                if (result.get() == ButtonType.OK)
                {
                	
                	recoveryCode = generateCode();
            		sendEmailBySSl(recoveryCode, connectedUser.getEmail());
            		staticEP = main.getEnterpriseProfileProxy().findEnterpriseById(connectedUser.getProfile().getId());
            		FXMLLoader loader=new FXMLLoader(getClass().getResource("/fxml/recoverAccount.fxml")); 
                    Parent root=loader.load();
                    Scene s = anchorPaneID.getScene(); 
                    s.setRoot(root);
                	
                }else{
                    
                }
                
    			
    			
    			
    		}else {
    			Alert alerte = new Alert(Alert.AlertType.WARNING);
                alerte.setTitle("Warning dialog");
                alerte.setHeaderText("Sorry ! ");
                alerte.setContentText("Check username and password ...");
                alerte.showAndWait();
    		}
    		
            
    	}
    	else if(connectedUser.getRole()==Role.ApplicationAdministrator) {
    		FXMLLoader loader=new FXMLLoader(getClass().getResource("/fxml/adminDashboard.fxml")); 
            Parent root=loader.load();
            Scene s = anchorPaneID.getScene(); 
            s.setRoot(root);
    	}
    	else {
    		
    		generatedCode = generateCode();
    		sendEmailBySSl(generatedCode, connectedUser.getEmail());
    		staticEP = main.getEnterpriseProfileProxy().findEnterpriseById(connectedUser.getProfile().getId());
    		FXMLLoader loader=new FXMLLoader(getClass().getResource("/fxml/twoFactorAuthentication.fxml")); 
            Parent root=loader.load();
            Scene s = anchorPaneID.getScene(); 
            s.setRoot(root);
    	}
    	
    	
    }
    
    
    
}
