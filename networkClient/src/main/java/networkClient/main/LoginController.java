/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package networkClient.main;

import com.jfoenix.controls.JFXButton;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Emir Fattoum
 */
public class LoginController implements Initializable {
    @FXML
    private JFXButton admin;
    @FXML
    private JFXButton client;
    @FXML
    private JFXButton exit;
    
    public static String role;
    
    public static int uid;
    
    public static Stage pStage;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void go_to_admin(ActionEvent event) {
    	try {
    		role="admin";
            Parent root = FXMLLoader.load(getClass().getResource("Courses_admin.fxml"));
            Scene scene = new Scene( root);
            Stage primaryStage = new Stage();
            primaryStage.setScene(scene);
            primaryStage.setTitle("Network");
            pStage = primaryStage;
            primaryStage.show();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @FXML
    private void go_to_client(ActionEvent event) {
    	 try {
    		 role="client";
    		 uid=0001;
             Parent root = FXMLLoader.load(getClass().getResource("CoursesClient.fxml"));
             Scene scene = new Scene( root);
             Stage primaryStage = new Stage();
             primaryStage.setScene(scene);
             primaryStage.setTitle("Network");
             pStage = primaryStage;
             primaryStage.show();
         } catch (IOException ex) {
             ex.printStackTrace();
         }
    }

    @FXML
    private void exit(ActionEvent event) {
    	Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    	primaryStage.close();
    }
    
}
