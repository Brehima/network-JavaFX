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
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;

import javax.naming.NamingException;

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
import tn.redhats.network.networkServer.enumeration.AccountStatus;
import tn.redhats.network.networkServer.enumeration.Role;

/**
 * FXML Controller class
 *
 * @author lenovo
 */
public class SignUpValidationController implements Initializable {

    @FXML
    private AnchorPane anchorPaneID;
    @FXML
    private JFXButton backButton;
    @FXML
    private JFXTextField adminCode;
    @FXML
    private JFXTextField HRCode;
    @FXML
    private JFXTextField projectsManagerCode;
    @FXML
    private JFXTextField RecruitementCode;
    @FXML
    private JFXButton validateButton;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    	adminCode.setStyle("-fx-text-inner-color: white;");
    	HRCode.setStyle("-fx-text-inner-color: white;");
    	projectsManagerCode.setStyle("-fx-text-inner-color: white;");
    	RecruitementCode.setStyle("-fx-text-inner-color: white;");
    	
    }    

    @FXML
    private void clicBackButton(ActionEvent event) throws IOException {
    	FXMLLoader loader=new FXMLLoader(getClass().getResource("/fxml/enterpriseSignUp5.fxml")); 
        Parent root=loader.load();
        Scene s = anchorPaneID.getScene(); 
        s.setRoot(root);
    }

    @FXML
    private void clicValidateButton(ActionEvent event) throws NamingException, IOException {
    	if(adminCode.getText().equals(EnterpriseSignUp5Controller.adminCode)
    		&& HRCode.getText().equals(EnterpriseSignUp5Controller.HRCode)
    		&& projectsManagerCode.getText().equals(EnterpriseSignUp5Controller.ProjectsManagerCode)
    		&& RecruitementCode.getText().equals(EnterpriseSignUp5Controller.RecruitementsCode)) {
    		
    		// Instances
    		User EnterpriseAdministrator = new User();
    		User HRManager = new User();
    		User ProjectManager = new User();
    		User RecruitementManager = new User();
    		EnterpriseProfile enterpriseProfile = new EnterpriseProfile();
    		
    		
    		// Users
    		EnterpriseAdministrator.setFirstName(EnterpriseSignUp2Controller.staticFirstName);
    		EnterpriseAdministrator.setLastName(EnterpriseSignUp2Controller.staticLastName);
    		EnterpriseAdministrator.setRole(Role.EnterpriseAdministrator);
    		EnterpriseAdministrator.setEmail(EnterpriseSignUp2Controller.staticEmail);
    		EnterpriseAdministrator.setUsername(EnterpriseSignUp2Controller.staticUsername);
    		EnterpriseAdministrator.setPassword(SigninController.hashPassword(EnterpriseSignUp2Controller.staticPassword));
    		EnterpriseAdministrator.setAccountStatus(AccountStatus.ACTIVATED);
    		EnterpriseAdministrator.setLoginAttempts(0);
    		
    		
    		HRManager.setFirstName(EnterpriseSignUp3Controller.staticFirstName);
    		HRManager.setLastName(EnterpriseSignUp3Controller.staticLastName);
    		HRManager.setRole(Role.HRManager);
    		HRManager.setEmail(EnterpriseSignUp3Controller.staticEmail);
    		HRManager.setUsername(EnterpriseSignUp3Controller.staticUsername);
    		HRManager.setPassword(SigninController.hashPassword(EnterpriseSignUp3Controller.staticPassword));
    		HRManager.setAccountStatus(AccountStatus.ACTIVATED);
    		HRManager.setLoginAttempts(0);
    		
    		
    		ProjectManager.setFirstName(EnterpriseSignUp4Controller.staticFirstName);
    		ProjectManager.setLastName(EnterpriseSignUp4Controller.staticLastName);
    		ProjectManager.setRole(Role.ProjectManager);
    		ProjectManager.setEmail(EnterpriseSignUp4Controller.staticEmail);
    		ProjectManager.setUsername(EnterpriseSignUp4Controller.staticUsername);
    		ProjectManager.setPassword(SigninController.hashPassword(EnterpriseSignUp4Controller.staticPassword));
    		ProjectManager.setAccountStatus(AccountStatus.ACTIVATED);
    		ProjectManager.setLoginAttempts(0);
    		
    		
    		RecruitementManager.setFirstName(EnterpriseSignUp5Controller.staticFirstName);
    		RecruitementManager.setLastName(EnterpriseSignUp5Controller.staticLastName);
    		RecruitementManager.setRole(Role.RecruitementsManager);
    		RecruitementManager.setEmail(EnterpriseSignUp5Controller.staticEmail);
    		RecruitementManager.setUsername(EnterpriseSignUp5Controller.staticUsername);
    		RecruitementManager.setPassword(SigninController.hashPassword(EnterpriseSignUp5Controller.staticPassword));
    		RecruitementManager.setAccountStatus(AccountStatus.ACTIVATED);
    		RecruitementManager.setLoginAttempts(0);
    		
    		// Profile
    		enterpriseProfile.setEnterpriseName(EnterpriseSignUp1Controller.staticenterpriseName);
    		enterpriseProfile.setIntroduction(EnterpriseSignUp1Controller.staticIntroduction);
    		EnterpriseSignUp1Controller.saveFile(EnterpriseSignUp1Controller.staticFile);
    		enterpriseProfile.setPhoto(EnterpriseSignUp1Controller.profileHashName);
    		enterpriseProfile.setEmployeesNumber(EnterpriseSignUp1Controller.staticEmployeesNumber);
    		enterpriseProfile.setJobField(EnterpriseSignUp1Controller.staticJobField);
    		ArrayList<String> locations = new ArrayList<String>();

    		for(String location : EnterpriseSignUp1Controller.staticLocationsList) {
    			locations.add(location);
    		}
    		
    		enterpriseProfile.setLocations(locations);
    		enterpriseProfile.setWebsite(EnterpriseSignUp1Controller.staticWebsite);
    		enterpriseProfile.setUser(EnterpriseAdministrator);
    		enterpriseProfile.setUser(HRManager);
    		enterpriseProfile.setUser(ProjectManager);
    		enterpriseProfile.setUser(RecruitementManager);
    		
    		
    		// SetProfile pour les utilisateurs
    		EnterpriseAdministrator.setProfile(enterpriseProfile);
    		HRManager.setProfile(enterpriseProfile);
    		ProjectManager.setProfile(enterpriseProfile);
    		RecruitementManager.setProfile(enterpriseProfile);
    		
    		
    		
    		main.getEnterpriseProfileProxy().addEnterprise(enterpriseProfile, EnterpriseAdministrator, HRManager, ProjectManager, RecruitementManager);
    		
    		
    		
    		Alert alerte = new Alert(Alert.AlertType.INFORMATION);
            alerte.setTitle("Confirmation dialog");
            alerte.setHeaderText("Congratulations ! ");
            alerte.setContentText("Your enterprise account has been created ...");
            
            Optional<ButtonType> result = alerte.showAndWait();
            if (result.get() == ButtonType.OK)
            {
            	FXMLLoader loader=new FXMLLoader(getClass().getResource("/fxml/signin.fxml")); 
                Parent root=loader.load();
                Scene s = anchorPaneID.getScene(); 
                s.setRoot(root);     
            }            
            	
    		
    	}
    	else {
    		Alert alerte2 = new Alert(Alert.AlertType.WARNING);
            alerte2.setTitle("Warning dialog");
            alerte2.setHeaderText("Wrong codes ! ");
            alerte2.setContentText("Please check the sent codes ...");
            
            Optional<ButtonType> result2 = alerte2.showAndWait();
            if (result2.get() == ButtonType.OK){
            	/*
            	FXMLLoader loader=new FXMLLoader(getClass().getResource("/fxml/SignUpValidation.fxml")); 
                Parent root=loader.load();
                Scene s = anchorPaneID.getScene(); 
                s.setRoot(root);
                */
            }
    }
    
}
    }
