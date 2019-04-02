/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package networkClient.main;

import com.jfoenix.controls.JFXButton;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import tn.redhats.network.networkServer.entities.Course;
import tn.redhats.network.networkServer.services.CoursesserviceRemote;

/**
 * FXML Controller class
 *
 * @author Emir Fattoum
 */
public class Courses_adminController implements Initializable {
    @FXML
    private JFXButton courses_propositions;
    @FXML
    private JFXButton search_admin_courses;
    @FXML
    private JFXButton add_admin_courses;
    @FXML
    private VBox Vcourses;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    	try {
            // TODO
            Context ctx = new InitialContext() ;
            Object obj = ctx.lookup("/networkServer-ear/networkServer-ejb/Coursesservice!tn.redhats.network.networkServer.services.CoursesserviceRemote");
            CoursesserviceRemote s = (CoursesserviceRemote)obj;
            List <Course> list = s.return_v_course();
            for(Course c : list) 
                {
                    Course_ModelController.setparameters(c);
                    Parent root = FXMLLoader.load(getClass().getResource("Course_Model.fxml"));
                    Vcourses.getChildren().add(root);
                    
                 }
            
        } catch (NamingException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
        ex.printStackTrace();
        }
    }    

    @FXML
    private void go_to_proposed_courses(ActionEvent event) {
    	try {
            Parent root = FXMLLoader.load(getClass().getResource("Course_proposed_admin.fxml"));
            Scene scene = new Scene( root);
            Stage primaryStage = new Stage();
            primaryStage.setScene(scene);
            primaryStage.setTitle("Network");
            primaryStage.show();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @FXML
    private void search_course(ActionEvent event) {
    }

    @FXML
    private void add_a_new_course(ActionEvent event) {
    	try {
            Parent root = FXMLLoader.load(getClass().getResource("Course_admin_add.fxml"));
            Scene scene = new Scene( root);
            Stage primaryStage = new Stage();
            primaryStage.setScene(scene);
            primaryStage.setTitle("Network");
            primaryStage.show();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
}
