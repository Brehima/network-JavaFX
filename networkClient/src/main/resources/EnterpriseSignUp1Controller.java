/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author lenovo
 */
public class EnterpriseSignUp1Controller implements Initializable {

    @FXML
    private AnchorPane anchorPaneID;
    @FXML
    private ImageView backButton;
    @FXML
    private JFXTextField enterpriseNameTextField;
    @FXML
    private JFXTextArea introductionTextArea;
    @FXML
    private JFXTextField employeesNumberTextField;
    @FXML
    private JFXTextField jobFieldTextField;
    @FXML
    private JFXTextField websiteTextField;
    @FXML
    private JFXComboBox<?> locationsComboBox;
    @FXML
    private JFXListView<?> locationsListView;
    @FXML
    private JFXButton addButton;
    @FXML
    private JFXButton nextButton;
    @FXML
    private JFXButton fileButton;
    @FXML
    private Label enterpriseNameLabel;
    @FXML
    private Label introductionLabel;
    @FXML
    private Label employeesNumberLabel;
    @FXML
    private Label jobFieldLabel;
    @FXML
    private Label websiteLabel;
    @FXML
    private Label fileLabel;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void clicBack(ActionEvent event) {
    }

    @FXML
    private void clicNext(ActionEvent event) {
    }
    
}
