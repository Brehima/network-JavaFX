/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.redhats.network.networkClient.javafx.candidateProfile;

import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author Coulibaly
 */
public class ProfilePageController implements Initializable {

    /**
     * Initializes the controller class.
     */
	@FXML
	private Label firstName;
	@FXML
	private Label lastName;
	@FXML
	private JFXButton modifyProfile;
	@FXML
	private JFXButton editAboutMe;
	@FXML
	private JFXTextArea introduction;
	@FXML
	private JFXTextField totalContact;
	@FXML
	private JFXButton editEducations;
	@FXML
	private JFXTextField stringEducation;
	@FXML
	private JFXButton addEducation;
	@FXML
	private JFXListView<String> educations;
	@FXML
	private JFXButton editExperience;
	@FXML
	private JFXTextField stringExperience;
	@FXML
	private JFXButton addExperience;
	@FXML
	private JFXListView<String> experiences;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
