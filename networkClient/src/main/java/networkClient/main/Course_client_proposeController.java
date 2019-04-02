/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package networkClient.main;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

/**
 * FXML Controller class
 *
 * @author Emir Fattoum
 */
public class Course_client_proposeController implements Initializable {
    @FXML
    private JFXButton back;
    @FXML
    private JFXButton propose;
    @FXML
    private JFXTextField course_p_title;
    @FXML
    private JFXTextField course_p_url;
    @FXML
    private JFXTextField course_p_desc;
    @FXML
    private JFXTextField course_p_domain;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
