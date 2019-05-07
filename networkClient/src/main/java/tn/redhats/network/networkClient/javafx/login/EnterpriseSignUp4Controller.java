/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.redhats.network.networkClient.javafx.login;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.naming.NamingException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import networkClient.main.main;

/**
 * FXML Controller class
 *
 * @author lenovo
 */
public class EnterpriseSignUp4Controller implements Initializable {

    @FXML
    private JFXButton backButton;
    @FXML
    private AnchorPane anchorPaneID;
    @FXML
    private JFXTextField adminFristNameTextField;
    @FXML
    private JFXTextField adminLastNameTextField;
    @FXML
    private JFXTextField adminEmailTextField;
    @FXML
    private JFXPasswordField adminPasswordTextFirld;
    @FXML
    private JFXPasswordField adminRetypePasswordTextField;
    @FXML
    private JFXTextField adminUsernameTextField;
    @FXML
    private JFXButton nextButton;
    @FXML
    private Label firstNameLabel;
    @FXML
    private Label lastNameLabel;
    @FXML
    private Label emailLabel;
    @FXML
    private Label passwordLabel;
    @FXML
    private Label retypePasswordLabel;
    @FXML
    private Label usernameLabel;

    public static String staticFirstName="", staticLastName="", staticEmail="", staticPassword="", staticRetypePassword="", staticUsername="";
	public static int nextButtonOpacity = 0;
    public static final Pattern emailPattern =  Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
    public static final Pattern namePattern = Pattern.compile("^[a-zA-Z ]+$");
    
    private Boolean firstNameValidation = false, lastNameValidation = false, emailValidation = false, passwordValidation = false, reTypePasswordValidation = false, usernameValidation = false;
    
    private String tempEmail="";
    private String tempUsername="";

    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    	adminFristNameTextField.setText(staticFirstName);
    	adminLastNameTextField.setText(staticLastName);
    	adminEmailTextField.setText(staticEmail);
    	adminPasswordTextFirld.setText(staticPassword);
    	adminRetypePasswordTextField.setText(staticRetypePassword);
    	adminUsernameTextField.setText(staticUsername);
    	
