/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.redhats.network.networkClient.javafx.login;

import com.jfoenix.controls.JFXButton;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author lenovo
 */
public class AdminEnterpriseDetailsController implements Initializable {

    @FXML
    private AnchorPane anchorPaneID;
    @FXML
    private JFXButton backButton;
    @FXML
    private Label enterpriseName;
    @FXML
    private Label introductionValue;
    @FXML
    private Label jobFieldValue;
    @FXML
    private Label websiteValue;
    @FXML
    private Label employeesNumberValue;
    @FXML
    private ImageView logoImageView;
    @FXML
    private TableView<?> table;
    @FXML
    private TableColumn<?, ?> firstNameColumn;
    @FXML
    private TableColumn<?, ?> lastNameColumn;
    @FXML
    private TableColumn<?, ?> emailColumn;
    @FXML
    private TableColumn<?, ?> usernameColumn;
    @FXML
    private TableColumn<?, ?> roleColumn;

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
    
}