    	adminFristNameTextField.setStyle("-fx-text-inner-color: white;");
    	adminLastNameTextField.setStyle("-fx-text-inner-color: white;");
    	adminEmailTextField.setStyle("-fx-text-inner-color: white;");
    	adminPasswordTextFirld.setStyle("-fx-text-inner-color: white;");
    	adminRetypePasswordTextField.setStyle("-fx-text-inner-color: white;");
    	adminUsernameTextField.setStyle("-fx-text-inner-color: white;");
    	nextButton.setOpacity(nextButtonOpacity);
    }    

    @FXML
    private void clicBackButton(ActionEvent event) throws IOException {
    	FXMLLoader loader=new FXMLLoader(getClass().getResource("/fxml/enterpriseSignUp3.fxml")); 
        Parent root=loader.load();
        Scene s = anchorPaneID.getScene(); 
        s.setRoot(root);
    }

    public static boolean validateEmail(String email) {
		Matcher matcher = emailPattern .matcher(email);
		return matcher.find();
	}
    
    public static boolean validateName(String name) {
		Matcher matcher = namePattern .matcher(name);
		return matcher.find();
	}
    
    @FXML
    private void firstNameOnKeyReleased(KeyEvent event) {
    	if(validateName(adminFristNameTextField.getText())) {
    		adminFristNameTextField.setFocusColor(Color.LAWNGREEN);
    		firstNameLabel.setText("Valid first name");
    		firstNameLabel.setTextFill(Color.LAWNGREEN);
    		firstNameLabel.setOpacity(1);
    		firstNameValidation = true;
    		checkValidation();
    	}else {
    		adminFristNameTextField.setFocusColor(Color.RED);
    		firstNameLabel.setText("Invalid first name");
    		firstNameLabel.setTextFill(Color.RED);
    		firstNameLabel.setOpacity(1);
    	}
    }

    @FXML
    private void lastNameOnKeyReleased(KeyEvent event) {
    	if(validateName(adminLastNameTextField.getText())) {
    		adminLastNameTextField.setFocusColor(Color.LAWNGREEN);
    		lastNameLabel.setText("Valid last name");
    		lastNameLabel.setTextFill(Color.LAWNGREEN);
    		lastNameLabel.setOpacity(1);
    		lastNameValidation = true;
    		checkValidation();
    	}else {
    		adminLastNameTextField.setFocusColor(Color.RED);
    		lastNameLabel.setText("Invalid last name");
    		lastNameLabel.setTextFill(Color.RED);
    		lastNameLabel.setOpacity(1);
    	}
    }

    @FXML
    private void emailOnKeyReleased(KeyEvent event) throws NamingException {
    	if(validateEmail(adminEmailTextField.getText()) && main.getEnterpriseProfileProxy().checkEmail(adminEmailTextField.getText()) == false && EnterpriseSignUp1Controller.listEmails.contains(adminEmailTextField.getText()) == false) {
    		adminEmailTextField.setFocusColor(Color.LAWNGREEN);
    		emailLabel.setText("Valid email");
    		emailLabel.setTextFill(Color.LAWNGREEN);
    		emailLabel.setOpacity(1);
    		emailValidation = true;
    		checkValidation();
    		tempEmail = adminEmailTextField.getText();
    		EnterpriseSignUp1Controller.listEmails.add(adminEmailTextField.getText());
    		
    	}else if(main.getEnterpriseProfileProxy().checkEmail(adminEmailTextField.getText()) == true) {
    				
    		
    			adminEmailTextField.setFocusColor(Color.RED);
    			emailLabel.setText("Email already exists ...");
    			emailLabel.setTextFill(Color.RED);
    			emailLabel.setOpacity(1);
    		
    	}
    	
    	else if(EnterpriseSignUp1Controller.listEmails.contains(adminEmailTextField.getText()) && validateEmail(adminEmailTextField.getText()) && main.getEnterpriseProfileProxy().checkEmail(adminEmailTextField.getText()) == false) {
    		
    		tempEmail = adminEmailTextField.getText();
    		adminEmailTextField.setFocusColor(Color.RED);
    		emailLabel.setText("You already put this email in a previous page ...");
    		emailLabel.setTextFill(Color.RED);
    		emailLabel.setOpacity(1);
    	}
    	else {
    		if(EnterpriseSignUp1Controller.listEmails.contains(tempEmail)) {
    			EnterpriseSignUp1Controller.listEmails.remove(tempEmail);
    			tempEmail = adminEmailTextField.getText();
    		}
    		
    		adminEmailTextField.setFocusColor(Color.RED);
    		emailLabel.setText("Invalid email\n Example : name@domain.com");
    		emailLabel.setTextFill(Color.RED);
    		emailLabel.setOpacity(1);
    	}
    }

    @FXML
    private void passwordOnKeyReleased(KeyEvent event) {
    	if(adminPasswordTextFirld.getText().length() > 9) {
    		adminPasswordTextFirld.setFocusColor(Color.LAWNGREEN);
    		passwordLabel.setText("Valid password");
    		passwordLabel.setTextFill(Color.LAWNGREEN);
    		passwordLabel.setOpacity(1);
    		passwordValidation = true;
    		checkValidation();
    	}else {
    		adminPasswordTextFirld.setFocusColor(Color.RED);
    		passwordLabel.setText("Invalid password (must contain at least 10 caracters)");
    		passwordLabel.setTextFill(Color.RED);
    		passwordLabel.setOpacity(1);
    	}
    }

    @FXML
    private void retypePasswordOnKeyReleased(KeyEvent event) {
    	if(adminRetypePasswordTextField.getText().equals(adminPasswordTextFirld.getText()) ) {
    		adminRetypePasswordTextField.setFocusColor(Color.LAWNGREEN);
    		retypePasswordLabel.setText("Valid password");
    		retypePasswordLabel.setTextFill(Color.LAWNGREEN);
    		retypePasswordLabel.setOpacity(1);
    		reTypePasswordValidation = true;
    		checkValidation();
    	}else {
    		adminRetypePasswordTextField.setFocusColor(Color.RED);
    		retypePasswordLabel.setText("Passwords are not the same");
    		retypePasswordLabel.setTextFill(Color.RED);
    		retypePasswordLabel.setOpacity(1);
    	}
    }

    @FXML
    private void usernameOnKeyReleased(KeyEvent event) throws NamingException {
    	if(adminUsernameTextField.getText().length() > 4 && main.getEnterpriseProfileProxy().checkUsername(adminUsernameTextField.getText()) == false && EnterpriseSignUp1Controller.listUsernames.contains(adminUsernameTextField.getText()) == false) {
    		adminUsernameTextField.setFocusColor(Color.LAWNGREEN);
    		usernameLabel.setText("Valid username");
    		usernameLabel.setTextFill(Color.LAWNGREEN);
    		usernameLabel.setOpacity(1);
    		usernameValidation = true;
    		checkValidation();
    		tempUsername = adminUsernameTextField.getText();
    		EnterpriseSignUp1Controller.listUsernames.add(adminUsernameTextField.getText());
    		
    	}else if(main.getEnterpriseProfileProxy().checkUsername(adminUsernameTextField.getText()) == true) {
    				
    		
    			adminUsernameTextField.setFocusColor(Color.RED);
        		usernameLabel.setText("Username already exists ...");
        		usernameLabel.setTextFill(Color.RED);
        		usernameLabel.setOpacity(1);
    		
    	}
    	
    	else if(EnterpriseSignUp1Controller.listUsernames.contains(adminUsernameTextField.getText()) && adminUsernameTextField.getText().length() > 4 && main.getEnterpriseProfileProxy().checkUsername(adminUsernameTextField.getText()) == false) {
    		
    		tempUsername = adminUsernameTextField.getText();
    		adminUsernameTextField.setFocusColor(Color.RED);
    		usernameLabel.setText("You already put this username in a previous page ...");
    		usernameLabel.setTextFill(Color.RED);
    		usernameLabel.setOpacity(1);
    	}
    	else {
    		if(EnterpriseSignUp1Controller.listUsernames.contains(tempUsername)) {
    			EnterpriseSignUp1Controller.listUsernames.remove(tempUsername);
    			tempUsername = adminUsernameTextField.getText();
    		}
    		
    		adminUsernameTextField.setFocusColor(Color.RED);
    		usernameLabel.setText("Invalid username (must contain at least 5 caracters)");
    		usernameLabel.setTextFill(Color.RED);
    		usernameLabel.setOpacity(1);
    	}
    	

    }

    @FXML
    private void clicNextButton(ActionEvent event) throws IOException {
    	staticFirstName = adminFristNameTextField.getText();
    	staticLastName = adminLastNameTextField.getText();
    	staticEmail = adminEmailTextField.getText();
    	staticPassword = adminPasswordTextFirld.getText();
    	staticRetypePassword = adminRetypePasswordTextField.getText();
    	staticUsername = adminUsernameTextField.getText();
    	nextButtonOpacity = 1;
    	
    	FXMLLoader loader=new FXMLLoader(getClass().getResource("/fxml/enterpriseSignUp5.fxml")); 
        Parent root=loader.load();
        Scene s = anchorPaneID.getScene(); 
        s.setRoot(root);
    }
    
    private void checkValidation() {
    	if (firstNameValidation == true && lastNameValidation == true 
    			&& emailValidation == true && passwordValidation == true 
    			&& reTypePasswordValidation == true && usernameValidation == true) {
    		nextButton.setOpacity(1);
    	}
    }
    
}
